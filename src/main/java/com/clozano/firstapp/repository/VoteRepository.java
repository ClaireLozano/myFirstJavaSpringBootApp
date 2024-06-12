package com.clozano.firstapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clozano.firstapp.domain.Vote;

public interface VoteRepository extends JpaRepository<Vote,Long> {
    
}
