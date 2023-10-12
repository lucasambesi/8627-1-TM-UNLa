package com.chefencasa.Controller;

import com.chefencasa.Infraestructure.Producer.CreateRecipeProducer;
import com.chefencasa.Model.RecipeImage;
import com.chefencasa.Model.Step;
import com.chefencasa.service.RecipeService;
import com.chefencasa.service.UserService;
import grpc.Recipe;
import grpc.RecipeControllerGrpc;
import grpc.User;
import io.grpc.stub.StreamObserver;

import java.util.Base64;
import java.util.List;

public class RecipeController extends RecipeControllerGrpc.RecipeControllerImplBase {
    public RecipeService recipeService = RecipeService.getInstance();
    public UserService userService = UserService.getInstance();

    public RecipeController() {
    }

    public void addRecipe(Recipe.RecipeDTO request, StreamObserver<Recipe.RecipeObjDTO> responseObserver) {
        Recipe.RecipeObjDTO.Builder response = Recipe.RecipeObjDTO.newBuilder();
        Recipe.RecipeServerResponse.Builder serverResponse = Recipe.RecipeServerResponse.newBuilder();

        try {
            com.chefencasa.Model.Recipe recipe = this.recipeService.addRecipe(request);
            response.setRecipe(this.mapRecipeDTO(recipe));
            serverResponse.setCode(200);
            serverResponse.setMsg("Recipe created");
        } catch (Exception var6) {
            serverResponse.setCode(500);
            serverResponse.setMsg(var6.getMessage());
        }

        response.setServerResponse(serverResponse);
        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }

    public void updateRecipe(Recipe.RecipeDTO request, StreamObserver<Recipe.RecipeObjDTO> responseObserver) {
        Recipe.RecipeObjDTO.Builder response = Recipe.RecipeObjDTO.newBuilder();
        Recipe.RecipeServerResponse.Builder serverResponse = Recipe.RecipeServerResponse.newBuilder();

        try {
            com.chefencasa.Model.Recipe recipe = this.recipeService.updateRecipe(request);
            response.setRecipe(this.mapRecipeDTO(recipe));
            serverResponse.setCode(200);
            serverResponse.setMsg("Recipe updated");
        } catch (Exception var6) {
            serverResponse.setCode(500);
            serverResponse.setMsg(var6.getMessage());
        }

        response.setServerResponse(serverResponse);
        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }

    public void getRecipe(Recipe.GetRecipeRequest request, StreamObserver<Recipe.RecipeObjDTO> responseObserver) {
        com.chefencasa.Model.Recipe recipe = null;
        Recipe.RecipeServerResponse.Builder serverResponse = Recipe.RecipeServerResponse.newBuilder();
        Recipe.RecipeObjDTO.Builder response = Recipe.RecipeObjDTO.newBuilder();

        try {
            recipe = this.recipeService.getById(request.getIdRecipe());
            response.setRecipe(this.mapRecipeDTO(recipe));
            serverResponse.setCode(200);
            serverResponse.setMsg("Recipe found");

        } catch (Exception var7) {
            serverResponse.setCode(500);
            serverResponse.setMsg(var7.getMessage());
        }

        response.setServerResponse(serverResponse);
        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }

   public void getAllRecipes(Recipe.Empty request, StreamObserver<Recipe.RecipesDTO> responseObserver) {
        Recipe.RecipesDTO.Builder recipesDTO = Recipe.RecipesDTO.newBuilder();
        Recipe.RecipeServerResponse.Builder serverResponse = Recipe.RecipeServerResponse.newBuilder();
        try {
            List<com.chefencasa.Model.Recipe> recipes = this.recipeService.getAll();
            for (com.chefencasa.Model.Recipe recipe : recipes) {
                recipesDTO.addRecipes(mapRecipeDTO(recipe));
            }
            recipesDTO.setServerResponse(serverResponse);
        } catch (Exception e) {
            serverResponse.setCode(500);
            serverResponse.setMsg(e.getMessage());
        }
        responseObserver.onNext(recipesDTO.build());
        responseObserver.onCompleted();
    }

    public void getRecipesByUserId(Recipe.IdUserRequest request, StreamObserver<Recipe.RecipesDTO> responseObserver) {
        Recipe.RecipesDTO.Builder recipesDTO = Recipe.RecipesDTO.newBuilder();
        Recipe.RecipeServerResponse.Builder serverResponse = Recipe.RecipeServerResponse.newBuilder();
        try {
            List<com.chefencasa.Model.Recipe> recipes = recipeService.getByUserId(request.getIdUser());
            for (com.chefencasa.Model.Recipe recipe : recipes) {
                recipesDTO.addRecipes(mapRecipeDTO(recipe));
            }
            recipesDTO.setServerResponse(serverResponse);
        } catch (Exception e) {
            serverResponse.setCode(500);
            serverResponse.setMsg(e.getMessage());
        }
        responseObserver.onNext(recipesDTO.build());
        responseObserver.onCompleted();
    }

