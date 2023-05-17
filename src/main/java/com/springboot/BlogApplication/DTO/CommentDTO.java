package com.springboot.BlogApplication.DTO;

import lombok.Data;

@Data
public class CommentDTO {
    private Long id;
    private String name;
    private String email;
    private String body;
}
