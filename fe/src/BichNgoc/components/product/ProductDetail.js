import React, { Component } from "react";
import NikeShoe from "../../images/nikeshoe.jpg";
import BlueShoe from "../../images/blueshoe.jpg";
import TestShoe from "../../images/testshoe.jpg";

import DetailsThumb from "../DetailsThumb";
import "./ProductDetail.css";
import ProductDetailService from "../../services/ProductDetailService";
import Rating from "./Rating";

/**
 * Author: Bich Ngoc
 */


export class ProductDetail extends Component {
  constructor(props) {
    super(props);
    this.state = {
      products: [],
      index: 0,
      img: [NikeShoe, BlueShoe, TestShoe]
    };
  }

  myRef = React.createRef();

  handleTab = (index) => {
    this.setState({ index: index });
    const images = this.myRef.current.children;
    for (let i = 0; i < images.length; i++) {
      images[i].className = images[i].className.replace("active", "");
    }
    images[index].className = "active";
  };

  componentDidMount() {
    const { index } = this.state;
    this.myRef.current.children[index].className = "active";
    ProductDetailService.getOneProduct().then((res) => {
      this.setState({ products: res.data });
    });
  }

  render() {
    const { products,img} = this.state;
   
    return (
      <div className="product-box">
        <h1>Product Detail</h1>

        <div className="details">
          <div className="big-img">
            <img src={NikeShoe} alt="" />
          </div>

          <div className="box">
            <div className="row">
              <h2>{products.productName}</h2>
              <span>${products.unitPrice}</span>
            </div>
            
            <h3>Description</h3>
            <p>{products.description}</p>
            <p>{products.promotion}</p>
            
            <Rating/>
            
            <DetailsThumb
              images={img}
              tab={this.handleTab}
              myRef={this.myRef}
            />
            <button className="cart">Add to cart</button>
          </div>
        </div>
      </div>
    );
  }
}

export default ProductDetail;
