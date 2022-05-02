package com.example.digitom.domain.constructionsite;

import lombok.Data;

import java.io.Serializable;

@Data
public class ConstructionSiteDto implements Serializable {
    private final Integer id;
    private final String name;
    private final String address;
    private final Integer latitude;
    private final Integer longitude;
}
