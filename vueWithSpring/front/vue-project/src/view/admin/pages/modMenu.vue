<template>
  <div class="">
          <h6>메뉴 관리</h6>
          <div class="input-style">
                  <span><f-icon :icon="['fas', 'search']" /></span>
                  <input type="text" class="input-text" placeholder="전체 검색" name="searchContent" >
                  <button class="main_button" @click="searchPaging">검색</button>
          </div>

          <div class="input-style">
                  <tableToast
                  ref="gridTable"
                  :dataSource="dataSource"
                  :headerData="headers"
                  :pageOptionsProp="pageNations"
                  :bodyHeight="600"
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
  name: 'modTable',
  data () { /* 2021/07/23  리퀘스트 테스트 도중  */
    return {
      headers: [
        {header: 'depth1',
          name: 'LEVEL1',
          editor: 'text',
          _attributes: {
            className: {
            // Add class name on each columns
              column: {
                type: ['blue'],
                genre: ['blue']
              }
            }
          }},
        {header: 'depth2', name: 'LEVEL2', editor: 'text'},
        {header: 'depth3', name: 'LEVEL3', editor: 'text', hidden: true},
        {header: '사용여부', name: 'USE_YN', editor: {type: 'select', options: {listItems: [ { text: '사용', value: 'Y' }, { text: '비활성화', value: 'N' } ]}}},
        {header: '아이콘', name: 'MENU_ICON', editor: 'text'},
        {header: '컴포넌트', name: 'COMPONENT_CD', editor: 'text'},
        {header: '메뉴권한', name: 'MENU_AUHTO', editor: 'text'},
        {header: '메뉴코드', name: 'MENU_CD'},
        {header: 'url', name: 'MENU_URL'}
      ],
      dataSource: {
        contentType: 'application/json',
        headers: { 'Access-Control-Allow-Origin': '*' },
        initialRequest: true,
        initParams: {params: 'test'},
        api: {
          readData: { url: 'http://localhost:8050/api/getAppMenuList.json', method: 'GET' },
          deleteData: { url: 'http://localhost:8050/api/deleteBoard.json', method: 'POST' },
          updateData: { url: 'http://localhost:8050/api/updateBoard.json', method: 'PUT' }
          // createData: { url: 'http://localhost:8050/api/create', method: 'POST' }
        }
      }
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
