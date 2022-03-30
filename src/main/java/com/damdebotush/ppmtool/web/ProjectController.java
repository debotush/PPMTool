package com.damdebotush.ppmtool.web;

import com.damdebotush.ppmtool.domain.Project;
import com.damdebotush.ppmtool.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/project")
public class ProjectController {

    @Autowired
    ProjectService projectService;

    @PostMapping(value = "")
    public ResponseEntity<Project> createNewProject(@RequestBody Project project) {
        project = projectService.saveOrUpdateProject(project);
        return new ResponseEntity<Project>(project, HttpStatus.CREATED);
    }
}
