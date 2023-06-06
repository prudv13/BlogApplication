package com.springboot.BlogApplication.Service;

import com.springboot.BlogApplication.DTO.PostDTO;
import com.springboot.BlogApplication.Payload.PostResponse;

import java.util.List;

public interface PostService {
    public PostDTO createPost(PostDTO postDTO);

    public PostResponse getAllPosts(int pageNo, int pageSize, String sortBy, String sortDir);

    public PostDTO getPostById(Long id);

    public PostDTO updatePostById(PostDTO postDTO, Long id);

    public void deletePostById(Long id);

    public List<PostDTO> getPostsByCategory(Long categoryId);
}
