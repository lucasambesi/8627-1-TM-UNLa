const consumer = require("../kafka/consumer");
const producer = require("../kafka/producer");
const callback = {};

callback.getAll = async (req, res) => {
    const groupId = Date.now().toString();
    const topic = req.query.topic;
    const maxMessages = req.query.maxMessages;
    
    try {
        const data = await consumer.getMessages(topic, groupId, maxMessages);
        res.json(data);
    } catch (error) {
        console.error(error);
        res.status(500).json({ error: 'Internal Server Error' });
    }
};

callback.sendComment = async (req, res) => {
    console.log("entro aca sendComment")
    try {
      const message = req.body
      const topic = req.body.topic
      console.log("🚀 ~ file: recipeCallbacks.js:23 ~ topic:", topic)
      
      const response = producer.sendMessage(message, topic);      
      res.json(response);

    } catch (error) {
      console.error("produceCommentCallbak: " + error.message);
      res.json(serverError(error))
    }
};

module.exports = callback;
