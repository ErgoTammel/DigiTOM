package com.example.digitom.domain.companyuser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CompanyUserRepository extends JpaRepository<CompanyUser, Integer> {



    @Query("select c from CompanyUser c where c.user.id = ?1")
    List<CompanyUser> findByUserId(Integer id);


}