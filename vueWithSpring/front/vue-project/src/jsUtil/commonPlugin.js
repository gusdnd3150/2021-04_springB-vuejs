import {commonUtil} from '@/jsUtil/commonUtil.js'

export default {
  install (Vue, options) {
    Vue.prototype.$fnConvertForm = commonUtil.fnTest
    Vue.prototype.$fnConvertForm = function () {
    }
  }
}
