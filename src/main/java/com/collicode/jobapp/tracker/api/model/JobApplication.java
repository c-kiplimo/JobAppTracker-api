package com.collicode.jobapp.tracker.api.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;


import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "job_application")
public class JobApplication {
    @Id
    private Integer id;
    @Column("company_name")
    private String companyName;
    @Column("job_title")
    private String jobTitle;
    @Column("salary_range")
    private String salaryRange;
    @Column("job_url")
    private String jobUrl;
    @Column( "applied_date")
    private LocalDate appliedDate;
    private String description;
    private String status;
}
