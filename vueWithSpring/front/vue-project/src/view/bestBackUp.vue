<template>
  <div class="content">
    <h2>명소</h2>
    <div class="content-area">
      <router-link class="write-form" to="/bestForm">작성하기</router-link>

      <form id="searchForm" class="searchForm">
      <div class="search-area">
        <div class="input-group">
            <select name="searchRegion" v-model="searchRegion" class="select-cust">
              <option value="GYEONGI">경기도</option>
              <option value="SEOUL" >서울</option>
              <option value="GIMPO" >김포</option>
              <option value="BUSAN" >부산</option>
              <option value="" selected>------</option>
            </select>
            <p>지역</p>
        </div>
        <div class="input-group">
            <select name="searchCost" v-model="searchCost" class="select-cust">
              <option value="0">5~10만원</option>
              <option value="100000">10~20만원</option>
              <option value="200000">20~30만원</option>
              <option value="300000">30~40만원</option>
              <option value="" selected>-----</option>
            </select>
            <p>경비</p>
        </div>
        <div class="input-group">
            <input type="text" v-model="searchContent" name="searchContent" class="select-cust">
            <p>내용</p>
        </div>
        <div>
              <input type="button" @click="searchData" value="조회" class="cust_button" />
        </div>
      </div>
     </form>

      <div class="place-area">
        <div class="place-list" >

          <placeCard2 v-for="i in cardData"
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
        :selectPage="selectPage"
        :total="total_count"
        :cntPerPage="cntPerPage"
        @propsFromPaging="propsFromPaging" />
      </div>

    </div>
  </div>
</template>

<script>
import placeCard2 from '@/components/place-card2.vue'
import paging from '@/components/paging3.vue'
import { mapGetters } from 'vuex'

const bestStore = 'bestStore'

export default {
  name: 'best',
  data: function () {
    return {
      searchRegion: '',
      searchContent: '',
      searchCost: '',
      cardData: [],
      selectPage: 1,
      total_count: 0,
      cntPerPage: 0
    }
  },
  components: {
    placeCard2,
    paging
  },
  computed: {
    ...mapGetters(bestStore, ['GET_TEST']),
    ...mapGetters(bestStore, {test: 'GET_TEST'})
  },
  methods: {
    testFn () {
      alert(this.test)
      alert(this.GET_TEST)
    },
    propsFromPaging (data) {
      this.selectPage = data
      this.getListData()
      this.getListData2()
    },
    searchData () {
      this.selectPage = 1
      this.getListData()
    },
    getListData2 () {
      let data = this.$store.commit('getBestList', '/api/selectBestPlace.json', { selectPage: this.selectPage, cntPerPage: 9, searchRegion: this.searchRegion, searchContent: this.searchContent, searchCost: this.searchCost })
      console.log(data)
    },
    getListData () {
      fetch('http://localhost:8050/api/selectBestPlace.json', {
        method: 'post',
        headers: {'Content-Type': 'application/json'},
        async: false,
        body: JSON.stringify(
          { selectPage: this.selectPage,
            cntPerPage: 9,
            searchRegion: this.searchRegion,
            searchContent: this.searchContent,
            searchCost: this.searchCost
          })
      }).then((res) => {
        if (res.status === 200) {
          return res.json()
        }
      }).then((data) => {
        this.total_count = data.total
        this.cardData = data.result
        this.cntPerPage = data.cntPerPage
      })
    }
  },
  created: function () {
    this.getListData()
    this.testFn()
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
