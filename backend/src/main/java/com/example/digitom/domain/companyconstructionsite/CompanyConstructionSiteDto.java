package com.example.digitom.domain.companyconstructionsite;

import lombok.Data;

import java.io.Serializable;

@Data
public class CompanyConstructionSiteDto implements Serializable {
    private final Integer id;
    private final Integer companyId;
    private final String companyName;
    private final Integer companyRegNumber;
    private final Integer constructionSiteId;
    private final String constructionSiteName;
    private final String constructionSiteAddress;
    private final Integer constructionSiteLatitude;
    private final Integer constructionSiteLongitude;
    private final Boolean mainContractor;
}
