package com.chefencasa.Infraestructure.Producer.Json;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Lob;

@Getter
@Setter
public class CreateRecipeJson {
    @JsonProperty("recipeId")
    private int recipeId;

    @JsonProperty("title")
    private String title;

    @JsonProperty("username")
    private String username;

    @JsonProperty("url")
    private String file;
}
