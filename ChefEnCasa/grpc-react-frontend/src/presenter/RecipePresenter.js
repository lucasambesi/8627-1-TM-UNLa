import axios from "axios"
import {recipePresenterMock} from './Mocks/RecipeMock'

export const recipePresenter = () => {

    const useMock = import.meta.env.VITE_REACT_BACKEND_MOCK
    const baseUrl = import.meta.env.VITE_REACT_BACKEND_URL

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

    const getByFilter = async (filter) => {
        try {

            if(useMock == 'true'){
                return getMock().recipes
            }

            const res = await axios.get(`${baseUrl}/recipes/byFilter`, {
                params: {
                    "IdCategory": filter.idCategory != null ? filter.idCategory : 0,
                    "Title": filter.title != "" ? filter.title : null,
                    "Ingredients": filter.ingredients != "" ? filter.ingredients : null,
                    "TimeSince": filter.timeSince != null ? filter.timeSince : 0,
                    "TimeUntil":  filter.timeUntil != null ? filter.timeUntil : 1000,
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
            console.log("body =", body)
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
        getRecipesByUserId,
        addRecipe,
        getById,
        updateRecipe,
        getByFilter
    }
}