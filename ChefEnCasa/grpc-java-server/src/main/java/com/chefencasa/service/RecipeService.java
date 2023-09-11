package com.chefencasa.service;

import com.chefencasa.Model.Category;
import com.chefencasa.Model.Recipe;
import com.chefencasa.Model.Step;
import com.chefencasa.Model.User;
import com.chefencasa.Repository.RecipeRepository;
import com.chefencasa.Repository.UserRepository;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RecipeService {
    private static RecipeService service;

    public static RecipeService getInstance() {
        if(service == null) {
            service = new RecipeService();
        }
        return service;
    }

    public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    RecipeRepository recipeRepository = RecipeRepository.getInstance();

    UserService userService = UserService.getInstance();

    CategoryService categoryService = CategoryService.getInstance();

    public Recipe addRecipe(grpc.Recipe.RecipeDTO recipeDTO) throws Exception {
        Recipe toPersist = mapToEntity(recipeDTO);
        Recipe persisted = recipeRepository.createRecipe(toPersist);

        return persisted;
    }

    public Recipe updateRecipe(grpc.Recipe.RecipeDTO recipeDTO) throws Exception{

        Recipe recipe = null;

        try{
            recipe = recipeRepository.getById(recipeDTO.getIdRecipe());
            Recipe toPersist = mapToEntity(recipeDTO);
            recipe = recipeRepository.updateRecipe(toPersist);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            throw new Exception ("ATENCION: Error en updateRecipe");
        }

        return recipe;
    }

    public Recipe getById (int idRecipe) throws Exception{
        return recipeRepository.getById(idRecipe);
    }

    public List<Recipe> getAll() throws Exception{
        return recipeRepository.getAll();
    }

    public List<Recipe> getByUserId(int idUser) throws Exception{
        User user = userService.getById(idUser);
        return recipeRepository.getByUser(user);
    }

    public List<Recipe> getByFilter(int idCategory, String title, String ingredients, int timeSince, int timeUntil) throws Exception{

        Category categoria = idCategory == 0 ? null : categoryService.getById(idCategory);
        return recipeRepository.getByFilter(categoria, title, ingredients, timeSince, timeUntil);
    }

    private Recipe mapToEntity (grpc.Recipe.RecipeDTO dto) throws Exception{
        Recipe u = new Recipe();

        u.setIdRecipe(dto.getIdRecipe());
        u.setTitle(dto.getTitle());
        u.setDescription(dto.getDescription());
        u.setIngredients(dto.getIngredients());
        u.setPreparationTime(dto.getPreparationTime());
        u.setUser(userService.getById(dto.getIdUser()));
        u.setCategory(categoryService.getById(dto.getIdCategory()));

        List<Step> steps = new ArrayList<>();

        for(grpc.Step.StepDTO stepDTO : dto.getStepsList()){
            Step step = new Step();
            step.setIdStep(stepDTO.getIdStep());
            step.setDescription(stepDTO.getDescription());

            steps.add(step);
        }

        u.setSteps(steps);

        return u;
    }
}
