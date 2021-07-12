import { LOCAL_URL } from '@/jsUtil/config-variable.js'
import { axiosInterceptor } from '@/jsUtil/web-interceptor.js'
/* import axios from 'axios' 인터셉터를 사용하므로 나중에 사용 */

const defualtHeader = { 'Content-Type': 'application/json', 'Access-Control-Allow-Origin': '*' }
const multipartHeader = {'Content-Type': 'multipart/form-data', 'Access-Control-Allow-Origin': '*'}

/* 모든 파라미터는 자바스크립트 FormData 객체 이다
   리턴은 promise 이고 각각 store에서 반화값을 핸들링하면 된다. */
export const webAPI = {
  /* post 요청 */
  post (url, formData) {
    return axiosInterceptor.post(LOCAL_URL + url, formData,
      {
        headers: defualtHeader,
        timeout: 2000
      })
  },
  /* get 요청 */
  get (url, formData) {
    return axiosInterceptor.get(LOCAL_URL + url, formData,
      {
        headers: { 'Access-Control-Allow-Origin': '*' },
        timeout: 2000
      })
  },
  /* 파일포함 post 요청 */
  filePost (url, formData) {
    return axiosInterceptor.post(LOCAL_URL + url, formData,
      {
        headers: multipartHeader,
        timeout: 2000
      })
  }
}
