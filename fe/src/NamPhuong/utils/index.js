
//Author: Nam Phương

//COOKIE
//Reference: 
    //https://www.tabnine.com/academy/javascript/how-to-set-cookies-javascript/
    //https://www.w3schools.com/js/js_cookies.asp


// Cookie sẽ có dạng là 1 chuỗi, như thế này:
//     document.cookie = "username=John Smith; expires=Thu, 18 Dec 2013 12:00:00 UTC; path=/";
//______________________________________________________________________________________________
//Set cookie
export function setCookie(name,value,exp_days) {
    var d = new Date();
    d.setTime(d.getTime() + (exp_days*24*60*60*1000));
    var expires = "expires=" + d.toGMTString();
    document.cookie = name + "=" + value + ";" + expires + ";path=/";
}

//Get 1 cookie ~ determine the value of a cookie when given the cookie’s name.
export function getCookie(cname) { //Lấy tên cookie làm tham số (cname).
    let name = cname + "="; //text cần tìm: cName + "="
    
    let decodedCookie = decodeURIComponent(document.cookie);
    let ca = decodedCookie.split(';'); //Tách cookie có dấu chấm phẩy thành một mảng có tên là ca (ca = decodedCookie.split (';')).
    
    for(let i = 0; i <ca.length; i++) { //Lặp qua mảng ca (i = 0; i <ca.length; i ++) và đọc giá trị của từng phần tử ca [i].
      let c = ca[i];
      while (c.charAt(0) == ' ') {
        c = c.substring(1);
      }
      if (c.indexOf(name) == 0) {//Nếu cookie được tìm thấy (c.indexOf (name) == 0), hãy trả về giá trị của cookie (c.substring (name.length, c.length).
        return c.substring(name.length, c.length);
      }
    }
    return ""; //Nếu không tìm thấy cookie, hãy trả lại "".
}

//Check cookie ~ checkLogin
export function checkLogin(cookieName) { 
    let cookieValue = getCookie(cookieName);    
    if (cookieValue != ""){
      return 1;
    }     
    return 0;   
}

