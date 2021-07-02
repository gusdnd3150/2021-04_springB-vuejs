import { LOCAL_URL } from './config-variable.js'
import axios from 'axios'

const defaultSetting = {
  url: LOCAL_URL,
  header: { 'Content-Type': 'application/json', 'Access-Control-Allow-Origin': '*' },
  methodGet: 'get'
}

const fetchApi = {
  getAxiosData (getUrl, paramObj) {
    return axios.post(defaultSetting.url + getUrl,
      { params: paramObj,
        headers: defaultSetting.header,
        timeout: 2000
      })
  },
  insertBest (url, paramObj) {
    return axios.post(defaultSetting.url + url,
      { params: paramObj,
        headers: defaultSetting.header,
        timeout: 2000
      })
  }

}

export const bestAPIServcie = {
  insert (url, paramObj) {
    return fetchApi.insertBest(url, paramObj)
  },
  update () {

  },
  delete () {

  },
  getList (geturl, paramObj) {
    return fetchApi.getAxiosData(geturl, paramObj)
  }
}

export const userAPIServcie = {
}
