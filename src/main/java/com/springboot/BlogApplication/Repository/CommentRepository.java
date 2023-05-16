package com.springboot.BlogApplication.Repository;

import com.springboot.BlogApplication.Entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
