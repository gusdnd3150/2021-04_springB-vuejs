import Vue from 'vue'
import Vuex from 'vuex'
import VueAwesomeSwiper from 'vue-awesome-swiper'

import bestStore from './bestStore.js'
import userStore from './userStore.js'

Vue.use(Vuex)
Vue.use(VueAwesomeSwiper)

export const store = new Vuex.Store({
  modules: {
    bestStore: bestStore,
    userStore: userStore
  }
})
