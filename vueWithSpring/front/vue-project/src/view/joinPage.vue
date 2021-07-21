<template>
<div>
  <div class="content-area">
      <div class="content-main">
         <div class="left-area">
             <img src="@/assets/joinImage.jpg" alt="leftImage">
         </div>

         <div class="right-area">
             <h3>회원가입</h3>
             <p>간편 가입으로 MEETUS를 이용해 보세요</p>
            <div class="join-area">

                <table class="table" id="form">
                    <tr>
                        <td colspan="3">
                            <span>아이디</span>
                            <span class="checkButton" @click="fnCheck">중복체크</span>
                            <span class="valide" v-if="this.getduplicate">사용가능</span>
                            <input type="text" style="width:94%" class="form-input" data-y="y" data-id="y" name="user_id" v-model="joinObj.user_id">
                        </td>
                    </tr>
                    <tr>
                        <td colspan="3">
                            <span>비밀번호</span>
                            <input type="password" style="width:94%" data-y="y" class="form-input" data-pwd="y" name="user_pwd" v-model="joinObj.user_pwd">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <span>year</span>
                            <input type="text" class="form-input" data-y="y" data-year="y" name="user_year" v-model="joinObj.user_year">
                        </td>
                        <td>
                            <span>month</span>
                            <input type="text" class="form-input" data-y="y" data-month="y" name="user_month" v-model="joinObj.user_month">
                        </td>
                        <td>
                            <span>day</span>
                            <input type="text"  class="form-input" data-y="y" data-day="y" name="user_day" v-model="joinObj.user_day">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <span>앞자리</span>
                            <select name="user_phone1" data-y="y" v-model="joinObj.user_phone1" class="form-input">
                                <option value="010" :selected="true">010</option>
                                <option value="011">011</option>
                            </select>
                        </td>
                        <td colspan="2">
                            <span>뒷자리</span>
                            <input type="text" style="width:91%" data-phone="y" data-y="y"  class="form-input" name="user_phone2" v-model="joinObj.user_phone2">
                        </td>
                    </tr>
                </table>
                <input type="button" class="group-button" @click="joinUser" value="가입">
            </div>
         </div>

      </div>
  </div>
</div>
</template>

<script>
import { mapActions, mapGetters } from 'vuex'
import { validation } from '@/jsUtil/validation.js'

const userStore = 'userStore'

export default {
  name: 'joinPage',
  data () {
    return {
      joinObj: {
        user_id: '',
        user_pwd: '',
        user_day: '',
        user_year: '',
        user_month: '',
        user_phone1: '',
        user_phone2: '',
        user_email: ''
      },
      dupCheck: false
    }
  },
  computed: {
    ...mapGetters(userStore, {getduplicate: 'GET_DUP_CHECK'}),
    ...mapGetters(userStore, {getjoinState: 'GET_JOIN_STATE'}),
    watchJoin () { return this.getjoinState }
  },
  methods: {
    ...mapActions(userStore, {fnJoinUser: 'AC_JOIN_USER'}),
    ...mapActions(userStore, {fnDupCheck: 'AC_DUP_CHECK'}),

    joinUser () {
      if (!validation.checkInputsById('form')) { return }
      if (this.getduplicate === false) {
        alert('아이디 중복체크를 다시 진행해 주세요')
        return
      }
      this.fnJoinUser(this.$commonJs.ConvertForm(this.joinObj))
    },
    fnCheck () {
      if (this.joinObj.user_id.trim() === '') {
        alert('아이디를 입력해 주세요')
        return
      }
      this.fnDupCheck(this.$commonJs.ConvertForm(this.joinObj))
    },
    getDup () { return this.getduplicate }
  },
  watch: {
    watchJoin (newVal, oldVal) {
      if (newVal === true) {
        alert('회원가입이 완료 되었습니다.')
        this.$router.push({name: 'main'})
      }
    }
  }
}
</script>
<style scoped>
.content-area{
    padding-top: 20px;
    padding-bottom: 20px;
    max-width: 900px;
    text-align: center;
    margin: 0 auto;
    position: relative;
    /* background-color: #447eff; */
    border: solid;
    border-width: 1px;
    border-radius: 6px;
    border-color: #aaa;
}
.left-area{
    width:250px;
    height:220px;
    overflow:hidden;
}
img{
    width: 100%;
    height: 100%;
    object-fit: cover;
    transition: all 0.2s;
}
img:hover{
    transform: scale(1.02);
}
.join-area{
    width:100%;
}
ul{
    list-style: none;
    padding: 0;
}
.form-input:focus{
    border-color: darkmagenta;
}
.join-inputs{
    margin:0 auto;
    width: 200%;
}
.join-inputs > li{
    background-color: white;
    margin: 5px;
    border-radius: 10px;
}
.group-button{
    width: 50%;
}
.content-main{
    display: flex;
    align-items: flex-start;
    flex-wrap: wrap;
    justify-content: space-evenly
}
.right-area {
    text-align: left;
}
td span{
    font-size: 10px;
    color:grey;
    font-weight: bold;
    margin-left: 5px;
}
.right-area > p{
    text-align: left;
    color:gray;
    font-size: 11px;
}
.content-main > div:nth-child(2){
    flex-basis: 300px;
}
.content-main> div:nth-child(1){
    flex-basis: 300px;
}
.checkButton:hover{
    cursor: pointer;
}
.checkButton{
    border-style: solid;
    padding: 1px;
    border-width: 1px;
    border-radius: 5px;
}
.valide{
    color:blue
}
</style>
