using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

public class User
{
    public int IdUser { get; set; }

    [Required]
    public string Name { get; set; }

    [Required]
    public string Lastname { get; set; }

    public string Dni { get; set; }

    [Required]
    public string Email { get; set; }

    [Required]
    public string Username { get; set; }

    [Required]
    public string Password { get; set; }

    [Required]
    public int Popularity { get; set; }

}