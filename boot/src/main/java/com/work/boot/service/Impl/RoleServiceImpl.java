package com.work.boot.service.Impl;

import com.work.boot.entity.Role;
import com.work.boot.repository.RoleRepo;
import com.work.boot.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepo roleRepo;

    public RoleServiceImpl(RoleRepo roleRepo) {
        this.roleRepo = roleRepo;
    }

    @Override
    public List<String> getRoleNamesToList() {
        return roleRepo.getRoleNamesToList();
    }

    @Override
    public Role getRoleByName(String name) {
        List<Role>roles=getAllRoles();

        return roles.stream().filter(x-> x.getRole().equals(name)).findAny().orElse(null);
    }

    @Override
    public List<Role> getAllRoles() {
        return roleRepo.findAll();
    }
}
