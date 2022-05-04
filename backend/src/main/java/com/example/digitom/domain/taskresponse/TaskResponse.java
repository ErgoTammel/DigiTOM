package com.example.digitom.domain.taskresponse;

import com.example.digitom.domain.task.Task;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "task_response", schema = "digi_tom")
public class TaskResponse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "task_id", nullable = false)
    private Task task;

    @Column(name = "description")
    private String description;

    @Column(name = "\"time\"", nullable = false)
    private Instant time;

}