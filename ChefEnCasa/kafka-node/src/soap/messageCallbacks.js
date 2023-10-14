
const soap = require('soap');
const callback = {};

const serviceUrl = 'http://localhost:63857/MessageService.svc?wsdl';

callback.GetMessagesByUserId = async (req, res) => {
    const args = req.query

    try {
      const client = await soap.createClientAsync(serviceUrl);

      const result = await client.GetMessagerByUserIdAsync(args); 
  
      res.json(result[0]);
    } catch (error) {
      console.error(error);
      res.status(500).json({ error: 'Internal Server Error' });
    }
};

callback.CreateMessage = async (req, res) => {
  const args = 
  {
      "request" : req.body
  }

  try {
    const client = await soap.createClientAsync(serviceUrl);

    const result = await client.CreateMessageAsync(args); 

    res.json(result[0]);
  } catch (error) {
    console.error(error);
    res.status(500).json({ error: 'Internal Server Error' });
  }
};

callback.UpdateMessage = async (req, res) => {
    const args = 
    {
        "request" : req.body
    }
  
    try {
      const client = await soap.createClientAsync(serviceUrl);
  
      const result = await client.UpdateMessageAsync(args); 
  
      res.json(result[0]);
    } catch (error) {
      console.error(error);
      res.status(500).json({ error: 'Internal Server Error' });
    }
  };

module.exports = callback;
