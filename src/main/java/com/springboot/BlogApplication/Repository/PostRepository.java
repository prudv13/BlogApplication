package com.springboot.BlogApplication.Repository;

import com.springboot.BlogApplication.Entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    public List<Post> findByCategoryId(Long categoryId);
}
