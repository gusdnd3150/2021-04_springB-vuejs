
<template>
  <div class="left-sideBar">
      <ul class="list">
          <li>게시판 관리</li>
          <li>유저 관리</li>
      </ul>
  </div>
</template>

<script>
export default {
  name: 'sideBar'
}
</script>

<style scoped>

.list{
    color: white;
    list-style: none;
    padding: 0;
    margin: 0;
}
.list > li {
    text-align: left;
    padding-left: 10px;
}
.list > li:hover{
    cursor: pointer;
}
.left-sideBar{
    background-color: #2d3753;
    height: 100%;
    padding-top: 20px;
    padding-bottom: 16px;
}
</style>
