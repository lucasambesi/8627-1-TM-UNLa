using System.Collections.Generic;

public class Book
{
    public int IdBook { get; set; }

    public string Name { get; set; }

    public bool Active { get; set; }

    public int IdUser { get; set; }

    public HashSet<Recipe> Recipes { get; set; }
}