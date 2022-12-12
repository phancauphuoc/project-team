import { instance } from "../../axios";
import { useState, useEffect } from "react";
import { ItemInCart } from "./item";
import { useNavigate} from "react-router-dom";
import { checkLogin, getCookie } from "../../utils";

//Author:Nam Phương
export function Cart2() {

  const [listCart, setListCart] = useState([]);
  const [total, setTotal] = useState(0);

  //Để xử lý khi người dùng truy cập trực tiếp url: http://localhost:3000/cart hay bằng icon đi chăng (khi chưa  login)
  //=> Nhảy vào trang login
  const navigate = useNavigate();
  
  if(checkLogin("login_username") === 0){
    navigate("/login");
  }

  const navigateCheckout = () => {
    navigate("/checkout");
  }

  const navigateHomepage = () => {
    navigate("/");
  }

  useEffect(() => {
    instance // call API phải để trong 1 cài hàm hoặc useEffect
      .post("/cart/view-cart2", {
        username: getCookie("login_username"),
        password: "123456",
      })
      .then((ketqua) => {
        setListCart(ketqua.data);
      })
      .catch((loi) => {
        alert("Lỗi rồi!Không thể view shopping cart.");
      });
  }, []);

  return (
    <div>
      {/* Cart */}
      <div className="cart_container">
        <div className="container">
          <div className="row">
            <div className="col">
              <div className="cart_title">your shopping cart</div>
            </div>
          </div>

          {/* Title */}
          <div className="row">
            <div className="col">
              <div className="cart_bar d-flex flex-row align-items-center justify-content-start">
                <div className="cart_bar_title_name">Product Name</div>
                <div className="cart_bar_title_content ml-auto">
                  <div className="cart_bar_title_content_inner d-flex flex-row align-items-center justify-content-end">
                    <div className="cart_bar_title_price">Price</div>
                    <div className="cart_bar_title_quantity">Quantity</div>
                    <div className="cart_bar_title_total">Total</div>
                    <div className="cart_bar_title_button" />
                  </div>
                </div>
              </div>
            </div>
          </div>

          {/*List Cart----------------------------------------------------------*/}
          {//Code Javascript để render array  
          listCart.map((item) => { 
            return (
              <div>
                <div className="row">
                  <div className="col">
                    <ItemInCart
                        id = {item.id}
                        img = {item.product_img}
                        name = {item.product_name}
                        unitPrice = {item.unit_price}
                        quantity = {item.quantity}
                        setListCart={setListCart}
                        total = {total}
                        setTotal={setTotal}
                    />
                  </div>
                </div>
              </div>
            );
          })}

          <div className="row">
            <div className="col">
              <div className="cart_control_bar d-flex flex-md-row flex-column align-items-start justify-content-start">
                <button className="button_update cart_button_2 ml-md-auto"
                 onClick={navigateHomepage}>
                  continue shopping
                </button>
              </div>
            </div>
          </div>
          <div className="row cart_extra">
            
            {/* Cart Total */}
            <div className="col-lg-5 offset-lg-1">
              <div className="cart_total">
                <div className="cart_title">total: {total}</div>
                <button className="cart_total_button"
                 onClick={navigateCheckout}
                >
                  proceed to checkout
                </button>
              </div>
            </div>
          </div>
        </div>
      </div>

    </div>
  );
}
