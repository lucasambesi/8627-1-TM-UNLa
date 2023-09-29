package com.chefencasa.service;

import com.chefencasa.Model.Comment;
import com.chefencasa.Model.Rating;
import com.chefencasa.Model.Recipe;
import com.chefencasa.Model.User;
import com.chefencasa.Repository.CommentRepository;

import java.util.List;

public class CommentService {

    private static CommentService service;

    CommentRepository commentRepository = CommentRepository.getInstance();

    RecipeService recipeService = RecipeService.getInstance();

    public static CommentService getInstance() {
        if(service == null) {
            service = new CommentService();
        }
        return service;
    }

    public Comment saveComment(Comment rating) throws Exception {
        Comment persisted = commentRepository.saveOrUpdateComment(rating);
        return persisted;
    }

    public List<Comment> getByRecipe(int idRecipe, int pageNumber, int pageSize) throws Exception{
        Recipe recipe = recipeService.getById(idRecipe);

        return commentRepository.getByRecipe(recipe, pageNumber, pageSize);
    }
}
