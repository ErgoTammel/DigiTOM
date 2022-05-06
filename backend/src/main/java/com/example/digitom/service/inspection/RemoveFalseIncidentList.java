package com.example.digitom.service.inspection;

import lombok.Data;

import java.time.LocalDate;

@Data
public class RemoveFalseIncidentList {

    private String description;
    private String companyName;
    private LocalDate deadline;


}
