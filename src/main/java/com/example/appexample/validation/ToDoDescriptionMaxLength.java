package com.example.appexample.validation;

import com.example.appexample.payload.ToDoDtoRequest;

public class ToDoDescriptionMaxLength {

    public void validation(ToDoDtoRequest request){
        if (request.getDescription().length() > 30) {
            throw new IllegalStateException("ToDo description length more than 30 ...");
        }
    }
}
