<template>
  <div class="admin-area">
    <el-container>
      <el-header>Header</el-header>
      <el-container>
        <el-aside width="200px"><adminSide /></el-aside>
        <el-main>Main</el-main>
      </el-container>
    </el-container>
  </div>
</template>

<script>
/* 공통 컴포넌트 영역 */

import {mapGetters} from 'vuex'
/* 컨텐츠 컴포넌트 영역 DB MENU_CD 값과 일치 시킬 것 */
import modBoard from '@/view/admin/pages/modBoard.vue' /* 공지사항 관리 */
import modMenu from '@/view/admin/pages/modMenu.vue' /* 메뉴 관리 */
import user from '@/view/admin/pages/modUser.vue' /* 유저 관리 */
import adminSide from '@/components/admin_sideBar.vue'

const menuStore = 'menuStore'

export default {
  name: 'adminArea',
  data () {
    return {
      childMenu: [],
      showComponent: '',
      showMenu: false
    }
  },
  computed: {
    ...mapGetters(menuStore, {getMenuList: 'GET_MENU_LIST'}),
    sortLevel1Menu () {
      let Menu1 = this.getMenuList
      let newList = Menu1.filter((i) => {
        if (i.LEVEL === 1) {
          // let Query = {name: i.MENU_URL, params: { }}
          return i
        }
      })
      return newList
    }
  },
  components: {
    modBoard,
    modMenu,
    user,
    adminSide
  },
  methods: {
    changeMenu (menuCd) {
      let menuList = document.querySelectorAll('.inner_side_list > li')
      menuList.forEach((el) => {
        el.removeAttribute('class')
      })
      let selectTag = document.getElementById(menuCd)
      selectTag.setAttribute('class', 'active')

      let Menu2 = this.getMenuList
      let newChild = Menu2.filter((i) => {
        if (i.MENU_PARENT === menuCd) {
          return i
        }
      })
      this.childMenu = newChild
    },
    changeChildComponent (menuCd) {
      console.log(menuCd)
      this.showComponent = menuCd
    }
  },
  mounted () {
    let MenuList = this.getMenuList
    let firstTopMenu
    let firstChilcMenu
    MenuList.some((el) => {
      if (el.LEVEL === 1) {
        firstTopMenu = el.MENU_CD
        return (el.LEVEL === 1)
      }
    })
    MenuList.some((el) => {
      if (el.MENU_PARENT === firstTopMenu) {
        firstChilcMenu = el.MENU_CD
        return (el.MENU_PARENT === firstTopMenu)
      }
    })
    this.changeMenu(firstTopMenu)
    this.changeChildComponent(firstChilcMenu)
  }
}
</script>

<style scoped>
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

/* ----------------------------------사이드바 css*/

.el-aside{
  /*background-color: #384059;*/
  height: 100%;
  padding: 30px 0 20px 0;
}
.el-container{
  height: 100%;
}

.el-main{
  background-color: #F9F9F9;
}

</style>
