import axios from 'axios';

const INFO_CUSTOMER_BASE_REST_API_URL = "http://localhost:8080/cloud/api/v1/get-one-customer-by";
const INFO_CUSTOMER_BASE_REST_API_URL1 = "http://localhost:8080/cloud/api/v1/update-customer";

class InfoCustomerService{
    getCustomer(customerId){
        return axios.get(INFO_CUSTOMER_BASE_REST_API_URL+'/'+customerId);
    }
    updateCustomer(customerId,customer){
        return axios.put(INFO_CUSTOMER_BASE_REST_API_URL1 +'/'+customerId , customer);
    }
}



export default new InfoCustomerService();