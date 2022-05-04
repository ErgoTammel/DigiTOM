package com.example.digitom.domain.safetyfield;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SafetyFieldRepository extends JpaRepository<SafetyField, Integer> {


    @Override
    Optional<SafetyField> findById(Integer integer);
}