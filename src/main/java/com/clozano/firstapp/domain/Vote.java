package com.clozano.firstapp.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor          
@Getter
@Setter
@ToString
public class Vote extends Auditable {
    @Id
    @GeneratedValue
    private Long id;

    // Pas besoin de @NonNull car l'annotation @NonNull est conçue pour être utilisée sur des références (objets) 
    // pour indiquer qu'elles ne doivent pas être null. Les types primitifs ne peuvent pas être null
    private int vote;

    // user
       
    @ManyToOne
    private Link link;
}
