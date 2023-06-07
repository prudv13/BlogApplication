package com.springboot.BlogApplication.Controller;

import com.springboot.BlogApplication.DTO.PostDTO;
import com.springboot.BlogApplication.Payload.PostResponse;
import com.springboot.BlogApplication.Service.PostService;
import static com.springboot.BlogApplication.Utils.ApplicationConstants.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
@Tag(name="CRUD REST APIs for Post Controller")
public class PostController {

    @Autowired
    private PostService postService;

    @PreAuthorize("hasRole('ADMIN')")
    @SecurityRequirement(name = "Bearer Authentication")
    @Operation(summary = "Create Post REST API", description = "This API is used to save new posts into the database")
    @ApiResponse(responseCode = "201", description = "Http Status 201 CREATED")
    @PostMapping
    public ResponseEntity<PostDTO> createPost(@Valid @RequestBody PostDTO postDTO){
        return new ResponseEntity<>(postService.createPost(postDTO), HttpStatus.CREATED);
    }

    @GetMapping
    @Operation(summary = "Get All Posts REST API", description = "This API is used to fetch a list of all posts from the database")
    @ApiResponse(responseCode = "200", description = "Http Status 200 OK")
    public PostResponse getAllPosts(
            @RequestParam(value = "pageNo", defaultValue = DEFAULT_PAGE_NUMBER, required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = DEFAULT_PAGE_SIZE, required = false) int pageSize,
            @RequestParam(value = "sortBy", defaultValue = DEFAULT_SORT_BY, required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = DEFAULT_SORT_DIRECTION, required = false) String sortDir
    ){
        return postService.getAllPosts(pageNo, pageSize, sortBy, sortDir);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get Post REST API", description = "This API is used to fetch a post with ID as reference from the database")
    @ApiResponse(responseCode = "200", description = "Http Status 200 OK")
    public ResponseEntity<PostDTO> getPostById(@PathVariable(name = "id") Long id){
        return ResponseEntity.ok(postService.getPostById(id));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @SecurityRequirement(name = "Bearer Authentication")
    @Operation(summary = "Update Post REST API", description = "This API is used to update an existing post in the database")
    @ApiResponse(responseCode = "200", description = "Http Status 200 OK")
    @PutMapping("/{id}")
    public ResponseEntity<PostDTO> updatePost(@Valid @RequestBody PostDTO postDTO, @PathVariable(name = "id") Long id){
        PostDTO postResponse = postService.updatePostById(postDTO, id);
        return new ResponseEntity<>(postResponse, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @SecurityRequirement(name = "Bearer Authentication")
    @Operation(summary = "Delete Post REST API", description = "This API is used to delete an existing post in the database")
    @ApiResponse(responseCode = "200", description = "Http Status 200 OK")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePostById(@PathVariable(name = "id") Long id){
        postService.deletePostById(id);
        return new ResponseEntity<>("Post entity deleted successfully", HttpStatus.OK);
    }

    @GetMapping("/category/{id}")
    @Operation(summary = "Get Posts by Category ID REST API", description = "This API is used to fetch posts with same category ID from the database")
    @ApiResponse(responseCode = "200", description = "Http Status 200 OK")
    public ResponseEntity<List<PostDTO>> getPostsByCategory(@PathVariable(name = "id") Long categoryId){
        List<PostDTO> posts = postService.getPostsByCategory(categoryId);
        return ResponseEntity.ok(posts);
    }
}
