<template>
  <div id="app">
    <router-view name="navi" />

        <router-view id="main-content"/>

    <!-- <router-view name="bottom" /> -->
  </div>
</template>

<script>

export default {
  name: 'App'
}
</script>

<style>
@import './css/main.css';
html, body{
  height: 100%;
  width: 100%;
}
#app{
  height: 100%;
}
#main-content{
  height: 100%;
}
</style>
