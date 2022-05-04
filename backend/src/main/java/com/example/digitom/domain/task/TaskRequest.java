package com.example.digitom.domain.task;

import lombok.Data;

import java.time.LocalDate;

@Data
public class TaskRequest {
    private String description;
    private LocalDate deadline;

}
