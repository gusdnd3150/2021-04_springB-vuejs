<template>
   <div class="navigation">
       <div>
           <router-link to="/">홈</router-link>

       </div>
       <div>
           <ul class="navigation-link">
               <li>피드</li>
               <li>피드</li>
               <li>피드</li>
           </ul>
       </div>
       <div>로그인</div>
   </div>
</template>

<script>
export default {
  name: 'navibar'
}
</script>

<style scoped>

.navigation{
    display: flex;
    flex-wrap: wrap;
    justify-content: space-around;
    box-shadow: rgba(0, 0, 0, 0.16) 0px 3px 6px, rgba(0, 0, 0, 0.23) 0px 3px 6px;
    padding: 20px;
    margin-bottom: 20px;
}

.navigation-link{
    list-style: none;
    padding-left: 0px;
    display: flex;
    flex-wrap: nowrap;
    justify-content: space-evenly;
}
.navigation-link > li{
    flex-basis: 200px;
}
</style>
