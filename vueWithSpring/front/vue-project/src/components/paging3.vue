<template>
 <div>  토탈페이지:{{totalPages }} 시작페이지: {{startPage}}  끝페이지 {{endPage}}

<ul class="pagination">
    <li class="page-item prev-page">
      <a class="page-link" @click="prevPage">
        <span v-if="withText">Prev</span>
      </a>
    </li>

    <li class="page-item" v-for="item in range(startPage, endPage)" :key="item" :class="{ active: selectPage === item }">
      <a class="page-link" @click="changePage(item)">{{ item }}</a>
    </li>

    <li class="page-item page-pre next-page" >
      <a class="page-link"  @click="nextPage">
        <span v-if="withText">Next</span>
      </a>
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
    onePerPage: {
      type: Number,
      default: 10
    },
    perPage: {
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
      return Math.ceil((this.total - 1) / this.perPage)
    },
    startPage () {
      return Math.floor(((this.selectPage - 1) / this.perPage) * this.perPage + 1)
    },
    endPage () {
      let end = Math.floor(this.startPage * this.totalPages)
      if (end < this.totalPages) {
        end = this.totalPages
      }
      return end
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
      if (this.value < this.totalPages) {
        this.$emit('propsFromPaging', this.selectPage + 1)
      }
    },
    prevPage () {
      if (this.value > 1) {
        this.$emit('propsFromPaging', this.selectPage - 1)
      }
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
