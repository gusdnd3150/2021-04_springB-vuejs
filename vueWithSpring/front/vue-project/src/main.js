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

/* 폰트를 전역에서 사용할 수 있도록  */
import '@/css/fontawesome.js'

/* 전역 컴포넌트로서 사용 */
Vue.config.productionTip = false
Vue.use(VueGlide)

/* 전역 함수 사용 */
Vue.prototype.$http = axios

/* eslint-disable no-new */
new Vue({
  el: '#app',
  store: store,
  router,
  components: { App },
  template: '<App/>'
})
