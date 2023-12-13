package com.dreamer.webap.repository;

import com.dreamer.webap.models.Users;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface UserRepo extends CrudRepository<Users, String> {
    Users findByUsername(String username);
}
