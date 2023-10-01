using Grpc.Net.Client;
using grpc_net_client.Model;
using grpc_net_client.Model.Config;
using Microsoft.AspNetCore.Mvc;
using Microsoft.Extensions.Options;
using System.Web.Http.Cors;

namespace grpc_net_client.Controllers
{
    [Route("api/rating")]
    [ApiController]
    [EnableCors(origins: "http://localhost:5173/", headers: "*", methods: "*")]
    public class RatingControllerClient : ControllerBase
    {
        private readonly IOptions<ApiConfig> _config;
        RatingController.RatingControllerClient _service;

        #region constructor
        public RatingControllerClient(IOptions<ApiConfig> config)
        {
            _config = config;
            AppContext.SetSwitch("System.Net.Http.SocketsHttpHandler.Http2UnencryptedSupport", true);
            GrpcChannel channel = GrpcChannel.ForAddress(_config.Value.GrpcChannelURL, new GrpcChannelOptions
            {
                MaxReceiveMessageSize = 1000 * 1024 * 1024
            });
            _service = new RatingController.RatingControllerClient(channel);
        }
        #endregion

        #region endpoints
        [HttpPost]
        public async Task<ActionResult> Post([FromBody] RatingDTO rating)
        {
            try
            {
                var response = await _service.addRatingAsync(rating);
                if (response.ServerResponse.Code == 500) throw new Exception(response.ServerResponse.Msg);
                return Ok(response);
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message.ToString());
                return StatusCode(500, ex.Message);
            }
        }

        [HttpPut]
        public async Task<ActionResult> Put([FromBody] RatingDTO ratingDTO)
        {
            try
            {
                var response = await _service.updateRatingAsync(ratingDTO);
                if (response.ServerResponse.Code == 500) throw new Exception(response.ServerResponse.Msg);
                return Ok(response);
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message.ToString());
                return StatusCode(500, ex.Message);
            }
        }

        [HttpGet("rating")]
        public async Task<ActionResult> Get(int idRecipe)
        {
            try
            {
                GetRatingRequest idRatingDTO = new() { IdRating = idRecipe };
                var response = await _service.getRatingAsync(idRatingDTO);
                if (response.ServerResponse.Code == 500) throw new Exception(response.ServerResponse.Msg);
                return Ok(response);
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message.ToString());
                return StatusCode(500, ex.Message);
            }
        }

        [HttpGet("rating/average")]
        public async Task<ActionResult> getAverageRating(int idRecipe)
        {
            try
            {
                GetRatingAvgRequest idRatingDTO = new() { IdRecipe = idRecipe };
                var response = await _service.getAverageRatingAsync(idRatingDTO);
                if (response.ServerResponse.Code == 500) throw new Exception(response.ServerResponse.Msg);
                return Ok(response);
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message.ToString());
                return StatusCode(500, ex.Message);
            }
        }

        [HttpGet("user-recipe")]
        public async Task<ActionResult> Get(int idUser, int idRecipe)
        {
            try
            {
                UserAndRecipeRatingRequest request = new() { 
                    IdUser = idUser,
                    IdRecipe = idRecipe 
                };

                var response = await _service.getRatingByUserAndRecipeAsync(request);
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
