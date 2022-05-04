package com.example.digitom.domain.task;

import lombok.Data;

import java.util.Date;

@Data
public class TaskRequest {
    private String description;
    private Date deadline;

}
