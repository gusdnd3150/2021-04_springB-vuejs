<template>
  <div id="intro-area">
    <h2>공지사항</h2>
    <vue-glide :perView="1" :peek="peek" :autoplay="autoplay">
      <vue-glide-slide v-for="i in 10" :key="i">
            <div class="board-content">
           </div>
      </vue-glide-slide>
      <template slot="control">
        <button class="left-button" data-glide-dir="<">prev</button>
        <button class="right-button" data-glide-dir=">">next</button>
      </template>
    </vue-glide>
  </div>
</template>

<script>
import { Glide, GlideSlide } from 'vue-glide-js'

export default {
  components: {
    [Glide.name]: Glide,
    [GlideSlide.name]: GlideSlide
  },
  data(){
    return{
      autoplay: 5000,
      peek:{before: 50, after:50}
    }
  }
}
</script>
<style scoped>

.intro-area{
  position: relative;
  
}

li .glide__slide{
  margin: 0px !important;
}
.board-content{
  min-height: 240px;
  border-radius: 4px;
  border-style: solid;
  border-width: 1px;
  border-color: gray;
  margin:0px 0px 0px 0px;
text-align: center;
background-color: white;
transition: box-shadow 0.1s
}

.left-button{
  position: absolute;
   left: -36px;
    top: 110px;
}
.right-button{
   position: absolute;
    right: -36px;
    top: 110px;
}
@media (max-width:750px){
  .left-button{
    display: none;
  }
  .right-button{
    display: none;
  }
}

</style>
