package com.springboot.BlogApplication.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Set;

@Data
@Schema(description = "PostDTO Model Information")
public class PostDTO {
    private Long id;

    @NotEmpty
    @Size(min = 2, message = "Post Title should have at least 2 characters")
    @Schema(description = "Blog Post title")
    private String title;

    @NotEmpty
    @Size(min = 10, message = "Post description should have at least 10 characters")
    @Schema(description = "Blog Post description")
    private String description;

    @NotEmpty
    @Schema(description = "Blog Post content")
    private String content;

    @Schema(description = "Blog Post comments")
    private Set<CommentDTO> comments;

    @Schema(description = "Blog Post category")
    private Long categoryId;

}
