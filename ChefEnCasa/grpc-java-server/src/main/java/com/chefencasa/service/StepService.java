package com.chefencasa.service;

import com.chefencasa.Model.Recipe;
import com.chefencasa.Model.Step;
import com.chefencasa.Repository.StepRepository;

import java.util.List;

public class StepService {
    private static StepService service;

    public static StepService getInstance() {
        if(service == null) {
            service = new StepService();
        }
        return service;
    }

    StepRepository stepRepository = StepRepository.getInstance();

    RecipeService recipeService= RecipeService.getInstance();

    public Step addStep(grpc.Step.StepDTO stepDTO) throws Exception {
        Step toPersist = mapToEntity(stepDTO);
        Step persisted = stepRepository.createStep(toPersist);

        return persisted;
    }

    public List<Step> getByRecipeId(int idRecipe) throws Exception{
        Recipe recipe = recipeService.getById(idRecipe);
        return stepRepository.getByRecipe(recipe);
    }

    private Step mapToEntity (grpc.Step.StepDTO dto) throws Exception{
        Step u = new Step();

        u.setIdStep(dto.getIdStep());
        u.setRecipe(recipeService.getById(dto.getIdRecipe()));
        u.setDescription(dto.getDescription());

        return u;
    }
}
