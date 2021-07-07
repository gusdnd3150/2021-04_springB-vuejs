import { LOCAL_URL } from '@/jsUtil/config-variable.js'
import axios from 'axios'

const defualtHeader = { 'Content-Type': 'application/json', 'Access-Control-Allow-Origin': '*' }
const multipartHeader = {'Content-Type': 'multipart/form-data', 'Access-Control-Allow-Origin': '*'}

/* 모든 파라미터는 자바스크립트 FormData 객체 이다
   리턴은 promise 이고 각각 store에서 반화값을 핸들링하면 된다.
 */

export const webAPI = {
  /* post 요청 */
  post (url, formData) {
    return axios.post(LOCAL_URL + url, formData,
      {
        headers: defualtHeader,
        timeout: 2000
      })
  },
  /* get 요청 */
  get (url, formData) {
    return axios.get(LOCAL_URL + url, formData,
      {
        headers: defualtHeader,
        timeout: 2000
      })
  },
  /* 파일포함 post 요청 */
  filePost (url, formData) {
    return axios.post(LOCAL_URL + url, formData,
      {
        headers: multipartHeader,
        timeout: 2000
      })
  }
}
