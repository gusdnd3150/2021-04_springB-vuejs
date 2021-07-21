<template>
  <div>
      <div class="top-navi">
          <div class=""><span>기준정보</span></div>
          <div>시스템</div>
          <div></div>
      </div>
  </div>
</template>

<script>
export default {
  name: 'topNavi',
  data () {
    return {
      style: 'active'
    }
  }
}
</script>

<style>
.top-navi{
    display: flex;
    justify-content: flex-end;
    list-style: none;
    padding: 0;
    margin: 0;
    border: solid 1px;
    border-color: #4b6fcf;
}
.top-navi > div{
    min-width: 100px;
    min-height: 60px;
    max-height: 60px;
    display: inline;
    -webkit-transition: all 0.1s;
    transition: all 0.1s;
    border-left: solid 1px;
    border-color: #4b6fcf;
}

.top-navi > div:hover{
    cursor: pointer;
    opacity: 0.8;
    background-color: #4b6fcf;
    color:white
}
</style>
