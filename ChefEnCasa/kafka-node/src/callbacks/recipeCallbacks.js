const consumer = require("../kafka/consumer");
const callback = {};

callback.consume = async (req, res) => {
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

module.exports = callback;
