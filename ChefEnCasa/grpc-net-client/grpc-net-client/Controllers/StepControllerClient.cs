using Grpc.Net.Client;
using grpc_net_client.Model.Config;
using Microsoft.AspNetCore.Mvc;
using Microsoft.Extensions.Options;
using System.Web.Http.Cors;

namespace grpc_net_client.Controllers
{
    [Route("api/step")]
    [ApiController]
    [EnableCors(origins: "http://localhost:5173/", headers: "*", methods: "*")]
    public class StepControllerClient : ControllerBase
    {
        private readonly IOptions<ApiConfig> _config;
        StepController.StepControllerClient _service;

        #region constructor
        public StepControllerClient(IOptions<ApiConfig> config)
        {
            _config = config;
            AppContext.SetSwitch("System.Net.Http.SocketsHttpHandler.Http2UnencryptedSupport", true);
            GrpcChannel channel = GrpcChannel.ForAddress(_config.Value.GrpcChannelURL);
            _service = new StepController.StepControllerClient(channel);
        }
        #endregion

        [HttpPost]
        public async Task<ActionResult> Post([FromBody] StepDTO step)
        {
            try
            {
                var response = await _service.addStepAsync(step);
                if (response.ServerResponse.Code == 500) throw new Exception(response.ServerResponse.Msg);
                return Ok(response);
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message.ToString());
                return StatusCode(500, ex.Message);
            }
        }

        [HttpGet]
        [Route("recipe")]
        public async Task<ActionResult> GetByRecipe(int recipeId)
        {
            try
            {
                IdRecipeRequest request = new IdRecipeRequest() { Idrecipe = recipeId };
                var response = await _service.getStepsByRecipeIdAsync(request);
                if (response.Steps.Count == 0) return NoContent();
                if (response.ServerResponse.Code == 500) throw new Exception(response.ServerResponse.Msg);
                return Ok(response.Steps);
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message.ToString());
                return StatusCode(500, ex.Message);
            }
        }
    }
}
