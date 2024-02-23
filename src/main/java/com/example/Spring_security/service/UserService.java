package com.example.Spring_security.service;

import com.example.Spring_security.domain.Role;
import com.example.Spring_security.domain.User;

import java.util.List;

public interface UserService {
    User getUser(String username);
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String name,String roleName);
    List<User> getUsers();
}
