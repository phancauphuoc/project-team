import axios from 'axios';


const PRODUCT_DETAIL_API_BASE_URL = "http://localhost:8080/cloud/api/v1/get-product-detail";

class ProductDetailService {
    getOneProduct() {
        return axios.get(PRODUCT_DETAIL_API_BASE_URL);
    }

}

export default new ProductDetailService()