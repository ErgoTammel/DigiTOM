package com.example.digitom.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.OptionalDouble;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("select (count(u) > 0) from User u where upper(u.email) = upper(?1)")
    boolean existsByEmail(String email);

    @Query("select u from User u where upper(u.email) = upper(?1) and u.password = ?2")
    Optional<User> findByEmailAndPassword(String email, String password);

}