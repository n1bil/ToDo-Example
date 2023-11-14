package com.example.appexample.utils;

import com.example.appexample.entity.ToDo;
import com.example.appexample.entity.User;
import com.example.appexample.exception.NotFoundException;
import com.example.appexample.payload.ToDoDtoRequest;
import com.example.appexample.payload.ToDoDtoResponse;
import com.example.appexample.repository.ToDoRepository;
import com.example.appexample.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ToDoConverters {

    private final ToDoRepository repository;
    private final UserRepository userRepository;

    public ToDo converterFromRequestToTodo(ToDoDtoRequest request) {

        Optional<User> author = userRepository.findById(request.getUserId());

        if (author.isEmpty()) {
            throw new NotFoundException("Request user id not found");
        }

        ToDo entity = new ToDo();
        entity.setTitle(request.getTitle());
        entity.setDescription(request.getDescription());
        entity.setCreationDate(LocalDateTime.now());
        entity.setAuthor(author.get());
        return entity;
    }

    public static ToDoDtoResponse converterFromTodoToResponse(ToDo entity) {

        ToDoDtoResponse response = new ToDoDtoResponse();
        response.setId(entity.getId());
        response.setTitle(entity.getTitle());
        response.setDescription(entity.getDescription());
        response.setCreationDate(entity.getCreationDate());
        response.setUserId(entity.getAuthor().getId());
        return response;
    }
}
