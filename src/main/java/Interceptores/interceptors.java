api.interceptors.request.use(
(config: InternalAxiosRequestConfig) => {
        const token = localStorage.getItem('token');
if (token && config.headers) {
config.headers.Authorization = `Bearer ${token}`;
        }
        return config;
},
        (error: AxiosError) => {
        return Promise.reject(error);
}
        );
        api.interceptors.response.use(
(response: any) => response,
        (error: AxiosError<ApiError>) => {
        if (error.response?.status === 401) {
        localStorage.removeItem('token');
localStorage.removeItem('user');
window.location.href = '/login';
        }
        return Promise.reject(error);
}
        );

