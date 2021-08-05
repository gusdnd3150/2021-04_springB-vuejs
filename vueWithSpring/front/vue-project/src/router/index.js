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
import adminArea from '@/view/admin/adminArea.vue'
import modBoard from '@/view/admin/pages/modBoard.vue'
import sideBar from '@/components/admin_sideBar.vue'
import topBar from '@/components/admin_topNavi.vue'
import {menu} from '@/jsUtil/menuList.js'
Vue.use(Router)

console.log(menu.getMenu())

export default new Router({
  mode: 'history',
  routes: [
    {
      path: '/',
      name: 'main',
      components: {middle: main, navi: navibar}
    },
    {
      path: '/login',
      name: 'login',
      components: {middle: login, navi: navibar}
    },
    {
      path: '/joinPage',
      name: 'joinPage',
      components: {middle: joinPage, navi: navibar}
    },
    {
      path: '/story',
      name: 'story',
      components: {middle: story, navi: navibar}
    },
    {
      path: '/feed',
      name: 'feed',
      components: {middle: feed, navi: navibar}
    },
    {
      path: '/best',
      name: 'best',
      components: {middle: best, navi: navibar}
    },
    {
      path: '/bestForm',
      name: 'bestForm',
      components: {middle: bestFormTest, navi: navibar}
    },
    /* -----------------------------관리자 페이지 ----------------------------- */
    {
      path: '/admin/modBoard',
      name: 'modBoard',
      components: {admin_middle: modBoard, sidebar: sideBar, topbar: topBar, navi: navibar}
    },
    {
      path: '/admin/test',
      name: 'admin',
      components: {adminArea: adminArea},
      props: true
    }
  ]
})
