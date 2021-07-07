import { webAPI } from '@/jsUtil/webAPI.js'

/* api url  */
const url = {
  LOGIN: 'api/login',
  JOIN: 'api/join',
  DUPCHECK: 'api/dupCheck'
}

const userStore = {
  namespaced: true,
  state: {
    userInfo: {
      user_id: 'test',
      user_token: 'qqq',
      user_auth: 'USER'
    },
    login: false,
    dupCheck: false
  },
  getters: {
    GET_USER_INFO: function (state) {
      return state.userInfo
    },
    GET_DUP_CHECK: function (state) {
      return state.dupCheck
    },
    GET_LOGIN_STATE: function (state) {
      let check = localStorage.getItem('login')
      if (check != null) {
        state.login = check
      }
      return state.login
    }
  },
  mutations: {
    MU_LOGIN_STATE: function (state, payload) {
      state.login = payload
    },
    MU_USER_INFO: function (state, payload) {
      state.userInfo.user_id = payload.user_id
      state.userInfo.user_token = payload.user_token
      state.userInfo.user_auth = payload.user_auth
    },
    MU_DUP_USERID (state, payload) {
      state.dupCheck = payload
    }
  },
  actions: {
    AC_USER_LOGIN: function ({ commit }, payload) {
      webAPI.post(url.LOGIN, payload)
        .then(res => {
          if (res.data.user_id != null) {
            commit('MU_LOGIN_STATE', true)
            commit('MU_USER_INFO', res.data)
            console.log(res.data)
            localStorage.setItem('userInfo', res.data)
            localStorage.setItem('login', true)
          } else {
            alert('로그인 실패')
          }
        }).catch(res => {
          alert('error' + res.state)
        })
    },
    AC_LOGOUT: function ({ commit }) {
      commit('MU_LOGIN_STATE', false)
      commit('MU_USER_INFO', {})
      localStorage.clear()
    },
    AC_JOIN_USER ({ commit }, payload) {
      webAPI.post(url.JOIN, payload)
        .then(res => {
          console.log(res.data)
        }).catch(res => {
          alert('error' + res.state)
        })
    },
    AC_DUP_CHECK ({ commit }, payload) {
      webAPI.post(url.DUPCHECK, payload)
        .then(res => {
          console.log(res.data)
          commit('MU_DUP_USERID', res.data)
        }).catch(res => {
          alert('error' + res.state)
        })
    }
  }
}

export default userStore
