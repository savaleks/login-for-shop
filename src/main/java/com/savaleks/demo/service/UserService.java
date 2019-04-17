package com.savaleks.demo.service;

import com.savaleks.demo.model.User;

public interface UserService {

    void save(User user);

    User findByUsername(String username);
}
