package com.example.digitom.service.image;

import lombok.Data;

@Data
public class ReportPictureRequest {
    private Integer reportId;
    private Integer taskId;
    private String base64;
}
