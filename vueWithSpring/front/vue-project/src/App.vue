<template>
  <div id="app">
    <router-view name="navi" />
    <router-view/>
    <router-view name="bottom" />
  </div>
</template>

<script>
export default {
  name: 'App'
}
</script>

<style>
@import url(http://fonts.googleapis.com/earlyaccess/notosanskr.css);
*{
  font-family: 'Noto Sans KR';
}

html{
  position: relative;
    min-height: 100%;
    margin: 0;
}
body{
  min-height: 100%;
}

#app {
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
  margin: 5px 5px 5px 5px;
  padding: 10px 15px 10px 15px;
  background: rgb(255,255,255);
  background: linear-gradient(90deg, rgba(255,255,255,1) 0%, rgba(255,255,255,1) 100%, rgba(16,175,207,1) 100%);
  color:blue;
  font-weight: bold;
  border-style: solid;
  border-color:blue;
}
</style>
