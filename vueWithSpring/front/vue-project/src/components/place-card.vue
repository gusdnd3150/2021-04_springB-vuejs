<template>
     <div class="best-place-area">
           <div class="best-place-card">
             <div class="card-top">
              <div class="img-box">
               <img src="images/noneImg.png">
              </div>
                <p>gusdnd3150</p>
             </div>
             <div class="card-middle">
               <p>[짝궁] 정민</p>
               <p>[장소] 가평군</p>
             </div>
             <hr>
            <div class="card-bottom">
              <a>#가평</a><a>#물놀이</a>
            </div>
           </div>
           <div class="best-place-card">
             <div class="card-top">
              <div class="img-box">
               <img src="images/noneImg.png">
              </div>
                <p>gusdnd3150</p>
             </div>
             <div class="card-middle">
               <p>[짝궁] 정민</p>
               <p>[장소] 가평군</p>
             </div>
             <hr>
            <div class="card-bottom">
              <a>#가평</a><a>#물놀이</a>
            </div>
           </div>
           <div class="best-place-card">
             <div class="card-top">
              <div class="img-box">
               <img src="images/noneImg.png">
              </div>
                <p>gusdnd3150</p>
             </div>
             <div class="card-middle">
               <p>[짝궁] 정민</p>
               <p>[장소] 가평군</p>
             </div>
             <hr>
            <div class="card-bottom">
              <a>#가평</a><a>#물놀이</a>
            </div>
           </div>
        </div>
</template>

<script>
export default {
  name: 'card-place',
  props: ['list']
}
</script>

<style scoped>

.best-place-area{
  display: flex;
  flex-wrap: wrap;
  justify-items: center;
}
.img-box{
  width: 60px;
  border-radius: 50%;
}

img {
  max-width: 100%;
  height: auto !important;
}

.best-place-area > div{
 flex-grow: 0;
 height: 240px;
flex-basis: 190px;
border-style: solid;
 border-width: 2px;
border-color: #ecf1fd;
background-color: blue;
 margin-top:20px;
margin-bottom:20px;
margin-left:10px;
margin-right:10px;
text-align: center;
background-color: white;
transition: box-shadow 0.1s
}
.best-place-card{
    padding: 10px 4px 10px 4px;
    text-align: left;
}
.card-top{
  position: relative;
  display: flex;
  flex-wrap: nowrap;
}
.card-top p{
  font-weight: bold;
}
.card-middle{
  text-align: left;
}
.card-middle p{
  color:gray;
  font-size: 14px;
}
.card-bottom{
  text-align: left;
}
.card-bottom a{
  background-color: #ffe2ed;
  padding: 1px 5px 1px 5px;
  border-style:solid;
  margin-right: 8px;
  border-width: 1px;
  color: gray;
  font-size: 14px;
  box-shadow: rgba(50, 50, 93, 0.25) 0px 2px 5px -1px, rgba(0, 0, 0, 0.3) 0px 1px 3px -1px;
}
</style>
