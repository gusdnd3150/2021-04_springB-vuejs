
/* form input 유효성 체크용
data-y='y'   :  필수값
data-int='y'  :  숫자값
data-string='y' : 문자값
data-day='y'    : 날짜값
*/
const numRule = /^[0-9]*$/

export const validation = {
  checkInputsById (id) {
    let require = document.querySelectorAll('#' + id + ' input[data-y="y"]')
    let number = document.querySelectorAll('#' + id + ' input[data-int="y"]')

    var check = true
    var numCheck = true

    /* data-y 기준 필수값 null 체크 */
    require.forEach(function (tag, index, array) {
      if (tag.value === 'undefined' || tag.value.trim() === '') {
        tag.style.borderColor = 'red' /* 체크 후 별도의 처리를 원할 경우 커스텀하자 */
        check = false
      } else {
        tag.style.borderColor = 'black'
      }
    })

    number.forEach(function (tag, index, array) {
      if (!numRule.test(tag.value)) {
        numCheck = false
      }
    })
    if (!check) { alert('필수값을 입력해 주세요') }
    if (!numCheck) { alert('숫자형식이 아닙니다.') }

    return check
  }
}
