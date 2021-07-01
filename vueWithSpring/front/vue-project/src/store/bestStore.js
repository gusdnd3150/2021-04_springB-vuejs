import { bestAPIServcie } from '@/functionUtills/api-service.js'

const bestStore = {
  namespaced: true,
  state: {
    test: 'DFFDF',
    bestData: {},
    selectPage: 1,
    total: 0
  },
  getters: {
    GET_BEST_DATA: function (state) {
      console.log('개터')
      return state.bestData
    },
    GET_TEST: function (state) {
      return state.test
    },
    GET_SELECT_PAGE: function (state) {
      return state.selectPage
    },
    GET_TOTAL: function (state) {
      return state.total
    }
  },
  mutations: {
    MU_BEST_DATA: function (state, payload) {
      state.bestData = payload
    },
    MU_TEST: function (state, payload) {
      state.test = payload
    },
    MU_SELECT_PAGE: function (state, payload) {
      state.selectPage = payload
    },
    MU_TOTAL: function (state, payload) {
      state.total = payload
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
    AC_TEST: function ({ commit }, payload) {
      commit('MU_TEST', payload)
    }
  }
}

export default bestStore
