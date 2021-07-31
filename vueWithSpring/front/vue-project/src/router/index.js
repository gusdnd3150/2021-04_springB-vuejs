import Vue from 'vue'
import Router from 'vue-router'

/* 유저 페이지 */
import navibar from '@/components/navibar.vue'
import main from '@/view/main.vue'
import login from '@/view/login.vue'
import best from '@/view/best.vue'
import feed from '@/view/feed.vue'
import story from '@/view/story.vue'
/* import bestForm from '@/view/bestForm.vue' */
import bestFormTest from '@/view/bestFormTest.vue'
import joinPage from '@/view/joinPage.vue'

/* 관리자 페이지 */
import modBoard from '@/view/admin/modBoard.vue'

Vue.use(Router)

export default new Router({
  mode: 'history',
  routes: [
    {
      path: '/',
      name: 'main',
      components: {default: main, navi: navibar}
    },
    {
      path: '/login',
      name: 'login',
      components: {default: login, navi: navibar}
    },
    {
      path: '/joinPage',
      name: 'joinPage',
      components: {default: joinPage, navi: navibar}
    },
    {
      path: '/story',
      name: 'story',
      components: {default: story, navi: navibar}
    },
    {
      path: '/feed',
      name: 'feed',
      components: {default: feed, navi: navibar}
    },
    {
      path: '/best',
      name: 'best',
      components: {default: best, navi: navibar}
    },
    {
      path: '/bestForm',
      name: 'bestForm',
      components: {default: bestFormTest, navi: navibar}
    },
    /* 관리자 페이지 */
    {
      path: '/admin/modBoard',
      name: 'modBoard',
      components: {default: modBoard, navi: navibar}
    }
  ]
})
