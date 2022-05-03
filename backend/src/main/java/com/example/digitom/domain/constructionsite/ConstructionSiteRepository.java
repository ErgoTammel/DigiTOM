package com.example.digitom.domain.constructionsite;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ConstructionSiteRepository extends JpaRepository<ConstructionSite, Integer> {


    @Query("select c from ConstructionSite c where c.id = ?1")
    List<ConstructionSite> findById(List <Integer> integer);

    @Query("select c from ConstructionSite c where c.id = ?1")
    ConstructionSite findConstructionSiteById(Integer id);



}