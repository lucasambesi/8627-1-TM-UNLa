const express = require('express');
const recipeCallbacks = require('../callbacks/recipeCallbacks')

const router = express();

router.get('/', (req, res)=>{
    res.send("chefEnCasa client!")
})

router.get('/recipes', recipeCallbacks.consume);

module.exports = router