import Vue from 'vue'
import Vuex from 'vuex'
import VueAwesomeSwiper from 'vue-awesome-swiper'

Vue.use(Vuex)
Vue.use(VueAwesomeSwiper)

export const store = new Vuex.Store({
  state: {
    counter: 0,
    userToken: {}
  }
})
