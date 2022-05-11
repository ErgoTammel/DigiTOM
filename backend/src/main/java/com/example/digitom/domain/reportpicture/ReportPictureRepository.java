package com.example.digitom.domain.reportpicture;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReportPictureRepository extends JpaRepository<ReportPicture, Integer> {
    @Query("select r from ReportPicture r where r.report.id = ?1")
    List<ReportPicture> findByReportId(Integer id);

    @Query("select r from ReportPicture r where r.task.id = ?1")
    ReportPicture findByTaskId(Integer id);

    @Query("select r from ReportPicture r where r.task.id = ?1")
    ReportPicture getByTaskId(Integer id);



}