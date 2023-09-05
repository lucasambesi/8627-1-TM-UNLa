package com.chefencasa.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name="steps")
public class Step {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idStep")
    private int idStep;

    @Column(name = "description", nullable = true)
    private String description;

    @ManyToOne(optional = false, cascade = {CascadeType.MERGE,
            CascadeType.REFRESH}, targetEntity = Recipe.class)
    private Recipe recipe;


}
