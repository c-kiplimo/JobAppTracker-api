package com.collicode.jobapp.tracker.api.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "job_application")
public class JobApplication {
    @Id
    private Integer id;
    @Column(name = "company_name")
    private String companyName;
    @Column(name = "job_title")
    private String jobTitle;
    @Column(name = "salary_range")
    private String salaryRange;
    @Column(name = "job_url")
    private String jobUrl;
    @Column(name = "applied_date")
    private LocalDate appliedDate;
    private String description;
    private String status;
}
