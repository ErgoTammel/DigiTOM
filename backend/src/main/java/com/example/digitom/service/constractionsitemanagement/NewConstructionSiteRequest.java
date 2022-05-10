package com.example.digitom.service.constractionsitemanagement;

import lombok.Data;

@Data
public class NewConstructionSiteRequest {
    private String siteName;
    private String siteAddress;
    private Integer mainContractorCompanyId;

}
