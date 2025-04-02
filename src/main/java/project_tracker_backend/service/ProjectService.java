package project_tracker_backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project_tracker_backend.domain.Project;
import project_tracker_backend.domain.User;
import project_tracker_backend.dto.incoming.ProjectCreationDto;
import project_tracker_backend.dto.mapper.ProjectMapper;
import project_tracker_backend.repository.ProjectRepository;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;
    private final ProjectMapper projectMapper;
    private final UserService userService;

    @Autowired
    public ProjectService(ProjectRepository projectRepository, ProjectMapper projectMapper, UserService userService) {
        this.projectRepository = projectRepository;
        this.projectMapper = projectMapper;
        this.userService = userService;
    }

    public void createProject(ProjectCreationDto projectCreationDto) {
        Project project = projectMapper.mapProjectCreationDtoToProject(projectCreationDto);
        projectRepository.save(project);

        User user = userService.findUserById(projectCreationDto.getUserId());
        project.setUser(user);
    }

    public Project findProjectById(Long projectId) {
        //TODO throw Exception
        return projectRepository.findById(projectId).orElse(null);
    }
}
