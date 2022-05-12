package com.example.digitom.domain.report;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ReportRepository extends JpaRepository<Report, Integer> {


    @Override
    Optional<Report> findById(Integer integer);

    @Query("select r from Report r " +
            "where r.id = ?1 or r.constructionSite.name like concat('%', ?2, '%') or r.date = ?3 " +
            "order by r.id DESC")
    List<Report> reportSearch(Integer id, String name, LocalDate date);

    @Query("select r from Report r where r.constructionSite.id = ?1 order by r.date DESC")
    List<Report> findReportsByConstructionSiteId(Integer id);

    @Query("select r from Report r where r.inspectorId = ?1 order by r.date DESC")
    List<Report> getInspectorReports(Integer inspectorId);

    @Query("select r from Report r where r.inspectorId = ?1 order by r.id DESC")
    List<Report> getReportsByInspectorId(Integer inspectorId);


}