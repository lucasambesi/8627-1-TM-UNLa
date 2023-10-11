using rest_net.Models;

namespace rest_net.Repositories.Interfaces
{
    public interface IReportCollection
    {
        Task<Report> GetReport(string id);

        Task InsertReport(Report report);

        Task UpdateReport(Report report);

        Task DeleteReport(string id);

        Task<List<Report>> GetReports();
    }
}
