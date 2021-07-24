<template>
  <div>
    <topBar />
    <div class="row" style="height:100%">
      <div class="col-lg-2" style="padding-right:0">    <!-- 사이드바 -->
        <sideBar />
      </div>

      <div class="col-lg-10 content">   <!-- 컨텐츠 -->

        <div class="container">

          <h6>공지사항 관리</h6>
          <div class="input-style">
                  <span><f-icon :icon="['fas', 'search']" /></span>
                  <input type="text" class="input-text" placeholder="전체 검색" name="searchContent" v-model="searchContent">
                  <button @click="searchPaging">검색 테스트</button>
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
      </div>

    </div>
  </div>
</template>

<script>
import tableToast from '@/components/tableToast.vue'
import sideBar from '@/components/admin_sideBar.vue'
import topBar from '@/components/admin_topNavi.vue'

export default {
  name: 'modTable',
  data () { /* 2021/07/23  리퀘스트 테스트 도중  */
    return {
      headers: [
        {header: '번호', name: 'BOARD_NUM', sortingType: 'desc', sortable: true, width: 20, hidden: true},
        {header: '제목', name: 'BOARD_TITLE', sortingType: 'desc', sortable: true, editor: 'text'},
        {header: '내용', name: 'BOARD_CONTENT', sortingType: 'desc', sortable: true, editor: 'text'},
        {header: '유저ID', name: 'USER_ID', sortingType: 'desc', sortable: true},
        {header: '등록일', name: 'BOARD_REG', sortingType: 'desc', sortable: true},
        {header: '수정일',
          name: 'BOARD_UPD',
          sortingType: 'desc',
          sortable: true,
          editor: {
            type: 'datePicker',
            options: {
              format: 'yyyy-MM-dd HH:mm',
              timepicker: true
            }
          }}
      ],
      dataSource: {
        contentType: 'application/json',
        headers: { 'Access-Control-Allow-Origin': '*' },
        initialRequest: true,
        initParams: {params: 'test'},
        api: {
          readData: { url: 'http://localhost:8050/api/selectBoardList.json', method: 'GET' },
          deleteData: { url: 'http://localhost:8050/api/deleteBoard.json', method: 'POST' },
          updateData: { url: 'http://localhost:8050/api/updateBoard.json', method: 'PUT' }
          // createData: { url: 'http://localhost:8050/api/create', method: 'POST' }
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
      this.getBoard(page)
    },
    onClickCell (data) {
      console.log(data)
    },
    searchPaging () {
      this.$refs.gridTable.searchPaging(this.searchContent)
    }
  },
  components: {
    tableToast,
    sideBar,
    topBar
  }
}
</script>
<style scoped>

h6{
  text-align: left;
}
.input-style{
    position: relative;
    text-align: left;
    background-color: white;
    margin-bottom: 10px;
    padding: 4px 0px 4px 16px;
    box-shadow: rgba(60, 64, 67, 0.3) 0px 1px 2px 0px, rgba(60, 64, 67, 0.15) 0px 1px 3px 1px;
}

.input-style .input-text {
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

.content{
    padding: 10px;
    background-color: #f4f5f8;
    min-height: 80%;
}
</style>
