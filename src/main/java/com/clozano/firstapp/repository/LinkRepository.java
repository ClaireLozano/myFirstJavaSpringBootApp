package com.clozano.firstapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clozano.firstapp.domain.Link;

public interface LinkRepository extends JpaRepository<Link,Long> { // Type de l'entity et type de l'ID de l'entity
    
}
