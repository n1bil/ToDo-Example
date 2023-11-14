package com.example.appexample.payload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class UserDtoRequest {
    private String username;
    private String password;
    private String email;

}