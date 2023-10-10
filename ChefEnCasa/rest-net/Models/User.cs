using System.ComponentModel.DataAnnotations.Schema;
using System.ComponentModel.DataAnnotations;

namespace rest_net.Models
{
    public class User
    {
        public int IdUser { get; set; }

        public string Name { get; set; }

        public string Lastname { get; set; }

        public string Dni { get; set; }

        public string Email { get; set; }

        public string Username { get; set; }

        public string Password { get; set; }

        public int Popularity { get; set; }

        public virtual ICollection<Recipe> Recipes { get; set; } = new HashSet<Recipe>();

        public virtual ICollection<Recipe> Favorites { get; set; } = new HashSet<Recipe>();

        public virtual ICollection<User> Following { get; set; } = new HashSet<User>();
    }
}
