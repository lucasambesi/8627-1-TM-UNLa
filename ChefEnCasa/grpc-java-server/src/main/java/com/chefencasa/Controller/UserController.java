package com.chefencasa.Controller;
import com.chefencasa.Model.Step;
import com.chefencasa.service.UserService;
import grpc.Recipe;
import grpc.User;
import grpc.UserControllerGrpc;
import io.grpc.stub.StreamObserver;

import java.util.List;

public class UserController extends UserControllerGrpc.UserControllerImplBase {

    public UserService userService = UserService.getInstance();

    public UserController() {
    }

    public void addUser(User.UserDTO request, StreamObserver<User.UserObjDTO> responseObserver) {
        User.UserObjDTO.Builder response = User.UserObjDTO.newBuilder();
        User.UserServerResponse.Builder serverResponse = User.UserServerResponse.newBuilder();

        try {
            com.chefencasa.Model.User usuario = this.userService.addUser(request);
            response.setUser(this.mapUserDTO(usuario));
            serverResponse.setCode(200);
            serverResponse.setMsg("User created");
        } catch (Exception var6) {
            serverResponse.setCode(500);
            serverResponse.setMsg(var6.getMessage());
        }

        response.setServerResponse(serverResponse);
        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }

    public void addFollowing(User.PostFollowingRequest request, StreamObserver<User.PostFollowingResponse> responseObserver) {

        int idUser = request.getIdUser();
        int idFollowing = request.getIdFollowing();

        com.chefencasa.Model.User usuario = null;

        User.UserServerResponse.Builder serverResponse = User.UserServerResponse.newBuilder();
        User.PostFollowingResponse.Builder response =  User.PostFollowingResponse.newBuilder();

        try {
            usuario = this.userService.addFollowing(idUser, idFollowing);

            response.setIdUser(idUser);
            response.setIdFollowing(idFollowing);

            serverResponse.setCode(200);
            serverResponse.setMsg("Following created");
        }
        catch (Exception e) {
            serverResponse.setCode(500);
            serverResponse.setMsg(e.getMessage());
        }

        response.setServerResponse(serverResponse);
        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }

    public void deleteFollowing(User.PostFollowingRequest request, StreamObserver<User.PostFollowingResponse> responseObserver) {

        int idUser = request.getIdUser();
        int idFollowing = request.getIdFollowing();

        com.chefencasa.Model.User user = null;

        User.UserServerResponse.Builder serverResponse = User.UserServerResponse.newBuilder();
        User.PostFollowingResponse.Builder response =  User.PostFollowingResponse.newBuilder();

        try {
            user = this.userService.deleteFollowing(idUser, idFollowing);

            response.setIdUser(idUser);
            response.setIdFollowing(idFollowing);

            serverResponse.setCode(200);
            serverResponse.setMsg("Following deleted");
        }
        catch (Exception e) {
            serverResponse.setCode(500);
            serverResponse.setMsg(e.getMessage());
        }

        response.setServerResponse(serverResponse);
        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }

    public void addFavorite(User.PostFavoriteRequest request, StreamObserver<User.PostFavoriteResponse> responseObserver) {

        int idUser = request.getIdUser();
        int idFavorite = request.getIdrecipe();

        com.chefencasa.Model.User usuario = null;

        User.UserServerResponse.Builder serverResponse = User.UserServerResponse.newBuilder();
        User.PostFavoriteResponse.Builder response =  User.PostFavoriteResponse.newBuilder();

        try {
            usuario = this.userService.addFavoriteRecipes(idUser, idFavorite);

            response.setIdUser(idUser);
            response.setIdrecipe(idFavorite);

            serverResponse.setCode(200);
            serverResponse.setMsg("Favorit created");
        }
        catch (Exception e) {
            serverResponse.setCode(500);
            serverResponse.setMsg(e.getMessage());
        }

        response.setServerResponse(serverResponse);
        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }

