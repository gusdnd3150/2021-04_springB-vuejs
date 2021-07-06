
export const commonUtil = {
  /* 일반 객체를 formData로 변환 */
  ConvertForm (Obj) {
    let form = new FormData()
    for (const key in Obj) {
      form.append(key, Obj[key])
    }
    return form
  }
}
