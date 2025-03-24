package project_tracker_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project_tracker_backend.domain.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
}
