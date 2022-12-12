import React, { useEffect, useState } from 'react'
import { useParams } from 'react-router-dom';
import InfoCustomerService from '../services/InfoCustomerService';
import { Link } from 'react-router-dom';

function InfoUser() {


    const [customer, setCustomer] = useState([]);
    const { id } = useParams();

    useEffect(() => {
        InfoCustomerService.getCustomer(id).then((response) => {
            setCustomer(response.data);
            console.log(response.data);
        }).catch(error => {
            console.log(error);
        })

    }, [])


    return (
        <div>
            {
                <div className="infomation" key={customer.id}>
                    <div className="info1">
                        <h3>Infomation</h3>
                    </div>
                    <div className="info2">
                        <div className="info-img">
                            <img src="https://res.cloudinary.com/phancauphuoc/image/upload/v1659428588/web_2107/img-web-last2/product_image_1_drjves.jpg" alt="image-customer" />
                        </div>
                        <div className="info-context" >
                            <h4 >{customer.fullName}</h4>
                            <p>{customer.address}</p>
                            <span>{customer.phoneNumber}</span>
                        </div>
                    </div>
                    <div className="info3">
                        <div className="info3-1">
                            <img src="https://res.cloudinary.com/phancauphuoc/image/upload/v1659933996/web_2107/img-web-last2/imgs/user-128_sjjrhz.png" alt="img-user" />
                        </div>
                        <div className="info3-2">
                            <Link to={`/update_info_user/${id}`}>Thay đổi thông tin</Link>
                        </div>
                    </div>
                    <div className="info4">
                        <div className="info4-1">
                            <img src="https://res.cloudinary.com/phancauphuoc/image/upload/v1659933887/web_2107/img-web-last2/69986_j6eqa8.png" alt="img-user" />
                        </div>
                        <div className="info4-2">
                            <a href="#">Quản lý đơn hàng</a>
                        </div>
                    </div>
                </div>
            }
        </div >
    )
}

export default InfoUser 
