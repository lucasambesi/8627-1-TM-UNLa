import axios from "axios"

export const messagePresenter = () => {

    const baseUrl = import.meta.env.VITE_REACT_NODE_KAFKA_URL

    const addMessage = async (message) => {
        try {
            const body ={
                "IdReceiver": message.IdReceiver,
                "IdSender": message.IdSender,
                "Subject": message.Subject,
                "Value": message.Value
            }

            const res = await axios.post(`${baseUrl}/soap/messages`, body);

            const result = res.status === 200 ? await res.data : null;
            return result;
        } catch (err) {
            console.log('err => ', err);
        }
    }

    const updateMessage = async (message) => {

        const body = {
            "IdMessage": message.IdMessage,
            "Response": message.Response
        }
        
        try {    
            const res = await axios.put(`${baseUrl}/soap/messages`, body);

            const result = res.status == "200" ? await res.data : null
            return result;
        } catch (err) {
            console.log('err => ' , err)
        }
    }

    const getByUserId = async (id) => {
        try {
            const res = await axios.get(`${baseUrl}/soap/messages/user?id=${id}`);

            const result = await res.data

            return result.GetMessagerByUserIdResult.Message

        } catch (err) {
            console.error(err)
        }
    }

    return {
        addMessage,
        updateMessage,
        getByUserId
    }
}