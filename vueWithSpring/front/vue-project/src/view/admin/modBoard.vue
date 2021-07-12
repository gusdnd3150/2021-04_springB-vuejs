<template>
  <div class="content">
      <tableToast
      :selectData="this.getStoreBoard.result"
      :headerData="this.headers"
      :selectPage="this.getStoreBoard.selectPage"
      :total="this.getStoreBoard.total"
      :cntPerPage="this.getStoreBoard.cntPerPage"
      @tableToastPage="onSelectPage"
       />
  </div>
</template>

<script>
import tableToast from '@/components/tableToast.vue'
import { commonUtil } from '@/jsUtil/commonUtil.js'
import { mapGetters, mapActions } from 'vuex'

const adminStore = 'adminStore'

export default {
  name: 'modTable',
  data () {
    return {
      headers: [
        {header: '번호', name: 'BOARD_NUM'},
        {header: '제목', name: 'BOARD_TITLE'},
        {header: '유저ID', name: 'USER_ID'},
        {header: '내용', name: 'BOARD_CONTENT'},
        {header: '등록일', name: 'BOARD_REG'}
      ]
    }
  },
  computed: {
    ...mapGetters(adminStore, {getStoreBoard: 'GET_BOARD'})
  },
  methods: {
    ...mapActions(adminStore, {fnSelectBoardList: 'AC_SELECT_BOARD'}),

    onSelectPage (page) {
      this.getBoard(page)
    },
    getBoard (page) {
      if (page === undefined || page === '' || page === null) { page = 1 }
      let formData = commonUtil.ConvertForm({selectPage: page})
      this.fnSelectBoardList(formData)
    }
  },
  components: {
    tableToast
  },
  created: function () {
    this.getBoard()
  }
}
</script>
<style scoped>

</style>
