package com.example.digitom.service.image;

import lombok.Data;

@Data
public class TaskPictureRequest {
    private Integer taskResponseId;
    private String base64;
}
