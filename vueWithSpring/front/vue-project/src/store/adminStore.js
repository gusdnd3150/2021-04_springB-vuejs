import { webAPI } from '@/jsUtil/webAPI.js'

/* api url  */
const url = {
  adminBoard: 'api/selectBoardList.json'
}

const adminStore = {
  namespaced: true,
  state: {
    getData: {}
  },
  getters: {
    GET_BOARD: function (state) {
      return state.getData
    },
    GET_HEADER: function (state) {
      return state.headers
    }
  },
  mutations: {
    MU_SET_BOARD: function (state, payload) {
      state.getData = payload
    }
  },
  actions: {
    AC_SELECT_BOARD: function ({ commit }, payload) {
      webAPI.post(url.adminBoard, payload)
        .then(res => {
          console.log(res.data)
          commit('MU_SET_BOARD', res.data)
        })
    }
  }
}

export default adminStore
