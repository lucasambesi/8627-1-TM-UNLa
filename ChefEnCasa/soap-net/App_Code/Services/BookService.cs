using System.Collections.Generic;
using System.Configuration;

public class BookService : IBookService
{
    private string connectionString = ConfigurationManager.ConnectionStrings["chefEnCasa"].ConnectionString;
    private BookRepository bookRepository;

    public BookService()
    {
        bookRepository = new BookRepository(connectionString);
    }

    public bool AddRecipe(int idRecipe, int idBook)
    {
        if (idRecipe == 0 || idBook == 0)
        {
            return false;
        }

        return bookRepository.AddRecipe(idRecipe, idBook);
    }

    public bool CreateBook(string name, int idUser)
    {
        if (name == "" || idUser == 0)
        {
            return false;
        }

        return bookRepository.CreateBook(name, idUser);
    }

    public bool DeleteBook(int id)
    {
        if (id == 0)
        {
            return false;
        }

        return bookRepository.DeleteBook(id);
    }

    public List<Book> GetBooksByUserId(string id, bool withRecipes)
    {
        return bookRepository.GetBooksByUserId(id, withRecipes);
    }
}