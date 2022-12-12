//import React from 'react'
import { Link } from 'react-router-dom'
import CategoryHomeService from '../services/CategoryHomeService';
import React, { useEffect, useState } from 'react'
import { useNavigate } from 'react-router-dom';

//Author: Phước + Nam Phương

const Header = () => {
    const [category, setCategory] = useState([]);

    //Author: Nam Phuong
    let navigate = useNavigate();

    const navigateCart = () => {
        navigate("/cart")
    }
    //-----------------------------------------------------------
    //Author: Phước
    useEffect(() => {
        getAllCategory();
    }, [])

    const getAllCategory = () => {
        CategoryHomeService.getAllCategory().then((response) => {
            setCategory(response.data);
        })
    }

    return (
        <div>
            {/* Header */}
            <header className="header">
                <div className="header_inner d-flex flex-row align-items-center justify-content-start">
                    <div className="logo"><a href="/">Wish</a></div>
                    <nav className="main_nav">
                        <ul>
                            <li><a href="/">Trang Chủ</a></li>
                            <li><a href="/category/1">Áo</a></li>
                            <li><a href="/category/2">Quần</a></li>
                            <li><a href="/category/3">Giày</a></li>
                            <li><a href="/category/4">Phụ Kiện</a></li>

                            {/* {
                                category.map(
                                    category => 
                                         <li><a href={`/category/${category.id}`} key={category.id}>{category.category_name}</a></li>

                                )
                            } */}
                        </ul>
                    </nav>
                    <div className="header_content ml-auto">
                        <div className="search header_search">
                            <form action="#">
                                <input type="search" className="search_input" required="required" />
                                <button type="submit" id="search_button" className="search_button"><img src="https://res.cloudinary.com/phancauphuoc/image/upload/v1659428585/web_2107/img-web-last2/magnifying-glass_ilrtbh.svg" alt="" /></button>
                            </form>
                        </div>
                        <div className="shopping">
                            {/* Cart */}
                            <a href="">
                                <div className="cart" onClick={navigateCart}>
                                    <img src="https://res.cloudinary.com/phancauphuoc/image/upload/v1659428589/web_2107/img-web-last2/shopping-bag_u1xa27.svg" alt="" />
                                    <div className="cart_num_container">
                                        <div className="cart_num_inner">
                                            <div className="cart_num">1</div>
                                        </div>
                                    </div>
                                </div>
                            </a>
                            {/* Avatar */}
                            <a href="#">
                                <div className="avatar">
                                    <img src="https://res.cloudinary.com/phancauphuoc/image/upload/v1659428582/web_2107/img-web-last2/avatar_fgg5lm.svg" alt="" />
                                </div>
                            </a>
                        </div>
                    </div>
                    <div className="burger_container d-flex flex-column align-items-center justify-content-around menu_mm"><div /><div /><div /></div>
                </div>
            </header>
            {/* Menu */}
            <div className="menu d-flex flex-column align-items-end justify-content-start text-right menu_mm trans_400">
                <div className="menu_close_container"><div className="menu_close"><div /><div /></div></div>
                <div className="logo menu_mm"><a href="#">Wish</a></div>
                <div className="search">
                    <form action="#">
                        <input type="search" className="search_input menu_mm" required="required" />
                        <button type="submit" id="search_button_menu" className="search_button menu_mm"><img className="menu_mm" src="images/magnifying-glass.svg" alt="" /></button>
                    </form>
                </div>
                <nav className="menu_nav">
                    <ul className="menu_mm">
                        <li className="menu_mm"><a href="#">Trang Chủ</a></li>
                        <li className="menu_mm"><a href="#">Sản Phẩm</a></li>
                        <li className="menu_mm"><a href="#">accessories</a></li>
                        <li className="menu_mm"><a href="#">lingerie</a></li>
                        <li className="menu_mm"><a href="#">Liên Hệ</a></li>
                    </ul>
                </nav>
            </div>
        </div>
    )
}

export default Header