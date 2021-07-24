<template>
  <div class="grid-content">
    <div :style="width">
      <grid
            ref="tuiGrid"
            :data="dataSource"
            :columns="headerData"
            :scrollX="scrollX"
            :scrollY="scrollY"
            :rowHeaders="['checkbox']"
            :pageOptions="pageOptionsProp"
            :bodyHeight="bodyHeight"
            @click="onClick"
            @response="afterResponse"
        ></grid>
    </div>
    <div class="button-area">
      <button v-if="useUpdateButton" @click="onApiUpdateRow">수정</button>
      <button v-if="useDeleteButton && !showDelete" @click="onDeleteRow">삭제</button>
      <button v-if="showDelete" @click="onApiDeleteRow">삭제 저장</button>
    </div>
  </div>
</template>

<script>

export default {
  inheritAttrs: false,
  name: 'Exam3',
  data () {
    return {
      showDelete: false
    }
  },
  mounted () {
    this.onLoadFunction()
  },
  methods: {
    emitSelectpage (page) {
      this.$emit('onClickPage', page)
    },
    onClick (event) { /* 클릭 CELL */
      this.$emit('onClickCell', event.rowKey, event.value)

      // console.log(event.instance.getCheckedRows())
      const { rowKey, columnName } = event.instance.getFocusedCell()
      event.instance.finishEditing(rowKey, columnName)
    },
    onCheckAll () {
      this.$refs.tuiGrid.invoke('destroy')
    },
    onDeleteRow (event) { /* 그리드에서만 삭제 */
      // this.$refs.tuiGrid.invoke('removeRow', event.rowKey)
      let checkrow = this.$refs.tuiGrid.gridInstance.getCheckedRows()
      // console.log(checkrow)
      if (checkrow.length === 0) {
        alert('체크 후 삭제 가능')
        return
      }
      this.$refs.tuiGrid.gridInstance.removeCheckedRows()

      this.showDelete = true
    },
    onApiDeleteRow () { /* api 주소를 토대로 서버에 삭제 데이터 전송 */
      this.$refs.tuiGrid.gridInstance.request('deleteData')
      // event.instance.request('deleteData', {checkedOnly: false})
    },
    onApiUpdateRow () { /* api 주소를 토대로 서버에 업데이트 데이터 전송 */
      if (this.$refs.tuiGrid.gridInstance.getModifiedRows().updatedRows.length !== 0) {
        this.$refs.tuiGrid.gridInstance.request('updateData', {modifiedOnly: true})
      } else {
        alert('데이터 변경이 없습니다.')
      }
    },
    searchPaging (content) { /* 검색 함수 */
      this.$refs.tuiGrid.invoke('readData', 1, {searchContent: content})
    },
    onLoadFunction () {
      // this.$refs.tuiGrid.gridInstance.on('successResponse', this.select())
    },
    afterResponse (event) {
      // console.log(event.xhr.responseURL)
      if (event.xhr.responseURL.indexOf('update') > 0) {
        event.instance.reloadData()
      }
    }
  },
  props: {
    dataSource: Object, /* api 정보 */
    headerData: Array, /* 헤더 */
    pageOptionsProp: Object,
    params: Object,
    scrollX: {type: Boolean, default: true},
    scrollY: {type: Boolean, default: true},
    width: {type: String, default: 'width:auto'},
    bodyHeight: {type: Number, default: 300},
    useDeleteButton: {type: Boolean, default: true},
    useUpdateButton: {type: Boolean, default: true}
  }
}
</script>
<style scoped>
.grid-content{
  background-color: white;
  box-shadow: rgba(0, 0, 0, 0.1) 0px 1px 3px 0px, rgba(0, 0, 0, 0.06) 0px 1px 2px 0px;
}
#paging{
  width:100%
}

.hide{
  display: none;
}

.button-area{
    text-align: right;
    padding: 0px 5% 2% 0px;
}
button{
    background-color: #4b96e6;
    color: white;
    outline: none;
    font-size: 11px;
    font-weight: 400;
    border: 0;
    padding: 8px 14px 8px 14px;
    border-radius: 7px;
    transition: all 0.2s;
}
button:hover{
  opacity: 0.8;
}
</style>
