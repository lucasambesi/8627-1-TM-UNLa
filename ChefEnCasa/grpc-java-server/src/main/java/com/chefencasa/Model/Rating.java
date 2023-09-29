package com.chefencasa.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name="rating")
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idRating")
    private int idRating;

    @Column(name="value")
    private int value;

    @ManyToOne (cascade={CascadeType.ALL, CascadeType.REFRESH})
    @JoinColumn (name = "idRecipe")
    private Recipe recipe;

    @ManyToOne (cascade={CascadeType.ALL, CascadeType.REFRESH})
    @JoinColumn (name = "idUser")
    private User user;

}
