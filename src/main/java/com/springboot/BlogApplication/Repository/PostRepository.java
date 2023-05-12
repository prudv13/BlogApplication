package com.springboot.BlogApplication.Repository;

import com.springboot.BlogApplication.Entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
