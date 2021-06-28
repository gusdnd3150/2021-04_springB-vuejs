<template>
 <div>  토탈페이지:{{totalPages }} 시작페이지: {{startPage}}  끝페이지 {{endPage}}

<ul class="pagination">
    <li class="page-item prev-page"  v-if="startPage != 1">
      <a class="page-link" @click="prevPage"><span>Prev</span></a>
    </li>

    <li class="page-item" v-for="item in range(startPage, endPage)" :key="item" :class="{ active: selectPage === item }">
      <a class="page-link" @click="changePage(item)">{{ item }}</a>
    </li>

    <li class="page-item page-pre next-page"   v-if="endPage != lastPage">
      <a class="page-link"  @click="nextPage"><span>Next</span></a>
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
    range (min, max) {
      let arr = []
      for (let i = min; i <= max; i++) {
        arr.push(i)
      }
      return arr
    },
    changePage (item) {
      this.$emit('propsFromPaging', item)
    },
    nextPage () {
      this.$emit('propsFromPaging', this.endPage + 1)
    },
    prevPage () {
      this.$emit('propsFromPaging', this.startPage - 1)
    }
  }
}
</script>
<style scoped>
ul{ list-style: none; display: flex; flex-wrap: wrap; justify-content:center;}
ul li{ font-size: 10px; margin:0 2px 0 2px }
ul li:hover{cursor: pointer; opacity: 0.8;}
.active{opacity: 0.9; color:red}

</style>
