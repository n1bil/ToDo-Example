package com.example.appexample.payload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class ToDoDtoRequest {
    private String title;
    private String description;
    private Integer userId;

}
