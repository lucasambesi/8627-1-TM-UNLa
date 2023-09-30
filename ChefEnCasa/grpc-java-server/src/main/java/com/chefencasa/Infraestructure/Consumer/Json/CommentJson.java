package com.chefencasa.Infraestructure.Consumer.Json;

import com.chefencasa.Model.Comment;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentJson {
    @JsonProperty("idRecipe")
    private int idRecipe;

    @JsonProperty("idUser")
    private int idUser;

    @JsonProperty("comment")
    private String value;
}

