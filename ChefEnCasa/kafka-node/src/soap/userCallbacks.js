
const soap = require('soap');
const callback = {};

const serviceUrl = 'http://localhost:63857/UserService.svc?wsdl';

callback.GetUsers = async (req, res) => {
    const args = req.body;

    try {
      const client = await soap.createClientAsync(serviceUrl);

      const result = await client.GetUsersAsync(args); 

      console.log("🚀 ~ file: soapCallback.js:15 ~ callback.getData= ~ result:", result)
  
      res.json(result[0]);
    } catch (error) {
      console.error(error);
      res.status(500).json({ error: 'Internal Server Error' });
    }
};

callback.GetUserById = async (req, res) => {
  const args = req.query;
  console.log("🚀 ~ file: userCallbacks.js:26 ~ callback.GetUserById= ~ args:", args)
  try {
    const client = await soap.createClientAsync(serviceUrl);

    const result = await client.GetUserByIdAsync(args); 

    console.log("🚀 ~ file: soapCallback.js:15 ~ callback.getData= ~ result:", result)

    res.json(result[0]);
  } catch (error) {
    console.error(error);
    res.status(500).json({ error: 'Internal Server Error' });
  }
};

module.exports = callback;
