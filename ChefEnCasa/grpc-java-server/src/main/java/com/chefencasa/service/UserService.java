package com.chefencasa.service;

import com.chefencasa.Model.Recipe;
import com.chefencasa.Model.User;
import com.chefencasa.Repository.RecipeRepository;
import com.chefencasa.Repository.UserRepository;
import grpc.User.UserDTO;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserService {

    private static UserService service;

    public static UserService getInstance() {
        if(service == null) {
            service = new UserService();
        }
        return service;
    }

    UserRepository userRepository = UserRepository.getInstance();

    RecipeRepository recipeRepository = RecipeRepository.getInstance();

    public User addUser(UserDTO userDTO) throws Exception {
        User toPersist = mapToEntity(userDTO);
        User persisted = userRepository.saveOrUpdate(toPersist);
        return persisted;
    }
    public User addFollowing(int idUser, int idFollowing) throws Exception{

        User user = null;
        User following = null;
        Set<User> followings = new HashSet<>();

        try{
            user = userRepository.getById(idUser);
            following = userRepository.getById(idFollowing);

            followings = user.getFollowing();
            followings.add(following);

            user = userRepository.saveOrUpdate(user);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            throw new Exception ("ATENCION: Error en addFollowing");
        }

        return user;
    }

    public User deleteFollowing(int idUser, int idFollowing) throws Exception{

        User user = null;
        User following = null;

        try{
            user = userRepository.getById(idUser);
            following = userRepository.getById(idFollowing);

            if(user != null && following != null){
                user.getFollowing().remove(following);
                user = userRepository.saveOrUpdate(user);
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            throw new Exception ("ATENCION: Error en daleteFavoriteRecipes");
        }

        return user;
    }


    public User addFavoriteRecipes(int idUser, int idRecipe) throws Exception{

        User user = null;
        Recipe recipe = null;

        try{
            user = userRepository.getById(idUser);
            recipe = recipeRepository.getById(idRecipe);

            if(!user.getFavorites().contains(recipe) && recipe.getUser().getIdUser() != idUser){
                user.getFavorites().add(recipe);
                user = userRepository.saveOrUpdate(user);
            }

        }
        catch(Exception e){
            System.out.println(e.getMessage());
            throw new Exception ("ATENCION: Error en addFavoriteRecipes");
        }

        return user;
    }

    public User deleteFavoriteRecipes(int idUser, int idRecipe) throws Exception{

        User user = null;
        Recipe recipe = null;

        try{
            user = userRepository.getById(idUser);
            recipe = recipeRepository.getById(idRecipe);

            if(user != null && recipe != null){
                user.getFavorites().remove(recipe);
                user = userRepository.saveOrUpdate(user);
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            throw new Exception ("ATENCION: Error en daleteFavoriteRecipes");
        }

        return user;
    }

    public List<Recipe> getFavorites (int idUser) throws Exception{
        return userRepository.getFavorites(idUser);
    }

    public List<User> getUsersByPopularity(int pageSize, int pageNumber) throws Exception{
        return userRepository.getUsersByPopularity(pageSize, pageNumber);
    }

    public User getById (int isUser) throws Exception{
        return userRepository.getById(isUser);
    }

    public User getByUserIdAndPassword(String userName, String password) throws Exception{
        User user = null;
        try{
            user = userRepository.getByUserIdAndPassword(userName, password);
            return user;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            throw new Exception ("Error:" + e.getMessage());
        }
    }

    private User mapToEntity (UserDTO dto) throws Exception{
        User u = new User();
        u.setIdUser(dto.getIdUser());
        u.setName(dto.getName());
        u.setLastname(dto.getLastName());
        u.setDni(dto.getDni());
        u.setEmail(dto.getEmail());
        u.setUsername(dto.getUsername());
        u.setPassword(dto.getPassword());
        u.setPopularity(dto.getPopularity());
        return u;
    }
}
