package com.example.digitom.domain.companyconstructionsite;

import com.example.digitom.domain.companyuser.CompanyUser;
import com.example.digitom.domain.constructionsite.ConstructionSite;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class CompanyConstructionSiteService {

    @Resource
    private CompanyConstructionSiteRepository companyConstructionSiteRepository;


//    public List<CompanyConstructionSite> getCompanyConstructionSites(List<CompanyUser> companyUsers) {
//        List<Integer> companyIDs = new ArrayList<>();
//        for (CompanyUser companyUser : companyUsers) {
//            Integer companyID = companyUser.getId();
//            companyIDs.add(companyID);
//        }
//        return companyConstructionSiteRepository.findByCompanyId(companyIDs);
//    }

    public List<ConstructionSite> getAllConstructionSites(List<Integer> allUserCompanyIds) {
        List<ConstructionSite> companyConstructionSites = new ArrayList<>();
        for (Integer allUserCompanyId : allUserCompanyIds) {
            List<CompanyConstructionSite> found = companyConstructionSiteRepository.findByCompanyId(allUserCompanyId);
            for (CompanyConstructionSite companyConstructionSite : found) {
                companyConstructionSites.add(companyConstructionSite.getConstructionSite());
            }
        }
        return companyConstructionSites;
    }
}
