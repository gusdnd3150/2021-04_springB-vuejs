
var requestOptions = {
  headers: {
    'Content-Type': 'application/json',
    timeout: 60000
  }
}

export default{
  install (Vue) {
    Vue.prototype.$emailValidation = function (data) {
      var regExp = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i
      if (regExp.test(data)) {
        return true
      } else {
        return false
      }
    }
    Vue.prototype.$login = function (event, username, password) {
      event.preventDefault()
      if (username === '' || password === '') {
        alert('아이디 패스워드는 필수이다.')
        return
      }
      fetch('http://localhost:8090/api/login', {
        method: 'post',
        headers: requestOptions.headers,
        body: JSON.stringify({username: username, password: password})
      }).then((res) => {
        if (res.status === 200) {
          return res.json()
        } else {
          alert('로그인 실패')
        }
      }).then((data) => {
        this.$store.state.userToken = data
        console.log(this.$store.state.userToken)
        this.$router.push({name: 'main'})
      })
    }
  }
}
