<template>
  <div class="grid-content">
    <div :style="this.width">
      <grid
            ref="tuiGrid"
            :data="this.selectData"
            :columns="this.headerData"
            :scrollX="this.scrollX"
            :scrollY="this.scrollY"
            :rowHeaders="['checkbox']"
            @click="onClick"
        ></grid>
    </div>

    <div id="paging">
       <paging
       :selectPage="this.selectPage"
       :total="this.total"
       :cntPerPage="this.cntPerPage"
       @propsFromPaging="emitSelectpage"
       />
    </div>
  </div>
</template>

<script>
import paging from '@/components/paging.vue'

export default {
  inheritAttrs: false,
  name: 'Exam3',
  components: {
    paging
  },
  methods: {
    emitSelectpage (page) {
      this.$emit('onClickPage', page)
    },
    onClick (event) {
      this.$emit('onClickCell', event.rowKey, event.value)
    },
    onCheckAll () {
      this.$refs.tuiGrid.invoke('destroy')
    }
  },
  props: {
    total: Number, /* 토탈 */
    selectData: Array, /* 리스트 */
    headerData: Array, /* 헤더 */
    selectPage: {type: Number, default: 1}, /* 선택페이지 */
    cntPerPage: {type: Number, default: 9}, /* 페이지당 보여줄 개수 */
    scrollX: {type: Boolean, default: true},
    scrollY: {type: Boolean, default: true},
    width: {type: String, default: 'width:auto'}
  },
  computed: {
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

</style>
