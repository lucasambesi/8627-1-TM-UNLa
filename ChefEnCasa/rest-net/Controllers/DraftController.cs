using Microsoft.AspNetCore.Mvc;
using rest_net.Models;
using rest_net.Services.Interfaces;
using System.Web.Http.Cors;

namespace rest_net.Controllers
{
    [Route("api/draft")]
    [ApiController]
    [EnableCors(origins: "http://localhost:5173/", headers: "*", methods: "*")]
    public class DraftController : ControllerBase
    {
        private readonly ILogger<DraftController> _logger;

        internal IDraftService _draftService;

        public DraftController(
            ILogger<DraftController> logger,
            IDraftService draftService)
        {
            _logger = logger;
            _draftService = draftService;
        }

        [HttpGet]
        public async Task<IActionResult> GetAllDrafts()
        {
            return Ok(await _draftService.GetDrafts());
        }

        [HttpGet("{id}")]
        public async Task<IActionResult> GetDraft(string id)
        {
            return Ok(await _draftService.GetDraft(id));
        }

        [HttpGet("user/{userId}")]
        public async Task<IActionResult> GetDraftsByUser(string userId)
        {
            return Ok(await _draftService.GetDrafts(userId));
        }

        [HttpPost]
        public async Task<IActionResult> CreateDraft([FromBody] Draft draft)
        {
            if (draft == null)
                return BadRequest();

            if(draft.Title == string.Empty)
            {
                ModelState.AddModelError("Title", "El titulo esta vacio");
            }

            await _draftService.InsertDraft(draft);

            return Created("Created", true);
        }

        [HttpPost("many")]
        public async Task<IActionResult> CreateDrafts([FromBody] List<Draft> drafts)
        {
            if (drafts == null)
                return BadRequest();

            await _draftService.InsertDrafts(drafts);

            return Created("Created", true);
        }

        [HttpPut]
        public async Task<IActionResult> UpdateDraft([FromBody] Draft draft, string id)
        {
            if (draft == null)
                return BadRequest();

            if (draft.Title == string.Empty)
            {
                ModelState.AddModelError("Title", "El titulo esta vacio");
            }

            draft.Id = new MongoDB.Bson.ObjectId(id);

            await _draftService.UpdateDraft(draft);

            return Created("Updated", true);
        }

        [HttpDelete("{id}")]
        public async Task<IActionResult> DeleteDraft(string id)
        {
            await _draftService.DeleteDraft(id);

            return NoContent();
        }
    }
}
