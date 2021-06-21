<template>
  <div>
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
    </div>
  </div>
</template>

<script>
export default {
  name: 'bestForm'

}
</script>

<style scoped>
/*인풋 박스 p 테그*/
.input-group >p{   position: absolute;    top: -2px;    left: 5px;    font-size: 3px;    color: gray;}
/*인풋 박스*/
.input-group{  position: relative;}
/*셀렉트 박스 */
.select-cust{  padding: 8px 30px 8px 30px;  margin-right: 10px;}
/*인풋 영역*/
.search-area{  text-align: left;  display: flex;  flex-direction: row;  margin-bottom: 30px;}
.content-area{  padding-top: 20px;  padding-bottom:20px;  max-width: 900px;  text-align: center;  margin:0 auto;  position: relative;}
</style>
