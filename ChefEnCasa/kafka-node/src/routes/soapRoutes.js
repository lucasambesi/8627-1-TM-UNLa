const express = require('express');
const soapCallbacks = require('../soap/userCallbacks')

const router = express();

router.post('/api/soap/users', soapCallbacks.GetUsers);
router.post('/api/soap/users/user', soapCallbacks.GetUserById);

module.exports = router