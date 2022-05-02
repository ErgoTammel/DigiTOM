package com.example.digitom.domain.constructionsite;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ConstructionSiteService {

    @Resource
    private ConstructionSiteRepository constructionSiteRepository;

    public List<ConstructionSite> findAllConstructionSitesById(List<Integer> constructionSiteIDs) {
        return constructionSiteRepository.findById(constructionSiteIDs);
    }

    public List<ConstructionSite> findAllConstructionSites() {
        return constructionSiteRepository.findAll();

    }
}
