package com.savaleks.demo.repository;

import com.savaleks.demo.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    
    User findByUsername(String username);
}
