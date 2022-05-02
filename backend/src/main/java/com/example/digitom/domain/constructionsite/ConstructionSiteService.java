package com.example.digitom.domain.constructionsite;

import com.example.digitom.service.constractionsitemanagement.NewConstructionSiteRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ConstructionSiteService {

    @Resource
    private ConstructionSiteRepository constructionSiteRepository;

    @Resource
    private ConstructionSiteMapper constructionSiteMapper;

    public List<ConstructionSite> findAllConstructionSitesById(List<Integer> constructionSiteIDs) {
        return constructionSiteRepository.findById(constructionSiteIDs);
    }

    public List<ConstructionSite> findAllConstructionSites() {
        return constructionSiteRepository.findAll();
    }


    public Integer addNewConstructionSite(NewConstructionSiteRequest newConstructionSiteRequest) {
        ConstructionSite constructionSite = constructionSiteMapper.requestToConstructionSite(newConstructionSiteRequest);
        constructionSite.setAddress(newConstructionSiteRequest.getSiteAddress());
        constructionSite.setName(newConstructionSiteRequest.getSiteName());
        constructionSiteRepository.save(constructionSite);
        return constructionSite.getId();
    }
}
