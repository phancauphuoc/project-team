import axios from "axios";

const CATEGORY_HOME_API_BASE_URL = "http://localhost:8080/cloud/api/v1/get-all-category";

class CategoryHomeService{
    getAllCategory(){
        return axios.get(CATEGORY_HOME_API_BASE_URL);
    }
}
export default new  CategoryHomeService();
