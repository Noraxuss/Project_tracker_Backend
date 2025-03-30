package project_tracker_backend.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "tasks")
@Getter
@Setter
@NoArgsConstructor
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "id")
    private Long id;

    @Column(nullable = false, name = "name")
    private String name;

    @Column(nullable = false, name = "description")
    private String description;

    @Column(nullable = false, name = "status")
    private String status;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    @OneToMany
    private List<Task> subTasks;

    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task parentTask;
}
