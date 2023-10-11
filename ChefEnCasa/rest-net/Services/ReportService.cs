using rest_net.Models;
using rest_net.Repositories.Interfaces;
using rest_net.Services.Interfaces;

namespace rest_net.Services
{
    public class ReportService : IReportService
    {
        internal IReportCollection _reportCollection;

        public ReportService(IReportCollection reportCollection)
        {
            _reportCollection = reportCollection;
        }

        public async Task DeleteReport(string id)
        {
            await _reportCollection.DeleteReport(id);
        }

        public async Task<List<Report>> GetReports()
        {
            return await _reportCollection.GetReports();
        }

        public async Task InsertReport(Report report)
        {
            await _reportCollection.InsertReport(report);
        }

        public async Task UpdateReport(Report report)
        {
            await _reportCollection.UpdateReport(report);
        }

        public async Task UpdateResolvedReport(string id, bool resolved)
        {
            var report = await _reportCollection.GetReport(id);

            report.Resolved = resolved;

            await _reportCollection.UpdateReport(report);
        }
    }
}
