using Grpc.Net.Client;
using grpc_net_client.Model;
using grpc_net_client.Model.Config;
using Microsoft.AspNetCore.Mvc;
using Microsoft.Extensions.Options;
using System.Web.Http.Cors;

namespace grpc_net_client.Controllers
{
    [Route("api/recipes")]
    [ApiController]
    [EnableCors(origins: "http://localhost:5173/", headers: "*", methods: "*")]
    public class RecipeControllerClient : ControllerBase
    {
        private readonly IOptions<ApiConfig> _config;
        RecipeController.RecipeControllerClient _service;

        #region constructor
        public RecipeControllerClient(IOptions<ApiConfig> config)
        {
            _config = config;
            AppContext.SetSwitch("System.Net.Http.SocketsHttpHandler.Http2UnencryptedSupport", true);
            GrpcChannel channel = GrpcChannel.ForAddress(_config.Value.GrpcChannelURL, new GrpcChannelOptions
            {
                MaxReceiveMessageSize = 1000 * 1024 * 1024
            });
            _service = new RecipeController.RecipeControllerClient(channel);
        }
        #endregion

        #region endpoints

        [HttpGet("recipe")]
        public async Task<ActionResult> Get(int idRecipe)
        {
            try
            {
                GetRecipeRequest idRecipeDTO = new GetRecipeRequest() { IdRecipe = idRecipe };
                var response = await _service.getRecipeAsync(idRecipeDTO);
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
                var response = await _service.getAllRecipesAsync(new Empty());
                if (response.Recipes.Count == 0) return NoContent();
                if (response.ServerResponse.Code == 500) throw new Exception(response.ServerResponse.Msg);
                return Ok(response.Recipes);
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message.ToString());
                return StatusCode(500, ex.Message);
            }
        }

        [HttpGet]
        [Route("user")]
        public async Task<ActionResult> GetByUsuario(int userId)
        {
            try
            {
                IdUserRequest request = new IdUserRequest() { IdUser = userId };
                var response = await _service.getRecipesByUserIdAsync(request);
                if (response.Recipes.Count == 0) return NoContent();
                if (response.ServerResponse.Code == 500) throw new Exception(response.ServerResponse.Msg);
                return Ok(response.Recipes);
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message.ToString());
                return StatusCode(500, ex.Message);
            }
        }

        [HttpGet]
        [Route("byFilter")]
        public async Task<ActionResult> GetByFilter([FromQuery] GetByFilterRequest request)
        {
            try
            {
                var response = await _service.getByFilterAsync(request);
                if (response.Recipes.Count == 0) return NoContent();
                if (response.ServerResponse.Code == 500) throw new Exception(response.ServerResponse.Msg);
                return Ok(response.Recipes);
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message.ToString());
                return StatusCode(500, ex.Message);
            }
        }

        [HttpPost]
        public async Task<ActionResult> Post([FromBody] Recipe recipe)
        {
            try
            {
                RecipeDTO recipeDTO = new()
                {
                    IdRecipe = recipe.IdRecipe,
                    Title = recipe.Title,
                    Description = recipe.Description,
                    Ingredients = recipe.Ingredients,
                    PreparationTime = recipe.PreparationTime,
                    IdCategory = recipe.IdCategory,
                    IdUser = recipe.IdUser,
                };

                foreach (var image in recipe.Images)
                {
                    RecipeImageDTO imageDTO = new() 
                    { 
                        Name = image.Name,
                        File = image.File,
                        IdImage = image.IdImage
                    };
                    recipeDTO.Images.Add(imageDTO);
                }

                foreach (var step in recipe.Steps)
                {
                    StepDTO stepDTO = new()
                    {
                        Description = step.Description,
                        IdStep = step.IdStep
                    };
                    recipeDTO.Steps.Add(stepDTO);
                }

                var response = await _service.addRecipeAsync(recipeDTO);
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
        public async Task<ActionResult> Put([FromBody] Recipe recipe)
        {
            try
            {
                RecipeDTO recipeDTO = new()
                {
                    IdRecipe = recipe.IdRecipe,
                    Title = recipe.Title,
                    Description = recipe.Description,
                    Ingredients = recipe.Ingredients,
                    PreparationTime = recipe.PreparationTime,
                    IdCategory = recipe.IdCategory,
                    IdUser = recipe.IdUser,
                };

                foreach (var image in recipe.Images)
                {
                    RecipeImageDTO imageDTO = new()
                    {
                        Name = image.Name,
                        File = image.File,
                        IdImage = image.IdImage
                    };
                    recipeDTO.Images.Add(imageDTO);
                }

                foreach (var step in recipe.Steps)
                {
                    StepDTO stepDTO = new()
                    {
                        Description = step.Description,
                        IdStep = step.IdStep
                    };
                    recipeDTO.Steps.Add(stepDTO);
                }

                var response = await _service.updateRecipeAsync(recipeDTO);
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
