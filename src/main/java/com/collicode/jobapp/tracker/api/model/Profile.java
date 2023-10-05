package com.collicode.jobapp.tracker.api.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "profile")
public class Profile {
    @Id
    private Integer id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "address_street_1")
    private String addressStreet1;
    @Column(name = "address_street_2")
    private String addressStreet2;
    @Column(name = "address_city")
    private String addressCity;
    @Column(name = "address_state")
    private String addressState;
    @Column(name = "address_zip")
    private String addressZip;
    private String linkedin;
    private String github;
    @Column(name = "personal_website")
    private String personalWebsite;
}
