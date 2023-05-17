package com.springboot.BlogApplication.Service;

import com.springboot.BlogApplication.DTO.CommentDTO;

public interface CommentService {

    public CommentDTO createComment(Long postId, CommentDTO commentDTO);
}
