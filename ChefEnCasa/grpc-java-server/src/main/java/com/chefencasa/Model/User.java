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
@Table(name="users")

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUser")
    private int idUser;

    @Column(name="name")
    private String name;

    @Column(name="lastname")
    private String lastname;

    @Column(name="dni")
    private String dni;

    @Column(name="email")
    private String email;

    @Column(name="username")
    private String username;

    @Column(name="password")
    private String password;

    @Setter(AccessLevel.NONE)
    @OneToMany(cascade = {CascadeType.MERGE,
            CascadeType.REFRESH}, targetEntity = Recipe.class)
    private Set<Recipe> recipes = new HashSet<>();

    @Setter(AccessLevel.NONE)
    @ManyToMany(cascade = {CascadeType.MERGE,
            CascadeType.REFRESH}, targetEntity = Recipe.class)
    private Set<Recipe> favorites = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE,
            CascadeType.REFRESH}, targetEntity = User.class)
    private Set<User> following = new HashSet<>();
}
