package com.example.digitom.domain.taskresponse;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;

@Data
public class TaskResponseDto implements Serializable {
    private final Integer id;
    private final Integer taskId;
    private final String description;
    private final Instant time;
    private byte[] base64;

}
