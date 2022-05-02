package com.example.digitom.service.constractionsitemanagement;

import com.example.digitom.domain.company.Company;
import lombok.Data;

import java.util.List;

@Data
public class NewConstructionSiteRequest {
    private String siteName;
    private String siteAddress;
    private Integer mainContractorCompanyId;
    private List<Company> subContractorsCompanyId;

}
