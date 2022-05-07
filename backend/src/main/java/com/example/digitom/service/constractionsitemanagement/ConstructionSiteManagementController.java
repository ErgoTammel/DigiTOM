package com.example.digitom.service.constractionsitemanagement;

import com.example.digitom.domain.companyconstructionsite.CompanyConstructionSiteListResponse;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RequestMapping("/construction-site")
@RestController
public class ConstructionSiteManagementController {

    @Resource
    private ConstructionSiteManagementService constructionSiteManagementService;

    @GetMapping("/all")
    @Operation(summary = "Get the list of all companies (name and ID)")
    public List<CompanyNameResponse> getAllCompanies() {
        return constructionSiteManagementService.getAllCompanies();
    }

    @GetMapping("/contact")
    @Operation(summary = "Get the list of company contact persons")
    public List<CompanyContactResponse> getContactName(Integer companyId) {
        return constructionSiteManagementService.getContactName(companyId);
    }

    @PostMapping("/new")
    @Operation(summary = "Register new construction site")
    public Integer addNewConstructionSite (@RequestBody NewConstructionSiteRequest newConstructionSiteRequest) {
        return constructionSiteManagementService.addNewConstructionSite(newConstructionSiteRequest);
    }

    @PostMapping ("/new/subcontractor")
    @Operation(summary = "Add new subcontractor to the construction site")
    public void addNewSubContractor (@RequestParam Integer companyId, @RequestParam Integer constructionSiteId) {
        constructionSiteManagementService.addNewSubContractor(companyId, constructionSiteId);
    }

    @GetMapping ("/all/subcontractor")
    @Operation(summary = "Get the subcontractors list from construction site")
    public List<CompanyConstructionSiteListResponse> getAllCompaniesFromSite (@RequestParam Integer constructionSiteId) {
        return constructionSiteManagementService.getAllCompaniesFromSite(constructionSiteId);
    }

    @DeleteMapping ("/delete")
    @Operation(summary = "Delete subcontractor from the construction site by company and site IDs")
    public void removeSubcontractorFromSiteByIds (@RequestParam Integer companyId, @RequestParam Integer siteId) {
        constructionSiteManagementService.removeSubcontractorFromSiteByIds(companyId, siteId);
    }

    @GetMapping ("/name")
    @Operation(summary = "Get the header information for report")
    public ReportConstructionSiteInfo getReportConstructionSiteInfo (@RequestParam Integer constructionSiteId, @RequestParam Integer reportId) {
        return constructionSiteManagementService.getReportConstructionSiteInfo(constructionSiteId, reportId);
    }

    @GetMapping("/all/company")
    @Operation(summary = "Get all companies with main constructor from construction site")
    public List<CompanyConstructionSiteListResponse> getAllCompaniesWithMainContractor (@RequestParam Integer constructionSiteId) {
        return constructionSiteManagementService.getAllCompaniesWithMainContractor(constructionSiteId);
    }


}
