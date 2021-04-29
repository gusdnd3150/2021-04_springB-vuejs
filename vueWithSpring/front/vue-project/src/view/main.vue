<template>
<div>
  <div class="banner-area">
      <div class="banner-left">
          <h2>MEET US</h2>
          <h3>커플일상 공유 사이트</h3>
         <p>다른 커플들에게 우리의 일상을 뽐내보고 우리들만의 비밀 아지트를 공유해 보아요!</p>
         <button>일상 업로드</button>
      </div>
      <div class="banner-right">
        <img src="@/assets/banner2.png">
      </div>
  </div>

  <div class="content-area">
    <intro />
  </div>

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
          <h3>BEST 커플</h3>
          <hr>
          <router-link to="/">더보기</router-link>
       </div>
       <coupleCard v-bind:bestCouple="msg"></coupleCard>
     </div>

     <div class="content-area">
       <div class="content-description">
          <h3>BEST 장소</h3>
          <hr>
          <router-link to="/">더보기</router-link>
       </div>
       <placeCard v-bind:list="msg"></placeCard>
     </div>
</div>
</template>

<script>
import placeCard from '@/components/place-card.vue'
import intro from '@/components/intro.vue'
import coupleCard from '@/components/couple-card.vue'

export default {
  name: 'mainPage',
  data () {
    return {
      msg: '메인영역'
    }
  },
  components: {placeCard, intro, coupleCard}
}

</script>

<style  scoped>
.banner-area{
  overflow-y: hidden;
  width:100%;
  background-color: #447eff;
  position: relative;
  min-height: 370px;
  max-height: 370px;
  display: flex;
  flex-wrap: wrap;
  justify-content: center;
}

.banner-right{
  flex-basis: 300px;
  text-align: left;
}
.banner-right img{
  max-width: 100%;
}
.banner-left{
  flex-basis: 300px;
  text-align: left;
  margin-top: auto;
  margin-bottom: auto;
}
.banner-left > p{
  color:white
}
.banner-left >h2{
  color:white;
  font-weight: 800;
  font-size: 35px;
}

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
  margin-top: 79px;
}
.content-description h3{
  margin-bottom: 0px;
}
.content-description > a{
    position: absolute;
    top: 8px;
    right: 10px;
    text-decoration: none;
    color: gray;
    font-weight: 600;
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
  .banner-left{
  flex-basis: 100%;
  text-align: center;
  }
}
</style>
