using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations.Schema;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

public class Message
{
        public int IdMessage { get; set; }

        public int SenderId { get; set; }

        public User Sender { get; set; }

        public int ReceiverId { get; set; }

        public User Receiver { get; set; }

        public string Subject { get; set; }

        public string Value { get; set; }

        public string Response { get; set; }

        public bool Answered { get; set; }
}