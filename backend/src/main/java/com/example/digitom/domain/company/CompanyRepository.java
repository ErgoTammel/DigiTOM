package com.example.digitom.domain.company;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company, Integer> {


    @Override
    Optional<Company> findById(Integer integer);






}