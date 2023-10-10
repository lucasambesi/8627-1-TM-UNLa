using rest_net.Models;
using rest_net.Repositories.Interfaces;
using rest_net.Services.Interfaces;

namespace rest_net.Services
{
    public class DraftService : IDraftService
    {
        internal IDraftCollection _draftCollection;

        public DraftService(IDraftCollection draftCollection)
        {
            _draftCollection = draftCollection;
        }

        public async Task DeleteDraft(string id)
        {
            await _draftCollection.DeleteDraft(id);
        }

        public async Task<Draft> GetDraft(string id)
        {
            return await _draftCollection.GetDraft(id);
        }

        public async Task<List<Draft>> GetDrafts(string userId)
        {
            return await _draftCollection.GetDrafts(userId);
        }

        public async Task<List<Draft>> GetDrafts()
        {
            return await _draftCollection.GetDrafts();
        }

        public async Task InsertDraft(Draft draft)
        {
            await _draftCollection.InsertDraft(draft);
        }

        public async Task InsertDrafts(List<Draft> drafts)
        {
            await _draftCollection.InsertDrafts(drafts);
        }

        public async Task UpdateDraft(Draft draft)
        {
            await _draftCollection.UpdateDraft(draft);
        }
    }
}
