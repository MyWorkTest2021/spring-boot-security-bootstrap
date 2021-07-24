package com.work.boot.repository;

import com.work.boot.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepo extends JpaRepository<Role,Long> {

    @Query("select role from Role ")
    List<String>getRoleNamesToList();
}
