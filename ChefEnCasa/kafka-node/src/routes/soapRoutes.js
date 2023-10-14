const express = require('express');
const userCallbacks = require('../soap/userCallbacks')
const messageCallbacks = require('../soap/messageCallbacks')

const router = express();

router.get('/api/soap/users', userCallbacks.GetUsers);
router.get('/api/soap/users/user', userCallbacks.GetUserById);

router.get('/api/soap/messages/user', messageCallbacks.GetMessagesByUserId);
router.post('/api/soap/messages', messageCallbacks.CreateMessage);
router.put('/api/soap/messages', messageCallbacks.UpdateMessage);

module.exports = router