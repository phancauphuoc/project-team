import axios from 'axios';
const PRODUCT_HOME_BASE_REST_API_URL = "http://localhost:8080/cloud/api/v1/get-ten-product";

const PRODUCT_HOME_BY_CATEGORY_REST_API_URL = "http://localhost:8080/cloud/api/v1/get-ten-product-category4";

class ProductHomeService {
    getAllProduct(){
        return axios.get(PRODUCT_HOME_BASE_REST_API_URL);
    }

    getProductByCategory(){
        return axios.get(PRODUCT_HOME_BY_CATEGORY_REST_API_URL);
    }
}
export default new ProductHomeService();