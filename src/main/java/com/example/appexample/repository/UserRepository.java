package com.example.appexample.repository;

import com.example.appexample.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    User save(User entity);

    List<User> findAll();

    Optional<User> findById(Integer id);

    Optional<User> findByEmail(String email);

}
