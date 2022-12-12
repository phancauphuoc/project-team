import axios from "axios";

//Author: Nam Phương
export const instance = axios.create({
  baseURL: "http://localhost:8080/cloud",
  timeout: 10000
  // header{} //header này để trống hoặc xoá đi, thì bên backend mới nhận 
              //được request (mang theo username, password mà người dùng nhập vào) từ frontend
});

/*
instance.interceptors.request.use(
  config => {
    const token = localStorage.getItem("token") // load token tên “token” từ Local Storage (F12) lên, gắn token này vô request, 
    if (token) {                                // sau đó gửi cho backend. Backend sẽ check token đó để biết thằng này đăng nhập hay chưa. 
      config.headers.Authorization = `Bearer ${token}`;
    }
    return config;
  },
  error => Promise.reject(error)
);*/
