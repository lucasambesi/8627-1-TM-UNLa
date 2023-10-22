using System.Collections.Generic;
using System.ServiceModel;

[ServiceContract]
public interface IBookService
{
    [OperationContract]
    bool CreateBook(string name, int idUser);

    [OperationContract]
    bool AddRecipe(int idRecipe, int idBook);

    [OperationContract]
    List<Book> GetBooksByUserId(string id, bool withRecipes);

    [OperationContract]
    bool DeleteBook(int id);
}
