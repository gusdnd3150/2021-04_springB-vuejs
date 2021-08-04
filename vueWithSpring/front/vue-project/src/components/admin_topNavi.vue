<template>
  <div>
      <div class="top-navi">
          <div v-for="MenuList in sortLevel1Menu" :key="MenuList.MENU_CD" class="">
            <!-- <router-link v-if="MenuList.LEVEL === 1" :to="MenuList.MENU_URL">{{MenuList.MENU_NM}}</router-link> -->
            <router-link :to="'MenuList.MENU_URL'">{{MenuList.MENU_NM}}</router-link>
           </div>
      </div>
  </div>
</template>

<script>
import {mapGetters} from 'vuex'

const menuStore = 'menuStore'
export default {
  name: 'topNavi',
  data () {
    return {
      style: 'active'
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
  }
}
</script>

<style>
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
