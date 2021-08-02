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
                    <input type="text" data-y="dd" name="user_id" id="user_id" v-model="loginObj.user_id" placeholder="아이디">
                  </div>
                   <div class="input">
                    <input type="password" name="user_pw" id="user_pw" v-model="loginObj.user_pw" placeholder="비밀번호">
                  </div>

                  <div>
                  <input @click="joinPage" type="button"  value="회원가입">
                  <input @click="userLogin" type="button" value="로그인">
                  </div>
             </form>
            </div>
         </div>
     </div>
</div>
</template>

<script>
import { mapGetters, mapActions } from 'vuex'

const userStore = 'userStore'

export default {
  name: 'login',
  data () {
    return {
      loginObj: {
        user_id: '',
        user_pw: ''
      }
    }
  },
  computed: {
    ...mapGetters(userStore, {checkLogin: 'GET_LOGIN_STATE'}),
    watchLoginState () { return this.checkLogin }
  },
  methods: {
    ...mapActions(userStore, {login: 'AC_USER_LOGIN'}),
    joinPage: function () {
      this.$router.push({name: 'joinPage'})
    },
    userLogin: function (event) {
      event.preventDefault()
      if (this.loginObj.user_id === '' || this.loginObj.user_pwd === '') {
        alert('아이디 패스워드는 필수입니다.')
        return
      }
      let form = this.$commonJs.ConvertForm(this.loginObj)
      this.login(form)
    }
  },
  watch: {
    watchLoginState (newVal, oldVal) {
      // alert(newVal)
      if (newVal === true) {
        alert('메인페이지로 이동합니다')
        this.$router.push({name: 'main'})
      }
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
@media (max-width: 750px){
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
