package com.savaleks.demo.repository;

import com.savaleks.demo.model.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Long> {

    Role findByName(String name);
}
