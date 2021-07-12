<template>
<div>
  <grid
        ref="tuiGrid2"
        :data="this.selectData"
        :columns="this.headerData"
        :scrollX="this.scrollX"
        :scrollY="this.scrollY"
    ></grid>

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
      this.$emit('tableToastPage', page)
    }
  },
  props: {
    selectPage: Number, /* 선택페이지 */
    total: Number, /* 토탈 */
    cntPerPage: {type: Number, default: 9}, /* 페이지당 보여줄 개수 */
    selectData: Array, /* 리스트 */
    headerData: Array, /* 헤더 */
    scrollX: {type: Boolean, default: false},
    scrollY: {type: Boolean, default: false}
  },
  computed: {
  }
}
</script>
