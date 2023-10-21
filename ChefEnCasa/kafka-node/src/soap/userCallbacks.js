
const soap = require('soap');
const callback = {};

const serviceUrl = 'http://localhost:63857/UserService.svc?wsdl';

callback.GetUsers = async (req, res) => {
    const args = req.body;

    try {
      const client = await soap.createClientAsync(serviceUrl);

      const result = await client.GetUsersAsync(args); 
  
      res.json(result[0]);
    } catch (error) {
      console.error(error);
      res.status(500).json({ error: 'Internal Server Error' });
    }
};

callback.GetUserById = async (req, res) => {
  const args = req.query;
  try {
    const client = await soap.createClientAsync(serviceUrl);

    const result = await client.GetUserByIdAsync(args); 

    res.json(result[0]);
  } catch (error) {
    console.error(error);
    res.status(500).json({ error: 'Internal Server Error' });
  }
};

module.exports = callback;
