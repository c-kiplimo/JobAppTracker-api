package com.collicode.jobapp.tracker.api.repository;

import com.collicode.jobapp.tracker.api.model.Profile;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;


@Repository

public interface ProfileRepository extends ReactiveCrudRepository<Profile, Integer> {
}
