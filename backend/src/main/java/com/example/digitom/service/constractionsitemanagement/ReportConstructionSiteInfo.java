package com.example.digitom.service.constractionsitemanagement;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ReportConstructionSiteInfo {
    private String siteName;
    private String siteAddress;
    private String companyName;
    private LocalDate reportDate;
}
