import { bestAPIServcie } from '@/functionUtills/api-service.js'

const bestStore = {
  namespaced: true,
  state: {
    bestData: {},
    insertResult: '',
    selectPage: 1,
    total: 0
  },
  getters: {
    GET_BEST_DATA: function (state) {
      console.log('개터')
      return state.bestData
    },
    GET_SELECT_PAGE: function (state) {
      return state.selectPage
    },
    GET_TOTAL: function (state) {
      return state.total
    },
    GET_IN_RESULT: function (state) {
      return state.insertResult
    }
  },
  mutations: {
    MU_BEST_DATA: function (state, payload) {
      state.bestData = payload
    },
    MU_SELECT_PAGE: function (state, payload) {
      state.selectPage = payload
    },
    MU_TOTAL: function (state, payload) {
      state.total = payload
    },
    MU_IN_RESULT: function (state, payload) {
      state.insertResult = payload
    }
  },
  actions: {
    AC_BEST_DATA: function ({ commit }, payload) {
      bestAPIServcie.getList(payload.url, payload)
        .then(res => {
          console.log('액션')
          commit('MU_BEST_DATA', res.data.result)
          commit('MU_SELECT_PAGE', res.data.selectPage)
          commit('MU_TOTAL', res.data.total)
        })
    },
    AC_INSERT_BEST: function ({ commit }, payload) {
      bestAPIServcie.insert(payload.get('url'), payload)
        .then(res => {
          commit('MU_IN_RESULT', res.data)
        })
    }
  }
}

export default bestStore
