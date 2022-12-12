import axios from 'axios';

const EMPLOYEE_API_BASE_URL = "http://localhost:8080/cloud/api/v1/get-all-customer";
const EMPLOYEE_API_BASE_URL1 = "http://localhost:8080/cloud/api/v1/save-customer";
// class CloudService{
//     getProducts(){
//         return axios.get(EMPLOYEE_API_BASE_URL);
//     }
// }

class CloudyService{
    
    getCustomer(){
        return axios.get(EMPLOYEE_API_BASE_URL);
    }

    registerCustomer(customer){
        return axios.post(EMPLOYEE_API_BASE_URL1, customer)
    }



}
// export default new CloudService();
export default new CloudyService();