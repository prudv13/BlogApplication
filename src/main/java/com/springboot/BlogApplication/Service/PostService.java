package com.springboot.BlogApplication.Service;

import com.springboot.BlogApplication.DTO.PostDTO;

import java.util.List;

public interface PostService {
    public PostDTO createPost(PostDTO postDTO);

    public List<PostDTO> getAllPosts();
}
