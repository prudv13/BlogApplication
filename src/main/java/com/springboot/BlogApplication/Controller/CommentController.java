package com.springboot.BlogApplication.Controller;

import com.springboot.BlogApplication.DTO.CommentDTO;
import com.springboot.BlogApplication.Service.CommentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Tag(name="CRUD REST APIs for Comment Controller")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/posts/{postId}/comments")
    @Operation(summary = "Create Comment REST API", description = "This API is used to save new comments into the database")
    @ApiResponse(responseCode = "201", description = "Http Status 201 CREATED")
    public ResponseEntity<CommentDTO> createComment(
            @PathVariable(value = "postId") Long postId,
            @Valid @RequestBody CommentDTO commentDTO)
    {
        return new ResponseEntity<>(commentService.createComment(postId, commentDTO), HttpStatus.CREATED);
    }

    @GetMapping("/posts/{postId}/comments")
    @Operation(summary = "Get Comments by Post ID REST API", description = "This API is used to fetch a list of comments with Post ID as reference from the database")
    @ApiResponse(responseCode = "200", description = "Http Status 200 OK")
    public List<CommentDTO> getCommentsByPostId(@PathVariable(value = "postId") Long postId){
        return commentService.getCommentsByPostId(postId);
    }

    @GetMapping("/posts/{postId}/comments/{commentId}")
    @Operation(summary = "Get Comments by ID REST API", description = "This API is used to fetch a comment with ID as reference from the database")
    @ApiResponse(responseCode = "200", description = "Http Status 200 OK")
    public ResponseEntity<CommentDTO> getCommentById(
            @PathVariable(value = "postId") Long postId,
            @PathVariable(value = "commentId") Long commentId)
    {
        CommentDTO commentDTO = commentService.getCommentById(postId, commentId);
        return new ResponseEntity<>(commentDTO, HttpStatus.OK);
    }

    @PutMapping("/posts/{postId}/comments/{commentId}")
    @Operation(summary = "Update Comment REST API", description = "This API is used to update an existing comment in the database")
    @ApiResponse(responseCode = "200", description = "Http Status 200 OK")
    public ResponseEntity<CommentDTO> updateComment(
            @PathVariable(value = "postId") Long postId,
            @PathVariable(value = "commentId") Long commentId,
            @Valid @RequestBody CommentDTO commentDTO)
    {
        CommentDTO updatedComment = commentService.updateComment(postId, commentId, commentDTO);
        return new ResponseEntity<>(updatedComment, HttpStatus.OK);
    }

    @DeleteMapping("/posts/{postId}/comments/{commentId}")
    @Operation(summary = "Delete Comment REST API", description = "This API is used to delete an existing comment in the database")
    @ApiResponse(responseCode = "200", description = "Http Status 200 OK")
    public ResponseEntity<String> deleteComment(
            @PathVariable(value = "postId") Long postId,
            @PathVariable(value = "commentId") Long commentId)
    {
        commentService.deleteComment(postId, commentId);
        return new ResponseEntity<>("Comment deleted successfully", HttpStatus.OK);
    }

}
