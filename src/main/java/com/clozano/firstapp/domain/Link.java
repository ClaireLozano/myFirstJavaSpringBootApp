package com.clozano.firstapp.domain;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@NoArgsConstructor          
@Data
public class Link extends Auditable {
    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    private String title;

    @NonNull
    private String url;

    @OneToMany(mappedBy = "link") // Un link pour plusieurs commentaires
    private List<Comment> comments = new ArrayList<>();

    // todo: temporaire, dans le tuto il ne comprend pas pk il n'a pas de constructeur avec title et url
    public Link(@NonNull String title, @NonNull String url) {
        this.title = title;
        this.url = url;
    }

    // todo: idem, il comprend pas pk il a a le faire à la main
    public void addComment(Comment comment) {
        comments.add(comment);
    }
}
