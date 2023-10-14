using System;
using System.Collections.Generic;
using System.Configuration;
using System.Linq;
using System.Web;

public class MessageService : IMessageService
{
    private string connectionString = ConfigurationManager.ConnectionStrings["chefEnCasa"].ConnectionString;
    private MessageRepository messageRepository;

    public MessageService()
    {
        messageRepository = new MessageRepository(connectionString);
    }

    public bool CreateMessage(CreateRequest request)
    {
        var message = MessageMapper.MapToEntity(request);
        
        if(message == null)
        {
            return false;
        }

        if(request.IdSender == 0 ||  request.IdReceiver == 0 ||
           request.Subject == "" || request.Value == "")
        {
            return false;
        }

        return messageRepository.CreateMessage(message);
    }

    public bool UpdateMessage(UpdateRequest request)
    {
        var message = MessageMapper.MapToEntity(request);

        if (message == null)
        {
            return false;
        }

        if (request.IdMessage == 0 || request.Response == null)
        {
            return false;
        }

        return messageRepository.UpdateMessage(message);
    }

    public List<Message> GetMessagerByUserId(string id)
    {
        return messageRepository.GetMessagerByUserId(id);
    }
}