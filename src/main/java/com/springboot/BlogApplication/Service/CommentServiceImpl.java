package com.springboot.BlogApplication.Service;

import com.springboot.BlogApplication.DTO.CommentDTO;
import com.springboot.BlogApplication.Entity.Comment;
import com.springboot.BlogApplication.Entity.Post;
import com.springboot.BlogApplication.Exception.ResourceNotFoundException;
import com.springboot.BlogApplication.Repository.CommentRepository;
import com.springboot.BlogApplication.Repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService{

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private PostRepository postRepository;

    // entity to DTO
    private CommentDTO mapToDTO(Comment comment){
        CommentDTO commentDTO = new CommentDTO();
        commentDTO.setId(comment.getId());
        commentDTO.setName(comment.getName());
        commentDTO.setEmail(comment.getEmail());
        commentDTO.setBody(comment.getBody());
        return commentDTO;
    }

    // DTO to entity
    private Comment mapToEntity(CommentDTO commentDTO){
        Comment comment = new Comment();
         comment.setId(commentDTO.getId());
         comment.setName(commentDTO.getName());
         comment.setEmail(commentDTO.getEmail());
         comment.setBody(commentDTO.getBody());
         return comment;
    }

    @Override
    public CommentDTO createComment(Long postId, CommentDTO commentDTO) {
        Comment comment = mapToEntity(commentDTO);

        // retrieve post entity by ID
        Post post = postRepository.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post", "id", postId));

        // set post to comment entity
        comment.setPost(post);

        // save comment entity to DB
        Comment newComment = commentRepository.save(comment);
        return mapToDTO(newComment);
    }

    @Override
    public List<CommentDTO> getCommentsByPostId(Long postId) {

        // retrieve comments by postId
        List<Comment> comments = commentRepository.findCommentByPostId(postId);

        // convert list of comment entities to list of comment DTOs
        return comments.stream().map(comment -> mapToDTO(comment)).toList();
    }
}
