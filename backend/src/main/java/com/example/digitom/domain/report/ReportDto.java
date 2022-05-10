package com.example.digitom.domain.report;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class ReportDto implements Serializable {
    private final Integer id;
    private final Integer constructionSiteId;
    private final String constructionSiteName;
    private final String constructionSiteAddress;
    private final Integer constructionSiteLatitude;
    private final Integer constructionSiteLongitude;
    private final LocalDate date;
    private final BigDecimal tom;
}
