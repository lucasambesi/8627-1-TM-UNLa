using Grpc.Net.Client;
using grpc_net_client.Model.Config;
using Microsoft.AspNetCore.Mvc;
using Microsoft.Extensions.Options;
using System.Web.Http.Cors;

namespace grpc_net_client.Controllers
{
    [Route("api/user")]
    [ApiController]
    [EnableCors(origins: "http://localhost:5173/", headers: "*", methods: "*")]
    public class UserControllerClient : ControllerBase
    {
        private readonly IOptions<ApiConfig> _config;
        UserController.UserControllerClient _service;

        #region constructor
        public UserControllerClient(IOptions<ApiConfig> config)
        {
            _config = config;
            AppContext.SetSwitch("System.Net.Http.SocketsHttpHandler.Http2UnencryptedSupport", true);
            GrpcChannel channel = GrpcChannel.ForAddress(_config.Value.GrpcChannelURL);
            _service = new UserController.UserControllerClient(channel);
        }
        #endregion

        #region endpoints
        [HttpGet]
        public async Task<ActionResult> Get(int idUser)
        {
            try
            {
                GetUserRequest idUsuarioDTO = new GetUserRequest() { IdUser = idUser };
                var response = await _service.getUserAsync(idUsuarioDTO);
                if (response.ServerResponse.Code == 500) throw new Exception(response.ServerResponse.Msg);
                return Ok(response);
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message.ToString());
                return StatusCode(500, ex.Message);
            }
        }

        [HttpGet("popularity")]
        public async Task<ActionResult> GetPopularityUser(int pageSize, int pageNumber)
        {
            try
            {
                GetPopularityUserRequest request = new GetPopularityUserRequest() 
                {
                    PageNumber = pageNumber,
                    PageSize= pageSize,
                };
                var response = await _service.getUsersByPopularityAsync(request);
                if (response.ServerResponse.Code == 500) throw new Exception(response.ServerResponse.Msg);
                return Ok(response);
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message.ToString());
                return StatusCode(500, ex.Message);
            }
        }

        [HttpPost]
        [Route("login")]
        public async Task<ActionResult> Login([FromBody] GetByUserIdAndPasswordRequest request)
        {
            try
            {
                var response = await _service.getByUserAndPasswordRequestAsync(request);
                if (response.User == null) return NotFound();
                if (response.ServerResponse.Code == 500) throw new Exception(response.ServerResponse.Msg);
                return Ok(response.User);
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message.ToString());
                return StatusCode(500, ex.Message);
            }
        }

        [HttpPost]
        [Route("following")]
        public async Task<ActionResult> Following([FromBody] PostFollowingRequest request)
        {
            try
            {
                var response = await _service.addFollowingAsync(request);
                if (response.IdUser == null) return NotFound();
                if (response.ServerResponse.Code == 500) throw new Exception(response.ServerResponse.Msg);
                return Ok(response);
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message.ToString());
                return StatusCode(500, ex.Message);
            }
        }

        [HttpDelete]
        [Route("following")]
        public async Task<ActionResult> DeleteFollowing([FromQuery] PostFollowingRequest request)
        {
            try
            {
                var response = await _service.deleteFollowingAsync(request);
                if (response.IdUser == null) return NotFound();
                if (response.ServerResponse.Code == 500) throw new Exception(response.ServerResponse.Msg);
                return Ok(response);
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message.ToString());
                return StatusCode(500, ex.Message);
            }
        }

        [HttpPost]
        [Route("favorites")]
        public async Task<ActionResult> FavoriteRecipe([FromBody] PostFavoriteRequest request)
        {
            try
            {
                var response = await _service.addFavoriteAsync(request);
                if (response.IdUser == null) return NotFound();
                if (response.ServerResponse.Code == 500) throw new Exception(response.ServerResponse.Msg);
                return Ok(response);
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message.ToString());
                return StatusCode(500, ex.Message);
            }
        }

        [HttpDelete]
        [Route("favorites")]
        public async Task<ActionResult> DeleteRecipe([FromQuery] PostFavoriteRequest request)
        {
            try
            {
                var response = await _service.deleteFavoriteAsync(request);
                if (response.IdUser == null) return NotFound();
                if (response.ServerResponse.Code == 500) throw new Exception(response.ServerResponse.Msg);
                return Ok(response);
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message.ToString());
                return StatusCode(500, ex.Message);
            }
        }

        [HttpPost]
        [Route("register")]
        public async Task<ActionResult> Post([FromBody] UserDTO user)
        {
            try
            {
                var response = await _service.addUserAsync(user);
                if (response.ServerResponse.Code == 500) throw new Exception(response.ServerResponse.Msg);
                return Ok(response);
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message.ToString());
                return StatusCode(500, ex.Message);
            }
        }
        #endregion
    }
}
