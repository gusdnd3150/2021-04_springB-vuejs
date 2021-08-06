
<template>
  <div class="left-sideBar">
      <el-radio-group v-model="isCollapse" style="margin-bottom: 20px;">
        <el-radio-button @open="handleOpen" :label="false">expand</el-radio-button>
        <el-radio-button @open="handleClose" :label="true">collapse</el-radio-button>
      </el-radio-group>

      <el-menu  class="el-menu-vertical-demo" @open="handleOpen" @close="handleClose" :collapse="isCollapse">
        <el-submenu v-for="(list,index1) in this.getMenuList" :key="index1" :index="1" >
          <template v-if="list.LEVEL === 1" slot="title">
            <i class="el-icon-location"></i>
            <span slot="title">{{list.MENU_NM}}</span>
          </template>
            <el-menu-item v-else-if="list.LEVEL === 2" :index="list.MENU_INDEX">{{list.MENU_NM}}</el-menu-item>
            <el-menu-item v-else-if="list.LEVEL === 3" :index="list.MENU_INDEX">{{list.MENU_NM}}</el-menu-item>
        </el-submenu>
      </el-menu>
  </div>
</template>

<script>
import {mapGetters} from 'vuex'

const menuStore = 'menuStore'

export default {
  name: 'sideBar',
  date () {
    return {
      isCollapse: true
    }
  },
  methods: {
    handleOpen (key, keyPath) {
      this.isCollapse = !this.isCollapse
      console.log(key, keyPath)
    },
    handleClose (key, keyPath) {
      console.log(key, keyPath)
      this.isCollapse = !this.isCollapse
    }
  },
  computed: {
    ...mapGetters(menuStore, {getMenuList: 'GET_MENU_LIST'}),
    convertMenu () {
      let menu = this.getMenuList
      menu.forEach(el => {
        let menuObj = {}
        if (el.LEVEL === 1) {
          console.log(el)
        }
      })

      return ''
    }
  }
}
</script>

<style scoped>
.left-sideBar{
  height: 70%;
}
.el-menu-vertical-demo:not(.el-menu--collapse) {
    width: 200px;
    height: 100%;
}
</style>
