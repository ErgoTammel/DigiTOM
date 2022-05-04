package com.example.digitom.domain.report;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ReportRepository extends JpaRepository<Report, Integer> {


    @Override
    Optional<Report> findById(Integer integer);
}