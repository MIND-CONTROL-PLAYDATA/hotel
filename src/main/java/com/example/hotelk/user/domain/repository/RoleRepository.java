package com.example.hotelk.user.domain.repository;

import com.example.hotelk.user.domain.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RoleRepository extends JpaRepository<Role, Long> {
    @Query("from Role where name=:name")
    Role findByName(@Param("name") String name);
}
