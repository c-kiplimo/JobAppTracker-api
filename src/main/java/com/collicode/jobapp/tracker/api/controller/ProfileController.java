package com.collicode.jobapp.tracker.api.controller;

import com.collicode.jobapp.tracker.api.model.AddProfileInput;
import com.collicode.jobapp.tracker.api.model.Profile;
import com.collicode.jobapp.tracker.api.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    @MutationMapping
    public Mono<Profile> addProfile(@Argument AddProfileInput addProfileInput) {
        Mono<Profile> profile = profileService.addProfile(addProfileInput);
        return profile;
    }

    @MutationMapping
    public Mono<Profile> updateProfile(@Argument Profile profile) {
        return profileService.updateProfile(profile);
    }

    @QueryMapping
    public Flux<Profile> allProfile() {
        Flux<Profile> profile = profileService.allProfile();
        return profile;
    }
}