<template>
 <div>
 <!-- 토탈페이지:{{totalPages }} 시작페이지: {{startPage }} 끝:{{endPage}} 앤드:{{lastPage}} 토탈: {{total}}  -->
  <ul class="pagination">
    <li class="page-item prev-page"  @click="prevPage" v-if="startPage != 1">
      <a class="page-link" ><span class="page-text">이전</span></a>
    </li>

    <li class="page-item" @click="changePage(item)" v-for="item in range(startPage, endPage)" :key="item" :class="{ active: selectPage === item }">
      <a class="page-link" >{{ item }}</a>
    </li>

    <li class="page-item page-pre next-page"  @click="nextPage"  v-if="endPage != lastPage">
      <a class="page-link" ><span class="page-text">다음</span></a>
    </li>
  </ul>

 </div>
</template>

<script>
export default {
  name: 'pagination',
  props: {
    withText: Boolean,
    noArrows: Boolean,
    pageCount: {
      type: Number,
      default: 0
    },
    cntPage: {
      type: Number,
      default: 6
    },
    cntPerPage: {
      type: Number,
      default: 10
    },
    total: {
      type: Number,
      default: 1
    },
    selectPage: {
      type: Number,
      default: 1
    }
  },
  computed: {
    totalPages () {
      return Math.ceil((this.total - 1) / this.cntPage)
    },
    startPage () {
      let start = Math.floor(this.endPage - this.cntPage + 1)
      if (start < 1) {
        start = 1
      }
      return start
    },
    endPage () {
      let end = Math.ceil(this.selectPage / this.cntPage) * this.cntPage
      console.log(end)
      if (this.lastPage < end) {
        end = this.lastPage
      }
      return end
    },
    lastPage () {
      return Math.ceil(this.total / this.cntPerPage)
    }
  },
  data () {
    return {
      defaultPagesToDisplay: 5
    }
  },
  methods: {
    scrollUp () {
      window.scrollTo(0, 0)
    },
    range (min, max) {
      let arr = []
      for (let i = min; i <= max; i++) {
        arr.push(i)
      }
      return arr
    },
    changePage (item) {
      this.$emit('propsFromPaging', item)
      this.scrollUp()
    },
    nextPage () {
      this.$emit('propsFromPaging', this.endPage + 1)
      this.scrollUp()
    },
    prevPage () {
      this.$emit('propsFromPaging', this.startPage - 1)
      this.scrollUp()
    }
  }
}
</script>
<style scoped>
.pagination{ list-style: none; display: flex; flex-wrap: wrap; justify-content:center;}
.pagination li{ font-size: 15px; margin:0 4px 0 2px ; padding: 5px 10px 5px 10px; transition: all 0.4s; }
.pagination li:hover{cursor: pointer; opacity: 0.8; border-bottom: solid; border-width: 1px; border-radius: 5px;}
.active{opacity: 0.9; color:white; background-color: navy; border-radius: 5px;}
.next-page, .prev-page{font-size: 7px !important; font-weight: bold;padding-top:8px !important; box-shadow: rgba(0, 0, 0, 0.05) 0px 6px 24px 0px, rgba(0, 0, 0, 0.08) 0px 0px 0px 1px;}
</style>
