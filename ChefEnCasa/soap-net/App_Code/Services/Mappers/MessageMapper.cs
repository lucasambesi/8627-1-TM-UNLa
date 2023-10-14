using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

public static class MessageMapper
{
    public static Message MapToEntity(CreateRequest createRequest)
    {
        if (createRequest == null)
        {
            return null;
        }

        return new Message
        {
            SenderId = createRequest.IdSender,
            ReceiverId = createRequest.IdReceiver,
            Subject = createRequest.Subject,
            Value = createRequest.Value
        };
    }

    public static Message MapToEntity(UpdateRequest createRequest)
    {
        if (createRequest == null)
        {
            return null;
        }

        return new Message
        {
            IdMessage = createRequest.IdMessage,
            Response = createRequest.Response
        };
    }
}