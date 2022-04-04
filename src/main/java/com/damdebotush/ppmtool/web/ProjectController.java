package com.damdebotush.ppmtool.web;

import com.damdebotush.ppmtool.domain.Project;
import com.damdebotush.ppmtool.service.MapValidationErrorService;
import com.damdebotush.ppmtool.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private MapValidationErrorService mapValidationErrorService;

    @PostMapping(value = "")
    public ResponseEntity<?> createNewProject(@Valid @RequestBody Project project, BindingResult result) {

        ResponseEntity<?> errorMap = mapValidationErrorService.getMapValidationError(result);
        if (errorMap != null)
            return errorMap;

        project = projectService.saveOrUpdateProject(project);
        return new ResponseEntity<>(project, HttpStatus.CREATED);
    }

    @GetMapping("/{projectId}")
    public  ResponseEntity<?> getProjectById(@PathVariable String projectId) {

        Project project = projectService.getProjectByProjectIdentifier(projectId);

        return new ResponseEntity<>(project, HttpStatus.OK);
    }

    @GetMapping("/all")
    public Iterable<?> getAllProects() {

        return projectService.getAllProjects();
    }

    @DeleteMapping("/{projectId}")
    public ResponseEntity<?> deleteProjectByProjectIdentifier(@PathVariable String projectId) {

        projectService.deleteProject(projectId);

        return new ResponseEntity<>("Project has been deleted.", HttpStatus.OK);
    }
}
