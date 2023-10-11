using MongoDB.Bson;
using MongoDB.Driver;
using rest_net.Models;
using rest_net.Repositories.Interfaces;

namespace rest_net.Repositories
{
    public class ReportCollection : IReportCollection
    {
        internal MongoDbRepository _repository = new MongoDbRepository();
        private IMongoCollection<Report> Collection;

        public ReportCollection()
        {
            Collection = _repository.database.GetCollection<Report>("Reports");
        }

        public async Task<Report> GetReport(string id)
        {
            return await Collection.FindAsync(
                new BsonDocument { { "_id", new ObjectId(id) } }).Result.FirstAsync();
        }

        public async Task DeleteReport(string id)
        {
            var filter = Builders<Report>.Filter.Eq(s => s.Id, new ObjectId(id));
            await Collection.DeleteOneAsync(filter);
        }

        public async Task<List<Report>> GetReports()
        {
            var reports = await Collection.FindAsync(new BsonDocument()).Result.ToListAsync();

            foreach (var report in reports)
            {
                report.ReportId = report.Id.ToString();
            }

            return reports;
        }

        public async Task InsertReport(Report report)
        {
            await Collection.InsertOneAsync(report);
        }

        public async Task UpdateReport(Report report)
        {
            var filter = Builders<Report>
                .Filter
                .Eq(s => s.Id, report.Id);

            await Collection.ReplaceOneAsync(filter, report);
        }
    }
}
