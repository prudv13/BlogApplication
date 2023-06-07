package com.springboot.BlogApplication.Controller;

import com.springboot.BlogApplication.DTO.CategoryDTO;
import com.springboot.BlogApplication.Service.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@Tag(name="CRUD REST APIs for Category Controller")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    @SecurityRequirement(name = "Bearer Authentication")
    @Operation(summary = "Create Category REST API", description = "This API is used to save new categories into the database")
    @ApiResponse(responseCode = "201", description = "Http Status 201 CREATED")
    public ResponseEntity<CategoryDTO> addCategory(@RequestBody CategoryDTO categoryDTO){
        CategoryDTO savedCategory = categoryService.addCategory(categoryDTO);
        return new ResponseEntity<>(savedCategory, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get Category REST API", description = "This API is used to fetch a Category with ID as reference from the database")
    @ApiResponse(responseCode = "200", description = "Http Status 200 OK")
    public ResponseEntity<CategoryDTO> getCategory(@PathVariable("id") Long categoryId){
        CategoryDTO category = categoryService.getCategory(categoryId);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    @GetMapping
    @Operation(summary = "Get All Categories REST API", description = "This API is used to fetch a list of all categories from the database")
    @ApiResponse(responseCode = "200", description = "Http Status 200 OK")
    public ResponseEntity<List<CategoryDTO>> getAllCategory(){
        List<CategoryDTO> categories = categoryService.getAllCategories();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    @SecurityRequirement(name = "Bearer Authentication")
    @Operation(summary = "Update Category REST API", description = "This API is used to update an existing category in the database")
    @ApiResponse(responseCode = "200", description = "Http Status 200 OK")
    public ResponseEntity<CategoryDTO> updateCategory(@RequestBody CategoryDTO categoryDTO, @PathVariable("id") Long categoryId){
        CategoryDTO updatedCategory = categoryService.updateCategory(categoryDTO, categoryId);
        return new ResponseEntity<>(updatedCategory, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    @SecurityRequirement(name = "Bearer Authentication")
    @Operation(summary = "Delete Category REST API", description = "This API is used to delete an existing category in the database")
    @ApiResponse(responseCode = "200", description = "Http Status 200 OK")
    public ResponseEntity<String> deleteCategory(@PathVariable("id") Long categoryId){
        categoryService.deleteCategory(categoryId);
        return new ResponseEntity<>("Category deleted successfully!", HttpStatus.OK);
    }
}
