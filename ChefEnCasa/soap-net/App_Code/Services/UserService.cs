using System;
using System.Collections.Generic;
using System.Configuration;

public class UserService : IUserService
{
    private string connectionString = ConfigurationManager.ConnectionStrings["chefEnCasa"].ConnectionString;
    private UserRepository userRepository;

    public UserService()
    {
        userRepository = new UserRepository(connectionString);
    }

    public List<User> GetUsers()
    {
        var users = userRepository.GetUsers();

        return users;
    }

    public User GetUserById(string id)
    {
        var user = userRepository.GetUserById(id);
        List<User> users = new List<User>();
        return user;
    }
}
