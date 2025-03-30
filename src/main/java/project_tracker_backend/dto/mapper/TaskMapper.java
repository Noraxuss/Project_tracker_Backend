package project_tracker_backend.dto.mapper;

import org.springframework.stereotype.Component;
import project_tracker_backend.domain.Task;
import project_tracker_backend.dto.incoming.TaskCreationDto;

@Component
public class TaskMapper {

    public Task mapTaskCreationDtoToTask(TaskCreationDto taskCreationDto) {
        Task task = new Task();
        task.setDescription(taskCreationDto.getDescription());
        task.setStatus(taskCreationDto.getStatus());
        return task;
    }

}
