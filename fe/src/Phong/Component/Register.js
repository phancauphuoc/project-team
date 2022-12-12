import React, { useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import CloudyService from "../Service/CloudyService";

const Register = () => {
  const [fullName, setFullName] = useState("");
  const [gender, setGender] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPass] = useState("");
  const [phoneNumber, setPhoneNumber] = useState("");
  const [address, setAddress] = useState("");

  const navigate = useNavigate();
  // const [value, setValue] = useComboboxControls({initialValue: 'male', initialValue : 'female'});

  const addCus = (e) => {
    e.preventDefault();
    const customer = {
      fullName,
      gender,
      email,
      password,
      phoneNumber,
      address,
    };
    console.log(JSON.stringify(customer));
    CloudyService.registerCustomer(customer)
      .then((response) => {
        console.log(response.data);
        navigate("/");
      })
      .catch((error) => {
        console.log(error);
      });
  };

  return (
    <div>
      <br></br>

      <div className="container phong3">
        <div className="row">
          <div className="card col-md-6 offset-md-3 offset-md-3 ">
            <h2 className="text-center" id="reg">
              Register
            </h2>
            <div className="card-body">
              <form>
                <div className="form-group mb-2">
                  <label className="form-label">Name</label>
                  <input
                    type="text"
                    placeholder="Enter your name"
                    name="fullName"
                    className="form-control"
                    value={fullName}
                    onChange={(e) => setFullName(e.target.value)}
                    required
                  ></input>
                </div>

                <div className="form-group mb-2">
                  <label className="form-label">Email</label>
                  <input
                    type="text"
                    placeholder="Enter your email"
                    name="email"
                    className="form-control"
                    value={email}
                    onChange={(e) => setEmail(e.target.value)}
                    required
                  ></input>
                </div>
                <div className="form-group mb-2">
                  <label className="form-label">Password</label>
                  <input
                    type="password"
                    placeholder="Enter your password"
                    name="password"
                    className="form-control"
                    value={password}
                    onChange={(e) => setPass(e.target.value)}
                    required
                  ></input>
                </div>
                <div className="form-group mb-2">
                  <label className="form-label">Phone Number</label>
                  <input
                    type="text"
                    placeholder="Enter your phone number"
                    name="phoneNumber"
                    className="form-control"
                    value={phoneNumber}
                    onChange={(e) => setPhoneNumber(e.target.value)}
                    required
                  ></input>
                </div>
                <div className="form-group mb-2">
                  <label className="form-label">Address</label>
                  <input
                    type="text"
                    placeholder="Enter your address"
                    name="Address"
                    className="form-control"
                    value={address}
                    onChange={(e) => setAddress(e.target.value)}
                    required
                  ></input>
                </div>
                <div className="form-group mb-2 phong1">
                  <label className="form-label">Gender</label>
                  {/* <input
                                        type="text"
                                        placeholder="Choose your gender"
                                        name="gender"
                                        className="form-control"
                                        value={gender}
                                        onChange={(e) => setGender(e.target.value)}
                                        required
                                    >
                                    </input> */}

                  {/* <DatalistInput 
                                        placeholder="Choose your gender"
                                        value={value}
                                        setValue={setValue}
                                        iteams = {[...]}
                                        onChange={(iteam) =>{
                                            setValue('');
                                        }}
                                        

                                    /> */}
                  <div>
                    <select
                      id="gender"
                      name="gender"
                      className="phong2"
                      onChange={(e) => setGender(e.target.value)}
                    >
                      <option value={gender}></option>
                      <option value="male">Male</option>
                      <option value="female">Female</option>
                    </select>
                  </div>
                </div>

                <br></br>

                <button className="btn btn-success" onClick={(e) => addCus(e)}>
                  {" "}
                  Submit
                </button>
                <br></br>
                <br></br>
                <p>
                  Already have a account? <Link to={"/login"}>Sign in</Link>
                </p>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default Register;
