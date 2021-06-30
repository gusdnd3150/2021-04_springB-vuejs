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

html{  position: relative;    min-height: 100%;    margin: 0;}
body{  min-height: 100%;}

#app {  -webkit-font-smoothing: antialiased;  -moz-osx-font-smoothing: grayscale;  text-align: center;  color: #2c3e50;}

.button{ width: 80px;    height: 40px;    border: 2px solid #34495e;    float: left;    text-align: center;    cursor: pointer;    position: relative;
    -webkit-box-sizing: border-box;    box-sizing: border-box;    overflow: hidden;}
.button p{    font-size: 15px;    color: #34495e;    text-decoration: none;    line-height: 50px;    -webkit-transition: all .5s ease;
transition: all .5s ease;    z-index: 2;    position: relative;    top: -7px;    margin: 0;}

/*버튼 커스텀*/
.cust_button{ padding: 7px 20px 8px 20px;    background-color: #007bff;    border: none;    border-radius: 4px;    color: white;    font-weight: bold;    font-size: 15px; transition: all 0.2s;}
.cust_button:hover{cursor: pointer; opacity: 0.8;}

.eff{  width:140px;  height:50px;  left:-140px;  background:#34495e;  position:absolute;  transition:all .5s ease;  z-index:1;}
.button:hover .eff{  left:0;}
.button:hover p{  color:#fff;}
.content-area{  /*border:solid gray 1px;*/  padding-top: 20px;  padding-bottom:20px;  max-width: 900px;  text-align: center;  margin:0 auto;  position: relative;}
</style>
