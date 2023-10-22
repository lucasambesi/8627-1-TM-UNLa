const express = require('express');
const userCallbacks = require('../soap/userCallbacks')
const messageCallbacks = require('../soap/messageCallbacks')
const bookCallbacks = require('../soap/bookCallbacks')

const router = express();

router.get('/api/soap/users', userCallbacks.GetUsers);
router.get('/api/soap/users/user', userCallbacks.GetUserById);

router.get('/api/soap/messages/user', messageCallbacks.GetMessagesByUserId);
router.post('/api/soap/messages', messageCallbacks.CreateMessage);
router.put('/api/soap/messages', messageCallbacks.UpdateMessage);

router.get('/api/soap/books/user', bookCallbacks.GetBooksByUserId);
router.post('/api/soap/books/recipe', bookCallbacks.AddRecipe);
router.post('/api/soap/books', bookCallbacks.CreateBook);
router.delete('/api/soap/books', bookCallbacks.DeleteBook);

module.exports = router