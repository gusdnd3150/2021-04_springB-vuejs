
<template>
  <div class="left-sideBar">
      <!--
      <ul class="list">
          <li><router-link to="/admin/modBoard">공지사항 관리 </router-link></li>
          <li><router-link to="/admin/menu">메뉴 관리 </router-link></li>
          <li><router-link to="/admin/users">유저 관리 </router-link></li>
      </ul>
      -->

      <ul class="list" >
          <li v-for="MenuList in this.getMenuList" :key="MenuList.MENU_CD">
              <router-link v-if="MenuList.LEVEL === 2" :to="MenuList.MENU_URL">{{MenuList.MENU_NM}}</router-link>
          </li>
      </ul>
  </div>
</template>

<script>
import {mapGetters} from 'vuex'

const menuStore = 'menuStore'

export default {
  name: 'sideBar',
  date () {
  },
  computed: {
    ...mapGetters(menuStore, {getMenuList: 'GET_MENU_LIST'})
  }
}
</script>

<style scoped>

.list{
    color: white;
    list-style: none;
    padding: 0;
    margin: 0;
}
.list > li {
    text-align: left;
    padding-left: 10px;
}
.list > li:hover{
    cursor: pointer;
}
.left-sideBar{
    background-color: #2d3753;
    height: 100%;
    padding-top: 20px;
    padding-bottom: 16px;
}
</style>
