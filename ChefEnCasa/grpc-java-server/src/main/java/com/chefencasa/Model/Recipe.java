package com.chefencasa.Model;

import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.*;

@Entity
@Getter
@Setter
@Table(name="recipes")
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idRecipe")
    private int idRecipe;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", nullable = true)
    private String description;

    @Column(name = "ingredients", nullable = true)
    private String ingredients;

    @Column(name = "preparationTime", nullable = false)
    @Type(type="int")
    private int preparationTime;

    @Column(name = "popularity", nullable = false)
    @Type(type="int")
    private int popularity;

    @ManyToOne (cascade={CascadeType.DETACH,CascadeType.REFRESH})
    @JoinColumn (name = "category")
    private Category category;

    @ManyToOne(optional = false, cascade = {
            CascadeType.REFRESH}, targetEntity = User.class)
    private User user;

    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE,
            CascadeType.REFRESH}, targetEntity = Step.class)
    private List<Step> steps = new ArrayList<>();

    @OneToMany(cascade= CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true, mappedBy="recipe")
    private Set<RecipeImage> images;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipe recipe = (Recipe) o;
        return idRecipe == recipe.idRecipe;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idRecipe);
    }
}
