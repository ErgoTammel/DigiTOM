package com.example.digitom.domain.taskresponsepicture;

import com.example.digitom.domain.taskresponse.TaskResponse;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "task_response_picture", schema = "digi_tom")
public class TaskResponsePicture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "task_response_id", nullable = false)
    private TaskResponse taskResponse;

    @Column(name = "base64", nullable = false)
    private byte[] base64;

}