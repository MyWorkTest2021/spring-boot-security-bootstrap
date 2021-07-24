package com.work.boot.service;

import com.work.boot.entity.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    User getById(Long id);

    User findByUsername(String s);

    User updateUser(User user);

    User addUser(User user);

    void deleteUser(Long id);


}
