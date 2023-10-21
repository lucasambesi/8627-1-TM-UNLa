using MySql.Data.MySqlClient;
using System;
using System.Collections.Generic;
using System.Linq;

public class BookRepository
{
    private string connectionString;

    public BookRepository(string connectionString)
    {
        this.connectionString = connectionString;
    }

    public bool CreateBook(string name, int idUser)
    {
        using (MySqlConnection connection = new MySqlConnection(connectionString))
        {
            try
            {
                connection.Open();

                string sql = "INSERT INTO books (name, active, idUser) " +
                             "VALUES (@Name, @Active, @IdUser)";

                using (MySqlCommand cmd = new MySqlCommand(sql, connection))
                {
                    cmd.Parameters.AddWithValue("@Name", name);
                    cmd.Parameters.AddWithValue("@IdUser", idUser);
                    cmd.Parameters.AddWithValue("@Active", true);

                    int rowsAffected = cmd.ExecuteNonQuery();

                    return rowsAffected > 0;
                }
            }
            catch (Exception ex)
            {
                Console.WriteLine("Error al crear el recetario: " + ex.Message);
                return false;
            }
            finally
            {
                connection.Close();
            }
        }
    }

    public bool AddRecipe(int idRecipe, int idBook)
    {
        using (MySqlConnection connection = new MySqlConnection(connectionString))
        {
            try
            {
                connection.Open();

                string sql = "INSERT INTO books_recipes (Book_idBook, recipes_idRecipe) " +
                             "VALUES (@IdBook, @IdRecipe)";

                using (MySqlCommand cmd = new MySqlCommand(sql, connection))
                {
                    cmd.Parameters.AddWithValue("@IdBook", idBook);
                    cmd.Parameters.AddWithValue("@IdRecipe", idRecipe);

                    int rowsAffected = cmd.ExecuteNonQuery();

                    return rowsAffected > 0;
                }
            }
            catch (Exception ex)
            {
                Console.WriteLine("Error al agregar receta al recetario: " + ex.Message);
                return false;
            }
            finally
            {
                connection.Close();
            }
        }
    }

    public List<Book> GetBooksByUserId(string id, bool withRecipes)
    {
        Dictionary<int, Book> bookDictionary = new Dictionary<int, Book>();

        using (MySqlConnection connection = new MySqlConnection(connectionString))
        {
            connection.Open();

            string sql = "SELECT books.*, recipes.* " +
                         "FROM books " +
                         "LEFT JOIN books_recipes ON books.idBook = books_recipes.Book_idBook " +
                         "LEFT JOIN recipes ON books_recipes.recipes_idRecipe = recipes.idRecipe " +
                         "WHERE (books.idUser = @UserId AND books.active = @Active)";

            using (MySqlCommand cmd = new MySqlCommand(sql, connection))
            {
                cmd.Parameters.AddWithValue("@UserId", id);
                cmd.Parameters.AddWithValue("@Active", true);

                using (MySqlDataReader reader = cmd.ExecuteReader())
                {
                    while (reader.Read())
                    {
                        int bookId = Convert.ToInt32(reader["idBook"]);

                        if (!bookDictionary.ContainsKey(bookId))
                        {
                            Book book = mapToEntity(reader);
                            bookDictionary.Add(bookId, book);
                        }

                        if (withRecipes && reader["IdRecipe"] != DBNull.Value)
                        {
                            Recipe recipe = mapRecipeToEntity(reader);

                            if (bookDictionary[bookId].Recipes == null)
                            {
                                bookDictionary[bookId].Recipes = new HashSet<Recipe>();
                            }

                            bookDictionary[bookId].Recipes.Add(recipe);
                        }
                    }
                }
            }

            connection.Close();
        }

        return bookDictionary.Values.ToList();
    }

    private static Recipe mapRecipeToEntity(MySqlDataReader reader)
    {
        return new Recipe
        {
            IdRecipe = Convert.ToInt32(reader["idRecipe"]),
            Title = Convert.ToString(reader["title"]),
            Description = Convert.ToString(reader["description"]),
            Ingredients = Convert.ToString(reader["ingredients"]),
        };
    }

    private Book mapToEntity(MySqlDataReader reader)
    {
        var book = new Book
        {
            IdBook = Convert.ToInt32(reader["idBook"]),
            Name = reader["name"].ToString(),
            IdUser = Convert.ToInt32(reader["idUser"]),
            Active = Convert.ToBoolean(reader["active"])
        };

        return book;
    }
}