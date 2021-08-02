import Vue from 'vue'
import Vuex from 'vuex'
import VueAwesomeSwiper from 'vue-awesome-swiper'

import bestStore from './bestStore.js'
import userStore from './userStore.js'
import adminStore from './adminStore.js'
import createPersistedState from 'vuex-persistedstate'
import menuStore from './menuStore.js'
Vue.use(Vuex)
Vue.use(VueAwesomeSwiper)

export const store = new Vuex.Store({
  modules: {
    bestStore: bestStore,
    userStore: userStore,
    adminStore: adminStore,
    menuStore: menuStore
  },
  plugins: [createPersistedState({ // 새로고침 시 state가 초기화 되는 것을 막기 위해 추가
    paths: ['userStore', 'menuStore']
  })]
})
