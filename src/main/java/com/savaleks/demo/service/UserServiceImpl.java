package com.savaleks.demo.service;

import com.savaleks.demo.model.Role;
import com.savaleks.demo.model.User;
import com.savaleks.demo.repository.RoleRepository;
import com.savaleks.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashSet;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(User user) {

        user.setRoles(new HashSet<Role>(Collections.singleton(roleRepository.findByName("ROLE_USER"))));
        if (user.getRole().equals("SUPPLIER")){
            user.setRoles(new HashSet<Role>(Collections.singleton(roleRepository.findByName("ROLE_SUPPLIER"))));
        }
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
