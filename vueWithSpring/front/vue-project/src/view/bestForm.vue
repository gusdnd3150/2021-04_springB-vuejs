<template>
  <div>
    <div class="content-area">
        <div class="form-box">
            <div class="input-group">
                <span>제목</span>
                <input type="text" name="" >
            </div>
            <div class="input-group">
                <span>내용</span>
                <input type="text" name="" >
            </div>
        </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'bestForm'
}
</script>

<style scoped>
.form-box{ width: 300px; margin:0 auto;}
/*인풋 박스*/
.input-group{  position: relative; margin: 0 0 10px 0}
/*인풋 박스 span 테그*/
.input-group > span{   position: absolute;    top: -2px;    left: 5px;    font-size: 3px;    color: gray;}
.input-group input{ width: 100%; height: 30px;}
/*셀렉트 박스 */
.select-cust{  padding: 8px 30px 8px 30px;  margin-right: 10px;}
/*인풋 영역*/
.search-area{  text-align: left;  display: flex;  flex-direction: row;  margin-bottom: 30px;}
</style>
