import { instance } from '../../axios';
import './index.css'
import { useState } from "react";
import { useNavigate } from "react-router-dom";
import { setCookie } from '../../utils';

//Author: Nam Phương

export function Login() {
    // const [id, setId] = useState(0);
    const [username, setUsername] = useState(""); //Thêm state username
    const [password, setPassword] = useState(""); //Thêm state password
    let navigate = useNavigate(); // chuyển hướng trang

    const onChangeUsername = (e) => {
        setUsername(e.target.value);
        //console.log(e.target.value);
    };

    const onChangePassword = (e) => {
        setPassword(e.target.value);
        //console.log(e.target.value);
    };

    const handleSignIn = (e) => {
        e.preventDefault(); //Chặn reload page

         //Từ frontend: Mình sẽ gửi về server(backend) 2 thông tin là username và password
        instance
          .post("/common/login", {
            username: username, //username bên trái : request.body.username, bên phải là value mình truyển vô
            password: password, //password bên trái : request.body.password, bên phải là value mình truyển vô
          })
        .then((result) => { //call API thành công (Đăng nhập thành công)      
            //Tạo ra Cookie                   
            setCookie("login_username", result.data.username, 5);
            setCookie("login_customerId", result.data.id, 5);
            
            //navigate sang trang Home
            navigate("/");                                                             
        })
        .catch((error) => { //call API thất bại (Đăng nhập thất bại)
            alert("Invalid username or password!");
        });   
    }


    return (
        <div className="bodyLogin">
        <div className="login-wrap">
            <div className="login-html">
            <input
                id="tab-1"
                type="radio"
                name="tab"
                className="sign-in"
                defaultChecked
            />
            <label htmlFor="tab-1" className="tab">
                Sign In
            </label>
            <input id="tab-2" type="radio" name="tab" className="sign-up" />
            <label htmlFor="tab-2" className="tab">
                Sign Up
            </label>
            <div className="login-form">
                {/*SIGN IN */}
                <div className="sign-in-htm">

                {/*Username (của Sign In) */}
                <div className="group">
                    <label htmlFor="user" className="label">
                    Username
                    </label>
                    <input 
                        id="user" 
                        type="text" 
                        required 
                        className="input" 
                        onChange={onChangeUsername}
                        />
                </div>
                {/*---------------------------------------*/}
                {/*Password (của Sign In) */}
                <div className="group">
                    <label htmlFor="pass" className="label">
                    Password
                    </label>
                    <input
                    id="pass"
                    type="password"
                    required
                    className="input"
                    data-type="password"
                    onChange={onChangePassword}
                    />
                </div>
                {/*---------------------------------------*/}
                <div className="group">
                    <input
                    id="check"
                    type="checkbox"
                    className="check"
                    defaultChecked
                    />
                    <label htmlFor="check">
                    <span className="icon" /> Keep me Signed in
                    </label>
                </div>
                {/*---------------------------------------*/}
                {/*Button Sign In */}
                <div className="group">
                    <input
                    type="submit"
                    className="button"
                    defaultValue="Sign In"
                    value="Sign In"
                    onClick={handleSignIn}
                    />
                </div>
                {/*---------------------------------------*/}
                {/*Đường nằm ngang (của Sign In) */}
                <div className="hr" />
                {/*---------------------------------------*/}
                {/*Forgot password (của Sign In)*/}
                <div className="foot-lnk">
                    <a href="#forgot">Forgot Password?</a>
                </div>
                </div>
                {/*____________________________________________________________*/}
                {/*SIGN UP */}
                <div className="sign-up-htm">
                <div className="group">
                    <label htmlFor="user" className="label">
                    Username
                    </label>
                    <input id="user" type="text" className="input" />
                </div>
                <div className="group">
                    <label htmlFor="pass" className="label">
                    Password
                    </label>
                    <input
                    id="pass"
                    type="password"
                    className="input"
                    data-type="password"
                    />
                </div>
                <div className="group">
                    <label htmlFor="pass" className="label">
                    Repeat Password
                    </label>
                    <input
                    id="pass"
                    type="password"
                    className="input"
                    data-type="password"
                    />
                </div>

                <div className="group">
                    <label htmlFor="pass" className="label">
                    Email Address
                    </label>
                    <input id="pass" type="text" className="input" />
                </div>

                <div className="group">
                    <input
                    type="submit"
                    className="button"
                    defaultValue="Sign Up"
                    value="Sign Up"
                    />
                </div>

                <div className="hr" />
                <div className="foot-lnk">
                    <label htmlFor="tab-1">Already Member?</label>
                </div>
                </div>
            </div>
            </div>
        </div>
        </div>
    );
}
