package com.example.digitom.domain.role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    @Query("select r from Role r where upper(r.name) = upper(?1)")
    Role findByName(String name);


}