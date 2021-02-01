package com.blog.registration.repository;

import com.blog.registration.model.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Long> {

    Role findByName(String name);

}
