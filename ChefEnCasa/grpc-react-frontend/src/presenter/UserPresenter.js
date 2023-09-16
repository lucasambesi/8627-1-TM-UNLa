import axios from "axios"
import {userPresenterMock} from './Mocks/UserMock'

export const userPresenter = () => {

    const useMock = import.meta.env.VITE_REACT_BACKEND_MOCK
    const baseUrl = import.meta.env.VITE_REACT_BACKEND_URL

    const { getMock } = userPresenterMock()

    const getById = async (idUser) => {
        try {

            if(useMock == 'true'){
                return getMock()
            }

            const res = await axios.get(`${baseUrl}/user`, {
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

    const login = async (username, password) => {
        try {
            if(useMock == 'true'){
                return getMock()
            }

            const body = {
                user: username,
                password: password
            }
            console.log(`${baseUrl}/user/login`, body)
            const res = await axios.post(`${baseUrl}/user/login`, body);
            
            return res;
        } catch (err) {
            console.log('err => ' , err)
        }
    }

    const register = async (user) => {
        try {
            if(useMock == 'true'){
                return getMock()
            }

            const body ={
                "name": user.name,
                "lastName": user.lastName,
                "dni": user.dni,
                "email": user.email,
                "username": user.username,
                "password": user.password
              }
            
            const res = await axios.post(`${baseUrl}/user/register`, body);

            return res.data;
        } catch (err) {
            console.log('err => ' , err)
        }
    }

    const addToFavorites = async (idUser, idRecipe) => {
        try {
            if(useMock == 'true'){
                return "success"
            }

            const body ={
                "idUser": idUser,
                "idRecipe": idRecipe
              }
            
            const res = await axios.post(`${baseUrl}/user/favorites`, body);

            return res.data;
        } catch (err) {
            console.log('err => ' , err)
        }
    }

    const deleteToFavorites = async (idUser, idRecipe) => {
        try {
            if(useMock == 'true'){
                return "success"
            }

            const body ={
                "idUser": idUser,
                "idRecipe": idRecipe
              }
              
            console.log("body = ", body)
            
            const res = await axios.delete(`${baseUrl}/user/favorites`, body);

            return res.data;
        } catch (err) {
            console.log('err => ' , err)
        }
    }

    const addFollowing = async (idUser, idFollowing) => {
        try {
            if(useMock == 'true'){
                return "success"
            }

            const body ={
                "idUser": idUser,
                "idFollowing": idFollowing
              }
            
            const res = await axios.post(`${baseUrl}/user/following`, body);

            return res.data;
        } catch (err) {
            console.log('err => ' , err)
        }
    }

    return {
        getById,
        login,
        register,
        addToFavorites,
        deleteToFavorites,
        addFollowing
    }
}