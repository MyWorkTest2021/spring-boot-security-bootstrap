package com.work.boot.service;

import com.work.boot.entity.Role;

import java.util.List;

public interface RoleService {
    List<String> getRoleNamesToList();

    Role getRoleByName(String name);

    List<Role> getAllRoles();
}
