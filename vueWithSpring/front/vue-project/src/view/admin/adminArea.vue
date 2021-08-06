<template>
  <div class="admin-area">
        <div class="top-navi"> <!-- 상단 메뉴 -->
              상단 메뉴
        </div>

      <div class="row admin-area">

        <div class="col-lg-2">   <!-- 사이드바 메뉴 -->
            <div class="row left-sideBar">

              <div class="col-lg-5 L-inner-div">
                  <ul class="inner_side_list" >
                      <li v-for="menuList in sortLevel1Menu" :key="menuList.MENU_CD" :id="menuList.MENU_CD" @click="changeMenu(menuList.MENU_CD)">
                        <div class="innerL_li">
                          <f-icon class="inner_side_list_icon" v-if="menuList.MENU_ICON !== 'undefined'" :icon="['fas', menuList.MENU_ICON]" />
                          <span style="display: block" >{{menuList.MENU_NM}}</span>
                        </div>
                      </li>
                  </ul>
              </div>

              <div class="col-lg-7 R-inner-div">
                      <ul class="side_list" >
                          <li v-for="menuList in childMenu" :key="menuList.MENU_CD" @click="changeChildComponent(menuList.MENU_CD)">
                              <f-icon v-if="menuList.MENU_ICON !== 'undefined'" :icon="['fas', menuList.MENU_ICON]" />
                              <span >{{menuList.MENU_NM}}</span>
                              <f-icon :icon="['fas', 'angle-right']" :id="menuList.MENU_CD" />
                          </li>
                      </ul>
              </div>
            </div>
        </div>

                    <!-- 메인 컴포넌트 -->
        <div class="col-lg-10 admin-content-area" style="background:#f0f2f6" >
          <div class="container">
                <component :is="showComponent">
                  <!-- MENU_CD 와 컴포넌트 이름을 동일하게 적용 -->
                </component>
          </div>
        </div>
      </div>
  </div>
</template>

<script>
/* 공통 컴포넌트 영역 */

import {mapGetters} from 'vuex'
/* 컨텐츠 컴포넌트 영역 DB MENU_CD 값과 일치 시킬 것 */
import modBoard from '@/view/admin/pages/modBoard.vue' /* 공지사항 관리 */
import modMenu from '@/view/admin/pages/modMenu.vue' /* 메뉴 관리 */
import user from '@/view/admin/pages/modUser.vue' /* 유저 관리 */

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
    user
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
.L-inner-div{
  background-color: #335cc8;
  height: 100%;
  padding: 0px 0 20px 0;
}
.inner_side_list_icon{
    font-size: 2vw;
    margin: 0;
}

.R-inner-div{
  background-color: #384059;
  height: 100%;
  padding: 30px 0 20px 0;
}
.innerL_li{
    display: inline;
    line-height: 75px;
}
.innerL_li > *{
  vertical-align: middle;
  display: inline !important;
}
.innerR_li{
    display: inline;
    line-height: 30px;
}
.innerR_li > *{
  vertical-align: middle;
  display: inline !important;
}
.inner_side_list{
    color: white;
    list-style: none;
    padding: 0px !important;
    margin: 0px !important;
    width: 96%;
    padding-left: 1vw;
    text-align: center;
}
.inner_side_list > li {
    text-align: center;
    width: 110%;
    /* margin-top: 17%; */
    margin-right: 0px;
    font-weight: 200;
    font-size: 0.8vw;
    min-height: 82px;
}
.inner_side_list > li:hover{
  cursor: pointer;
}
.inner_side_list > li.active{
  background-color: #384059;
}
.side_list{
    color: white;
    list-style: none;
    padding: 0px !important;
    margin: 0px !important;
    width: 96%;
    overflow: hidden;
    padding-left: 1vw;
}
.side_list > li {
    text-align: left;
    margin: 0px 0px 0px 0px !important;
    padding: 5px 0px 2vh 15px;
    width: 93%;
    font-weight: 200;
    font-size: 0.8vw;
}
.side_list > li > svg.active {
    display: none;
}
.side_list > li:hover{
    cursor: pointer;
    font-weight: bold;
}
.left-sideBar{
    background-color: #2d3753;
    height: 100%;
}

li > svg{
      margin-right: 14px;
}

/*-------------------------------------------탑바 css*/
.top-navi{
    display: flex;
    justify-content: flex-end;
    list-style: none;
    padding: 0;
    margin: 0;
    border: solid 1px;
    border-color: #4b6fcf;
}
.top-navi > div{
    min-width: 100px;
    min-height: 60px;
    max-height: 60px;
    display: inline;
    -webkit-transition: all 0.1s;
    transition: all 0.1s;
    border-left: solid 1px;
    border-color: #4b6fcf;
}

.top-navi > div:hover{
    cursor: pointer;
    opacity: 0.8;
    background-color: #4b6fcf;
    color:white
}
</style>
