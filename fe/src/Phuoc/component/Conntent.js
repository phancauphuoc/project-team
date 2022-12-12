import { Pagination } from '@mui/material';
import React, { useEffect, useState } from 'react'
import ReactPaginate from 'react-paginate';
// import axios from 'axios'
import ProductHomeService from '../services/ProductHomeService';
// import JsonData from "./MOCK_DATA.json"
//import CategoryHomeService from '../services/CategoryHomeService';
const Conntent = () => {

  const [product, setProduct] = useState([50]);
  const [pageNumber, setPageNumber] = useState(0)

  const [productPerPage] = useState(3)
  const pageVisitsed = pageNumber * productPerPage
  const pageCount = Math.ceil(product.length / productPerPage);

  const display = product
    .slice(pageVisitsed, pageVisitsed + productPerPage)
    .map((product) => {
      return (
      // <div className="row products_container phuoc5">
        <div className="col-lg-4 product_col" key={product.id}>
          <div className="product">
            <div className="product_image">
              <img src={product.productImg} alt="" />
            </div>
            <div className="rating rating_4">
              <i className="fa fa-star" />
              <i className="fa fa-star" />
              <i className="fa fa-star" />
              <i className="fa fa-star" />
              <i className="fa fa-star" />
            </div>
            <div className="product_content clearfix">
              <div className="product_info">
                <div className="product_name"><a href="product.html">{product.productName}</a></div>
                <div className="product_price">{product.unitPrice} VNĐ</div>
              </div>
            </div>
          </div>
        {/* </div> */}
      </div>
      )
      
    })
    

  const changePage = ({ selected }) => {
    setPageNumber(selected)
  }


  const [productCate, setProductCate] = useState([]);




  useEffect(() => {
    getAllProduct();
    getProductCate();
  }, [])

  const getAllProduct = () => {
    ProductHomeService.getAllProduct().then((response) => {
      setProduct(response.data);
    })
  }

  const getProductCate = () => {
    ProductHomeService.getProductByCategory().then((response) => {
      setProductCate(response.data);
    })
  }


  return (
    <div>
      {/* Home */}
      <div className="home">
        {/* Home Slider */}
        <div className="home_slider_container">
          <div className="owl-carousel owl-theme home_slider">
            {/* Home Slider Item */}
            <div className="owl-item">
              <div className="home_slider_background" style={{ backgroundImage: 'url(https://res.cloudinary.com/phancauphuoc/image/upload/v1660643420/web_2107/img-web-last2/imgs/womens_website_u629nt.webp)' }} />
              <div className="home_slider_content">
                <div className="home_slider_content_inner">
                  <div className="home_slider_subtitle">Promo Prices</div>
                  <div className="home_slider_title">New Style Shirt</div>
                </div>
              </div>
            </div>
            {/* Home Slider Item */}
            <div className="owl-item">
              <div className="home_slider_background" style={{ backgroundImage: 'url(https://res.cloudinary.com/phancauphuoc/image/upload/v1660643542/web_2107/img-web-last2/imgs/women-banner-2_vy4tr8.webp)' }} />
              <div className="home_slider_content">
                <div className="home_slider_content_inner">
                  <div className="home_slider_subtitle">Promo Prices</div>
                  <div className="home_slider_title">New Fashion sport</div>
                </div>
              </div>
            </div>
            {/* Home Slider Item */}
            <div className="owl-item">
              <div className="home_slider_background" style={{ backgroundImage: 'url(https://res.cloudinary.com/phancauphuoc/image/upload/v1660642555/web_2107/img-web-last2/imgs/Homepage-Women-Banner_6a89611b-1a0c-4b43-9a75-d8b2a4057153_kmjtnh.webp)' }} />
              <div className="home_slider_content">
                <div className="home_slider_content_inner">
                  <div className="home_slider_subtitle">Promo Prices</div>
                  <div className="home_slider_title">New Collection</div>
                </div>
              </div>
            </div>
          </div>
          {/* Home Slider Nav */}
          <div className="home_slider_next d-flex flex-column align-items-center justify-content-center"><img src="https://res.cloudinary.com/phancauphuoc/image/upload/v1659428582/web_2107/img-web-last2/arrow_r_ifqion.png" alt="" /></div>
          {/* Home Slider Dots */}
          <div className="home_slider_dots_container">
            <div className="container">
              <div className="row">
                <div className="col">
                  <div className="home_slider_dots">
                    <ul id="home_slider_custom_dots" className="home_slider_custom_dots">
                      <li className="home_slider_custom_dot active">01.<div /></li>
                      <li className="home_slider_custom_dot">02.<div /></li>
                      <li className="home_slider_custom_dot">03.<div /></li>
                    </ul>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>

      {/* New Arrivals */}
      <div className="arrivals">
        <div className="container">
          <div className="row">
            <div className="col">
              <div className="section_title_container text-center">
                <div className="section_subtitle">only the best</div>
                <div className="section_title">Sản phẩm nổi bật</div>
              </div>
            </div>
          </div>
          <div className="row products_container phuoc5">
            {/* Product */}
            {/* {
              product.map(
                product =>
                  <div className="col-lg-4 product_col"  key={product.id}>
                    <div className="product">
                      <div className="product_image">
                        <img src={product.productImg} alt="" />
                      </div>
                      <div className="rating rating_4">
                        <i className="fa fa-star" />
                        <i className="fa fa-star" />
                        <i className="fa fa-star" />
                        <i className="fa fa-star" />
                        <i className="fa fa-star" />
                      </div>
                      <div className="product_content clearfix">
                        <div className="product_info">
                          <div className="product_name"><a href="product.html">{product.productName}</a></div>
                          <div className="product_price">{product.unitPrice} VNĐ</div>
                        </div>
                        
                      </div>
                    </div>
                  </div>
              )
            } */}
             <div className="row products_container phuoc5">
              {display}
              
              <ReactPaginate
                previousLabel={"Previous"}
                nextLabel={"Next"}
                pageCount={pageCount}
                onPageChange={changePage}
                containerClassName={"paginationBttns"}
                previousLinkClassName={"previousBttn"}
                nextLinkClassName={"nextBttn"}
                disabledLinkClassName={"paginationDisabled"}
                activeClassName={"paginationActive"}
              />
            </div>
          </div>

        </div>
      </div>
      {/* san phẩm category 4 */}
      <div className="arrivals">
        <div className="container">
          <div className="row">
            <div className="col">
              <div className="section_title_container text-center">
                <div className="section_subtitle">only the best</div>
                <div className="section_title">Phụ kiện nổi bật</div>
              </div>
            </div>
          </div>
          <div className="row products_container phuoc5">
            {/* Product */}
            {
              productCate.map(
                productCate =>
                  <div className="col-lg-4 product_col" key={productCate.id}>
                    <div className="product">
                      <div className="product_image">
                        <img src={productCate.productImg} alt="" />
                      </div>
                      <div className="rating rating_4">
                        <i className="fa fa-star" />
                        <i className="fa fa-star" />
                        <i className="fa fa-star" />
                        <i className="fa fa-star" />
                        <i className="fa fa-star" />
                      </div>
                      <div className="product_content clearfix">
                        <div className="product_info">
                          <div className="product_name"><a href="product.html">{productCate.productName}</a></div>
                          <div className="product_price">{productCate.unitPrice.toLocaleString()} VNĐ</div>
                        </div>

                      </div>
                    </div>
                  </div>
              )
            }
          </div>

        </div>
      </div>

      {/* Gallery */}
      <div className="gallery">
        <div className="gallery_image" style={{ backgroundImage: 'url(https://res.cloudinary.com/phancauphuoc/image/upload/v1660643420/web_2107/img-web-last2/imgs/womens_website_u629nt.webp)' }} />
        <div className="container">
          <div className="row">
            <div className="col">
              <div className="gallery_title text-center">
              </div>
              <div className="button gallery_button"><a href="#">submit</a></div>
            </div>
          </div>
        </div>
        <div className="gallery_slider_container">
          {/* Gallery Slider */}
          <div className="owl-carousel owl-theme gallery_slider">
            {/* Gallery Item */}
            <div className="owl-item gallery_item">
              <a className="colorbox" href="https://res.cloudinary.com/phancauphuoc/image/upload/v1660642718/web_2107/img-web-last2/imgs/Male-categories_Vests_medium_ocierj.webp">
                <img src="https://res.cloudinary.com/phancauphuoc/image/upload/v1660642718/web_2107/img-web-last2/imgs/Male-categories_Vests_medium_ocierj.webp" alt="" />
              </a>
            </div>
            {/* Gallery Item */}
            <div className="owl-item gallery_item">
              <a className="colorbox" href="https://res.cloudinary.com/phancauphuoc/image/upload/v1660643083/web_2107/img-web-last2/imgs/Shorts_medium_ikvqui.webp">
                <img src="https://res.cloudinary.com/phancauphuoc/image/upload/v1660643083/web_2107/img-web-last2/imgs/Shorts_medium_ikvqui.webp" alt="" />
              </a>
            </div>
            {/* Gallery Item */}
            <div className="owl-item gallery_item">
              <a className="colorbox" href="https://res.cloudinary.com/phancauphuoc/image/upload/v1660643130/web_2107/img-web-last2/imgs/dope-women_medium_mbxi9d.webp">
                <img src="https://res.cloudinary.com/phancauphuoc/image/upload/v1660643130/web_2107/img-web-last2/imgs/dope-women_medium_mbxi9d.webp" alt="" />
              </a>
            </div>
            {/* Gallery Item */}
            <div className="owl-item gallery_item">
              <a className="colorbox" href="https://res.cloudinary.com/phancauphuoc/image/upload/v1660643197/web_2107/img-web-last2/imgs/tops_medium_b4bnbb.webp">
                <img src="https://res.cloudinary.com/phancauphuoc/image/upload/v1660643197/web_2107/img-web-last2/imgs/tops_medium_b4bnbb.webp" alt="" />
              </a>
            </div>
            {/* Gallery Item */}
            <div className="owl-item gallery_item">
              <a className="colorbox" href="https://res.cloudinary.com/phancauphuoc/image/upload/v1660643268/web_2107/img-web-last2/imgs/Male-categories_hoodies_ebc43862-64b4-4e73-9de8-ae6451d7237d_medium_qmvjbm.webp">
                <img src="https://res.cloudinary.com/phancauphuoc/image/upload/v1660643268/web_2107/img-web-last2/imgs/Male-categories_hoodies_ebc43862-64b4-4e73-9de8-ae6451d7237d_medium_qmvjbm.webp" alt="" />
              </a>
            </div>
            {/* Gallery Item */}
            <div className="owl-item gallery_item">
              <a className="colorbox" href="https://res.cloudinary.com/phancauphuoc/image/upload/v1660643347/web_2107/img-web-last2/imgs/mens-tracks_medium_nwv3qe.webp">
                <img src="https://res.cloudinary.com/phancauphuoc/image/upload/v1660643347/web_2107/img-web-last2/imgs/mens-tracks_medium_nwv3qe.webp" alt="" />
              </a>
            </div>
          </div>
        </div>
      </div>

    </div>
  )
}

export default Conntent