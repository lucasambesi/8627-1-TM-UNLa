namespace grpc_net_client.Model
{
    public class Recipe
    {
        public int IdRecipe { get; set; }

        public string Title { get; set; }

        public string Description { get; set; }

        public string Ingredients { get; set; }

        public int PreparationTime { get; set; }

        public bool Active { get; set; }

        public int IdCategory { get; set; }

        public int IdUser { get; set; }

        public Image[] Images { get; set; }

        public Step[] Steps { get; set; }
    }
}
