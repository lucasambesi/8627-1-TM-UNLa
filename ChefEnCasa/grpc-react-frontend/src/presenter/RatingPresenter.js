import axios from "axios"
import { recipePresenter } from './RecipePresenter'

export const ratingPresenter = () => {

    const baseUrl = import.meta.env.VITE_REACT_BACKEND_URL
    const { sendPopularityKafka } = recipePresenter()

    const addRating = async (rating) => {

        try {
            const body = {
                "idUser": rating.idUser,
                "idRecipe": rating.idRecipe,
                "value":rating.value
            }
            
            const res = await axios.post(`${baseUrl}/rating`, body);
            
            if(res.status == "200"){
                const resKafka = await sendPopularityKafka(rating.idRecipe, `+${rating.value}`)
            }        

            const result = res.status == "200" ? await res.data : null
            return result;
        } catch (err) {
            console.log('err => ' , err)
        }
    }

    const updateRating = async (rating, diffValue ) => {
        try {

            const body = {
                "idRating": rating.idRating,
                "idUser": rating.idUser,
                "idRecipe": rating.idRecipe,
                "value": rating.value
            }

            const res = await axios.put(`${baseUrl}/rating`, body);

            if(res.status == "200"){
                const resKafka = await sendPopularityKafka(rating.idRecipe, diffValue)
            }    

            const result = res.status == "200" ? await res.data : null
            return result;
        } catch (err) {
            console.log('err => ' , err)
        }
    }

    const getById = async (id) => {
        try {
            const res = await axios.get(`${baseUrl}/rating`, {
                params: {
                  idRating: id
                }
              });

            const result = await res.data

            return result
        } catch (err) {
            console.error(err)
        }
    }

    const getAverage = async (idRecipe) => {
        console.log("🚀 ~ file: RatingPresenter.js:71 ~ getAverage ~ idRecipe:", idRecipe)
        try {
            const res = await axios.get(`${baseUrl}/rating/average`, {
                params: {
                    idRecipe: idRecipe
                }
              });

              console.log("🚀 ~ file: RatingPresenter.js:79 ~ getAverage ~ res:", res)
            const result = await res.data

            return result
        } catch (err) {
            console.error(err)
        }
    }

    const getRatingByUserIdAndRecipeId = async (userId, recipeId) => {
        try {

            const res = await axios.get(`${baseUrl}/rating/user-recipe`, {
                params: {
                    idUser: userId,
                    idRecipe: recipeId
                }
              });

            const result = res.status == "200" ? await res.data : null
            return result
        } catch (err) {
            console.error(err)
        }
    }

    return {
        addRating,
        updateRating,
        getById,
        getRatingByUserIdAndRecipeId,
        getAverage
    }
}