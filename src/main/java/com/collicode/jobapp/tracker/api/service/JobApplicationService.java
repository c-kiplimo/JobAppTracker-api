package com.collicode.jobapp.tracker.api.service;


import com.collicode.jobapp.tracker.api.model.AddJobApplicationInput;
import com.collicode.jobapp.tracker.api.model.JobApplication;
import com.collicode.jobapp.tracker.api.repository.JobApplicationRepository;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Objects;
import java.util.function.Function;

@Service
@Slf4j
public class JobApplicationService {
    @Autowired
    private JobApplicationRepository jobApplicationRepository;
    Function<AddJobApplicationInput, JobApplication> mapping = limo -> {
        var jobApplication = new JobApplication();
        jobApplication.setCompanyName(limo.getCompanyName());
        jobApplication.setJobTitle(limo.getJobTitle());
        jobApplication.setSalaryRange(limo.getSalaryRange());
        jobApplication.setJobUrl(limo.getJobUrl());
        jobApplication.setAppliedDate(limo.getAppliedDate());
        jobApplication.setDescription(limo.getDescription());
        jobApplication.setStatus(limo.getStatus());
        return jobApplication;
    };

    Function<JobApplication, JobApplication> editMapping = mo -> {
        var jobApplication = new JobApplication();
        jobApplication.setId(mo.getId());
        jobApplication.setCompanyName(mo.getCompanyName());
        jobApplication.setJobTitle(mo.getJobTitle());
        jobApplication.setSalaryRange(mo.getSalaryRange());
        jobApplication.setJobUrl(mo.getJobUrl());
        jobApplication.setAppliedDate(mo.getAppliedDate());
        jobApplication.setDescription(mo.getDescription());
        jobApplication.setStatus(mo.getStatus());
        return jobApplication;
    };
    public Mono<JobApplication> addJobApplication(AddJobApplicationInput addJobApplicationInput) {
        Mono<JobApplication> jobApplication = jobApplicationRepository.save(mapping.apply(addJobApplicationInput));
        log.info("Added new job application: {}", addJobApplicationInput);
        return jobApplication;
    }


    public Mono<JobApplication> updateJobApplication(JobApplication jobApplication) {
        log.info("Updating job application id {}", jobApplication.getId());
        return this.jobApplicationRepository.findById(jobApplication.getId())
                .flatMap(l -> {
                    l.setCompanyName(jobApplication.getCompanyName());
                    l.setJobTitle(jobApplication.getJobTitle());
                    l.setSalaryRange(jobApplication.getSalaryRange());
                    l.setJobUrl(jobApplication.getJobUrl());
                    l.setAppliedDate(jobApplication.getAppliedDate());
                    l.setDescription(jobApplication.getDescription());
                    l.setStatus(jobApplication.getStatus());
                    return jobApplicationRepository.save(jobApplication).log();
                });
    }
    public Mono<JobApplication> deleteJobApplication(@NonNull Integer id) {
        final Mono<JobApplication> jobApplication = jobApplicationRepository.findById(id);
        if (Objects.isNull(jobApplication)) {
            return Mono.empty();
        }
        log.info("Deleting job application idd {}", id);
        return this.jobApplicationRepository.findById(id).switchIfEmpty(Mono.empty()).filter(Objects::nonNull)
                .flatMap(jobApplicationToBeDeleted -> jobApplicationRepository
                        .delete(jobApplicationToBeDeleted)
                        .then(Mono.just(jobApplicationToBeDeleted))).log();

    }


    public Flux<JobApplication> allJobApplication() {
        return this.jobApplicationRepository.findAll().log();
    }
}
