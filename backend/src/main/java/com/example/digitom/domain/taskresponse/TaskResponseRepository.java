package com.example.digitom.domain.taskresponse;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TaskResponseRepository extends JpaRepository<TaskResponse, Integer> {
    @Query("select t from TaskResponse t where t.task.id = ?1")
    TaskResponse findTaskResponseByTaskId(Integer id);

    @Query("select (count(t) > 0) from TaskResponse t where t.task.id = ?1")
    boolean existsByTaskId(Integer id);



}