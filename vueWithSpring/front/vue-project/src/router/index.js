import Vue from 'vue'
import Router from 'vue-router'
import navibar from '@/components/navibar.vue'
import main from '@/view/main.vue'

Vue.use(Router)

export default new Router({
  mode: 'history',
  routes: [
    {
      path: '/',
      name: 'main',
      components: {default: main, navi: navibar}
    }
  ]
})
