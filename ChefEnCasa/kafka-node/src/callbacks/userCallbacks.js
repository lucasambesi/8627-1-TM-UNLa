const consumer = require("../kafka/consumer");
const producer = require("../kafka/producer");
const callback = {};

callback.sendPopularity = async (req, res) => {
    try {
      const topic = req.body.topic
      const message = {
        "idUser": req.body.idUser,
        "score": req.body.score
      }

      const response = producer.sendMessage(message, topic);      
      res.json(response);

    } catch (error) {
      console.error("produceSendPopularityCallbak: " + error.message);
      res.json(serverError(error))
    }
};

module.exports = callback;
