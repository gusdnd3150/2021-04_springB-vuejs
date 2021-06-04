<template>
<div>
    <div class="place">
        <div class="place-img">
          <img src="@/assets/sample9.jpg">
        </div>
        <div class="place-dscript">
          <p>2020-03-03</p>
        </div>
        <div class="place-content">
          <p>내용</p>
        </div>
    </div>
</div>
</template>

<script>
export default {
  name: 'place-card2',
  data () {
    return {
      checkLogin: this.$store.state.userToken.token === null,
      cardData: {}
    }
  }
}
</script>

<style scoped>
.place{
    min-height: 250px;
    box-shadow: rgba(0, 0, 0, 0.05) 0px 6px 24px 0px, rgba(0, 0, 0, 0.08) 0px 0px 0px 1px;
    flex-grow: 0;
    flex-basis: 200px;
    margin:0px 5px 30px 0px;
}

.place-dscript{
  height: 30px;
  padding: 2px 3px 2px 3px;
  background-color: #ecf1fd;
}
.place-dscript p{
  background-color: #ecf1fd;
  font-weight: bold;
  margin:0;
}
.place-img{
    width:250px;
    height:150px;
    overflow:hidden;
    margin:0 auto;
}
img{
  width:100%;
    height:100%;
    object-fit:cover;
}

</style>
