package com.chefencasa.service;

import com.chefencasa.Model.*;
import com.chefencasa.Repository.RatingRepository;

import java.util.List;

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

    public Rating saveRating(grpc.Rating.RatingDTO ratingDTO) throws Exception {
        Rating toPersist = mapToEntity(ratingDTO);
        Rating persisted = ratingRepository.saveOrUpdateRating(toPersist);
        return persisted;
    }

    public Rating updateRating(grpc.Rating.RatingDTO ratingDTO) throws Exception{

        Rating rating = null;

        try{
            rating = ratingRepository.getById(ratingDTO.getIdRating());

            Rating toPersist = mapToEntity(ratingDTO);

            rating.setValue(toPersist.getValue());

            rating = ratingRepository.saveOrUpdateRating(rating);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            throw new Exception ("ATENCION: Error en updateRating");
        }

        return rating;
    }

    public Rating getById (int idRating) throws Exception{

        Rating rating = ratingRepository.getById(idRating);

        return rating;
    }

    public Rating getRatingByUserAndRecipe(int idUser, int idRecipe) throws Exception{
        User user = userService.getById(idUser);
        Recipe recipe = recipeService.getById(idRecipe);

        return ratingRepository.getByUserAndRecipe(user, recipe);
    }

    public double getAverageRating(int idRecipe) throws Exception{
        return ratingRepository.getAverageRating(idRecipe);
    }

    public double getRatingCount(int idRecipe) throws Exception{
        return ratingRepository.getRatingCount(idRecipe);
    }

    private Rating mapToEntity (grpc.Rating.RatingDTO dto) throws Exception{
        Rating u = new Rating();
        u.setValue(dto.getValue());
        u.setUser(userService.getById(dto.getIdUser()));
        u.setRecipe(recipeService.getById(dto.getIdRecipe()));

        return u;
    }
}
