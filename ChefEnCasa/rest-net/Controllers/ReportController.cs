using Microsoft.AspNetCore.Mvc;
using rest_net.Models;
using rest_net.Models.Enums;
using rest_net.Services.Interfaces;
using System.Web.Http.Cors;

namespace rest_net.Controllers
{
    [Route("api/report")]
    [ApiController]
    [EnableCors(origins: "http://localhost:5173/", headers: "*", methods: "*")]
    public class ReportController : ControllerBase
    {
        private readonly ILogger<ReportController> _logger;

        internal IReportService _reportService;

        public ReportController(
            ILogger<ReportController> logger,
            IReportService reportService)
        {
            _logger = logger;
            _reportService = reportService;
        }

        [HttpGet]
        public async Task<IActionResult> GetAllReports()
        {
            return Ok(await _reportService.GetReports());
        }

        [HttpPost]
        public async Task<IActionResult> CreateReport([FromBody] Report report)
        {
            if (report == null)
                return BadRequest();

            if (report.Type == ReportType.None)
            {
                ModelState.AddModelError("Type", "Type esta vacio");
            }

            if (report.RecipeId == null)
            {
                ModelState.AddModelError("RecipeId", "RecipeId esta vacio");
            }

            if (report.UserId == null)
            {
                ModelState.AddModelError("UserId", "UserId esta vacio");
            }

            await _reportService.InsertReport(report);

            return Created("Created", true);
        }

        [HttpPut]
        public async Task<IActionResult> UpdateReport([FromBody] Report report, string id)
        {
            if (report == null)
                return BadRequest();

            if (report.Resolved == null)
            {
                ModelState.AddModelError("Resolved", "Resuelto esta vacio");
            }

            report.Id = new MongoDB.Bson.ObjectId(id);

            await _reportService.UpdateReport(report);

            return Created("Updated", true);
        }

        [HttpPatch]
        public async Task<IActionResult> UpdateResolvedReport([FromQuery] bool resolved, string id)
        {
            await _reportService.UpdateResolvedReport(id, resolved);

            return Created("Updated", true);
        }

        [HttpDelete("{id}")]
        public async Task<IActionResult> DeleteReportt(string id)
        {
            await _reportService.DeleteReport(id);

            return NoContent();
        }
    }
}
