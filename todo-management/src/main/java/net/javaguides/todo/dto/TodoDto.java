package net.javaguides.todo.dto;

import lombok.Data;

@Data
public class TodoDto {

    private Long id;
    private String title;
    private  String description;
    private String status;

}
