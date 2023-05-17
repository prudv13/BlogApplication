package com.springboot.BlogApplication.Service;

import com.springboot.BlogApplication.DTO.CommentDTO;

import java.util.List;

public interface CommentService {

    public CommentDTO createComment(Long postId, CommentDTO commentDTO);

    public List<CommentDTO> getCommentsByPostId(Long postId);
}
