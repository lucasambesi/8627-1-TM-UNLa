using MongoDB.Driver;

namespace rest_net.Repositories
{
    public class MongoDbRepository
    {
        public MongoClient client;

        public IMongoDatabase database;

        public MongoDbRepository()
        {
            client = new MongoClient("mongodb://127.0.0.1:27017");
            database = client.GetDatabase("chefEnCasa");
            //mongodb://localhost:27017
        }
    }
}
