package com.chefencasa.Model;

import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
}
