<template>
  <div>
    <div class="content-area">
      <form id="form1" name="form1" method="post" enctype="multipart/form-data">
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
              <select name="plRegion" v-model="plObejct.plRegion" class="select-cust">
                <option value="GYEONGI">경기도</option>
                <option value="SEOUL" >서울</option>
                <option value="GIMPO" >김포</option>
                <option value="BUSAN" >부산</option>
              </select>
            </div>
            <div class="input-group">
                <span>비용</span>
                <input type="text" name="plCost" v-model="plObejct.plCost">
            </div>
            <div class="input-group file">
                <p class="cust_button" @click="clickFile">사진</p>
                <input type="file" name="image" id="file" ref="trigger" multiple="multiple">
            </div>
            <input type="button" @click="formCheck" value="save" class="cust_button">
        </div>
        </form>
    </div>
  </div>
</template>

<script>
import { mapActions, mapGetters } from 'vuex'

const bestStore = 'bestStore'
const userStore = 'userStore'

export default {
  name: 'bestForm',
  data: function () {
    return {
      plObejct: {plCost: '', files: [], plTitle: '', plContent: '', plRegion: '', url: 'api/insertBestPlace'}
    }
  },
  computed: {
    ...mapGetters(bestStore, {result: 'GET_IN_RESULT'}),
    ...mapGetters(userStore, {userInfo: 'GET_USER_INFO'})
  },
  methods: {
    ...mapActions(bestStore, {insertBest: 'AC_INSERT_BEST'}),

    insertBestPlace: function () {
      let formParam = document.getElementById('form1')
      const param = new FormData(formParam)

      param.append('url', 'api/insertBestPlace.json')
      param.append('user_id', this.userInfo.user_id)

      for (let key of param.entries()) {
        console.log(key)
      }

      this.insertBest(param)
    },
    formCheck: function (event) {
      event.preventDefault()

      let values = this.plObejct
      for (let i in values) {
        console.log(values[i])
        if (values[i] === '') {
          alert('값을 입력해 주세요')
          return
        }
      }
      this.insertBestPlace()
    },
    formClear: function () {
      for (let obj in this.plObejct) {
        this.plObejct[obj] = ''
      }
    },
    clickFile: function () {
      this.$refs.trigger.click()
    }
  }
}
</script>

<style scoped>

#file{ display: none;}
.form-box{ width: 300px; margin:0 auto;}
/*인풋 박스*/
.input-group{  position: relative; margin: 0 0 10px 0}
/*인풋 박스 span 테그*/
.input-group > span{   position: absolute;    top: -2px;    left: 5px;    font-size: 3px;    color: gray;}
.input-group input,select{ width: 100%; height: 50px;}
/*셀렉트 박스 */
.select-cust{  padding: 8px 30px 8px 30px;  margin-right: 10px;}
/*인풋 영역*/
.search-area{  text-align: left;  display: flex;  flex-direction: row;  margin-bottom: 30px;}
textarea{width: 100%; padding-top: 20px; min-height: 300px;}
</style>
