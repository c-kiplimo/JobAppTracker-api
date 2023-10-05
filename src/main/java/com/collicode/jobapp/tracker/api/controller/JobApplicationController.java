package com.collicode.jobapp.tracker.api.controller;

import com.collicode.jobapp.tracker.api.model.AddJobApplicationInput;
import com.collicode.jobapp.tracker.api.model.JobApplication;
import com.collicode.jobapp.tracker.api.service.JobApplicationService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.reactive.config.CorsRegistry;
import org.springframework.web.reactive.config.WebFluxConfigurer;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Controller
public class JobApplicationController {
    @Bean
    private WebFluxConfigurer corsConfigurer() {
        return new WebFluxConfigurer() {
            @Value("${ui.path}")
            private String UI_PATH;

            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/graphql").allowedOrigins(UI_PATH);
            }
        };
    }

    @Autowired
    private JobApplicationService jobApplicationService;
    @MutationMapping
    public Mono<JobApplication> addJobApplication(@Argument AddJobApplicationInput addJobApplicationInput) {
        Mono<JobApplication> jobApplication = jobApplicationService.addJobApplication(addJobApplicationInput);
        return jobApplication;
    }
    @MutationMapping
    public Mono<JobApplication> updateJobApplication(@Argument JobApplication jobApplication) {
        return jobApplicationService.updateJobApplication(jobApplication);
    }


    @MutationMapping
    public Mono<JobApplication> deleteJobApplication(@Argument @NonNull Integer id) {
        final Mono<JobApplication> jobApplication = jobApplicationService.deleteJobApplication(id);
        return jobApplication;

    }

    @QueryMapping
    public Flux<JobApplication> allJobApplication() {
        Flux<JobApplication> jobApplications = jobApplicationService.allJobApplication();
        return jobApplications;
    }
}
