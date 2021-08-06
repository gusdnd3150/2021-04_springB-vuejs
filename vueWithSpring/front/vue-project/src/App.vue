<template>
  <div id="app">
    <!-- 일반 영역 -->
    <router-view name="navi" />
    <router-view name="middle" />
    <router-view name="adminArea" />
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
</style>
