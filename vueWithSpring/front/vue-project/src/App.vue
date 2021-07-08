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
@import './css/main.css';
</style>
