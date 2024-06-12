package com.clozano.firstapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Vote {
    @Id @GeneratedValue
    private Long id;

    private int vote;

    // user
        
    // link
    
    public Vote(Long id, int vote) {
        this.id = id;
        this.vote = vote;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getVote() {
        return vote;
    }

    public void setVote(int vote) {
        this.vote = vote;
    }

    @Override
    public String toString() {
        return "Vote [id=" + id + ", vote=" + vote + "]";
    }
}
