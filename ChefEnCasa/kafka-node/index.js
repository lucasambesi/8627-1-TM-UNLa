const express = require('express');
const path = require('path');

const recipeRoutes = require('./src/routes/recipeRoutes');

const myConnection = require('express-myconnection');
const app = express();
app.set('port', 5000);

app.use(express.json());

app.use(express.urlencoded({ extended: false }));
const logger = (req, res, next) => {
  console.log(`Request ${req.method.toUpperCase()} received - ${req.protocol}://${req.get('host')}${req.originalUrl}`);
  console.log("body: ", req.body);
  next();
};

app.use(logger);
app.use(recipeRoutes);

app.listen(app.get('port'), () => {
  console.log("Server started and listening on port ", app.get('port'));
});