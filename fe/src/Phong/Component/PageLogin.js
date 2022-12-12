import React, { useState } from 'react'
import { Link, useNavigate  } from 'react-router-dom';


const PageLogin = () => {
    const [fullName, setFullName] = useState('');
    const [password, setPass] = useState('');
    const navigate = useNavigate();
   
    const [jwt, setJwt] = useState('')

    function loginRequest (){
        const reqBody = {
            fullName : "aaa",
            password : "cloud",
        }
        // com.store.controllerAPI.CustomerControllerAPI
        // check URL	localhost:8080/cloud/api/v1/login ??
        // check URL	localhost:3000/api/v1/login ??
//        fetch("/api/v1/login",{
	
        // com.store.np.springsecurityjwt.restcontroller.NapuRestController
        fetch("http://localhost:8080/cloud/login",{
            headers:{
                "Content-Type" : "application/json",
            },
            method: "post",
            body : JSON.stringify(reqBody),
        })
        .then((resposnse) => Promise.all([resposnse.json(),resposnse.headers]))
        .then(([body,headers]) =>{
            setJwt(headers.get("authorization"));
            return navigate("/");
        })
    };


  return (
    <div>
        <br></br>
        <div className="container">
            <div className="row">
                <div className="card col-md-6 offset-md-3 offset-md-3 ">
                    <h2 className="text-center">Login</h2>
                    <div className="card-body">
                        <form>
                           <div className="form-group mb-2" >
                                <label className="form-label">Name</label>
                                <input
                                    type="text"
                                    placeholder="Enter your name"
                                    name = "fullName"
                                    className = "form-control"
                                    value = {fullName}
                                    onChange ={(e) => setFullName(e.target.value)}
                                    required
                                >

                                </input>
                                
                           </div>
                           <div className="form-group mb-2" >
                                <label className="form-label">Password</label>
                                <input
                                    type="password"
                                    placeholder="Enter your password"
                                    name = "password"
                                    className = "form-control"
                                    value = {password}
                                    onChange ={(e) => setPass(e.target.value)}
                                    required
                                >

                                </input>
                                
                           </div> 
                           <button className="btn btn-success" onClick={() => loginRequest()}> Submit</button>
                           
                           <Link to="/" className="btn btn-danger">Cancel</Link><br></br>
                           <p> Do not have a account ? <Link to ="/register" >Sign up</Link></p>
                           

                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
  )
};
export default PageLogin
