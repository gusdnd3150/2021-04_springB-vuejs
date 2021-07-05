import { userAPIServcie } from '@/functionUtills/api-service.js'

const userStore = {
  namespaced: true,
  state: {
    userInfo: {
      user_id: 'test',
      user_token: 'qqq',
      user_auth: 'USER'
    },
    login: false
  },
  getters: {
    GET_USER_INFO: function (state) {
      return state.userInfo
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
    }
  },
  actions: {
    AC_USER_LOGIN: function ({ commit }, payload) {
      userAPIServcie.login(payload.url, payload)
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
    }
  }
}

export default userStore
