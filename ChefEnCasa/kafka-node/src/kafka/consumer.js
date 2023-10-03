const { Kafka } = require('kafkajs');

const kafka = new Kafka({
  clientId: "DSSDTP2",
  brokers: ["127.0.0.1:29092"],
});

const getMessages = async (topic, groupId, maxMessages) => {
  try {
    let unreadMessages = [];
    let messagesRead = 0;

    console.log(`the topic <${topic}> is consumed with the groupId: ${groupId}`);
    const consumer = kafka.consumer({ groupId: groupId });

    await consumer.connect();

    await consumer.subscribe({
      topic: topic,
      fromBeginning: true
    });

    const data = await new Promise((resolve, reject) => {
      consumer.run({
        eachBatchAutoResolve: false,
        eachBatch: async ({ batch, resolveOffset, heartbeat, isRunning, isStale }) => {
          console.log("pending messages: " + batch.messages.length);
          let rs = [];
          for (let message of batch.messages) {
            if (!isRunning() || isStale()) break;
            resolveOffset(message.offset);
            rs.push(JSON.parse(message.value.toString()));

          }

          unreadMessages = rs.slice(-5);;
          consumer.disconnect();
          resolve(unreadMessages);
        }
      });
    });

    return data;
  } catch (error) {
    console.error("consumer error: " + error);
    throw error;
  }
};
  
module.exports = {
  getMessages
};
