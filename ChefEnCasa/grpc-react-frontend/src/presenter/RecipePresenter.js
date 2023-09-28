import axios from "axios"
import {recipePresenterMock} from './Mocks/RecipeMock'

export const recipePresenter = () => {

    const useMock = import.meta.env.VITE_REACT_BACKEND_MOCK
    const baseUrl = import.meta.env.VITE_REACT_BACKEND_URL
    const baseKafkaUrl = import.meta.env.VITE_REACT_NODE_KAFKA_URL

    const {getMock} = recipePresenterMock()

    const getRecipes = async () => {
        try {

            if(useMock == 'true'){
                return getMock().recipes
            }
            
            const res = await axios.get(`${baseUrl}/recipes`);
            
            const result = await res.data;            
            return result
        } catch (err) {
            console.error(err)
        }
    }

    const getKafkaRecipes = async (countRecipes) => {
        try {
            const topic = import.meta.env.VITE_REACT_TOPIC_NEWS
            
            const res = await axios.get(`${baseKafkaUrl}/recipes/recipes`, {
                params: {                  
                  topic: topic,
                  maxMessages: countRecipes
                }
              });
            
            const result = await res.data;
            
            return result
        } catch (err) {
            console.error(err)
        }
    }

    const sendCommentKafka = async (idUser, idRecipe, comment) => {
        try {
            const topic = import.meta.env.VITE_REACT_TOPIC_COMMENTS

            const body = {
                "topic": topic,
                "idUser": idUser,
                "idRecipe": idRecipe,
                "comment": comment
            }

            const res = await axios.post(`${baseKafkaUrl}/recipes/send-comment`, body);

            return res.data;
        } catch (err) {
            console.log('err => ' , err)
        }
    }

    const getById = async (id) => {
        try {

            if(useMock == 'true'){
                return getMock()
            }

            const res = await axios.get(`${baseUrl}/recipes/recipe`, {
                params: {
                  idRecipe: id
                }
              });

            const result = await res.data

            return result.recipe
        } catch (err) {
            console.error(err)
        }
    }

    const getRecipesByUserId = async (idUser) => {
        try {

            if(useMock == 'true'){
                return getMock().recipes
            }

            const res = await axios.get(`${baseUrl}/recipes/user`, {
                params: {
                  userId: idUser
                }
              });

            const result = await res.data

            return result
        } catch (err) {
            console.error(err)
        }
    }

    const getFavorites = async (idUser) => {
        try {

            if(useMock == 'true'){
                return getMock().recipes
            }

            const res = await axios.get(`${baseUrl}/recipes/favorites`, {
                params: {
                  userId: idUser
                }
              });

            const result = await res.data

            return result
        } catch (err) {
            console.error(err)
        }
    }

    const getByFilter = async (filter) => {
        try {

            if(useMock == 'true'){
                return getMock().recipes
            }
            console.log("filter =>", filter)
            const res = await axios.get(`${baseUrl}/recipes/byFilter`, {
                params: {
                    "IdCategory": filter.category.idCategory != null ? filter.category.idCategory : 0,
                    "Title": filter.title != "" ? filter.title : null,
                    "Ingredients": filter.ingredients != "" ? filter.ingredients : null,
                    "TimeSince": filter.timeSince != null ? filter.timeSince : 0,
                    "TimeUntil":  filter.timeUntil != null ? filter.timeUntil : 1000,
                    "PageNumber": filter.pageNumber != null ? filter.pageNumber : 1,
                    "PageSize": filter.pageSize != null ? filter.pageSize : 6,
                }
              });

            const result = await res.data

            return result
        } catch (err) {
            console.error(err)
        }
    }

    const addRecipe = async (recipe) => {

        console.log("recipe ", recipe)
        try {
            if(useMock == 'true'){
                return getMock()
            }

            const body = {
                "idUser": recipe.idUser,
                "title": recipe.title,
                "description":recipe.description,
                "ingredients": recipe.ingredients,
                "idCategory": recipe.idCategory,
                "preparationTime": recipe.preparationTime,
                "images": recipe.images,
                "steps": recipe.steps
            }
            console.log("body =>", body)
            const res = await axios.post(`${baseUrl}/recipes`, body);

            return res.data;
        } catch (err) {
            console.log('err => ' , err)
        }
    }

    const updateRecipe = async (recipe, idUser) => {
        try {
            if(useMock == 'true'){
                return getMock()
            }
            
            const body = {
                "idUser": idUser,
                "idRecipe": recipe.idRecipe,
                "title": recipe.title,
                "description":recipe.description,
                "ingredients": recipe.ingredients,
                "idCategory": recipe.idCategory,
                "preparationTime": recipe.preparationTime,
                "images": recipe.images,
                "steps": recipe.steps
            }

            const res = await axios.put(`${baseUrl}/recipes`, body);

            return res.data;
        } catch (err) {
            console.log('err => ' , err)
        }
    }

    return {
        getRecipes,
        getKafkaRecipes,
        getRecipesByUserId,
        addRecipe,
        getById,
        updateRecipe,
        getByFilter,
        getFavorites,
        sendCommentKafka
    }
}