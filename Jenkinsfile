pipeline {
    agent any
    tools {
        maven 'Maven 3.5.0'
    }

    environment {
        PROJECT_ID = 'jenkins-403820'
        CLUSTER_NAME = 'k8s-cluster'
        LOCATION = 'us-central1'
        CREDENTIALS_ID = 'kubernetes'
		BUILD_ID ='latest'
    }

    stages {
        stage('Scm Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    sh 'docker build -t collins6299/job-application-tracker:latest .'
                }
            }
        }

        stage("Push Docker Image") {
            steps {
                script {
                    echo "Push Docker Image"
                    withCredentials([string(credentialsId: 'dockerhub', variable: 'dockerhub')]) {
                        sh "docker login -u collins6299 -p ${dockerhub}"
                    }
                    sh 'docker push collins6299/job-application-tracker:latest'

                }
            }
        }

        stage('Deploy to K8s') {
            steps {
                echo "Deployment started ..."
                sh 'ls -ltr'
                sh 'pwd'
                sh "sed -i 's/tagversion/${env.BUILD_ID}/g' serviceLB.yaml"
                sh "sed -i 's/tagversion/${env.BUILD_ID}/g' deployment.yaml"
                echo "Start deployment of serviceLB.yaml"
                step([$class: 'KubernetesEngineBuilder', projectId: env.PROJECT_ID, clusterName: env.CLUSTER_NAME, location: env.LOCATION, manifestPattern: 'serviceLB.yaml', credentialsId: env.CREDENTIALS_ID, verifyDeployments: true])
                echo "Start deployment of deployment.yaml"
                step([$class: 'KubernetesEngineBuilder', projectId: env.PROJECT_ID, clusterName: env.CLUSTER_NAME, location: env.LOCATION, manifestPattern: 'deployment.yaml', credentialsId: env.CREDENTIALS_ID, verifyDeployments: true])
                echo "Deployment Finished ..."
            }
        }
    }
}