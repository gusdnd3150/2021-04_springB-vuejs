import { LOCAL_URL } from '@/jsUtil/config-variable.js'
import axios from 'axios'

const defaultSetting = {
  url: LOCAL_URL,
  header: { 'Content-Type': 'application/json', 'Access-Control-Allow-Origin': '*' },
  methodGet: 'get'
}
/* 베스트플레이스 */
const bestApi = {
  getAxiosData (getUrl, paramObj) {
    return axios.post(LOCAL_URL + getUrl, paramObj,
      {
        headers: defaultSetting.header,
        timeout: 2000
      })
  },
  insertBest (url, paramObj) {
    console.log(url)
    return axios.post(LOCAL_URL + url, paramObj,
      {
        headers: {'Access-Control-Allow-Origin': '*', 'Content-Type': 'multipart/form-data'},
        timeout: 2000
      })
  }
}

export const bestAPIServcie = {
  insert (url, paramObj) {
    return bestApi.insertBest(url, paramObj)
  },
  update () {

  },
  delete () {

  },
  getList (geturl, paramObj) {
    return bestApi.getAxiosData(geturl, paramObj)
  }
}
