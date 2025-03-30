package project_tracker_backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project_tracker_backend.domain.Project;
import project_tracker_backend.domain.Task;
import project_tracker_backend.dto.incoming.TaskCreationDto;
import project_tracker_backend.dto.mapper.TaskMapper;
import project_tracker_backend.repository.TaskRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;
    private final ProjectService projectService;

    @Autowired
    public TaskService(TaskRepository taskRepository, TaskMapper taskMapper, ProjectService projectService) {
        this.taskRepository = taskRepository;
        this.taskMapper = taskMapper;
        this.projectService = projectService;
    }

    public void createTask(TaskCreationDto taskCreationDto) {
        Task task = taskMapper.mapTaskCreationDtoToTask(taskCreationDto);
        taskRepository.save(task);

        Project project = projectService.findProjectById(taskCreationDto.getProjectId());
        task.setProject(project);
    }

    public void autoAssignSubTasks(Task task) {
        List<Task> autoSubTaskList = new ArrayList<>();
        // TODO when autolist is introduced this method will slightly change
        task.setSubTasks(autoSubTaskList);
    }
}
