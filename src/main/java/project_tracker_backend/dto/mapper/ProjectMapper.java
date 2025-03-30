package project_tracker_backend.dto.mapper;

import org.springframework.stereotype.Component;
import project_tracker_backend.domain.Project;
import project_tracker_backend.dto.incoming.ProjectCreationDto;

@Component
public class ProjectMapper {

    public Project mapProjectCreationDtoToProject(ProjectCreationDto projectCreationDto) {
        Project project = new Project();
        project.setName(projectCreationDto.getName());
        project.setDescription(projectCreationDto.getDescription());
        project.setStatus(projectCreationDto.getStatus());
        return project;
    }
}
