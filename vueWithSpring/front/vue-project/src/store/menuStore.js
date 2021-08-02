import { webAPI } from '@/jsUtil/webAPI.js'

/* api url  */
const getMenu = 'api/getMenuList.json'

const menuStore = {
  namespaced: true,
  state: {
    menuList: [],
    selectMenu: false
  },
  getters: {
    GET_MENU_LIST: (state) => {
      return state.menuList
    }
  },
  mutations: {
    MU_SET_MENU_LIST: (state, payload) => {
      state.menuList = payload
    }
  },
  actions: {
    AC_MENU_LIST: function ({commit}, payload) {
      webAPI.get(getMenu)
        .then(res => {
          console.log(res.data)
          commit('MU_SET_MENU_LIST', res.data.result)
        })
        .catch(err => {
          console.log(err)
        })
    }
  }
}

export default menuStore
