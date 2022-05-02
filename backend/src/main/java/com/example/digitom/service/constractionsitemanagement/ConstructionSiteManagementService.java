package com.example.digitom.service.constractionsitemanagement;

import com.example.digitom.domain.company.Company;
import com.example.digitom.domain.company.CompanyRepository;
import com.example.digitom.domain.company.CompanyService;
import com.example.digitom.domain.companyuser.CompanyUserService;
import com.example.digitom.domain.constructionsite.ConstructionSite;
import com.example.digitom.domain.constructionsite.ConstructionSiteService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class ConstructionSiteManagementService {

    @Resource
    private ConstructionSiteService constructionSiteService;

    @Resource
    private CompanyUserService companyUserService;

    @Resource
    private CompanyService companyService;

    public List<CompanyNameResponse> getAllCompanies() {
        List<Company> allCompanies = companyService.findAllCompanies();
        List<CompanyNameResponse> companyNameResponses = new ArrayList<>();
        for (Company company : allCompanies) {
            CompanyNameResponse companyNameResponse = new CompanyNameResponse();
            companyNameResponse.setCompanyId(company.getId());
            companyNameResponse.setCompanyName(company.getName());
            companyNameResponses.add(companyNameResponse);
        }
        return companyNameResponses;
    }

    public List<CompanyContactResponse> getContactName(Integer companyId) {
        return companyUserService.getCompanyUsersByCompanyId(companyId);
    }

//    public void addNewConstructionSite(NewConstructionSiteRequest newConstructionSiteRequest) {
//        ConstructionSite constructionSite =
//    }
}
