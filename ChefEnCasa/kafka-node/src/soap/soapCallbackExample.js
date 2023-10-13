
const soap = require('soap');
const callback = {};

const serviceUrl = 'http://localhost:63857/Service.svc?wsdl';

callback.getData = async (req, res) => {
    const args = req.body;

    try {
      const client = await soap.createClientAsync(serviceUrl);

      const result = await client.GetDataAsync(args); 

      console.log("🚀 ~ file: soapCallback.js:15 ~ callback.getData= ~ result:", result)
  
      res.json(result[0]);
    } catch (error) {
      console.error(error);
      res.status(500).json({ error: 'Internal Server Error' });
    }
};

module.exports = callback;
