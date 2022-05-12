package com.example.digitom.domain.taskresponsepicture;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TaskResponsePictureRepository extends JpaRepository<TaskResponsePicture, Integer> {
    Optional<TaskResponsePicture> findByTaskResponse_Id(Integer id);




}