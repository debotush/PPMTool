package com.damdebotush.ppmtool.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String projectName;

    private String projectIdentifier;

    private String description;

    private Date startDate;

    private Date endDate;

    protected Date created_at;

    protected Date updated_At;

    @PrePersist
    public void setCreated_at() {
        this.created_at = new Date();
    }

    @PreUpdate
    public void setUpdated_At() {
        this.updated_At = new Date();
    }
}
