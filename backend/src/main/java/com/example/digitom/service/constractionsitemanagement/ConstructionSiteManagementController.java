package com.example.digitom.service.constractionsitemanagement;

import com.example.digitom.domain.company.Company;
import com.example.digitom.domain.company.CompanyDto;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RequestMapping("/construction-site")
@RestController
public class ConstructionSiteManagementController {

    @Resource
    private ConstructionSiteManagementService constructionSiteManagementService;

    @GetMapping("/all")
    public List<CompanyNameResponse> getAllCompanies() {
        return constructionSiteManagementService.getAllCompanies();
    }

    @GetMapping("/contact")
    public List<CompanyContactResponse> getContactName(Integer companyId) {
        return constructionSiteManagementService.getContactName(companyId);
    }

    @PostMapping("/new")
    public Integer addNewConstructionSite (@RequestBody NewConstructionSiteRequest newConstructionSiteRequest) {
        return constructionSiteManagementService.addNewConstructionSite(newConstructionSiteRequest);
    }

    @PostMapping ("/new/subcontractor")
    public void addNewSubContractor (@RequestParam Integer companyId, @RequestParam Integer constructionSiteId) {
        constructionSiteManagementService.addNewSubContractor(companyId, constructionSiteId);
    }

    @GetMapping ("/all/companies")
    public List<CompanyDto> getAllCompaniesFromSite (@RequestParam Integer constructionSiteId) {
        return constructionSiteManagementService.getAllCompaniesFromSite(constructionSiteId);
    }

    @DeleteMapping ("/delete")
    public void removeSubcontractorFromSiteByIds (@RequestParam Integer companyId, @RequestParam Integer siteId) {
        constructionSiteManagementService.removeSubcontractorFromSiteByIds(companyId, siteId);
    }

}
