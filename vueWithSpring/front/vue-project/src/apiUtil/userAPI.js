import { LOCAL_URL } from '@/jsUtil/config-variable.js'
import axios from 'axios'

const defaultSetting = {
  url: LOCAL_URL,
  header: { 'Content-Type': 'application/json', 'Access-Control-Allow-Origin': '*' },
  methodGet: 'get'
}

/* 유저 서비스 */
const userApi = {
  login (getUrl, paramObj) {
    return axios.post(LOCAL_URL + getUrl,
      { params: paramObj,
        headers: defaultSetting.header,
        timeout: 2000
      })
  }
}

export const userAPIServcie = {
  login (url, paramObj) {
    return userApi.login(url, paramObj)
  }
}
