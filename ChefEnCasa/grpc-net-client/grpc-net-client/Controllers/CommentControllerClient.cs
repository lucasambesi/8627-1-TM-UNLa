using Grpc.Net.Client;
using grpc_net_client.Model.Config;
using Microsoft.AspNetCore.Mvc;
using Microsoft.Extensions.Options;
using System.Web.Http.Cors;

namespace grpc_net_client.Controllers
{
    [Route("api/comments")]
    [ApiController]
    [EnableCors(origins: "http://localhost:5173/", headers: "*", methods: "*")]
    public class CommentControllerClient : ControllerBase
    {
        private readonly IOptions<ApiConfig> _config;
        CommentController.CommentControllerClient _service;

        #region constructor
        public CommentControllerClient(IOptions<ApiConfig> config)
        {
            _config = config;
            AppContext.SetSwitch("System.Net.Http.SocketsHttpHandler.Http2UnencryptedSupport", true);
            GrpcChannel channel = GrpcChannel.ForAddress(_config.Value.GrpcChannelURL, new GrpcChannelOptions
            {
                MaxReceiveMessageSize = 1000 * 1024 * 1024
            });
            _service = new CommentController.CommentControllerClient(channel);
        }
        #endregion

        [HttpGet]
        [Route("recipe")]
        public async Task<ActionResult> GetByRecipe([FromQuery] GetCommentRequest request)
        {
            try
            {
                var response = await _service.getCommentsAsync(request);
                if (response.Comments.Count == 0) return NoContent();
                if (response.ServerResponse.Code == 500) throw new Exception(response.ServerResponse.Msg);
                return Ok(response.Comments);
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message.ToString());
                return StatusCode(500, ex.Message);
            }
        }
    }
}
