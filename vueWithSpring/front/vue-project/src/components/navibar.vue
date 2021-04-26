<template>
   <div class="navigation">
       <div>
           <router-link to="/">홈</router-link>
       </div>
       <div>
           <ul class="navigation-link">
               <li> <router-link to="/story">story</router-link></li>
               <li> <router-link to="/best">베스트</router-link></li>
               <li> <router-link to="/feed">피드</router-link></li>
           </ul>
       </div>
       <div><router-link to="/login">Login</router-link></div>
   </div>
</template>

<script>
export default {
  name: 'navibar'
}
</script>

<style scoped>

a{
    color:black !important;
    text-decoration: none;
}

.navigation{
    width: auto;
    display: flex;
    flex-wrap: wrap;
    align-items: center;
    justify-content: space-around;
    padding: 20px;
    margin-bottom: 20px;
}

.navigation-link{
    margin: 0px;
    list-style: none;
    padding-left: 0px;
    display: flex;
    flex-wrap: nowrap;
    justify-content: space-evenly;
}
.navigation-link > li{
    height: 24px;
    margin-right: 30px;
    margin-left: 10px;
    font-weight: bold;
    border-bottom-style: solid;
    border-color: white;
}

.navigation-link > li:hover{
    border-color: red;
    border-bottom-style: solid;
}
@media (max-width: 750px) {
  .navigation{
      width: 86%;
      display: flex;
      flex-direction: column;
  }
  .navigation div{
      padding-top: 20px;
      padding-bottom: 20px;
  }
  .navigation-link{
      flex-direction: column;
  }
  .navigation-link > li{
    margin: 0px;
    padding: 10px 0px 10px 0px;
  }

}

</style>
