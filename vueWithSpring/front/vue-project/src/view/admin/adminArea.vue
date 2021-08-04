<template>
  <div class="admin-area">
        <div class="top-navi">
            <div v-for="MenuList in sortLevel1Menu" :key="MenuList.MENU_CD" class="" @click="changeMenu(MenuList.MENU_CD)">
              <span>{{MenuList.MENU_NM}}</span>
            </div>
        </div>

      <div class="row admin-area">

        <div class="col-lg-2">
            <div class="left-sideBar">
                <ul class="list" >
                    <li v-for="menuList in childMenu" :key="menuList.MENU_CD">
                        <span @click="changeChildComponent(menuList.MENU_CD)">{{menuList.MENU_NM}}</span>
                    </li>
                </ul>
            </div>
        </div>

        <div class="col-lg-10 admin-content-area" >
          <div class="container">
            <modBoard />
              <div v-html="showComponent"></div>
          </div>
        </div>
      </div>
  </div>
</template>

<script>
/* 공통 컴포넌트 영역 */
import topBar from '@/components/admin_topNavi.vue'
import sideBar from '@/components/admin_sideBar.vue'

/* 컨텐츠 컴포넌트 영역 */
import modBoard from '@/view/admin/pages/modBoard.vue'
import {mapGetters} from 'vuex'

const menuStore = 'menuStore'

export default {
  name: 'adminArea',
  data () {
    return {
      childMenu: [],
      showComponent: '<template> <modBoard /> </template>'
    }
  },
  props: {
    name: {
      type: String,
      default: ''
    },
    age: {
      type: Number,
      default: 0
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
    topBar,
    sideBar,
    modBoard
  },
  methods: {
    changeMenu (path) {
      let Menu2 = this.getMenuList
      let newChild = Menu2.filter((i) => {
        if (i.MENU_PARENT === path) {
          return i
        }
      })
      this.childMenu = newChild
    },
    changeChildComponent (menuCd) {
      console.log(menuCd)
    }
  },
  mounted () {
    let MenuList = this.getMenuList
    let firstTopMenu
    let firstChilcMenu
    MenuList.forEach((el, index) => {
      if (el.LEVEL === 1 && index === 0) {
        firstTopMenu = el.MENU_CD
      }
    })
    MenuList.forEach((el, index) => {
      if (el.MENU_PARENT === firstTopMenu) {
        firstChilcMenu = el.MENU_CD
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
