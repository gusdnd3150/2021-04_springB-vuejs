<template>
  <div class="content">
        <div class="input-style">
                <span><f-icon :icon="['fas', 'search']" /></span>
                <input type="text" class="input-text" placeholder="전체 검색" name="searchContent">
        </div>

        <div class="row">
            <div class="col-sm-8">
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
            <div class="col-sm-4 col-lg-4">
                <div class="right-area">
                    weqwe
                </div>
            </div>
        </div>
  </div>
</template>

<script>
import tableToast from '@/components/tableToast.vue'
import { mapGetters, mapActions } from 'vuex'

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
    tableToast
  },
  mounted () {
    this.getBoard()
  }
}
</script>
<style scoped>

.input-style{
    position: relative;
    text-align: left;
    background-color: white;
    margin-bottom: 10px;
    padding: 4px 0px 4px 16px;
    box-shadow: rgba(0, 0, 0, 0.1) 0px 1px 3px 0px, rgba(0, 0, 0, 0.06) 0px 1px 2px 0px;
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
    background-color: #e9e9e9;
    min-height: 80%;
}
</style>
