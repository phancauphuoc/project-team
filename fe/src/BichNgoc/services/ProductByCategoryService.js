import axios from 'axios';


const PRODUCT_CATEGORY_AO_API_URL = "http://localhost:8080/cloud/api/v1/get-product-category";

class ProductByCategoryService {
    listProductAo(categoryID) {
        return axios.get(PRODUCT_CATEGORY_AO_API_URL+"/"+categoryID);
    }

}

export default new ProductByCategoryService()                                                                                      