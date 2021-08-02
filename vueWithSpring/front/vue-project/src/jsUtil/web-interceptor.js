/* eslint-disable standard/object-curly-even-spacing */
import axios from 'axios'
import { LOCAL_URL } from '@/jsUtil/config-variable.js'

/* baseUrl은 그저 디폴트 경로일 뿐 이 경로를 바탕으로 서버를 한번더 오가는 것은 아니다 */
const interceptor = axios.create({
  baseURL: LOCAL_URL + 'api/interceptor'
})

/* 서버로 가기전에 한번 거치는 함수
*/
interceptor.interceptors.request.use(
  function (config) {
    let user = JSON.parse(localStorage.getItem('vuex'))
    if (user !== null) {
      config.headers['X-AUTH-TOKEN'] = user.userStore.userInfo.user_token
    }
    return config
  },
  function (error) {
    console.log(error)
  }
)

/* 서버로 다녀온 후 거치는 함수
*/
interceptor.interceptors.response.use((response) => {
  if (response.status === 401) {
    alert('You are not authorized')
  }
  return response
}, (error) => {
  if (error.response && error.response.data) {
    return Promise.reject(error.response.data)
  }
  return Promise.reject(error.message)
})

export const axiosInterceptor = interceptor
