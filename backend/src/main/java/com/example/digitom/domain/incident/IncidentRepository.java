package com.example.digitom.domain.incident;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IncidentRepository extends JpaRepository<Incident, Integer> {
    @Query("select i from Incident i where i.report.id = ?1 and i.safetyField.id = ?2 and i.safe = ?3")
    List<Incident> findByReportIdAndSafetyFieldIdAndSafe(Integer id, Integer id1, Boolean safe);




}