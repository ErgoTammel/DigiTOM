package com.example.digitom.service.inspection;

import lombok.Data;

import javax.persistence.Column;
import java.math.BigDecimal;

@Data
public class ReportResultResponse {
    private Integer safeSum;
    private Integer notSafeSum;
    @Column(name = "tom", precision = 5, scale = 2)
    private BigDecimal tom;

}
