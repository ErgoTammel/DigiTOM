package com.example.digitom.service.constractionsitemanagement;

import com.example.digitom.domain.company.Company;
import com.example.digitom.domain.company.CompanyRepository;
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
    private CompanyRepository companyRepository;

    @Resource
    private ConstructionSiteService constructionSiteService;

    @Resource
    private CompanyUserService companyUserService;

    public List<CompanyNameResponse> getAllCompanies() {
        List<ConstructionSite> allConstructionSites = constructionSiteService.findAllConstructionSites();
        List<CompanyNameResponse> companyNameResponses = new ArrayList<>();
        for (ConstructionSite constructionSite : allConstructionSites) {
            CompanyNameResponse companyNameResponse = new CompanyNameResponse();
            companyNameResponse.setCompanyId(constructionSite.getId());
            companyNameResponse.setCompanyName(constructionSite.getName());
            companyNameResponses.add(companyNameResponse);
        }
        return companyNameResponses;
    }

    public List<CompanyContactResponse> getContactName(Integer companyId) {
        return companyUserService.getCompanyUsersByCompanyId(companyId);
    }
}
