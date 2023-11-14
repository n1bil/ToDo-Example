package com.example.appexample.service.serviceImpl;

import com.example.appexample.entity.ToDo;
import com.example.appexample.exception.NotFoundException;
import com.example.appexample.payload.ToDoDtoRequest;
import com.example.appexample.payload.ToDoDtoResponse;
import com.example.appexample.repository.ToDoRepository;
import com.example.appexample.utils.ToDoConverters;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TodoServiceImpl  {

    private final ToDoRepository repository;
    private final ToDoConverters converters;

    public ToDoDtoResponse addTodo(ToDoDtoRequest request){

        ToDo newToDo = converters.converterFromRequestToTodo(request);
        newToDo = repository.save(newToDo);
        return ToDoConverters.converterFromTodoToResponse(newToDo);

    }

    public List<ToDoDtoResponse> findAll() {
        return repository.findAll().stream()
                .map(ToDoConverters::converterFromTodoToResponse)
                .collect(Collectors.toList());
    }

    public ToDoDtoResponse findById(Integer id) {
        ToDo toDo = repository.findById(id).orElseThrow(() -> new NotFoundException("ToDo not found"));
        return ToDoConverters.converterFromTodoToResponse(toDo);
    }

    public List<ToDoDtoResponse> findAllByUser(Integer userId) {
        List<ToDo> todosByUser = repository.findByUserId(userId);

        return todosByUser.stream()
                .map(ToDoConverters::converterFromTodoToResponse)
                .collect(Collectors.toList());
    }

    public ToDoDtoResponse updateToDo(ToDoDtoRequest request) {
        ToDo updatedToDo = converters.converterFromRequestToTodo(request);
        repository.save(updatedToDo);
        return ToDoConverters.converterFromTodoToResponse(updatedToDo);
    }

    public boolean deleteToDo(Integer id) {
        return repository.delete(id);
    }
}



















