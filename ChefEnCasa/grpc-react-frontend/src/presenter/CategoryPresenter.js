import axios from "axios"
import {categoryPresenterMock} from './Mocks/CategoryMock'

export const categoryPresenter = () => {

    const useMock = import.meta.env.VITE_REACT_BACKEND_MOCK
    const baseUrl = import.meta.env.VITE_REACT_BACKEND_URL

    const {getMock} = categoryPresenterMock()

    const getCategories = async () => {
        try {

            if(useMock == 'true'){
                return getMock()
            }

            const res = await axios.get(`${baseUrl}/categories`);
            
            const result = await res.data;
            return result
        } catch (err) {
            console.error(err)
        }
    }

    const getCategoryById = async (id) => {
        try {

            if(useMock == 'true'){
                return getMock()
            }

            const res = await axios.get(`${baseUrl}/categories/category`, {
                params: {
                  idCategory: id
                }
              });

            const result = await res.data

            return result.category
        } catch (err) {
            console.error(err)
        }
    }

    return {
        getCategories,
        getCategoryById,
    }
}