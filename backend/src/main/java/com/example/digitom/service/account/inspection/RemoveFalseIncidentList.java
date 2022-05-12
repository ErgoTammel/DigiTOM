package com.example.digitom.service.account.inspection;

import lombok.Data;

import java.time.LocalDate;

@Data
public class RemoveFalseIncidentList {

    private Integer taskId;
    private String description;
    private String companyName;
    private LocalDate deadline;


}
