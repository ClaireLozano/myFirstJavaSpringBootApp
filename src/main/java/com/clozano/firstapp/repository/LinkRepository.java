package com.clozano.firstapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clozano.firstapp.domain.Link;

public interface LinkRepository extends JpaRepository<Link, Long> { // Type de l'entity et type de l'ID de l'entity
    // Link findByTitle(String title);

    // List<Link> findAllByTitleLikeOrderByCreationDateDesc(String titleString);
}
