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
  }
  /*
  getFetchData (geturl, paramObj) {
    fetch(defaultSetting.url + geturl,
      {
        method: 'post',
        headers: { 'Content-Type': 'application/json', 'Access-Control-Allow-Origin': '*' },
        body: JSON.stringify(paramObj)

      }).then((res) => {
      if (res.status === 200) {
        return res.json()
      } else {
        return 'fail'
      }
    }).then((data) => {
      console.log('db 데이터')
      console.log(data)
      return data
    })
  } */
}

export const bestAPIServcie = {
  insert () {

  },
  update () {

  },
  delete () {

  },
  getList (geturl, paramObj) {
    return fetchApi.getAxiosData(geturl, paramObj)
  }
}

export const loginAPIServcie = {
}
