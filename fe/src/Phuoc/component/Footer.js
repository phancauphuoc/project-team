import React from 'react'

const Footer = () => {
    return (
        <div>
            {/* Newsletter */}
            <div className="newsletter">
                <div className="newsletter_content">
                    <div className="newsletter_image" style={{ backgroundImage: 'url(https://res.cloudinary.com/phancauphuoc/image/upload/v1660643542/web_2107/img-web-last2/imgs/women-banner-2_vy4tr8.webp)' }} />
                    <div className="container">
                        <div className="row">
                            <div className="col">
                                <div className="section_title_container text-center">
    
                                </div>
                            </div>
                        </div>
                        <div className="row newsletter_container">
                            <div className="col-lg-10 offset-lg-1">
                                <div className="newsletter_form_container">
                                    <form action="#">
                                        <input type="email" className="newsletter_input" required="required" placeholder="E-mail here" />
                                        <button type="submit" className="newsletter_button">subscribe</button>
                                    </form>
                                </div>
        
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            {/* Footer */}
            <footer className="footer">
                <div className="container">
                    <div className="row">
                        <div className="col text-center">
                            <div className="footer_logo"><a href="#">Wish</a></div>
                            <nav className="footer_nav">
                                <ul>
                                    <li><a href="index.html">home</a></li>
                                    <li><a href="categories.html">clothes</a></li>
                                    <li><a href="categories.html">accessories</a></li>
                                    <li><a href="categories.html">lingerie</a></li>
                                    <li><a href="contact.html">contact</a></li>
                                </ul>
                            </nav>
                            <div className="footer_social">
                                <ul>
                                    <li><a href="#"><i className="fa fa-pinterest" aria-hidden="true" /></a></li>
                                    <li><a href="#"><i className="fa fa-linkedin" aria-hidden="true" /></a></li>
                                    <li><a href="#"><i className="fa fa-instagram" aria-hidden="true" /></a></li>
                                    <li><a href="#"><i className="fa fa-reddit-alien" aria-hidden="true" /></a></li>
                                    <li><a href="#"><i className="fa fa-twitter" aria-hidden="true" /></a></li>
                                </ul>
                            </div>
                            <div className="copyright">{/* Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. */}
                                Copyright © All rights reserved | This template is made with <i className="fa fa-heart-o" aria-hidden="true" /> by <a href="https://colorlib.com" target="_blank">Colorlib</a>
                                {/* Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. */}</div>
                        </div>
                    </div>
                </div>
            </footer>
        </div> 
  )
}

export default Footer