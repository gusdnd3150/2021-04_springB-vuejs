<template>
  <div class="content">
    <h2>명소</h2>
    <div class="content-area">
      <router-link class="write-form" to="/bestForm">작성하기</router-link>

      <form id="searchForm" class="searchForm">
      <div class="search-area">
        <div class="input-group">
          <select name="searchType" class="select-cust">
            <option selected>경기도</option>
            <option>서울</option>
          </select>
          <p>지역</p>
        </div>
        <div class="input-group">
          <select name="priceTotal" class="select-cust">
            <option selected>5~10만원</option>
            <option value="10to20">10~20만원</option>
            <option value="20to30">20~30만원</option>
            <option value="30to40">30~40만원</option>
            <option>--</option>
          </select>
          <p>경비</p>
        </div>
        <div class="input-group">
          <input type="text" name="searchContent" class="select-cust">
          <p>내용</p>
        </div>
        <div>
           <div class="button">
            <div class="eff"></div>
            <p>조회</p>
          </div>
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

export default {
  name: 'best',
  data: function () {
    return {
      searchRegion: '',
      searchContent: '',
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
  methods: {
    propsFromPaging (data) {
      this.selectPage = data
      this.getListData()
    },
    getListData () {
      fetch('http://localhost:8050/api/selectBestPlace.json', {
        method: 'post',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify({selectPage: this.selectPage, cntPerPage: 9})
      }).then((res) => {
        return res.json()
      }).then((data) => {
        console.log(data)
        this.total_count = data.total
        this.cardData = data.result
        this.cntPerPage = data.cntPerPage
      })
    }
  },
  created: function () {
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

/*셀렉트 박스 */
.select-cust{  padding: 8px 30px 8px 30px;  margin-right: 10px;}

/*인풋 영역*/
.search-area{  text-align: left;  display: flex;  flex-direction: row;  margin-bottom: 30px;}
.content-area{  padding-top: 20px;  padding-bottom:20px;  max-width: 900px;  text-align: center;  margin:0 auto;  position: relative;}

.write-form{  position: absolute;  top: 2px;  right: 139px; color:gray; font-size: 15px; }
.write-form:hover{cursor: pointer;}
</style>
