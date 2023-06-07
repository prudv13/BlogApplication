package com.springboot.BlogApplication.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "CategoryDTO Model Information")
public class CategoryDTO {
    private Long id;

    @Schema(description = "Post Category name")
    private String name;

    @Schema(description = "Post Category description")
    private String description;
}
