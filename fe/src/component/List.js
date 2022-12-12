import React, { useEffect, useState } from 'react'
import { Link } from 'react-router-dom'
import CloudyService from '../../Service/CloudyService'

const List = () => {
    const [customers, setCustomers] = useState([])
    useEffect(() =>{
        CloudyService.getCustomer().then((response) => {
            setCustomers(response.data)
            console.log(response.data)
        }).catch(error =>{
            console.log(error);
        })
    }, [])

  return (
    <div className="container">
        <h2 className="text-center">List customer</h2>
        <Link to= "/login" className="btn btn-primary mb-2"> Login</Link>

        <table className="table table-bordered table-striped">
            <thead>
                <th>  ID</th>
                <th> Name</th>
                <th> Gender</th>
                <th> Email</th>
                <th> Password</th>
                <th> Phone Number</th>
                <th> Address</th>
                <th> Role</th>
            </thead>
            <tbody>
                {
                    customers.map(
                        customer =>
                        <tr key={customer.id}>
                            <td>{customer.id}</td>
                            <td>{customer.fullName}</td>
                            <td>{customer.gender}</td>
                            <td>{customer.email}</td>
                            <td>{customer.password}</td>
                            <td>{customer.phoneNumber}</td>
                            <td>{customer.address}</td>
                            <td>{customer.role}</td> 

                        </tr>
                    )
                }
            </tbody>
        </table>

    </div>
  )
}

export default List