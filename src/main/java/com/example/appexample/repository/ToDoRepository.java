package com.example.appexample.repository;

import com.example.appexample.entity.ToDo;

import java.util.List;
import java.util.Optional;

public interface ToDoRepository {

    ToDo save(ToDo entity);

    List<ToDo> findAll();

    Optional<ToDo> findById(Integer id);

    List<ToDo> findByUserId(Integer userId);

    boolean delete(Integer id);
}
