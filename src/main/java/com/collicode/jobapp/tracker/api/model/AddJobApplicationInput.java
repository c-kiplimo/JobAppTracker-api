package com.collicode.jobapp.tracker.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddJobApplicationInput {
    private String companyName;
    private String jobTitle;
    private String salaryRange;
    private LocalDate appliedDate;
    private String jobUrl;
    private String description;
    private String status;
}