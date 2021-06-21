<template>
  <div class="content">
    <h2>명소</h2>
    <div class="content-area">

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
            <option>10~20만원</option>
            <option>20~30만원</option>
            <option>30~40만원</option>
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
        <div class="place-list">
          <placeCard2 />
          <placeCard2 />
          <placeCard2 />
          <placeCard2 />
          <placeCard2 />
          <placeCard2 :cardData="cardData"/>
          <placeCard2 />
          <placeCard2 />
        </div>
      </div>

    </div>
    <paging :value="2" :total="30" @propsFromPaging="propsFromPaging" />
  </div>
</template>

<script>
import placeCard2 from '@/components/place-card2.vue'
import paging from '@/components/paging2.vue'

export default {
  name: 'best',
  data: function () {
    return {
      searchRegion: '',
      searchContent: '',
      cardData: {name: 'test', title: 'd'},
      page_value: 0,
      totalPage: 0
    }
  },
  components: {
    placeCard2,
    paging
  },
  methods: {
    search () {
      console.log('dd')
    },
    propsFromPaging (data) {
      console.log(data)
      this.cardData = {}
    }
  },
  watch: {
    paging: function (newQuestion, oldQuestion) {
      this.answer = 'Waiting for you to stop typing...'
      this.debouncedGetAnswer()
    }
  }

}

</script>
<style scoped>

.place-list{
  display: flex;
  flex-wrap: wrap;

}

/*인풋 박스 p 테그*/
.input-group >p{
   position: absolute;
    top: -2px;
    left: 5px;
    font-size: 3px;
    color: gray;
}
/*인풋 박스*/
.input-group{
  position: relative;
}

/*셀렉트 박스 */
.select-cust{
  padding: 8px 30px 8px 30px;
  margin-right: 10px;
}

/*인풋 영역*/
.search-area{
  text-align: left;
  display: flex;
  flex-direction: row;
  margin-bottom: 30px;
}
.content-area{
  /*border:solid gray 1px;*/
  padding-top: 20px;
  padding-bottom:20px;
  max-width: 900px;
  text-align: center;
  margin:0 auto;
}
</style>