    public void getFavotires(Recipe.IdUserRequest request, StreamObserver<Recipe.RecipesDTO> responseObserver) {
        Recipe.RecipesDTO.Builder recipesDTO = Recipe.RecipesDTO.newBuilder();
        Recipe.RecipeServerResponse.Builder serverResponse = Recipe.RecipeServerResponse.newBuilder();
        try {
            List<com.chefencasa.Model.Recipe> recipes = userService.getFavorites(request.getIdUser());
            for (com.chefencasa.Model.Recipe recipe : recipes) {
                recipesDTO.addRecipes(mapRecipeDTO(recipe));
            }
            recipesDTO.setServerResponse(serverResponse);
        } catch (Exception e) {
            serverResponse.setCode(500);
            serverResponse.setMsg(e.getMessage());
        }
        responseObserver.onNext(recipesDTO.build());
        responseObserver.onCompleted();
    }

    public void getByFilter(Recipe.GetByFilterRequest request, StreamObserver<Recipe.RecipesDTO> responseObserver) {
        Recipe.RecipesDTO.Builder response = Recipe.RecipesDTO.newBuilder();
        Recipe.RecipeServerResponse.Builder serverResponse = Recipe.RecipeServerResponse.newBuilder();
        try {
            List<com.chefencasa.Model.Recipe> recipes = recipeService.getByFilter(
                    request.getIdCategory(),
                    request.getTitle(),
                    request.getIngredients(),
                    request.getTimeSince(),
                    request.getTimeUntil(),
                    request.getPageNumber(),
                    request.getPageSize()
            );
            for(com.chefencasa.Model.Recipe p : recipes){
                response.addRecipes(mapRecipeDTO(p));
            }
            serverResponse.setCode(200);
            serverResponse.setMsg("");
        } catch (Exception e) {
            serverResponse.setCode(500);
            serverResponse.setMsg(e.getMessage());
        }
        response.setServerResponse(serverResponse);
        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }

    public void getRecipesByPopularity(Recipe.GetPopularityRecipeRequest request, StreamObserver<Recipe.RecipesDTO> responseObserver) {
        Recipe.RecipesDTO.Builder recipesDTO = Recipe.RecipesDTO.newBuilder();
        Recipe.RecipeServerResponse.Builder serverResponse = Recipe.RecipeServerResponse.newBuilder();
        try {
            List<com.chefencasa.Model.Recipe> recipes = recipeService.getRecipesByPopularity(
                    request.getPageSize(),
                    request.getPageNumber());

            for (com.chefencasa.Model.Recipe recipe : recipes) {
                recipesDTO.addRecipes(mapRecipeDTO(recipe));
            }
            recipesDTO.setServerResponse(serverResponse);
        } catch (Exception e) {
            serverResponse.setCode(500);
            serverResponse.setMsg(e.getMessage());
        }
        responseObserver.onNext(recipesDTO.build());
        responseObserver.onCompleted();
    }

    public Recipe.RecipeDTO.Builder mapRecipeDTO (com.chefencasa.Model.Recipe u){
        Recipe.RecipeDTO.Builder dto = Recipe.RecipeDTO.newBuilder();

        dto.setIdRecipe(u.getIdRecipe());
        dto.setIdUser(u.getUser().getIdUser());
        dto.setTitle(u.getTitle());
        dto.setDescription(u.getDescription());
        dto.setIngredients(u.getIngredients());
        dto.setPreparationTime(u.getPreparationTime());
        dto.setIdCategory(u.getCategory().getIdCategory());
        dto.setPopularity(u.getPopularity());
        dto.setActive(u.isActive());

        for(Step step: u.getSteps()){
            grpc.Step.StepDTO.Builder stepDTO = grpc.Step.StepDTO.newBuilder();
            stepDTO.setIdStep(step.getIdStep());
            stepDTO.setDescription(step.getDescription());

            dto.addSteps(stepDTO);
        }

        for(RecipeImage image: u.getImages()){
            Recipe.RecipeImageDTO.Builder tempImgDTO = Recipe.RecipeImageDTO.newBuilder();

            tempImgDTO.setIdImage(image.getIdImage());
            tempImgDTO.setName(image.getName());
            tempImgDTO.setFile(Base64.getEncoder().encodeToString(image.getFile()));

            dto.addImages(tempImgDTO);
        }

        return dto;
    }

}
