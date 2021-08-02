<template>
  <div id="app">
    <!-- 일반 영역 -->
    <router-view name="navi" />
    <router-view name="middle" />

    <!-- 관리자 영역 -->
      <router-view name="topbar" />
      <div class="row admin-area">
        <div class="col-lg-2">
          <router-view name="sidebar"/>
        </div>
        <div class="col-lg-10 admin-content-area" >
          <div class="container">
            <router-view name="admin_middle" id="main-content"/>
          </div>
        </div>
      </div>

    <!-- <router-view name="bottom" /> -->
  </div>
</template>

<script>
import { mapGetters, mapActions } from 'vuex'

const menuStore = 'menuStore'
const userStore = 'userStore'

export default {
  name: 'App',
  computed: {
    ...mapGetters(userStore, {getUserInfo: 'GET_USER_INFO'})
  },
  methods: {
    ...mapActions(menuStore, {acMenuList: 'AC_MENU_LIST'}),
    initMenu () {
      this.acMenuList()
    }
  },
  created: function () {
    this.initMenu()
  }
}
</script>

<style>
@import './css/main.css';
html, body{
  height: 100%;
  width: 100%;
}
#app{
  height: 100%;
}
#main-content{
  height: 100%;
}
.admin-area{
  height: 100%;
}

.admin-content-area{
  padding-top: 71px;
  background-color: #F9F9F9;
}

</style>
