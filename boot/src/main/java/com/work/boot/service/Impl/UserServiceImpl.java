package com.work.boot.service.Impl;

import com.work.boot.entity.User;
import com.work.boot.repository.UserRepo;
import com.work.boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepo userRepo;

    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public User addUser(User user)  {
       return userRepo.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepo.deleteById(id);

    }

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public User updateUser(User user) {
        return userRepo.save(user);
    }


    @Override
    public User getById(Long id) {
        return userRepo.findById(id).get();
    }

    @Override
    public User findByUsername(String s) {
        List<User>users = getAllUsers();
        return users.stream().filter(x -> x.getName().equals(s)).findAny().orElse(null);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        List<User>users = getAllUsers();
        return users.stream().filter(x -> x.getName().equals(s)).findAny().orElse(null);
    }
}
