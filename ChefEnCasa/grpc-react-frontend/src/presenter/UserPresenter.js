import { useState } from "react"
import axios from "axios"


export const userPresenter = () => {

    const [user, setUser] = useState([])
    
    const getById = async (idUser) => {
        try {
            const res = await axios.get('https://localhost:44381/api/user', {
                params: {
                  idUser: idUser
                }
              });
            const result = await res.data;
            return result
        } catch (err) {
            console.error(err)
        }
    }

    return {
        getById,
    }
}