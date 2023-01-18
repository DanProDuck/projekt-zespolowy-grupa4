import axios from "axios";


export const useFetchProduct = async (id) => {
    //relative path when baseURL or proxy is configured
    const resp = await axios.get(`/api/products/${id}`)
    if (resp.status >= 200 && resp.status < 400) {
        return resp.data
    }
}