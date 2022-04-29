package com.example.digitom.service.inspection;

import com.example.digitom.domain.companyconstructionsite.CompanyConstructionSite;
import com.example.digitom.domain.companyconstructionsite.CompanyConstructionSiteService;
import com.example.digitom.domain.companyuser.CompanyUser;
import com.example.digitom.domain.companyuser.CompanyUserService;
import com.example.digitom.domain.constructionsite.ConstructionSite;
import com.example.digitom.domain.constructionsite.ConstructionSiteService;
import com.example.digitom.service.account.NewInspectionConstructionSiteResponse;
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

    public List<NewInspectionConstructionSiteResponse> getConstructionSites(Integer userId) {
        List<NewInspectionConstructionSiteResponse> responses= new ArrayList<>();
        List<Integer> allUserCompanyIds = companyUserService.getAllUserCompanyIds(userId);
        List<ConstructionSite> allCompanyConstructionSiteIds=companyConstructionSiteService.getAllConstructionSites(allUserCompanyIds);
        for (ConstructionSite allCompanyConstructionSiteId : allCompanyConstructionSiteIds) {
            NewInspectionConstructionSiteResponse response = new NewInspectionConstructionSiteResponse();
            response.setConstructionSiteId(allCompanyConstructionSiteId.getId());
            response.setConstructionSiteName(allCompanyConstructionSiteId.getName());
            responses.add(response);
        }

        return responses;
    }
}
