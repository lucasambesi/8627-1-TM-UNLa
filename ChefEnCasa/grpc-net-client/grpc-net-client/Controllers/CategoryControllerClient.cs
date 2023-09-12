using Grpc.Net.Client;
using grpc_net_client.Model.Config;
using Microsoft.AspNetCore.Mvc;
using Microsoft.Extensions.Options;
using System.Web.Http.Cors;

namespace grpc_net_client.Controllers
{
    [Route("api/categories")]
    [ApiController]
    [EnableCors(origins: "http://localhost:5173/", headers: "*", methods: "*")]
    public class CategoryControllerClient : ControllerBase
    {
        private readonly IOptions<ApiConfig> _config;
        CategoryController.CategoryControllerClient _service;

        #region constructor
        public CategoryControllerClient(IOptions<ApiConfig> config)
        {
            _config = config;
            AppContext.SetSwitch("System.Net.Http.SocketsHttpHandler.Http2UnencryptedSupport", true);
            GrpcChannel channel = GrpcChannel.ForAddress(_config.Value.GrpcChannelURL, new GrpcChannelOptions
            {
                MaxReceiveMessageSize = 1000 * 1024 * 1024
            });
            _service = new CategoryController.CategoryControllerClient(channel);
        }
        #endregion

        [HttpPost]
        public async Task<ActionResult> Post([FromBody] CategoryDTO category)
        {
            try
            {
                var response = await _service.addCategoryAsync(category);
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
        public async Task<ActionResult> GetAll()
        {
            try
            {
                var response = await _service.getAllCategoriesAsync(new EmptyCategory());
                if (response.Categories.Count == 0) return NoContent();
                if (response.ServerResponse.Code == 500) throw new Exception(response.ServerResponse.Msg);
                return Ok(response.Categories);
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message.ToString());
                return StatusCode(500, ex.Message);
            }
        }

        [HttpGet("category")]
        public async Task<ActionResult> Get(int idCategory)
        {
            try
            {
                GetCategoryRequest idCategoryDTO = new GetCategoryRequest() { IdCategory = idCategory };
                var response = await _service.getCategoryAsync(idCategoryDTO);
                if (response.ServerResponse.Code == 500) throw new Exception(response.ServerResponse.Msg);
                return Ok(response);
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message.ToString());
                return StatusCode(500, ex.Message);
            }
        }
    }
}
