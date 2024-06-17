package com.clozano.firstapp.domain;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor          
@Getter
@Setter
@ToString
@RequiredArgsConstructor
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

    // todo: temporaire, il comprend pas pk il a a le faire à la main
    public void addComment(Comment comment) {
        comments.add(comment);
    }
}
