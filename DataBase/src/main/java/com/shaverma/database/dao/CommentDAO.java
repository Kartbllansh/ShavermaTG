package com.shaverma.database.dao;

import com.shaverma.database.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentDAO extends JpaRepository<Comment, Long> {
}
