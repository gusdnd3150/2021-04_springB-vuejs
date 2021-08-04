<template>
   <div class="navigation">
       <div class="show-navi-button">
           <router-link to="/">MEETUS</router-link>
            <div class="navi-button">
                <p>=</p>
            </div>
       </div>
       <div>
           <ul class="navigation-link">
               <li> <router-link to="/story">Story</router-link></li>
               <li> <router-link to="/best">Place</router-link></li>
               <li> <router-link to="/feed">Feed</router-link></li>
           </ul>
       </div>
       <div>
           <!-- <router-link v-if="this.userInfo.user_auth === 'USER'" to="/admin/test">공지수정</router-link> -->
           <h6 v-if="this.userInfo.user_auth === 'USER'" @click="moveAdminPage">공지수정</h6>

           <router-link v-if="!this.loginCheck" to="/login"><f-icon :icon="['fas','sign-in-alt']" size="lg" :style="{ color: '#447eff' }"/>로그인</router-link>
           <p class="logout" v-if="this.loginCheck" @click="logOut"><f-icon :icon="['fas','sign-out-alt']" size="lg" :style="{ color: '#447eff' }"/>LogOut</p>
       </div>
   </div>
</template>

<script>
import { mapActions, mapGetters } from 'vuex'

const userStroe = 'userStore'

export default {
  name: 'navibar',
  data () {
    return {
    }
  },
  computed: {
    ...mapGetters(userStroe, {loginCheck: 'GET_LOGIN_STATE'}),
    ...mapGetters(userStroe, {userInfo: 'GET_USER_INFO'})
  },
  methods: {
    ...mapActions(userStroe, {setLogin: 'AC_LOGOUT'}),
    logOut () {
      this.setLogin()
    },
    moveAdminPage () {
      this.$router.push({name: 'admin', params: {name: 'cat', age: 3}})
    }
  }
}
</script>

<style scoped>

a{
    color:black !important;
    text-decoration: none;
}

.show-navi-button a{
    font-weight: bold;
}

.navigation{
    display: flex;
    flex-wrap: wrap;
    justify-content: space-around;
    padding: 20px;
    margin-bottom: 20px;
}

.navigation-link{
    margin: 0px;
    list-style: none;
    padding-left: 0px;
    display: flex;
    flex-wrap: nowrap;
    justify-content: space-evenly;
}
.navigation-link > li{
    height: 24px;
    margin-right: 30px;
    margin-left: 10px;
    font-weight: bold;
    border-bottom-style: solid;
    border-color: white;
}

.navigation-link > li:hover{
    border-color: red;
    border-bottom-style: solid;
}
.show-navi-button{
    position: relative;
}
.navi-button {
    position: absolute;
    display: none;
    top: -23px;
    right: 26px;
}
.navi-button p{
    border-style: solid;
    border-width: 1px;
    border-radius: 5px;
    padding: 5px;
    color: gray;
}

@media (max-width: 750px) {
  .navigation{
      display: flex;
      flex-direction: column;
  }
  .navigation div{
      padding-top: 20px;
      padding-bottom: 20px;
  }
  .navigation-link{
      flex-direction: column;
      display: none;
  }
  .navigation-link > li{
    margin: 0px;
    padding: 10px 0px 10px 0px;
  }
  .navigation-link > li:hover{
    background-color: gray;
    color:white;
    opacity: 0.7;
    border-bottom-style: none;
    border-color: none;
  }
  .navi-button {
      display: inline;
  }

}
.logout:hover{
    cursor: pointer;
}
</style>
