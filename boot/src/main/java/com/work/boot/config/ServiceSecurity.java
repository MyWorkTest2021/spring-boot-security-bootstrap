package com.work.boot.config;

import com.work.boot.entity.Role;
import com.work.boot.entity.User;
import com.work.boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ServiceSecurity implements UserDetailsService {

    private final UserService userService;

    public ServiceSecurity(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        User user = userService.findByUsername(s);
        if (user == null) {
            throw new UsernameNotFoundException("Unknown user: " + s);
        }
        return new org.springframework.security.core.userdetails
                .User(user.getUsername(),user.getPassword(),
                 mapRolesToAuthorities(user.getRoles()));
    }
    private Set<? extends GrantedAuthority> mapRolesToAuthorities(Set<Role> roles) {
        return roles.stream().map(r -> new SimpleGrantedAuthority(r.getRole())).
                collect(Collectors.toSet());
    }
}
