<template>
  <div class="content">
    <h2>커플 명소</h2>
    <div class="content-area">

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
      </div>

    </div>
  </div>
</template>

<script>
export default {
  name: 'best',
  data: function () {
    return {
      test: ''
    }
  }
}

</script>
<style scoped>

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
