package com.chefencasa.service;

import com.chefencasa.Model.Rating;
import com.chefencasa.Model.Recipe;
import com.chefencasa.Repository.RatingRepository;

public class RatingService {

    private static RatingService service;

    RatingRepository ratingRepository = RatingRepository.getInstance();

    RecipeService recipeService = RecipeService.getInstance();

    UserService userService = UserService.getInstance();

    public static RatingService getInstance() {
        if(service == null) {
            service = new RatingService();
        }
        return service;
    }

    public Rating saveOrUpdateRating(grpc.Rating.RatingDTO ratingDTO) throws Exception {
        Rating toPersist = mapToEntity(ratingDTO);
        Rating persisted = ratingRepository.saveOrUpdateRating(toPersist);
        return persisted;
    }

    public Rating getById (int idRating) throws Exception{

        Rating rating = ratingRepository.getById(idRating);

        return rating;
    }

    private Rating mapToEntity (grpc.Rating.RatingDTO dto) throws Exception{
        Rating u = new Rating();
        u.setValue(dto.getValue());
        u.setUser(userService.getById(dto.getIdUser()));
        u.setRecipe(recipeService.getById(dto.getIdRecipe()));

        return u;
    }
}
