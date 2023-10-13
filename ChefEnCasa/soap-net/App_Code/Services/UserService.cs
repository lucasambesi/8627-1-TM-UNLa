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

        return user;
    }

    public CompositeType GetDataUsingDataContract(CompositeType composite)
	{
		if (composite == null)
		{
			throw new ArgumentNullException("composite");
		}
		if (composite.BoolValue)
		{
			composite.StringValue += "Suffix";
		}
		return composite;
	}
}
