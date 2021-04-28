<template>
<div>
   <div class="recomend-area">
     <div class="content-area">
         <div class="best-couple-area">
            <div> d</div>
            <div> d</div>
            <div> d</div>
         </div>
     </div>
   </div>
     <div class="content-area">
       <div class="content-description">
          <h3>best 장소</h3>
          <hr>
       </div>
       <placeCard v-bind:list="msg"></placeCard>
     </div>
</div>
</template>

<script>
import placeCard from '@/components/place-card.vue'

export default {
  name: 'mainPage',
  data () {
    return {
      msg: '메인영역'
    }
  },
  components: {placeCard}
}

</script>

<style  scoped>
.best-couple-area{
  display: flex;
  flex-wrap: wrap;
  justify-content: center;
}
.best-couple-area > div{
  flex-grow: 0;
  height: 240px;
  flex-basis: 245px;
  border-radius: 10px;
 margin-top:20px;
margin-bottom:20px;
margin-left:10px;
margin-right:10px;
text-align: center;
background-color: white;
box-shadow: rgba(50, 50, 93, 0.25) 0px 2px 5px -1px, rgba(0, 0, 0, 0.3) 0px 1px 3px -1px;
transition: box-shadow 0.1s
}

.content-description{
  text-align: left;
  position: relative;
}
.content-description h3{
  margin-bottom: 0px;
}
.content-area {
  text-align: none;
  margin-top: 100px;
  width: 900px;
  margin: 0 auto;
}
.recomend-area{
  background-color: #ecf1fd;
  padding-top: 20px;
  padding-bottom:20px
}
@media (max-width: 767px){
  .content-area{
    width:100%;
  }
}
</style>
