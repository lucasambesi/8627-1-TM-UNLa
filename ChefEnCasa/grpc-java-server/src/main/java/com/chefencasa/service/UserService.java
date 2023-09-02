package com.chefencasa.service;

import com.chefencasa.Model.User;
import com.chefencasa.Repository.UserRepository;
import grpc.User.UserDTO;

public class UserService {

    private static UserService service;

    public static UserService getInstance() {
        if(service == null) {
            service = new UserService();
        }
        return service;
    }

    UserRepository userRepository = UserRepository.getInstance();

    public User agregarUsuario(UserDTO userDTO) throws Exception {
        User toPersist = mapToEntity(userDTO);
        User persisted = userRepository.createUser(toPersist);
        return persisted;
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
        return u;
    }
}
