// The Vue build version to load with the `import` command
/* 메인 처음으로 시작되는 자바스크립트 파일이기 때문에 전역으로 사용하려면 이 파일에 등록해야 되나보다 아래 webpack.base.conf에 설정을 추가해주자  */
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import { store } from './store/store.js'
import VueGlide from 'vue-glide-js'
import 'vue-glide-js/dist/vue-glide.css'
import axios from 'axios'
import BootstrapVue from 'bootstrap-vue'
import 'bootstrap/dist/css/bootstrap.min.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'
import 'tui-grid/dist/tui-grid.css'
import 'tui-date-picker/dist/tui-date-picker.css'
import 'tui-time-picker/dist/tui-time-picker.css'
import 'tui-pagination/dist/tui-pagination.css'
import { Grid } from '@toast-ui/vue-grid'
import TuiGrid from 'tui-grid'
import { commonUtil } from '@/jsUtil/commonUtil.js'
/* Vue.component로 등록한 컴포넌트를 전역에서 사용할 수 있도록 main.js에 import */
import '@/css/fontawesome.js'
/* 뷰설명서 노출 */
Vue.config.productionTip = false

TuiGrid.setLanguage('ko')
TuiGrid.applyTheme('clean')
Vue.component('grid', Grid)

/* 전역 사용 */
Vue.use(VueGlide)
Vue.use(BootstrapVue)

Vue.prototype.$commonJs = commonUtil
Vue.prototype.$http = axios

/* eslint-disable no-new */
new Vue({
  el: '#app',
  store: store,
  router,
  components: { App },
  template: '<App/>'
})
