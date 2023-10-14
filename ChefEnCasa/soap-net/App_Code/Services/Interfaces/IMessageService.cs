using Google.Protobuf.WellKnownTypes;
using System.Collections.Generic;
using System.Runtime.Serialization;
using System.ServiceModel;

[ServiceContract]
public interface IMessageService
{
    [OperationContract]
    bool CreateMessage(CreateRequest request);

    [OperationContract]
    bool UpdateMessage(UpdateRequest request);

    [OperationContract]
    List<Message> GetMessagerByUserId(string id);
}

[DataContract]
public class CreateRequest
{
    int idSender;
    int idReceiver;
    string subject;
    string valueMessage;

    [DataMember]
    public int IdSender
    {
        get { return idSender; }
        set { idSender = value; }
    }

    [DataMember]
    public int IdReceiver
    {
        get { return idReceiver; }
        set { idReceiver = value; }
    }

    [DataMember]
    public string Subject
    {
        get { return subject; }
        set { subject = value; }
    }

    [DataMember]
    public string Value
    {
        get { return valueMessage; }
        set { valueMessage = value; }
    }
}

[DataContract]
public class UpdateRequest
{
    int idMessage;
    string response;

    [DataMember]
    public int IdMessage
    {
        get { return idMessage; }
        set { idMessage = value; }
    }

    [DataMember]
    public string Response
    {
        get { return response; }
        set { response = value; }
    }
}
