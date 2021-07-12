<template>
  <div class="content">
    <h2>명소</h2>
    <div class="content-area">
      <router-link v-if="this.loginState" class="write-form" to="/bestForm">작성하기</router-link>

      <form id="searchForm" class="searchForm">
      <div class="search-area">
        <div class="input-group">
            <select name="searchRegion" v-model="paramObj.region" value="" class="select-cust">
              <option value="GYEONGI">경기도</option>
              <option value="SEOUL" >서울</option>
              <option value="GIMPO" >김포</option>
              <option value="BUSAN" >부산</option>
              <option value="" selected>------</option>
            </select>
            <p>지역</p>
        </div>
        <div class="input-group">
            <select name="searchCost" v-model="paramObj.cost" class="select-cust">
              <option value="0">5~10만원</option>
              <option value="100000">10~20만원</option>
              <option value="200000">20~30만원</option>
              <option value="300000">30~40만원</option>
              <option value="" selected>-----</option>
            </select>
            <p>경비</p>
        </div>
        <div class="input-group">
            <input type="text" v-model="paramObj.content" name="searchContent" class="select-cust">
            <p>내용</p>
        </div>
        <div>
              <input type="button" @click="searchData" value="조회" class="cust_button" />
        </div>
      </div>
     </form>

      <div class="place-area">
        <div class="place-list" >

          <placeCard2 v-for="i in this.bestList"
          :key="i.PL_NUM"
          :title="i.PL_TITLE"
          :content="i.PL_CONTENT"
          :cost="i.PL_COST"
          :num="i.PL_NUM"
          :regDate="i.PL_REG_DATE"
          :region="i.PL_REGION"
          :userId="i.USER_ID" />

        </div>
        <paging
        :selectPage="this.selectPage"
        :total="this.total"
        @propsFromPaging="propsFromPaging" />
      </div>
    </div>
  </div>
</template>

<script>
import placeCard2 from '@/components/place-card2.vue'
import paging from '@/components/paging.vue'
import { mapGetters, mapActions } from 'vuex'
import { commonUtil } from '@/jsUtil/commonUtil.js'

const bestStore = 'bestStore'
const userStore = 'userStore'

export default {
  name: 'best',
  data: function () {
    return {
      paramObj: {
        region: '',
        content: '',
        cost: '',
        selectPage: this.selectPage,
        total: this.total
      }
    }
  },
  components: {
    placeCard2,
    paging
  },
  computed: {
    ...mapGetters(bestStore, {bestList: 'GET_BEST_DATA', total: 'GET_TOTAL', selectPage: 'GET_SELECT_PAGE'}),
    ...mapGetters(userStore, {loginState: 'GET_LOGIN_STATE'})
  },
  methods: {
    ...mapActions(bestStore, {fnBestData: 'AC_BEST_DATA'}),

    propsFromPaging (data) {
      /* console.log('페이지 클릭' + data) */
      this.paramObj.selectPage = data
      this.getListData()
    },
    searchData () {
      this.paramObj.selectPage = 1
      this.getListData()
    },
    getListData () {
      let form = commonUtil.ConvertForm(this.paramObj)
      this.fnBestData(form)
    }
  },
  mounted: function () {
    this.getListData()
  }

}

</script>
<style scoped>

.place-list{  display: flex;  flex-wrap: wrap;}

/*인풋 박스 p 테그*/
.input-group >p{   position: absolute;    top: -2px;    left: 5px;    font-size: 3px;    color: gray;}
/*인풋 박스*/
.input-group{  position: relative;}
.input-group input:focus{ outline: red;}

/*버튼 커스텀*/
.cust_button{ padding: 7px 20px 8px 20px;    background-color: #007bff;    border: none;    border-radius: 4px;    color: white;    font-weight: bold;    font-size: 15px; transition: all 0.2s;}
.cust_button:hover{cursor: pointer; opacity: 0.8;}
/*셀렉트 박스 */
.select-cust{  padding: 8px 30px 8px 30px;  margin-right: 10px;}

/*인풋 영역*/
.search-area{  text-align: left;  display: flex;  flex-direction: row;  margin-bottom: 30px;}
.content-area{  padding-top: 20px;  padding-bottom:20px;  max-width: 900px;  text-align: center;  margin:0 auto;  position: relative;}

.write-form{  position: absolute;  top: 2px;  right: 139px; color:gray; font-size: 15px; }
.write-form:hover{cursor: pointer;}
</style>
