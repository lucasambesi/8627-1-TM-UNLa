package com.chefencasa.Infraestructure.Consumer.Json;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PopularityUserJson {
    @JsonProperty("idUser")
    private int idUser;

    @JsonProperty("score")
    private String score;
}
