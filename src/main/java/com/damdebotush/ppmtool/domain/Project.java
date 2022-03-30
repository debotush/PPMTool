package com.damdebotush.ppmtool.domain;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String projectName;

    @NotBlank
    private String projectIdentifier;

    @NotBlank
    private String description;

    private Date startDate;

    private Date endDate;

    protected Date created_at;

    protected Date updated_At;

    public Project() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectIdentifier() {
        return projectIdentifier;
    }

    public void setProjectIdentifier(String projectIdentifier) {
        this.projectIdentifier = projectIdentifier;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public Date getUpdated_At() {
        return updated_At;
    }

    @PrePersist
    public void setCreated_at() {
        this.created_at = new Date();
    }

    @PreUpdate
    public void setUpdated_At() {
        this.updated_At = new Date();
    }
}
