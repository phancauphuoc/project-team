
import React, { useState, useEffect } from 'react'
import { useNavigate } from "react-router-dom";
import { Link, useParams } from 'react-router-dom';
import InfoCustomerService from '../services/InfoCustomerService';

const UpdateInfoUser = () => {
    const [fullName, setFullName] = useState('');
    const [userName, setUserName] = useState('');
    const [gender, setGender] = useState('');
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const [phoneNumber, setPhoneNumber] = useState('');
    const [address, setAddress] = useState('');
    const navigate = useNavigate();
    const { id } = useParams();

    const updateCus = (e) => {
        e.preventDefault();

        const customer = { fullName, userName, gender, email, password, phoneNumber, address }

        InfoCustomerService.updateCustomer(id, customer).then((response) => {
            console.log(response.data)
            navigate(`/info_user/${id}`)

        }).catch(error => {
            console.log(error)
        })


    }

    useEffect(() => {
        InfoCustomerService.getCustomer(id).then((response) => {
            setFullName(response.data.fullName)
            setUserName(response.data.userName)
            setGender(response.data.gender)
            setEmail(response.data.email)
            setPassword(response.data.password)
            setPhoneNumber(response.data.phoneNumber)
            setAddress(response.data.address)
        }).catch(error => {
            console.log(error)
        })

    }, [])

    return (
        <div>
            <div className='container phuoc1'>
                <div className='row'>
                    <div className='card col-md-5 offset-md-3 offset-md-3'>
                        <h2 className='text-center'>Cập nhật thông tin</h2>
                        <div className='card-body'>
                            <form>

                                <div className='form-goup mb-2'>
                                    <label className='form-lable'>Họ tên:</label>
                                    <input
                                        placeholder='Nhập họ tên'
                                        name='fullName'
                                        className='form-control'
                                        value={fullName}
                                        onChange={(e) => setFullName(e.target.value)} >
                                    </input>
                                </div>

                                {/* <div className="form-group mb-2 phong1" hidden>
                                <label className="form-label">Gender</label>
                 
                                <div>
                                    <select
                                    id="gender"
                                    name="gender"
                                    className="phong2"
                                    onChange={(e) => setGender(e.target.value)}
                                    >
                                    <option value={gender} hidden></option>
                                    <option value="male">Male</option>
                                    <option value="female">Female</option>
                                    </select>
                                </div>
                             </div> */}

                                <div className='form-goup mb-2'>
                                    <label className='form-lable'>Email:</label>
                                    <input type="text"
                                        placeholder='Nhập email'
                                        name='email'
                                        className='form-control'
                                        value={email}
                                        onChange={(e) => setEmail(e.target.value)} >
                                    </input>
                                </div>

                                <div className='form-goup mb-2'>
                                    <label className='form-lable'>Mật khẩu:</label>

                                    <input type="text"
                                        placeholder='Nhập mật khẩu'
                                        name='password'
                                        className='form-control'
                                        value={password}
                                        onChange={(e) => setPassword(e.target.value)}>
                                    </input>
                                </div>
                                <div className='form-goup mb-2'>
                                    <label className='form-lable'>Số điện thoại:</label>

                                    <input type="text"
                                        placeholder='Nhập số điện thoại'
                                        name='phoneNumber'
                                        className='form-control'
                                        value={phoneNumber}
                                        onChange={(e) => setPhoneNumber(e.target.value)}>
                                    </input>
                                </div>
                                <div className='form-goup mb-2'>
                                    <label className='form-lable'>Địa chỉ:</label>

                                    <input type="text"
                                        placeholder='Nhập địa chỉ'
                                        name='address'
                                        className='form-control'
                                        value={address}
                                        onChange={(e) => setAddress(e.target.value)}>
                                    </input>
                                </div>

                                <button className='btn btn-success' onClick={(e) => updateCus(e)}>Cập nhật</button>
                                <Link to={`info_user/${id}`} className='btn btn-danger'>Hủy</Link>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>


            )
}

            export default UpdateInfoUser