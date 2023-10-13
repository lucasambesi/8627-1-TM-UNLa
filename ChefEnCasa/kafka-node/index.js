const express = require('express');
const path = require('path');
const cors = require('cors'); 

const recipeRoutes = require('./src/routes/recipeRoutes');
const userRoutes = require('./src/routes/userRoutes');
const soapRoutes = require('./src/routes/soapRoutes');


const myConnection = require('express-myconnection');
const app = express();

const corsOptions = {
  origin: 'http://localhost:5173',
  methods: 'GET,HEAD,PUT,PATCH,POST,DELETE',
  credentials: true,
  optionsSuccessStatus: 204,
};

app.set('port', 5000);

app.use(cors(corsOptions));

app.use(express.json());

app.use(express.urlencoded({ extended: false }));
const logger = (req, res, next) => {
  console.log(`Request ${req.method.toUpperCase()} received - ${req.protocol}://${req.get('host')}${req.originalUrl}`);
  console.log("body: ", req.body);
  next();
};

app.use(logger);
app.use(recipeRoutes);
app.use(userRoutes);
app.use(soapRoutes);

app.listen(app.get('port'), () => {
  console.log("Server started and listening on port ", app.get('port'));
});