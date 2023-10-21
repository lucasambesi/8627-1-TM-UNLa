using System.ComponentModel.DataAnnotations;
    
public class Recipe
{
    public int IdRecipe { get; set; }

    public string Title { get; set; }

    public string Description { get; set; }

    public string Ingredients { get; set; }

    public int PreparationTime { get; set; }

    public bool Active { get; set; }

    public int Popularity { get; set; }

}