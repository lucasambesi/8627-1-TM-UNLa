package com.chefencasa.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name="images")
public class RecipeImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idImage")
    private int idImage;

    @Column(name="name")
    private String name;

    @Column (name = "file")
    @Basic(fetch = FetchType.LAZY)
    @Lob
    private byte[] file;

    @ManyToOne (cascade={CascadeType.ALL, CascadeType.REFRESH})
    @JoinColumn (name = "idRecipe")
    private Recipe recipe;

}
