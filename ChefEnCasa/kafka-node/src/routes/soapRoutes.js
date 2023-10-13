const express = require('express');
const soapCallbacks = require('../soap/soapCallbackExample')

const router = express();

router.post('/api/callsoap', soapCallbacks.getData);

module.exports = router