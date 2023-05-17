package com.springboot.BlogApplication.Repository;

import com.springboot.BlogApplication.Entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    public List<Comment> findCommentByPostId(Long postId);
}
