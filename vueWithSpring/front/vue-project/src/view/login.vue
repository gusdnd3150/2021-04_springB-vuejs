<template>
<div class="content-area">
     <div class="login-div">
         <div>
             <!-- 이미지 -->
             <div class="login-left-content">
                <h2>hello </h2>
                <p>지금 연애하고 계신가요?
                비트윈을 시작하세요!
                비트윈은 연인과 더 사랑스럽게 소통하고, 소중한 추억을 손쉽게 저장할 수 있는 어플입니다.
                </p>
             </div>
         </div>
         <div>
            <div class="login-content">
             <form name="loginForm" action="/login" method="post">
                  <div class="input">
                    <input type="text" name="username" id="username" v-model="username" placeholder="아이디">
                  </div>
                   <div class="input">
                    <input type="text" name="password" id="password" v-model="password" placeholder="비밀번호">
                  </div>
                  <button @click="login">로그인</button>
             </form>
            </div>
         </div>
     </div>
</div>
</template>

<script>

export default {
  name: 'login',
  data () {
    return {
      username: '',
      password: ''
    }
  },
  methods: {
    login: function (event) {
      event.preventDefault()
      if (this.username === '' || this.password === '') {
        alert('아이디 패스워드는 필수이다.')
        return
      }
      fetch('/api/login', {
        method: 'post',
        // eslint-disable-next-line standard/object-curly-even-spacing
        headers: { 'Content-Type': 'application/json'},
        body: JSON.stringify({username: this.username, password: this.password})
      }).then((res) => {
        console.log(res.status)
        console.log(res.body)
        console.log(res.text)
        console.log(res.json())
      }).then((res) => {
        console.log(res)
      })
    }
  }
}
</script>

<style scoped>
.login-div{
  overflow: hidden;
  border-radius: 10px;
  display: flex;
  flex-wrap: nowrap;
  box-shadow: rgba(0, 0, 0, 0.07) 0px 1px 1px, rgba(0, 0, 0, 0.07) 0px 2px 2px, rgba(0, 0, 0, 0.07) 0px 4px 4px, rgba(0, 0, 0, 0.07) 0px 8px 8px, rgba(0, 0, 0, 0.07) 0px 16px 16px;
}

.login-div > div{
  flex-basis: 394px;
  min-height: 500px;
}
.login-div > div:first-child{
   position: relative;
    background-color: #3CAEFF;
    position: relative;
}
.login-div > div:first-child  .login-left-content{
    position: absolute;
    top: 148px;
    text-align: center;
    right: 35px;
    color: white;
    font-weight: bold;
    width: 81%;
}

.login-left-content p{
  font-size: 15px;
  color:white;
  opacity: 0.8;
}

.login-content{
  margin: 178px 0px 30px 0px;
}

.input input{
    border: 0;
    border-bottom-style: solid;
    border-width: 1px;
    height: 31px;
    width: 212px;
}

.input input:focus{
    outline: 0;
}

.content-area{
  margin-top: 100px;
  width: 800px;
  margin: 0 auto;
}
@media (max-width: 767px){
  .content-area{
    width:100%;
  }
}

@media (max-width: 750px) {
    .login-div{
      flex-direction:column
    }
    .login-div > div{
      width: auto;
      height: 200px;
      flex-grow: 1;
    }
    .login-left-content{
      width: auto;
    }
}
</style>
