package com.collicode.jobapp.tracker.api.repository;

import com.collicode.jobapp.tracker.api.model.JobApplication;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;


@Repository

public interface JobApplicationRepository extends ReactiveCrudRepository<JobApplication, Integer> {
}
