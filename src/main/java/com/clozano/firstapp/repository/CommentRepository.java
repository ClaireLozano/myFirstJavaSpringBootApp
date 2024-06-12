package com.clozano.firstapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clozano.firstapp.domain.Comment;

public interface CommentRepository extends JpaRepository<Comment,Long> { 
    
}
