import axios from "axios"

export const commentPresenter = () => {

    const baseUrl = import.meta.env.VITE_REACT_BACKEND_URL

    const getComments = async (idRecipe, pageSize, pageNumber) => {
        try {
            const res = await axios.get(`${baseUrl}/comments/recipe`, {
                params: {
                  idRecipe: idRecipe,
                  pageNumber: pageNumber != null ? pageNumber : 1,
                  pageSize: pageSize != null ? pageSize : 3,
                }
              });

            let result = await res.data

            return result
        } catch (err) {
            console.error(err)
        }
    }

    return {
        getComments
    }
}