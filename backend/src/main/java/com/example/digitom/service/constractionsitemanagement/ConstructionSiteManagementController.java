package com.example.digitom.service.constractionsitemanagement;

import com.example.digitom.domain.company.Company;
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

//    @PostMapping("/addnew")
//    public void addNewConstructionSite (@RequestBody NewConstructionSiteRequest newConstructionSiteRequest) {
//        constructionSiteManagementService.addNewConstructionSite(newConstructionSiteRequest);
//    }

}
