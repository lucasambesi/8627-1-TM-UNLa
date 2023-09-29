const express = require('express');
const recipeCallbacks = require('../callbacks/recipeCallbacks')

const router = express();

router.get('/', (   req, res)=>{
    res.send("chefEnCasa client!")
})

router.get('/api/recipes/recipes', recipeCallbacks.getAll);
router.post('/api/recipes/send-comment', recipeCallbacks.sendComment);
router.post('/api/recipes/popularity', recipeCallbacks.sendPopularity);

module.exports = router