/* eslint-disable standard/object-curly-even-spacing */
<template>
  <div class="">
          <h6>유저 관리</h6>
          <div class="input-style">
                  <span><f-icon :icon="['fas', 'search']" /></span>
                  <input type="text" class="input-text" placeholder="전체 검색" name="searchContent" v-model="searchContent">
                  <button class="main_button" @click="searchPaging">검색</button>
          </div>

          <div class="input-style">
                  <tableToast
                  ref="gridTable"
                  :dataSource="dataSource"
                  :headerData="headers"
                  :pageOptionsProp="pageNations"
                  @searchContent="searchContent"
                  @onClickPage="onClickPage"
                  @onClickCell="onClickCell"
                  />
          </div>
  </div>
</template>

<script>
import tableToast from '@/components/admin_tableToast.vue'

export default {
  name: 'modUser',
  data () { /* 2021/07/23  리퀘스트 테스트 도중  */
    return {
      headers: [
        {header: '아이디', name: 'USER_ID', sortingType: 'desc', sortable: true},
        {header: '이름', name: 'USER_NAME', sortingType: 'desc', sortable: true, editor: 'text'},
        {header: 'EN 이름', name: 'USER_EN_NM', sortingType: 'desc', sortable: true, editor: 'text'},
        {header: '이메일', name: 'USER_MAIL', sortingType: 'desc', sortable: true, editor: 'text'},
        {header: '레벨', name: 'USER_LEVEL', sortingType: 'desc', sortable: true, editor: 'text'},
        {header: '부서', name: 'USER_JOB', sortingType: 'desc', sortable: true, editor: 'text'},
        {header: '권한', name: 'AUTHO', formatter: 'listItemText', editor: {type: 'select', options: {listItems: [ { text: '유저', value: 'USER' }, { text: '관리자', value: 'ADMIN' } ]}}},
        {header: '삭제여부', name: 'DEL_YN', formatter: 'listItemText', editor: {type: 'select', options: {listItems: [ { text: 'N', value: 'n' }, { text: 'Y', value: 'y' } ]}}}
      ],
      dataSource: {
        contentType: 'application/json',
        headers: { 'Access-Control-Allow-Origin': '*' },
        initialRequest: true,
        initParams: {params: 'test'},
        api: {
          readData: { url: 'http://localhost:8050/api/userList.json', method: 'GET' },
          deleteData: { url: 'http://localhost:8050/api/deleteUser.json', method: 'POST' },
          updateData: { url: 'http://localhost:8050/api/updateUser.json', method: 'PUT' }
        }
      },
      pageNations: {useClient: true, perPage: 10},
      searchContent: ''
    }
  },
  computed: {
  },
  methods: {
    onClickPage (page) {
    },
    onClickCell (data) {
      console.log(data)
    },
    searchPaging () {
      this.$refs.gridTable.searchPaging(this.searchContent)
    }
  },
  components: {
    tableToast
  }
}
</script>
<style scoped>

h6{
  text-align: left;
}
div.input-style{
    position: relative;
    text-align: left;
    background-color: white;
    margin-bottom: 10px;
    padding: 4px 0px 4px 16px;
    box-shadow: rgba(60, 64, 67, 0.3) 0px 1px 2px 0px, rgba(60, 64, 67, 0.15) 0px 1px 3px 1px;
}

div.input-style input.input-text {
    width: 50%;
    border-radius: 20px;
    border-width: 1px;
    border-style: none;
    padding-left: 10px;
    font-size: 12px;
    margin-bottom:5px;
}
.input-style .input-text:focus{
    outline-style: none;
}
.input-style button{
    outline: none;
    border-style: none;
    background-color: white;
}
.input-style button:focus{
    outline-style: none;
    border-style: none;
}
.right-area {
    background-color: white;
}
.form{
    padding: 10px 10px 10px 10px;
    display: flex;
    /* border: solid 1px; */
    background-color: white;
    justify-content: space-evenly;
    flex-wrap: wrap;
    flex-direction: row;
    margin-bottom: 10px;
}

div.content{
    padding: 10px;
    background-color: #f4f5f8;
    min-height: 80%;
}

</style>
