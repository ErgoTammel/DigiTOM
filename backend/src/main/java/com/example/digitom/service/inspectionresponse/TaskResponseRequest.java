package com.example.digitom.service.inspectionresponse;

import lombok.Data;

import java.time.Instant;

@Data
public class TaskResponseRequest {
    private Integer taskId;
    private String description;
    private Instant time;

}
