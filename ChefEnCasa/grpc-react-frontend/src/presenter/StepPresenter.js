import axios from "axios"
import {stepPresenterMock} from './Mocks/StepMock'

export const stepPresenter = () => {

    const useMock = import.meta.env.VITE_REACT_BACKEND_MOCK
    const baseUrl = import.meta.env.VITE_REACT_BACKEND_URL

    const {getMock} = stepPresenterMock()

    const getStepsByRecipeId = async (recipeId) => {
        try {

            if(useMock == 'true'){
                return getMock()
            }

            const res = await axios.get(`${baseUrl}/step/recipe`, {
                params: {
                    recipeId: recipeId
                }
              });

            const result = await res.data
            return result
        } catch (err) {
            console.error(err)
        }
    }

    return {
        getStepsByRecipeId
    }
}