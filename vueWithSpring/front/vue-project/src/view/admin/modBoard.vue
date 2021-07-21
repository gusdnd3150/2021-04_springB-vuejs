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
                  <input type="text" class="input-text" placeholder="전체 검색" name="searchContent">
          </div>

            <div class="input-style">
                  <tableToast
                  :selectData="this.getStoreBoard.result"
                  :headerData="this.headers"
                  :selectPage="this.getStoreBoard.selectPage"
                  :total="this.getStoreBoard.total"
                  :cntPerPage="this.getStoreBoard.cntPerPage"
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
import { mapGetters, mapActions } from 'vuex'
import sideBar from '@/components/admin_sideBar.vue'
import topBar from '@/components/admin_topNavi.vue'

const adminStore = 'adminStore'

export default {
  name: 'modTable',
  data () {
    return {
      headers: [
        {header: '번호', name: 'BOARD_NUM', sortingType: 'desc', sortable: true},
        {header: '제목', name: 'BOARD_TITLE', sortingType: 'desc', sortable: true},
        {header: '유저ID', name: 'USER_ID', sortingType: 'desc', sortable: true},
        {header: '내용', name: 'BOARD_CONTENT', sortingType: 'desc', sortable: true},
        {header: '등록일', name: 'BOARD_REG', sortingType: 'desc', sortable: true}
      ]
    }
  },
  computed: {
    ...mapGetters(adminStore, {getStoreBoard: 'GET_BOARD'})
  },
  methods: {
    ...mapActions(adminStore, {fnSelectBoardList: 'AC_SELECT_BOARD'}),

    onClickPage (page) {
      this.getBoard(page)
    },
    onClickCell (data) {
      console.log(data)
    },
    getBoard (page) {
      if (page === undefined || page === '' || page === null) { page = 1 }
      let formData = this.$commonJs.ConvertForm({selectPage: page})
      this.fnSelectBoardList(formData)
    }
  },
  components: {
    tableToast,
    sideBar,
    topBar
  },
  mounted () {
    this.getBoard()
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
