package com.damdebotush.ppmtool.service;

import com.damdebotush.ppmtool.domain.Project;
import com.damdebotush.ppmtool.exceptions.ProjectIdException;
import com.damdebotush.ppmtool.repository.ProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepo projectRepo;

    public Project saveOrUpdateProject(Project project) {

        try {
            return projectRepo.save(project);
        } catch (Exception ex) {
            throw new ProjectIdException("Project ID " + project.getProjectIdentifier().toUpperCase()+ " is exist already.");
        }


    }
}
