<template>
  <div id="app">
    <router-view name="navi" />
    <div class="content-area">
    <router-view/>
    </div>
  </div>
</template>

<script>
export default {
  name: 'App'
}
</script>

<style>

.content-area{
  margin-top: 100px;
  width: 800px;
  margin: 0 auto;
}

#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}
button{
  margin: 5px 5px 5px 5px;
  padding: 10px 15px 10px 15px;
  background: rgb(255,255,255);
background: linear-gradient(138deg, rgba(255,255,255,1) 6%, rgba(16,175,207,1) 65%, rgba(255,255,255,1) 100%);
  color:white;
  font-weight: bold;
  border-style: none;
  border-radius: 5px;
  transition: all 0.4s;
}
button:hover{
  background: rgb(255,255,255);
  background: linear-gradient(90deg, rgba(255,255,255,1) 0%, rgba(255,255,255,1) 100%, rgba(16,175,207,1) 100%);
  color:blue;
  font-weight: bold;
  border-style: solid;
  border-width: 1px;
  border-color:blue;
}

@media (max-width: 767px){
  .content-area{
    width:100%;
  }
}
</style>
