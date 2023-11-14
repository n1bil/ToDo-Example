package com.example.appexample.controller;

import com.example.appexample.payload.ToDoDtoRequest;
import com.example.appexample.payload.ToDoDtoResponse;
import com.example.appexample.service.serviceImpl.TodoServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
public class TodoController {

    private TodoServiceImpl service;

    public TodoController(TodoServiceImpl toDoService) {
        this.service = toDoService;
    }

    @PostMapping("/")
    public ResponseEntity<ToDoDtoResponse> addTodo(@RequestBody ToDoDtoRequest todoDto) {
        ToDoDtoResponse toDo = service.addTodo(todoDto);

        return new ResponseEntity<>(toDo, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<ToDoDtoResponse>> findAllTodos() {
        List<ToDoDtoResponse> todos = service.findAll();

        return new ResponseEntity<>(todos, HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<ToDoDtoResponse>> findToDosByUserId(@PathVariable Integer userId) {
        List<ToDoDtoResponse> todos = service.findAllByUser(userId);

        return new ResponseEntity<>(todos, HttpStatus.OK);
    }

    @GetMapping("/{todoId}")
    public ResponseEntity<ToDoDtoResponse> findToDoById(@PathVariable Integer todoId) {
        ToDoDtoResponse todo = service.findById(todoId);

        return new ResponseEntity<>(todo, HttpStatus.OK);
    }

    @PutMapping("/")
    public ResponseEntity<ToDoDtoResponse> updateTodo(@RequestBody ToDoDtoRequest todoDto) {
        ToDoDtoResponse todo = service.updateToDo(todoDto);

        return new ResponseEntity<>(todo, HttpStatus.OK);
    }

    @DeleteMapping("/{todoId}")
    public ResponseEntity<Boolean> deleteComment(@PathVariable Integer todoId) {
        boolean response = service.deleteToDo(todoId);

        return new ResponseEntity<>(response, HttpStatus.OK);

    }
}
