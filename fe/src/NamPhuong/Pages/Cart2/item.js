import { useState } from 'react';
import { instance } from '../../axios';


//Author: Nam Phương

export function ItemInCart({id, img, name, unitPrice,quantity, setListCart, total, setTotal}){
    const [quantityItem, setQuantityItem] = useState(quantity);
    const [totalPriceItem, setTotalPriceItem] = useState(quantity*unitPrice);
     
    //Increase quantiy
    function increaseQuantity(){ //dùng async để đợi API trả về xong rồi -> mới set State (tránh lỗi)
        instance
        .post("/cart/increase-quantity-of-item-in-cart", {id: id}) //id (left) chính là: req.body.id
                                                                    //id(right) chính là: value truyền vào
        .then((ketqua) => {
            setQuantityItem(quantityItem + 1);
            setTotalPriceItem(totalPriceItem + unitPrice);
            //setTotal(totalPriceItem + unitPrice)
        })
        .catch((loi) => {
            alert("Không tăng được số lượng item này trong Cart!!!")
        })
    }

    //Decrease quantity
    function decreaseQuantity(){
      instance
      .post("/cart/decrease-quantity-of-item-in-cart", {id: id})
      .then((ketqua) => {
        setQuantityItem(quantityItem - 1);
        setTotalPriceItem(totalPriceItem - unitPrice);
      })
      .catch((loi) => {
          alert("Không giảm được số lượng item này trong Cart!!!")
      })
    }

    //Delete item
    function deleteItem(){
      instance
      .post("/cart/delete-item-in-cart",{id:id})
      .then((ketqua) => {
        setListCart(listCart => listCart.filter(item => item.id != id));//lọc lại listCart
        alert("Delete successfully!")
      })
      .catch((loi) => {
        alert("Deleting item is failed!")
    })
    }


    return (
      <div className="cart_products">
        <ul>
          <li className=" cart_product d-flex flex-md-row flex-column align-items-md-center align-items-start justify-content-start">
            
            {/* Product Image */}
            <div className="cart_product_image">
              <img
                src="https://res.cloudinary.com/phancauphuoc/image/upload/v1659428583/web_2107/img-web-last2/cart_product_1_nx9qnf.jpg"
                alt=""
              />
            </div>

            {/* Product Name */}
            <div className="cart_product_name">
              <a href="product.html">{name}</a>
            </div>
            <div className="cart_product_info ml-auto">
              <div className="cart_product_info_inner d-flex flex-row align-items-center justify-content-md-end justify-content-start">
                {/* Product Price */}
                <div className="cart_product_price">{unitPrice} VNĐ</div>

                {/* Product Quantity */}
                <div className="product_quantity_container">
                  <div className="product_quantity clearfix">
                    <input
                      id="quantity_input"
                      type="text"
                      pattern="[0-9]*"
                      defaultValue={quantityItem}
                      value = {quantityItem}

                    />

                    <div className="quantity_buttons">
                      {/* increase quantity */}
                      <div
                        id="quantity_inc_button"
                        className="quantity_inc quantity_control"
                        onClick={increaseQuantity}
                      >
                        {/* icon mũi tên đưa lên ^ */}
                        <i className="fa fa-caret-up" aria-hidden="true" />
                      </div>
                      {/*--------------------------*/}
                      {/* decrease quantity */}
                      <div
                        id="quantity_dec_button"
                        className="quantity_dec quantity_control"
                        onClick={decreaseQuantity}
                      >
                        <i className="fa fa-caret-down" aria-hidden="true" />
                      </div>
                    </div>
                  </div>
                </div>

                {/* Products Total Price */}
                <div className="cart_product_total">{totalPriceItem}</div>

                {/* Product Cart Trash Button */}
                <div className="cart_product_button">
                  <button className="cart_product_remove"
                    onClick={deleteItem}
                  >
                    <img
                      src="https://res.cloudinary.com/phancauphuoc/image/upload/v1659428590/web_2107/img-web-last2/trash_vdsiwk.png"
                      alt=""
                    />
                  </button>
                </div>
              </div>
            </div>
          </li>
        </ul>
      </div>
    );
}