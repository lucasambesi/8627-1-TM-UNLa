const {Kafka} = require('kafkajs')
const { serverError, serverOK } = require('../callbacks/utils')
const kafka = new Kafka({
    clientId: 'DSSDTP2',
    brokers: ['127.0.0.1:29092']
})

const producer = kafka.producer()

const sendMessage = async (msg, topic)=>{
    try {
        await producer.connect()

        const message = JSON.stringify(msg)
        console.log(`The message is saved in topic <${topic}>: ${message}`)

        await producer.send({
            topic: topic,
            messages:[
                {
                    value: message
                }
            ]
        })

        await producer.disconnect()

        return serverOK("comment saved")
    } catch (error) {
        console.error("producer error: " + error)
        return serverError(error)
    }
}


module.exports = {
    sendMessage
}