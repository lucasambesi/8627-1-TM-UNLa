import axios from "axios"
import {recipePresenterMock} from './Mocks/RecipeMock'

export const recipePresenter = () => {

    const useMock = import.meta.env.VITE_REACT_BACKEND_MOCK
    const baseUrl = import.meta.env.VITE_REACT_BACKEND_URL

    const {getMock} = recipePresenterMock()

    const getRecipes = async () => {
        try {

            if(useMock == 'true'){
                return getMock()
            }

            const res = await axios.get(`${baseUrl}/recipes`);
            
            const result = await res.data;
            return result
        } catch (err) {
            console.error(err)
        }
    }

    const getRecipesByUserId = async (idUser) => {
        try {

            if(useMock == 'true'){
                return getMock()
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

    return {
        getRecipes,
        getRecipesByUserId,
    }
}