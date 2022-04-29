package com.example.digitom.service.inspection;

import com.example.digitom.domain.companyconstructionsite.CompanyConstructionSite;
import com.example.digitom.domain.companyconstructionsite.CompanyConstructionSiteService;
import com.example.digitom.domain.companyuser.CompanyUser;
import com.example.digitom.domain.companyuser.CompanyUserService;
import com.example.digitom.domain.constructionsite.ConstructionSite;
import com.example.digitom.domain.constructionsite.ConstructionSiteService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class InspectionService {

    @Resource
    private CompanyUserService companyUserService;
    @Resource
    private CompanyConstructionSiteService companyConstructionSiteService;
    @Resource
    private ConstructionSiteService constructionSiteService;

    public List<ConstructionSite> getConstructionSites(Integer userId) {
        List<CompanyUser> allUserCompanies = companyUserService.getAllUserCompanies(userId);
        List<CompanyConstructionSite> companyConstructionSites=companyConstructionSiteService.getCompanyConstructionSites(allUserCompanies);
        List<Integer> constructionSiteIDs = new ArrayList<>();
        for (CompanyConstructionSite companyConstructionSite : companyConstructionSites) {

            constructionSiteIDs.add(companyConstructionSite.getId());
        }

        return constructionSiteService.findAllConstructionSitesById(constructionSiteIDs);
    }
}
