package com.example.digitom.domain.taskresponsepicture;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface TaskResponsePictureRepository extends JpaRepository<TaskResponsePicture, Integer> {
    Optional<TaskResponsePicture> findByTaskResponse_Id(Integer id);

    @Query("select t from TaskResponsePicture t where t.taskResponse.task.id = ?1")
    TaskResponsePicture findByTaskId(Integer id);

    @Query("select t from TaskResponsePicture t where t.taskResponse.id = ?1")
    TaskResponsePicture findByTaskResponseId(Integer id);






}