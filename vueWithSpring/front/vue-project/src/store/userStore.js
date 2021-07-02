/* import { userAPIServcie } from '@/functionUtills/api-service.js' */

const userStore = {
  namespaced: true,
  state: {
    userInfo: {
      user_name: '',
      user_id: '',
      user_token: '',
      user_auth: ''
    },
    login: false
  },
  getters: {
    GET_USER_INFO: function (state) {
      return state.userInfo
    },
    GET_LOGIN_STATE: function (state) {
      return state.login
    }
  },
  mutations: {
    MU_LOGIN_STATE: function (state, payload) {
      state.login = payload
    },
    MU_USER_INFO: function (state, payload) {
      state.userInfo = payload
    }
  },
  actions: {
    AC_USER_LOGIN: function ({ commit }, payload) {
      console.log('로그인시도')
      console.log(payload)
      /*
      userAPIServcie.login(payload.url, payload)
        .then(res => {
          console.log('로그인 로직')
          commit('MU_BEST_DATA', res.data.result)
          commit('MU_SELECT_PAGE', res.data.selectPage)
          commit('MU_TOTAL', res.data.total)
        })
        */
    }
  }
}

export default userStore
