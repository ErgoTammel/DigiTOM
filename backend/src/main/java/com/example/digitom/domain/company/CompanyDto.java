package com.example.digitom.domain.company;

import lombok.Data;

import java.io.Serializable;

@Data
public class CompanyDto implements Serializable {
    private final Integer id;
    private final String name;
    private final Integer regNumber;
}
