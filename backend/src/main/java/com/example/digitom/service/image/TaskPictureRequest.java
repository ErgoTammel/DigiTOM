package com.example.digitom.service.image;

import lombok.Data;

@Data
public class TaskPictureRequest {
    private Integer taskId;
    private String base64;
}
