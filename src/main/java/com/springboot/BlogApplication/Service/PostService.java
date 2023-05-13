package com.springboot.BlogApplication.Service;

import com.springboot.BlogApplication.DTO.PostDTO;

import java.util.List;

public interface PostService {
    public PostDTO createPost(PostDTO postDTO);

    public List<PostDTO> getAllPosts(int pageNo, int pageSize);

    public PostDTO getPostById(Long id);

    public PostDTO updatePostById(PostDTO postDTO, Long id);

    public void deletePostById(Long id);
}
