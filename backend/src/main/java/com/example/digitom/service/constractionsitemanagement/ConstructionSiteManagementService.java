package com.example.digitom.service.constractionsitemanagement;

import com.example.digitom.domain.company.Company;
import com.example.digitom.domain.company.CompanyDto;
import com.example.digitom.domain.company.CompanyService;
import com.example.digitom.domain.companyconstructionsite.CompanyConstructionSiteService;
import com.example.digitom.domain.companyuser.CompanyUserService;
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

    @Resource
    private CompanyConstructionSiteService companyConstructionSiteService;


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

    public Integer addNewConstructionSite(NewConstructionSiteRequest newConstructionSiteRequest) {
        Integer constructionSiteId = constructionSiteService.addNewConstructionSite(newConstructionSiteRequest);
        companyConstructionSiteService.addNewMainContractorConnection(newConstructionSiteRequest, constructionSiteId);
        return constructionSiteId;
    }

    public void addNewSubContractor(Integer companyId, Integer constructionSiteId) {
        companyConstructionSiteService.addNewSubContractor(companyId, constructionSiteId);
    }

    public List<CompanyDto> getAllCompaniesFromSite(Integer constructionSiteId) {
        return companyConstructionSiteService.getAllCompaniesFromSite(constructionSiteId);
    }
}
