package com.example.digitom.domain.task;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task, Integer> {

    @Query("select t from Task t where t.report.id = ?1")
    List<Task> findByReportId(Integer id);

    @Query("select t from Task t " +
            "where t.incident.report.id = ?1 and t.incident.safetyField.id = ?2 and t.incident.safe = ?3 " +
            "order by t.id DESC")
    List<Task> findByReportIdAndSafetyFieldIdAndSafe(Integer id, Integer id1, Boolean safe);


    @Override
    Optional<Task> findById(Integer integer);

    @Override
    void deleteById(Integer integer);

    @Query("select t from Task t where t.report.constructionSite.id = ?1 and t.isDone = ?2 order by t.deadline")
    List<Task> findByCompany_IdAndIsDone(Integer id, Boolean isDone);


    @Query("select t from Task t where t.report.constructionSite.id = ?1 and t.isDone = ?2")
    List<Task> findOpenTasksBySiteId(Integer id, Boolean isDone);

    @Query("select t from Task t where t.company.id = ?1 and t.isDone = ?2 order by t.deadline")
    List<Task> findByCompanyId(Integer id, Boolean isDone);









}