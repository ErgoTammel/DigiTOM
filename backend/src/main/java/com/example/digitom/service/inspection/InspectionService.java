package com.example.digitom.service.inspection;

import com.example.digitom.domain.companyconstructionsite.CompanyConstructionSiteService;
import com.example.digitom.domain.companyuser.CompanyUserService;
import com.example.digitom.domain.constructionsite.ConstructionSite;
import com.example.digitom.domain.constructionsite.ConstructionSiteService;
import com.example.digitom.domain.incident.Incident;
import com.example.digitom.domain.incident.IncidentService;
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
    @Resource
    private IncidentService incidentService;


    public List<NewInspectionConstructionSiteResponse> getConstructionSites(Integer userId) {
        List<NewInspectionConstructionSiteResponse> responses = new ArrayList<>();
        List<Integer> allUserCompanyIds = companyUserService.getUserCompanyIdsByUserIds(userId);
        List<ConstructionSite> companyConstructionSites = companyConstructionSiteService.getConstructionSitesByUserCompanyIds(allUserCompanyIds);
        for (ConstructionSite companyConstructionSite : companyConstructionSites) {
            NewInspectionConstructionSiteResponse response = new NewInspectionConstructionSiteResponse();
            response.setConstructionSiteId(companyConstructionSite.getId());
            response.setConstructionSiteName(companyConstructionSite.getName());
            responses.add(response);
        }
        return responses;
    }

    public void addNewIncident(IncidentRequest incidentRequest) {

        incidentService.addNewIncident(incidentRequest);
    }
}

