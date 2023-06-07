package com.springboot.BlogApplication.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Schema(description = "CommentDTO Model Information")
public class CommentDTO {
    private Long id;

    @NotEmpty(message = "Name should not be null or empty")
    @Size(min = 2)
    @Schema(description = "Blog post - Comment name")
    private String name;

    @NotEmpty(message = "Email should not be null or empty")
    @Email
    @Schema(description = "Blog post - Comment user email")
    private String email;

    @NotEmpty(message = "Comment body should not be null or empty")
    @Size(min = 10, message = "Comment body should be at least 10 characters")
    @Schema(description = "Blog post - Comment body")
    private String body;
}
