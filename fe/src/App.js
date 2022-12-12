import "./App.css";
import React from "react";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import Register from "./Phong/Component/Register";
import Header from './Phuoc/component/Header';
import Footer from './Phuoc/component/Footer';
import Conntent from './Phuoc/component/Conntent';

import { Cart2 } from "./NamPhuong/Pages/Cart2";
import { Login } from "./NamPhuong/Pages/Login";
import { Checkout } from "./NamPhuong/Pages/Checkout";
import ProductDetail from "./NamPhuong/Pages/ProductDetail";

import Default from "./BichNgoc/components/error/Default";
import Category from "./BichNgoc/components/productByCategory/Category";
/*
import ProductDetail from "./BichNgoc/components/productdetail";
import { Switch } from "@mui/material";
*/


import InfoUser from "./Phuoc/component/InfoUser";
import UpdateInfoUser from "./Phuoc/component/UpdateInfoUser";



function App() {
  return (

    <div>
      <div className="super_container">
        <BrowserRouter>
        <Header /> 
          <Routes>
          

			 {/* Author: Phước*/}
            <Route path="/" exact={true} element={<Conntent />} />            
            <Route path="/info_user/:id" element={<InfoUser/>}/>
            <Route path="/update_info_user/:id" element={<UpdateInfoUser/>}/>
            
            {/* Author: Phong*/}
            <Route path="/register" element={<Register />}></Route>
            
            {/* Author: Nam Phương */}
            <Route path="/cart" element={<Cart2/>} />
            <Route path="/login" element={<Login/>} />
            <Route path="/checkout" element={<Checkout/>} />\
            <Route path="/product_detail" element={<ProductDetail/>}/>
                 
            {/* Author: Ngọc*/}
            <Route path="/category/:id" element={<Category />}></Route>
          	<Route component={Default}></Route>
          
          </Routes>
          
          <Footer />
        </BrowserRouter>
      </div>
    </div>
  );
}

export default App;