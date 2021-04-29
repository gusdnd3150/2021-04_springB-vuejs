<template>
 <div class="intro-area">
  <div>dd</div>
  <div>dd</div>
 </div>
</template>

<script>
export default {
  name: 'intro',
  data () {
    return {
      test: 'ff'
    }
  }
}
</script>

<style scoped>
.intro-area{
  display: flex;
  flex-wrap: wrap;
  background-color: gray;
  justify-content: center;
}
.intro-area > div{
  flex-basis:440px;
}

</style>
