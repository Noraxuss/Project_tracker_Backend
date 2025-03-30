package project_tracker_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import project_tracker_backend.dto.incoming.ProjectCreationDto;
import project_tracker_backend.service.ProjectService;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    private final ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void createProject(@RequestBody ProjectCreationDto projectCreationDto) {
        //TODO logging
        projectService.createProject(projectCreationDto);
    }

}
