import { webAPI } from '@/jsUtil/webAPI.js'

/* api url  */

const selectBoard = 'api/selectBoardList.json'
const deleteBoard = 'api/deleteBoard.json'
const updateBoard = 'api/updateBoard.json'

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
    AC_SELECT_BOARD ({ commit }, payload) {
      webAPI.post(selectBoard, payload)
        .then(res => {
          console.log(res.data)
          commit('MU_SET_BOARD', res.data)
        })
    },
    AC_DELETE_BOARD ({commit}, payload) {
      webAPI.post(deleteBoard, payload)
        .then(res => {

        })
    },
    AC_UPDATE_BOARD ({commit}, payload) {
      webAPI.post(updateBoard, payload)
        .then(res => {

        })
    }
  }
}

export default adminStore
