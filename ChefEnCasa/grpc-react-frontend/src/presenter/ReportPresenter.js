import axios from "axios"

export const reportPresenter = () => {

    const baseUrl = import.meta.env.VITE_REACT_REST_NET_URL

    const addReport = async (report) => {
        try {
            const res = await axios.post(`${baseUrl}/report`, report);

            const result = res.status === 200 ? await res.data : null;
            return result;
        } catch (err) {
            console.log('err => ', err);
        }
    }

    const updateStatus = async (reportId, resolved) => {
        try {    
            const res = await axios.patch(`${baseUrl}/report?resolved=${resolved}?id=${reportId}`);

            const result = res.status == "200" ? await res.data : null
            return result;
        } catch (err) {
            console.log('err => ' , err)
        }
    }

    const updateReport = async (report) => {
        try {    
            const res = await axios.put(`${baseUrl}/report?id=${report.reportId}`, report);

            const result = res.status == "200" ? await res.data : null
            return result;
        } catch (err) {
            console.log('err => ' , err)
        }
    }


    const getAll = async () => {
        try {
            const res = await axios.get(`${baseUrl}/report`);

            const result = await res.data

            return result
        } catch (err) {
            console.error(err)
        }
    }

    return {
        addReport,
        updateStatus,
        getAll,
        updateReport
    }
}