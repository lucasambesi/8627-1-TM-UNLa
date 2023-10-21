
const soap = require('soap');
const callback = {};

const serviceUrl = 'http://localhost:63857/BookService.svc?wsdl';

callback.GetBooksByUserId = async (req, res) => {
    const args = req.query;

    try {
      const client = await soap.createClientAsync(serviceUrl);

      const result = await client.GetBooksByUserIdAsync(args); 
  
      res.json(result[0]);
    } catch (error) {
      console.error(error);
      res.status(500).json({ error: 'Internal Server Error' });
    }
};

callback.CreateBook = async (req, res) => {
    const args = req.body
    
    try {
      const client = await soap.createClientAsync(serviceUrl);
  
      const result = await client.CreateBookAsync(args); 
  
      res.json(result[0]);
    } catch (error) {
      console.error(error);
      res.status(500).json({ error: 'Internal Server Error' });
    }
  };

  callback.AddRecipe = async (req, res) => {
    const args = req.body
    console.log("🚀 ~ file: bookCallbacks.js:39 ~ callback.AddRecipe= ~ args:", args)
    
    try {
      const client = await soap.createClientAsync(serviceUrl);
  
      const result = await client.AddRecipeAsync(args); 
  
      res.json(result[0]);
    } catch (error) {
      console.error(error);
      res.status(500).json({ error: 'Internal Server Error' });
    }
  };

module.exports = callback;
