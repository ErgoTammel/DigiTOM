package com.example.digitom.domain.incident;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IncidentRepository extends JpaRepository<Incident, Integer> {
    @Query("select i from Incident i where i.report.id = ?1 and i.safetyField.id = ?2 and i.safe = ?3")
    List<Incident> findByReportIdAndSafetyFieldIdAndSafe(Integer id, Integer id1, Boolean safe);

    @Query("select i from Incident i where i.report.id = ?1 and i.safetyField.id = ?2 and i.safe = ?3 order by i.id")
    List<Incident> incidents(Integer id, Integer id1, Boolean safe);

    Incident findFirstByReport_IdAndSafetyField_IdAndSafeOrderByIdDesc(Integer id, Integer id1, Boolean safe);

    @Query("select i from Incident i where i.report.id = ?1")
    List<Incident> findByReportId(Integer id);

    @Query("select count(i) from Incident i where i.safetyField.id = ?1 and i.report.id = ?2 and i.safe = ?3")
    long countBySafetyField_IdAndReport_IdAndSafe(Integer id, Integer id1, Boolean safe);

    @Query("select i from Incident i where i.report.id = ?1 and i.safe = ?2")
    List<Incident> findByReportIdAndSafe(Integer id, Boolean safe);









}