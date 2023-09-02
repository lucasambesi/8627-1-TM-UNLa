package com.chefencasa.Controller;
import com.chefencasa.service.UserService;
import grpc.User;
import grpc.UserControllerGrpc;
import io.grpc.stub.StreamObserver;

public class UserController extends UserControllerGrpc.UserControllerImplBase {

    public UserService userService = UserService.getInstance();

    public UserController() {
    }

    public void addUser(User.UserDTO request, StreamObserver<User.UserObjDTO> responseObserver) {
        User.UserObjDTO.Builder response = User.UserObjDTO.newBuilder();
        User.UserServerResponse.Builder serverResponse = User.UserServerResponse.newBuilder();

        try {
            com.chefencasa.Model.User usuario = this.userService.agregarUsuario(request);
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

        return dto;
    }
}
