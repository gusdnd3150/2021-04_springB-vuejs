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
    /*
    let token = localStorage.getItem('token')
    config.headers = { 'MY-TOKEN': token, 'Access-Control-Allow-Origin': '*', 'Content-Type': 'application/json'}
    console.log('요청 전 인터셉터 원하는 로직을 넣으면 된다. return 값은 설정값일 뿐 별도의 서버를 거치지않고 프론트에서 해결함')
    axios.post(LOCAL_URL + 'api/interceptor')
    */
    return config
  },
  function (error) {
    console.log(error)
  }
)

/* 서버로 다녀온 후 거치는 함수
*/
interceptor.interceptors.response.use((response) => {
  console.log(response)
  if (response.status === 401) {
    alert('You are not authorized')
  }
  return response
}, (error) => {
  console.log(error)
  if (error.response && error.response.data) {
    return Promise.reject(error.response.data)
  }
  return Promise.reject(error.message)
})

export const axiosInterceptor = interceptor
