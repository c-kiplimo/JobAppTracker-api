def remote = [name: 'K8S_Master', host: '51.20.81.211', user: 'kube', password: 'admin123', allowAnyHosts: true]
pipeline{
    agent any
    tools {
        maven "maven3.9.1"
    }
    stages{
        stage('1. Git Clone'){
            steps{
                git branch: 'develop', url: 'https://github.com/c-kiplimo/JobAppTracker-api'
            }
        }
        stage('2. Maven Build'){
            steps{
                sh "mvn clean package"
            }
        }
        stage('5. Build Docker Image'){
            steps{
                sh "docker build . -t collins6299/job-application-tracker:1.0.0"
            }
        }
        stage('6. DockerHub Login'){
            steps{
                withCredentials([string(credentialsId: 'DockerHub password', variable: 'docker')]) {
                    sh "docker login -u collins6299 -p ${docker}"
                }
            }
        }
        stage('7. Push to DokerHub Registry'){
            steps{
                sh "docker push collins6299/job-application-tracker:1.0.0"
            }
        }
        stage('8. SSH onto K8S_Master & Deployment'){
            steps{
                sshPut remote: remote, from: '/var/lib/jenkins/jobs/spring/deployment.yml', into: '.'
                sshCommand remote: remote, command: "kubectl apply -f deployment.yml"
            }
        }
    }
} 
