
<template>
  <div class="left-sideBar">
      <ul class="list">
          <li><router-link to="/admin/modBoard">공지사항 관리 </router-link></li>
          <li><router-link to="/admin/menu">메뉴 관리 </router-link></li>
          <li><router-link to="/admin/users">유저 관리 </router-link></li>
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
