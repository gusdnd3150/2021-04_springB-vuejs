<template>
  <div class="best-couple-area">
    <div class="couple-card">
        <div class="img-box">
          <img src="@/assets/sample8.png">
        </div>
        <div class="card-cover">a
        </div>
        <div class="card-content">
          <p>사귄날짜, 디데이</p>
        </div>
        <div class="balloon">
          <p>내꺼내꺼니꺼내꺼</p>
          <div class="balloon-arrow"></div>
        </div>
    </div>
    <div class="couple-card">
        <div class="img-box">
          <img src="@/assets/sample7.png">
        </div>
        <div class="card-cover">
        </div>
        <div class="card-content">
          <p>사귄날짜, 디데이</p>
        </div>
        <div class="balloon">
          <p>콩판</p>
          <div class="balloon-arrow"></div>
        </div>
    </div>
    <div class="couple-card">
        <div class="img-box">
          <img src="@/assets/sample6.png">
        </div>
        <div class="card-cover">
        </div>
        <div class="card-content">
          <p>사귄날짜, 디데이</p>
        </div>
        <div class="balloon">
          <p>콩판</p>
          <div class="balloon-arrow"></div>
        </div>
    </div>
    <div class="couple-card">
        <div class="img-box">
          <img src="@/assets/sample5.png">
        </div>
        <div class="card-cover">
        </div>
        <div class="card-content">
          <p>사귄날짜, 디데이</p>
        </div>
        <div class="balloon">
          <p>늙은곰</p>
          <div class="balloon-arrow"></div>
        </div>
    </div>
    <div class="couple-card">
        <div class="img-box">
          <img src="@/assets/sample8.png">
        </div>
        <div class="card-cover">
        </div>
        <div class="card-content">
          <p>사귄날짜, 디데이</p>
        </div>
        <div class="balloon">
          <p>내꺼내꺼니꺼내꺼</p>
          <div class="balloon-arrow"></div>
        </div>
    </div>
    <div class="couple-card">
        <div class="img-box">
          <img src="@/assets/sample7.png">
        </div>
        <div class="card-cover">
        </div>
        <div class="card-content">
          <p>사귄날짜, 디데이</p>
        </div>
        <div class="balloon">
          <p>콩판</p>
          <div class="balloon-arrow"></div>
        </div>
    </div>
    <div class="couple-card">
        <div class="img-box">
          <img src="@/assets/sample6.png">
        </div>
        <div class="card-cover">
        </div>
        <div class="card-content">
          <p>사귄날짜, 디데이</p>
        </div>
        <div class="balloon">
          <p>콩판</p>
          <div class="balloon-arrow"></div>
        </div>
    </div>
    <div class="couple-card">
        <div class="img-box">
          <img src="@/assets/sample5.png">
        </div>
        <div class="card-cover">
        </div>
        <div class="card-content">
          <p>사귄날짜, 디데이</p>
        </div>
        <div class="balloon">
          <p>늙은곰</p>
          <div class="balloon-arrow"></div>
        </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'couple-card',
  data () {
    return {
      name: 'dd'
    }
  },
  props: ['bestCouple']
}
</script>

<style scoped>
.best-couple-area{
  display: flex;
  flex-wrap: wrap;
  justify-items: center;
}

.best-couple-area > div{
 flex-grow: 0;
 height: 240px;
flex-basis: 190px;
border-style: solid;
 border-width: 2px;
border-color: #ecf1fd;
background-color: blue;
 margin-top:20px;
margin-bottom:38px;
margin-left:10px;
margin-right:10px;
text-align: center;
background-color: white;
transition: box-shadow 0.1s
}
.couple-card{
  justify-content: center;
  position: relative;
  transition: all 0.6s;
}
.couple-card:hover .card-cover{
  opacity: 0.3;
}
.card-cover > *{
 color:white;
 opacity: 1 !important;
}
.card-content{
  position: absolute;
  top: auto;
  left: auto;
  opacity: 0;
  transition: all 0.2s;
}
.couple-card:hover .card-content{
  opacity: 1;
  top:0;
  left:20%
}
.card-content > *{
  color:white
}
.img-box{
  height: 100%;
  width: 100%;
  position: relative;
}
.card-cover{
  position: absolute;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    background-color: black;
    opacity: 0;
    transition: all 0.3s;
}
img {
  max-width: 100%;
  position: absolute; top:0; left: 0;
  width: 100%;
  height: 100%;
  border-radius: 7px;
  box-shadow: rgb(50 50 93 / 25%) 0px 2px 5px -1px, rgb(0 0 0 / 30%) 0px 1px 3px -1px;
}

.balloon{
    position: relative;
    width: 100%;
    background-color: #1e90ff;
    border-radius: 17px;
    -webkit-box-shadow: 0px 0px 4px rgb(0 0 0 / 12%);
    box-shadow: 0px 0px 4px rgb(0 0 0 / 12%);
    margin-top: 15px;
    padding: 1px 2px 3px 4px;
}
.balloon-arrow{
    position: absolute;
    background-color:#1e90ff;
    width: 10px;
    height: 10px;
    -webkit-transform: rotate(-45deg);
    top: -5px;
    right: 147px;
    box-shadow: 0px 0px 4px rgb(0 0 0 / 12%);
    z-index: -1;
}

.balloon > p{
    color: white;
    padding: 0px 2px 0px 2px;
    margin: 3px;
    font-size: 13px;
}
@media (max-width:750px){
  .best-couple-area > div{
    flex-basis: 100%;
    margin-bottom: 60px;
  }
  .balloon{
    position: relative;
    /* width: 180px; */
    background-color: #1e90ff;
    border-radius: 4px;
    -webkit-box-shadow: 0px 0px 4px rgb(0 0 0 / 12%);
    box-shadow: 0px 0px 4px rgb(0 0 0 / 12%);
    margin-top: 15px;
    padding: 1px 2px 3px 4px;
  }
}
</style>
