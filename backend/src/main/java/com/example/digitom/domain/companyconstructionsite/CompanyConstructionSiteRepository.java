package com.example.digitom.domain.companyconstructionsite;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CompanyConstructionSiteRepository extends JpaRepository<CompanyConstructionSite, Integer> {

    @Query("select c from CompanyConstructionSite c where c.company.id = ?1")
    List<CompanyConstructionSite> findByCompanyId(Integer id);

    @Query("select c from CompanyConstructionSite c where c.constructionSite.id = ?1 and c.mainContractor = ?2")
    List<CompanyConstructionSite> findByConstructionSiteId(Integer id, Boolean mainContractor);





}