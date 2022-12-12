import { checkLogin, getCookie } from "../../utils"
import { useNavigate } from "react-router-dom";

//Author: Nam Phương
export function Checkout(){

  const navigate = useNavigate();

  //Để xử lý khi người dùng truy cập trực tiếp url: http://localhost:3000/cart hay bằng icon đi chăng (khi chưa  login)
  //=> Nhảy vào trang login
  if(checkLogin("login_username") === 0){
    navigate("/login");
  }
    // console.log(getCookie("login_username"));
    // console.log(checkLogin("login_username"));
    
    return(
        <div>
            Check out Page
        </div>
    )
}