import axios from "axios"

export const bookPresenter = () => {

    const baseUrl = import.meta.env.VITE_REACT_NODE_KAFKA_URL

    const addBook = async (book) => {
        try {
            const body =
            {
                "name": book.Name,
                "idUser": book.IdUser
            }
            console.log("🚀 ~ file: BookPresenter.js:10 ~ addBook ~ body:", body)

            const res = await axios.post(`${baseUrl}/soap/books`, body);

            console.log("🚀 ~ file: BookPresenter.js:17 ~ addBook ~ res:", res)
            const result = res.status === 200 ? await res.data : null;
            return result;
        } catch (err) {
            console.log('err => ', err);
        }
    }

    const addRecipe = async (idRecipe, idBook) => {
        try {
            const body =
            {
                "idRecipe": idRecipe,
                "idBook": idBook
            }

            const res = await axios.post(`${baseUrl}/soap/books/recipe`, body);

            const result = res.status === 200 ? await res.data : null;
            return result;
        } catch (err) {
            console.log('err => ', err);
        }
    }

    const getBooksByUserId = async (id, withRecipes) => {
        try {
            const res = await axios.get(`${baseUrl}/soap/books/user?id=${id}&withRecipes=${withRecipes}`);
            
            const result = await res.data;
            return result.GetBooksByUserIdResult.Book
        } catch (err) {
            console.error(err)
        }
    }

    const deleteBook = async (id) => {
        console.log("🚀 ~ file: BookPresenter.js:55 ~ deleteBook ~ id:", id)
        try {
            const res = await axios.delete(`${baseUrl}/soap/books?id=${id}`);
            
            const result = await res.data;
            return result
        } catch (err) {
            console.error(err)
        }
    }

    return {
        getBooksByUserId,
        addBook,
        addRecipe,
        deleteBook
    }
}