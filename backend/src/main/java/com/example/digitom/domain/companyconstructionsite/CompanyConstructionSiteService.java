package com.example.digitom.domain.companyconstructionsite;

import com.example.digitom.domain.company.Company;
import com.example.digitom.domain.company.CompanyMapper;
import com.example.digitom.domain.company.CompanyRepository;
import com.example.digitom.domain.constructionsite.ConstructionSite;
import com.example.digitom.domain.constructionsite.ConstructionSiteRepository;
import com.example.digitom.service.constractionsitemanagement.NewConstructionSiteRequest;
import com.example.digitom.validation.ValidationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CompanyConstructionSiteService {

    @Resource
    private CompanyConstructionSiteRepository companyConstructionSiteRepository;

    @Resource
    private ConstructionSiteRepository constructionSiteRepository;

    @Resource
    private CompanyRepository companyRepository;

    @Resource
    private CompanyMapper companyMapper;

    @Resource
    private CompanyConstructionSiteMapper companyConstructionSiteMapper;
    @Resource
    private ValidationService validationService;


//    public List<CompanyConstructionSite> getCompanyConstructionSites(List<CompanyUser> companyUsers) {
//        List<Integer> companyIDs = new ArrayList<>();
//        for (CompanyUser companyUser : companyUsers) {
//            Integer companyID = companyUser.getId();
//            companyIDs.add(companyID);
//        }
//        return companyConstructionSiteRepository.findByCompanyId(companyIDs);
//    }

    public List<ConstructionSite> getConstructionSitesByUserCompanyIds(List<Integer> userCompanyIds) {
        List<ConstructionSite> constructionSites = new ArrayList<>();
        for (Integer userCompanyId : userCompanyIds) {
            List<CompanyConstructionSite> found = companyConstructionSiteRepository.findByCompanyId(userCompanyId);
            for (CompanyConstructionSite companyConstructionSite : found) {
                constructionSites.add(companyConstructionSite.getConstructionSite());
            }
        }
        return constructionSites;
    }

    public void addNewMainContractorConnection(NewConstructionSiteRequest newConstructionSiteRequest, Integer constructionSiteId) {

        newConstructionSiteRequest.getMainContractorCompanyId();
        CompanyConstructionSite companyConstructionSite = new CompanyConstructionSite();
        Optional<ConstructionSite> foundSite = constructionSiteRepository.findById(constructionSiteId);
        companyConstructionSite.setConstructionSite(foundSite.get());
        Optional<Company> foundMainCompany = companyRepository.findById(newConstructionSiteRequest.getMainContractorCompanyId());
        companyConstructionSite.setCompany(foundMainCompany.get());
        companyConstructionSite.setMainContractor(true);
        companyConstructionSiteRepository.save(companyConstructionSite);

    }

    public void addNewSubContractor(Integer companyId, Integer constructionSiteId) {
        String companyName = companyRepository.findById(companyId).get().getName();
        Boolean exist = companyConstructionSiteRepository.existByCompanyIdAndConstructionSiteId(companyId, constructionSiteId);
        validationService.companyConstructionSiteExist(companyName, exist);


        CompanyConstructionSite companyConstructionSite = new CompanyConstructionSite();
        companyConstructionSite.setCompany(companyRepository.getById(companyId));
        companyConstructionSite.setConstructionSite(constructionSiteRepository.getById(constructionSiteId));
        companyConstructionSite.setMainContractor(false);
        companyConstructionSiteRepository.save(companyConstructionSite);

    }

    public List<CompanyConstructionSiteListResponse> getAllCompaniesFromSite(Integer constructionSiteId) {
        List<CompanyConstructionSite> constructionSiteCompanies = companyConstructionSiteRepository.findByConstructionSiteId(constructionSiteId, false);
        return companyConstructionSiteMapper.toCCSListResponses(constructionSiteCompanies);
    }


    public void removeSubcontractorFromSiteByIds(Integer companyId, Integer siteId) {
        CompanyConstructionSite companyConstructionSite = companyConstructionSiteRepository.findByCompanyIdAndConstructionSiteId(companyId, siteId);
        companyConstructionSiteRepository.delete(companyConstructionSite);
    }

    public Company getMainContractor (Integer siteId, Boolean mainContractor) {
       return companyConstructionSiteRepository.findByConstructionSiteIdAndMainContractor(siteId, true).getCompany();
    }
}

