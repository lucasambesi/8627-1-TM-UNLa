using MySql.Data.MySqlClient;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

/// <summary>
/// Descripción breve de UserRepository
/// </summary>
public class UserRepository
{
    private string connectionString;

    public UserRepository(string connectionString)
    {
        this.connectionString = connectionString;
    }

    public List<User> GetUsers()
    {
        List<User> users = new List<User>();

        using (MySqlConnection connection = new MySqlConnection(connectionString))
        {
            connection.Open();

            string sql = "SELECT * FROM users";
            using (MySqlCommand cmd = new MySqlCommand(sql, connection))
            {
                using (MySqlDataReader reader = cmd.ExecuteReader())
                {
                    while (reader.Read())
                    {
                        User user = mapToEntity(reader);

                        users.Add(user);
                    }
                }
            }

            connection.Close();
        }

        return users;
    }

    public User GetUserById(string id)
    {
        User user = null;

        using (MySqlConnection connection = new MySqlConnection(connectionString))
        {
            connection.Open();

            string sql = "SELECT * FROM users WHERE idUser = @UserId";
            using (MySqlCommand cmd = new MySqlCommand(sql, connection))
            {
                cmd.Parameters.AddWithValue("@UserId", id);

                using (MySqlDataReader reader = cmd.ExecuteReader())
                {
                    while (reader.Read())
                    {
                        user = mapToEntity(reader);
                    }
                }
            }

            connection.Close();
        }

        return user;
    }

    private static User mapToEntity(MySqlDataReader reader)
    {
        return new User
        {
            IdUser = Convert.ToInt32(reader["idUser"]),
            Name = reader["Name"].ToString(),
            Lastname = reader["Lastname"].ToString(),
            Dni = reader["Dni"].ToString(),
            Email = reader["Email"].ToString(),
            Username = reader["Username"].ToString(),
            Password = reader["Password"].ToString(),
            Popularity = Convert.ToInt32(reader["Popularity"])
        };
    }
}