    public void deleteFavorite(User.PostFavoriteRequest request, StreamObserver<User.PostFavoriteResponse> responseObserver) {

        int idUser = request.getIdUser();
        int idFavorite = request.getIdrecipe();

        com.chefencasa.Model.User usuario = null;

        User.UserServerResponse.Builder serverResponse = User.UserServerResponse.newBuilder();
        User.PostFavoriteResponse.Builder response =  User.PostFavoriteResponse.newBuilder();

        try {
            usuario = this.userService.deleteFavoriteRecipes(idUser, idFavorite);

            response.setIdUser(idUser);
            response.setIdrecipe(idFavorite);

            serverResponse.setCode(200);
            serverResponse.setMsg("Favorit deleted");
        }
        catch (Exception e) {
            serverResponse.setCode(500);
            serverResponse.setMsg(e.getMessage());
        }

        response.setServerResponse(serverResponse);
        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }

    public void getUser(User.GetUserRequest request, StreamObserver<User.UserObjDTO> responseObserver) {
        com.chefencasa.Model.User user = null;
        User.UserServerResponse.Builder serverResponse = User.UserServerResponse.newBuilder();
        User.UserObjDTO.Builder response = User.UserObjDTO.newBuilder();

        try {
            user = this.userService.getById(request.getIdUser());
            response.setUser(this.mapUserDTO(user));
            serverResponse.setCode(200);
            serverResponse.setMsg("User found");
        } catch (Exception var7) {
            serverResponse.setCode(500);
            serverResponse.setMsg(var7.getMessage());
        }

        response.setServerResponse(serverResponse);
        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }

    public void getUsersByPopularity(User.GetPopularityUserRequest request, StreamObserver<User.UsersDTO> responseObserver) {
        User.UsersDTO.Builder usersDTO = User.UsersDTO.newBuilder();
        User.UserServerResponse.Builder serverResponse = User.UserServerResponse.newBuilder();
        try {
            List<com.chefencasa.Model.User> users = userService.getUsersByPopularity(
                    request.getPageSize(),
                    request.getPageNumber());

            for (com.chefencasa.Model.User user : users) {
                usersDTO.addUsers(mapUserDTO(user));
            }
            usersDTO.setServerResponse(serverResponse);
        } catch (Exception e) {
            serverResponse.setCode(500);
            serverResponse.setMsg(e.getMessage());
        }
        responseObserver.onNext(usersDTO.build());
        responseObserver.onCompleted();
    }

    public void getByUserAndPasswordRequest(User.GetByUserIdAndPasswordRequest request, StreamObserver<User.UserObjDTO> responseObserver) {

        String username = request.getUser();
        String password = request.getPassword();

        com.chefencasa.Model.User user = null;

        User.UserServerResponse.Builder serverResponse = User.UserServerResponse.newBuilder();
        User.UserObjDTO.Builder response = User.UserObjDTO.newBuilder();

        try{
            user = this.userService.getByUserIdAndPassword(username, password);
            response.setUser(mapUserDTO(user));
            serverResponse.setCode(200);
            serverResponse.setMsg("User found");
        }
        catch(Exception e){
            serverResponse.setCode(500);
            serverResponse.setMsg(e.getMessage());
        }

        response.setServerResponse(serverResponse);
        responseObserver.onNext(response.build());
        responseObserver.onCompleted();

    }

    public User.UserDTO.Builder mapUserDTO (com.chefencasa.Model.User u){
        User.UserDTO.Builder dto = User.UserDTO.newBuilder();
        dto.setIdUser((int)u.getIdUser());
        dto.setName(u.getName());
        dto.setLastName(u.getLastname());
        dto.setDni(u.getDni());
        dto.setEmail(u.getEmail());
        dto.setUsername(u.getUsername());
        dto.setPassword(u.getPassword());
        dto.setPopularity(u.getPopularity());
        dto.setRole(u.getRole().toString());

        for(com.chefencasa.Model.User user: u.getFollowing()){

            User.FollowingDTO.Builder userDto = User.FollowingDTO.newBuilder();
            userDto.setIdUser(user.getIdUser());
            userDto.setName(user.getName());
            userDto.setLastName(user.getLastname());
            userDto.setUsername(user.getUsername());

            dto.addFollowing(userDto);
        }

        return dto;
    }
}
