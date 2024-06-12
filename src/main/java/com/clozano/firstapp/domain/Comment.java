package com.clozano.firstapp.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

// https://projectlombok.org/features/
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@NoArgsConstructor          // pour ne pas avoir besoin d'écrire le constructeur vide
@RequiredArgsConstructor    // pour avoir un constructeur avec en argument requis ceux qui sont flagué @NonNull
@Data                       // avoir les setter, getter, toString, requiredArgsConstructor, equalsAndHashCode
public class Comment {
    @Id
    @GeneratedValue
    @NonNull
    private Long id;

    @NonNull
    private String body;

    // link
}
