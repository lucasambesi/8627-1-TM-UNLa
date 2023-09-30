package com.chefencasa.Infraestructure.Consumer.Json;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PopularityRecipeJson {

    @JsonProperty("idRecipe")
    private int idRecipe;

    @JsonProperty("score")
    private String score;
}
