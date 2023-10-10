import axios from "axios"

export const draftPresenter = () => {

    const baseUrl = import.meta.env.VITE_REACT_REST_NET_URL

    const addDrafts = async (drafts, userId) => {
        try {
            const body = drafts.map(draft => ({
                ...draft,
                userId: userId.toString()
            }));
            console.log("🚀 ~ file: DraftPresenter.js:15 ~ body ~ body:", body)
    
            const res = await axios.post(`${baseUrl}/draft/many`, body);
    
            console.log("🚀 ~ file: DraftPresenter.js:14 ~ addDrafts ~ res:", res);
            const result = res.status === 200 ? await res.data : null;
            return result;
        } catch (err) {
            console.log('err => ', err);
        }
    }

    const getById = async (id) => {
        try {
            const res = await axios.get(`${baseUrl}/draft/${id}`);

            const result = await res.data

            return result
        } catch (err) {
            console.error(err)
        }
    }

    const getByUserId = async (id) => {
        try {
            const res = await axios.get(`${baseUrl}/draft/user/${id}`);

            const result = await res.data

            return result
        } catch (err) {
            console.error(err)
        }
    }

    return {
        addDrafts,
        getById,
        getByUserId
    }
}