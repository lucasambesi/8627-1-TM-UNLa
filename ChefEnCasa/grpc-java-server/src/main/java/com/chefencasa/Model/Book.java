package com.chefencasa.Model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name="books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idBook")
    private int idBook;

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @Column(name="active", nullable = false)
    private boolean Active;

    @Setter(AccessLevel.NONE)
    @OneToMany(cascade = {
            CascadeType.REFRESH}, targetEntity = Recipe.class)
    private Set<Recipe> recipes = new HashSet<>();

    @ManyToOne (cascade={CascadeType.ALL, CascadeType.REFRESH})
    @JoinColumn (name = "idUser")
    private User user;
}
