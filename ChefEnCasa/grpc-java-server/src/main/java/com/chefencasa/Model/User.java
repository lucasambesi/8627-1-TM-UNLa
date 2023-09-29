package com.chefencasa.Model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
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

    @Column(name = "popularity", nullable = false)
    @Type(type="int")
    private int popularity;

    @Setter(AccessLevel.NONE)
    @OneToMany(cascade = {
            CascadeType.REFRESH}, targetEntity = Recipe.class)
    private Set<Recipe> recipes = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER, cascade = {
            CascadeType.REMOVE}, targetEntity = Recipe.class)
    @JoinTable(
            name = "User_Recipe_Favorites",
            joinColumns = @JoinColumn(name = "User_idUser"),
            inverseJoinColumns = @JoinColumn(name = "recipes_idRecipe")
    )
    private Set<Recipe> favorites = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER, cascade = {
            CascadeType.REMOVE}, targetEntity = User.class)
    private Set<User> following = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return idUser == user.idUser;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUser);
    }
}
