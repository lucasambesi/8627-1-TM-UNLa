const express = require('express');
const userCallbacks = require('../callbacks/userCallbacks')

const router = express();

router.post('/api/users/popularity', userCallbacks.sendPopularity);

module.exports = router