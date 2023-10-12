package com.chefencasa.service;

import com.chefencasa.Infraestructure.Producer.CreateRecipeProducer;
import com.chefencasa.Model.*;
import com.chefencasa.Repository.RecipeRepository;
import com.chefencasa.Repository.StepRepository;

import java.text.SimpleDateFormat;
import java.util.*;

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

    StepRepository stepRepository = StepRepository.getInstance();

    CategoryService categoryService = CategoryService.getInstance();

    CreateRecipeProducer createRecipeProducer = CreateRecipeProducer.getInstance();

    public Recipe addRecipe(grpc.Recipe.RecipeDTO recipeDTO) throws Exception {
        Recipe toPersist = mapToEntity(recipeDTO);

        Set<RecipeImage> images = toPersist.getImages();
        toPersist.setImages(new HashSet<>());
        toPersist.setActive(true);

        List<Step> steps = toPersist.getSteps();
        toPersist.setSteps(new ArrayList<>());

        Recipe persisted = recipeRepository.saveOrUpdateRecipe(toPersist);

        for(RecipeImage image : images ){
            image.setRecipe(persisted);
            recipeRepository.saveOrUpdateImage(image);
        }

        for(Step step : steps ){
            step.setRecipe(persisted);
            stepRepository.createStep(step);
        }

        persisted.setImages(images);
        persisted.setSteps(steps);

        createRecipeProducer.send(persisted.getTitle(), persisted);

        return persisted;
    }

    public Recipe updateRecipe(grpc.Recipe.RecipeDTO recipeDTO) throws Exception{

        Recipe recipe = null;

        try{
            recipe = recipeRepository.getById(recipeDTO.getIdRecipe());

            Recipe toPersist = mapToEntity(recipeDTO);

            recipe.setTitle(toPersist.getTitle());
            recipe.setDescription(toPersist.getDescription());
            recipe.setIngredients(toPersist.getIngredients());
            recipe.setPreparationTime(toPersist.getPreparationTime());
            recipe.setActive(toPersist.isActive());

            recipe = recipeRepository.saveOrUpdateRecipe(recipe);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            throw new Exception ("ATENCION: Error en updateRecipe");
        }

        return recipe;
    }

    public Recipe getById (int idRecipe) throws Exception{

        Recipe recipe = recipeRepository.getById(idRecipe);

        return recipe;
    }

    public List<Recipe> getAll() throws Exception{
        return recipeRepository.getAll();
    }

    public List<Recipe> getByUserId(int idUser) throws Exception{
        User user = userService.getById(idUser);
        return recipeRepository.getByUser(user);
    }

    public List<Recipe> getByFilter(int idCategory, String title, String ingredients, int timeSince, int timeUntil, int pageNumber, int pageSize) throws Exception{
        Category categoria = idCategory == 0 ? null : categoryService.getById(idCategory);
        return recipeRepository.getByFilter(categoria, title, ingredients, timeSince, timeUntil, pageNumber, pageSize);
    }

    public List<Recipe> getRecipesByPopularity(int pageSize, int pageNumber) throws Exception{
        return recipeRepository.getRecipesByPopularity(pageSize, pageNumber);
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
        u.setPopularity(dto.getPopularity());
        u.setActive(dto.getActive());

        List<Step> steps = new ArrayList<>();
        Set<RecipeImage> images = new HashSet<>();

        for(grpc.Step.StepDTO stepDTO : dto.getStepsList()){
            Step step = new Step();
            step.setIdStep(stepDTO.getIdStep());
            step.setDescription(stepDTO.getDescription());

            steps.add(step);
        }

        for(grpc.Recipe.RecipeImageDTO ImgDto : dto.getImagesList()){
            RecipeImage img = new RecipeImage();

            img.setIdImage(ImgDto.getIdImage());
            img.setName(ImgDto.getName());
            img.setFile(Base64.getDecoder().decode(ImgDto.getFile()));

            images.add(img);
        }
        u.setImages(images);
        u.setSteps(steps);

        return u;
    }
}
