package com.damdebotush.ppmtool.service;

import com.damdebotush.ppmtool.domain.Project;
import com.damdebotush.ppmtool.exceptions.ProjectIdException;
import com.damdebotush.ppmtool.repository.ProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

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

    public Project getProjectByProjectIdentifier(String projectIdentifier) {
        Project project = projectRepo.findByProjectIdentifier(projectIdentifier);

        if (Objects.isNull(project)) {
            throw new ProjectIdException("Project ID '"+projectIdentifier+"' does not exist");
        }

        return project;
    }

    public Iterable<Project> getAllProjects() {

        return projectRepo.findAll();

    }

    public void deleteProject(String projectId) {
        Project project = projectRepo.findByProjectIdentifier(projectId);

        if (Objects.isNull(project)) {
            throw new ProjectIdException("There are no Project exist with this ID '"+projectId+"'.");
        }

        projectRepo.delete(project);
    }

}
