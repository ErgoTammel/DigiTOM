package com.example.digitom.domain.report;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/report")
public class ReportController {

    @Resource
    private ReportService reportService;

    @PostMapping("/add")
    @Operation(summary = "Add new report by construction site ID")
    public Integer addNewReport(@RequestParam Integer siteId) {
        return reportService.addNewReport(siteId);
    }

}
