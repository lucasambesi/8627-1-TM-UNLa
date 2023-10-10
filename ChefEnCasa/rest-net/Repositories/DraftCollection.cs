using MongoDB.Bson;
using MongoDB.Driver;
using rest_net.Models;
using rest_net.Repositories.Interfaces;

namespace rest_net.Repositories
{
    public class DraftCollection : IDraftCollection
    {
        internal MongoDbRepository _repository = new MongoDbRepository();
        private IMongoCollection<Draft> Collection;

        public DraftCollection()
        {
            Collection = _repository.database.GetCollection<Draft>("Drafts");
        }

        public async Task DeleteDraft(string id)
        {
            var filter = Builders<Draft>.Filter.Eq(s => s.Id, new ObjectId(id));
            await Collection.DeleteOneAsync(filter);
        }

        public async Task<Draft> GetDraft(string id)
        {
            return await Collection.FindAsync(
                new BsonDocument { { "_id", new ObjectId(id) } }).Result.FirstAsync();
        }

        public async Task<List<Draft>> GetDrafts(string userId)
        {
            return await Collection.FindAsync(
                new BsonDocument { { "UserId", userId } }).Result.ToListAsync();
        }

        public async Task<List<Draft>> GetDrafts()
        {
            return await Collection.FindAsync(new BsonDocument()).Result.ToListAsync();
        }

        public async Task InsertDraft(Draft draft)
        {
            await Collection.InsertOneAsync(draft);
        }

        public async Task InsertDrafts(List<Draft> drafts)
        {
            await Collection.InsertManyAsync(drafts);
        }

        public async Task UpdateDraft(Draft draft)
        {
            var filter = Builders<Draft>
                .Filter
                .Eq(s => s.Id, draft.Id);

            await Collection.ReplaceOneAsync(filter, draft);
        }
    } 
}
