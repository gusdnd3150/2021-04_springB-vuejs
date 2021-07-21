
/* import { webApi } from '@/jsUtil/webAPI.js'     api필요시 사용할 계획 */

export const commonUtil = {
  /* 일반 객체를 formData로 변환 */
  ConvertForm (Obj) {
    let form = new FormData()
    for (const key in Obj) {
      form.append(key, Obj[key])
    }
    return form
  },
  /* id 선택자를 기준으로 formData로 변환 */
  fgGetPostData (id) {
    let inputs = document.querySelectorAll('#' + id + ' input:not([type="button"]),select')
    let form = new FormData()

    inputs.forEach(function (tag, index, array) {
      form.append(tag.name, tag.value)
    })
    /*
    for (var pair of form.entries()) {
      console.log(pair)
      console.log(form.get(pair))
    }    */
    return form
  },
  fnTest () {
    alert('공통함수')
  }
}
