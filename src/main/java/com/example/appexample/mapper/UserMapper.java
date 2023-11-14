package com.example.appexample.mapper;

import java.util.stream.Collectors;

public class UserMapper {

//    public static UserDtoRequest mapToUser(UserDto userDto) {
//        return UserDtoRequest.builder()
//                .username(userDto.getUsername())
//                .password(userDto.getPassword())
//                .email(userDto.getEmail())
//                .toDos(userDto.getTodos()
//                        .stream().map(ToDoMapper::mapToTodo)
//                        .collect(Collectors.toList()))
//                .build();
//    }
//
//    public static UserDto mapToUserDto(UserDtoRequest user) {
//        return UserDto.builder()
//                .username(user.getUsername())
//                .password(user.getPassword())
//                .email(user.getEmail())
//                .todos(user.getToDos().stream()
//                        .map(ToDoMapper::mapToToDoDto)
//                        .collect(Collectors.toList()))
//                .build();
//    }
}
