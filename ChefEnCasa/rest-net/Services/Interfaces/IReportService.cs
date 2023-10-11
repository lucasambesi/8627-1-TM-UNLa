using rest_net.Models;

namespace rest_net.Services.Interfaces
{
    public interface IReportService
    {
        Task InsertReport(Report report);

        Task UpdateReport(Report report);

        Task UpdateResolvedReport(string id, bool resolved);

        Task DeleteReport(string id);

        Task<List<Report>> GetReports();
    }
}
