package com.damdebotush.ppmtool.service;

import com.damdebotush.ppmtool.domain.Project;
import com.damdebotush.ppmtool.repository.ProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepo projectRepo;

    public Project saveOrUpdateProject(Project project) {
        // Logic

        return projectRepo.save(project);
    }
}
