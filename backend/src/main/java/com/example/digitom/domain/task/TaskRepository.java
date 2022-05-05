package com.example.digitom.domain.task;

import com.example.digitom.domain.report.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Integer> {
    @Query("select t from Task t where t.report.id = ?1")
    List<Task> findTasksByReportId(Integer id);

    @Transactional
    @Modifying
    @Query("delete from Task t where t.report = ?1")
    void deleteTasksByReportId(Report report);






}