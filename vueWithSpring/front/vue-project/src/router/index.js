import Vue from 'vue'
import Router from 'vue-router'
import navibar from '@/components/navibar.vue'
import main from '@/view/main.vue'
import login from '@/view/login.vue'
import footer from '@/view/footer.vue'
import best from '@/view/best.vue'
import feed from '@/view/feed.vue'
import story from '@/view/story.vue'

Vue.use(Router)

export default new Router({
  mode: 'history',
  routes: [
    {
      path: '/',
      name: 'main',
      components: {default: main, navi: navibar, bottom: footer}
    },
    {
      path: '/login',
      name: 'login',
      components: {default: login, navi: navibar, bottom: footer}
    },
    {
      path: '/story',
      name: 'story',
      components: {default: story, navi: navibar, bottom: footer}
    },
    {
      path: '/feed',
      name: 'feed',
      components: {default: feed, navi: navibar, bottom: footer}
    },
    {
      path: '/best',
      name: 'best',
      components: {default: best, navi: navibar, bottom: footer}
    }
  ]
})
