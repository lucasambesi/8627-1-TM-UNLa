using MySql.Data.MySqlClient;
using System;
using System.Collections.Generic;

public class MessageRepository
{
    private string connectionString;

    public MessageRepository(string connectionString)
    {
        this.connectionString = connectionString;
    }

    public bool CreateMessage(Message message)
    {
        using (MySqlConnection connection = new MySqlConnection(connectionString))
        {
            try
            {
                connection.Open();

                string sql = "INSERT INTO messages (idSender, idReceiver, subject, value, response, answered) " +
                             "VALUES (@SenderId, @ReceiverId, @Subject, @Value, @Response, @Answered)";

                using (MySqlCommand cmd = new MySqlCommand(sql, connection))
                {
                    cmd.Parameters.AddWithValue("@SenderId", message.SenderId);
                    cmd.Parameters.AddWithValue("@ReceiverId", message.ReceiverId);
                    cmd.Parameters.AddWithValue("@Subject", message.Subject);
                    cmd.Parameters.AddWithValue("@Value", message.Value);
                    cmd.Parameters.AddWithValue("@Response", message.Response);
                    cmd.Parameters.AddWithValue("@Answered", message.Answered);

                    int rowsAffected = cmd.ExecuteNonQuery();

                    return rowsAffected > 0;
                }
            }
            catch (Exception ex)
            {
                Console.WriteLine("Error al crear el mensaje: " + ex.Message);
                return false;
            }
            finally
            {
                connection.Close();
            }
        }
    }

    public bool UpdateMessage(Message message)
    {
        using (MySqlConnection connection = new MySqlConnection(connectionString))
        {
            try
            {
                connection.Open();

                string sql = "UPDATE messages " +
                             "SET response = @Response, answered = @Answered " +
                             "WHERE idMessage = @IdMessage";

                using (MySqlCommand cmd = new MySqlCommand(sql, connection))
                {
                    cmd.Parameters.AddWithValue("@IdMessage", message.IdMessage);
                    cmd.Parameters.AddWithValue("@Response", message.Response);
                    cmd.Parameters.AddWithValue("@Answered", true);

                    int rowsAffected = cmd.ExecuteNonQuery();

                    return rowsAffected > 0;
                }
            }
            catch (Exception ex)
            {
                Console.WriteLine("Error al actualizar el mensaje: " + ex.Message);
                return false;
            }
            finally
            {
                connection.Close();
            }
        }
    }

    public List<Message> GetMessagerByUserId(string id)
    {
        List<Message> messages = new List<Message>();

        using (MySqlConnection connection = new MySqlConnection(connectionString))
        {
            connection.Open();

            string sql = 
                "SELECT messages.*, users.* " +
                "FROM messages " +
                "INNER JOIN users ON (messages.idSender = users.idUser OR messages.idReceiver = users.idUser) " +
                "WHERE (messages.idSender = @UserId OR messages.idReceiver = @UserId) " +
                "AND users.idUser != @UserId ORDER BY messages.idMessage DESC;";
            using (MySqlCommand cmd = new MySqlCommand(sql, connection))
            {
                cmd.Parameters.AddWithValue("@UserId", id);

                using (MySqlDataReader reader = cmd.ExecuteReader())
                {
                    while (reader.Read())
                    {
                        Message message = mapToEntity(reader, id);

                        messages.Add(message);
                    }
                }
            }

            connection.Close();
        }

        return messages;
    }

    private static Message mapToEntity(MySqlDataReader reader, string id)
    {
        var message = new Message
        {
            IdMessage = Convert.ToInt32(reader["idMessage"]),
            ReceiverId = Convert.ToInt32(reader["idReceiver"]),
            SenderId = Convert.ToInt32(reader["idSender"]),
            Subject = reader["subject"].ToString(),
            Value = reader["value"].ToString(),
            Response = reader["response"].ToString(),
            Answered = Convert.ToBoolean(reader["answered"])
        };

        if(id != message.SenderId.ToString())
        {
            message.Sender = new User()
            {
                IdUser = message.SenderId,
                Username = reader["username"].ToString(),
                Name = reader["name"].ToString(),
                Lastname = reader["lastname"].ToString(),
            };
        }
        else
        {
            message.Receiver = new User()
            {
                IdUser = message.ReceiverId,
                Username = reader["username"].ToString(),
                Name = reader["name"].ToString(),
                Lastname = reader["lastname"].ToString(),
            };
        }

        return message;
    }
}