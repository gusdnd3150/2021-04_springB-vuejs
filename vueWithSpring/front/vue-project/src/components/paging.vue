<template>
 <div>
     {{ '페이지끝마지막 페이지'+calLast_page }}
     {{ '시작 페이지'+calStart_page }}
     {{ '마지막 페이지'+calEnd_page }}
 </div>
</template>

<script>
export default {
  name: 'main',
  data () {
    return {
      msg: '페이징'
    }
  },
  props: {
    current_page: {
      type: Number,
      default: 1
    },
    total_count: {
      type: Number,
      default: 0
    },
    cntPer_page: {
      type: Number,
      default: 20
    },
    nowPage: {
      type: Number,
      default: 1
    }
  },
  computed: {
    calLast_page: function () {
      var temp = 0
      temp = Math.ceil((this.total_count / this.cntPer_page))
      console.log('calLast_page' + temp)
      return temp
    },
    calEnd_page: function () {
      var temp = 0
      temp = Math.ceil((this.nowPage / this.cntPer_page) * this.cntPer_page)
      if (this.calLast_page < temp) {
        temp = this.calLast_page
      }
      console.log('calEnd_page' + temp)
      return temp
    },
    calStart_page: function () {
      var temp = 0
      temp = this.calEnd_page - this.cntPer_page + 1
      if (temp < 1) {
        temp = 1
      }
      console.log('calStart_page' + temp)
      console.log('calStart_page' + this.nowPage)
      return temp
    }
  }
}
</script>

<style scoped>

</style>
