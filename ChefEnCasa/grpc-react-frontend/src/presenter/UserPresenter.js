import axios from "axios"
import { recipePresenter } from './RecipePresenter'

export const userPresenter = () => {

    const baseUrl = import.meta.env.VITE_REACT_BACKEND_URL
    const baseKafkaUrl = import.meta.env.VITE_REACT_NODE_KAFKA_URL

    const { sendPopularityKafka: sendPopularityRecipeKafka } = recipePresenter()

    const sendPopularityKafka = async (idUser, score) => {
        try {
            const topic = import.meta.env.VITE_REACT_TOPIC_POPULARITY_USER

            const body = {
                "topic": topic,
                "idUser": idUser,
                "score": score,
            }

            const res = await axios.post(`${baseKafkaUrl}/users/popularity`, body);

            return res.data;
        } catch (err) {
            console.log('err => ' , err)
        }
    }

    const getById = async (idUser) => {
        try {
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

    const getUsersByPopularity = async (pageSize, pageNumber) => {
        try {
            const res = await axios.get(`${baseUrl}/user/popularity`, {
                params: {
                    pageSize: pageSize,
                    pageNumber: pageNumber
                }
              });

            const result = await res.data;

            return result.users
        } catch (err) {
            console.error(err)
        }
    }

    const login = async (username, password) => {
        try {
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

    const addToFavorites = async (idUser, idRecipe, idAutor) => {
        try {
            const body ={
                "idUser": idUser,
                "idRecipe": idRecipe
              }
            
            const res = await axios.post(`${baseUrl}/user/favorites`, body);
            if(res.status == "200"){
                const resKafka = await sendPopularityKafka(idAutor, '+1')
                const resRecipeKafka = sendPopularityRecipeKafka(idRecipe, '+1')
            }

            return res.data;
        } catch (err) {
            console.log('err => ' , err)
        }
    }

    const deleteToFavorites = async (idUser, idRecipe, idAutor) => {
        try {        
            const res = await axios.delete(`${baseUrl}/user/favorites`, {
                params: {
                    "idUser": idUser,
                    "idRecipe": idRecipe
                }
              });

            if(res.status == "200"){
                const resKafka = await sendPopularityKafka(idAutor, '-1')
                const resRecipeKafka = sendPopularityRecipeKafka(idRecipe, '-1')
            }

            return res.data;
        } catch (err) {
            console.log('err => ' , err)
        }
    }

    const addFollowing = async (idUser, idFollowing) => {
        try {
            const body ={
                "idUser": idUser,
                "idFollowing": idFollowing
              }
            
            const res = await axios.post(`${baseUrl}/user/following`, body);
            if(res.status == "200"){
                const resKafka = await sendPopularityKafka(idFollowing, '+1')
            }

            return res.data;
        } catch (err) {
            console.log('err => ' , err)
        }
    }

    const deleteFollowing = async (idUser, idFollowing) => {
        try {
            const res = await axios.delete(`${baseUrl}/user/following`, {
                params: {
                    "idUser": idUser,
                    "IdFollowing": idFollowing
                }
              });

              if(res.status== "200"){            
                  const resKafka = await sendPopularityKafka(idFollowing, '-1')
              }

            return res.data;
        } catch (err) {
            console.log('err => ' , err)
        }
    }


    const isInFavorites = async (idUser, idRecipe) => {

        //TODO: Refactor crear endpoint para consultar si la receta esta en favs
        try {
            const res = await axios.get(`${baseUrl}/recipes/favorites`, {
                params: {
                  userId: idUser
                }
              });

            const result = await res.data

            return existRecipe(result, idRecipe)
        } catch (err) {
            console.error(err)
        }
    }

    function existRecipe(recetas, idRecipe) {     
        for (let i = 0; i < recetas.length; i++) {
          if (recetas[i].idRecipe == idRecipe) {
            return true; 
          }
        }
        return false;
      }

    return {
        getById,
        login,
        register,
        addToFavorites,
        deleteToFavorites,
        addFollowing,
        deleteFollowing,
        isInFavorites,
        getUsersByPopularity,
        sendPopularityKafka
    }
}