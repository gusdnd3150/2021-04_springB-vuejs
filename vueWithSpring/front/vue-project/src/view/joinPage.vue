<template>
<div>
  <div class="content-area">
      <div class="content-main">
         <div style="background-color:red">
             dddddd
         </div>

         <div style="background-color:blue">
            <div class="join-area">
                        <span>아이디</span>
                        <input type="text" name="user_id" v-model="joinObj.user_id">
                        <span>비밀번호</span>
                        <input type="password" name="user_pwd" v-model="joinObj.user_pwd">
                        <span>생년월일</span>
                        <input type="text" name="user_birth" v-model="joinObj.user_birth">
                        <span>PHONE</span>
                        <input type="text" name="user_phone" v-model="joinObj.user_phone">
            </div>
         </div>

      </div>
  </div>
</div>
</template>

<script>
import { mapActions, mapGetters } from 'vuex'
import { commonUtil } from '@/jsUtil/commonUtil.js'

const userStore = 'userStore'

export default {
  name: 'joinPage',
  data () {
    return {
      joinObj: {
        user_id: '',
        user_pwd: '',
        user_birth: '',
        user_phone: '',
        user_email: ''
      }
    }
  },
  computed: {
    ...mapGetters(userStore, {getduplicate: 'GET_DUP_USER'})
  },
  methods: {
    ...mapActions(userStore, {fnJoinUser: 'AC_JOIN_USER'}),
    joinUser () {
      let form = commonUtil.ConvertForm(this.joinObj)
      this.fnJoinUser(form)
    }
  }
}
</script>
<style scoped>
.content-area{  padding-top: 20px;  padding-bottom:20px;  max-width: 900px;  text-align: center;  margin:0 auto;  position: relative; background-color: #447eff;}

.join-area{
    width:100%;
}
ul{
    list-style: none;
    padding: 0;
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

.content-main{
    display: flex;
    justify-content: center;
    align-items: flex-start;
    flex-wrap: wrap;
}

.content-main > div:nth-child(2){
    flex-basis: 300px;
}
.content-main> div:nth-child(1){
    flex-basis: 300px;
}
</style>
