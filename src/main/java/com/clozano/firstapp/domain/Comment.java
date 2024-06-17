package com.clozano.firstapp.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

// https://projectlombok.org/features/
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor          // pour ne pas avoir besoin d'écrire le constructeur vide
@RequiredArgsConstructor    // pour avoir un constructeur avec en argument requis ceux qui sont flagué @NonNull
//@Data                       // avoir les setter, getter, toString, requiredArgsConstructor, equalsAndHashCode
@Getter
@Setter
@ToString
public class Comment extends Auditable {
    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    private String body;

    @ManyToOne
    private Link link;

    public Comment(@NonNull String body, Link link) {
        this.body = body;
        this.link = link;
    }
}
