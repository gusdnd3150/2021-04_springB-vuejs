<template>
  <div>
    <div class="content-area">
        <div class="form-box">
            <div class="input-group">
                <span>제목</span>
                <input type="text" name="plTitle" v-model="plObejct.plTitle" >
            </div>
            <div class="input-group">
                <span>내용</span>
                <textarea name="plContent" v-model="plObejct.plContent"></textarea>
            </div>
            <div class="input-group">
                <span>지역</span>
                <input type="text" name="plRegion" v-model="plObejct.plRegion">
            </div>
            <div class="input-group">
                <span>비용</span>
                <input type="text" name="plCost" v-model="plObejct.plCost">
            </div>
            <input type="button" @click="insertBestPlace" value="클릭">
        </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'bestForm',
  data: function () {
    return {
      plObejct: {plCost: '', plTitle: '', plContent: '', plRegion: ''}
    }
  },
  methods: {
    insertBestPlace: function (event) {
      event.preventDefault()

      fetch('http://localhost:8050/api/insertBestPlace', {
        method: 'post',
        headers: { 'Content-Type': 'application/json', 'Access-Control-Allow-Origin': '*' },
        body: JSON.stringify(this.plObejct)
      }).then((res) => {
        if (res.status === 200) {
          return res.json()
        } else {
          alert('등록 실패')
        }
      }).then((data) => {
        console.log(data)
      })
    }
  }
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
textarea{width: 100%; padding-top: 20px; min-height: 300px;}
</style>
