package com.example.digitom.domain.companyconstructionsite;

import com.example.digitom.domain.company.Company;
import com.example.digitom.domain.constructionsite.ConstructionSite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CompanyConstructionSiteRepository extends JpaRepository<CompanyConstructionSite, Integer> {

    @Query("select c from CompanyConstructionSite c where c.company.id = ?1")
    List<CompanyConstructionSite> findByCompanyId(Integer id);

    @Query("select c from CompanyConstructionSite c where c.constructionSite.id = ?1 and c.mainContractor = ?2")
    List<CompanyConstructionSite> findByConstructionSiteId(Integer id, Boolean mainContractor);

    @Query("select c from CompanyConstructionSite c where c.company.id = ?1 and c.constructionSite.id = ?2")
    CompanyConstructionSite findByCompanyIdAndConstructionSiteId(Integer id, Integer id1);


}