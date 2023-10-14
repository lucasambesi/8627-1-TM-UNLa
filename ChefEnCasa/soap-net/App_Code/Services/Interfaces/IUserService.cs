using System.Collections.Generic;
using System.ServiceModel;

[ServiceContract]
public interface IUserService
{

	[OperationContract]
    List<User> GetUsers();

	[OperationContract]
	User GetUserById(string id);
}
