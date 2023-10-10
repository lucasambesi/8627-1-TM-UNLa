using rest_net.Models;

namespace rest_net.Repositories.Interfaces
{
    public interface IDraftCollection
    {
        Task InsertDraft(Draft draft);

        Task InsertDrafts(List<Draft> drafts);

        Task UpdateDraft(Draft draft);

        Task DeleteDraft(string id);

        Task<Draft> GetDraft(string id);

        Task<List<Draft>> GetDrafts(string userId);

        Task<List<Draft>> GetDrafts();
    }
}
