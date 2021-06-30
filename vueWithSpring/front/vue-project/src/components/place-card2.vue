<template>
<div>
    <div class="place">
        <div class="place-img">
          <img src="@/assets/sample9.jpg">      <!-- 이미지 {{cardData.img}}-->
        </div>
        <div class="place-dscript">           <!-- 유저정보 {{cardData.region}} {{cardData.date}}-->
          <p class="dscrip-region">{{region}}</p>
          <p class="dscrip-date">{{regDate}}</p>
        </div>
        <div class="place-content">              <!-- 내용 {{cardData.title}}-->
          <p class="content-title">{{title}}</p>
        </div>
        <div class="place-detail">   <!-- 내용 {{cardData.totalPrice}}-->
          <p class="detail-price">총 경비 : {{cost}}</p>
        </div>
    </div>
</div>
</template>

<script>
export default {
  name: 'place-card2',
  props: {
    content: {
      type: String,
      required: false
    },
    title: {
      type: String,
      required: false
    },
    cost: {
      type: Number,
      required: false
    },
    regDate: {
      type: String,
      required: false
    },
    userId: {
      type: String,
      required: false
    },
    region: {
      type: String,
      required: false
    },
    num: {
      type: Number,
      required: false
    }
  },
  data () {
    return {
      checkLogin: this.$store.state.userToken.token
    }
  },
  methods: {
    check () {
      alert(this.checkLogin)
    }
  }
}
</script>

<style scoped>
.place{
    min-height: 250px;
    box-shadow: rgba(0, 0, 0, 0.05) 0px 6px 24px 0px, rgba(0, 0, 0, 0.08) 0px 0px 0px 1px;
    flex-grow: 0;
    flex-basis: 200px;
    margin:0px 5px 30px 0px;
    max-width: 250px;
    transition: all 0.2s;
}
.place:hover{
  box-shadow: rgba(0, 0, 0, 0.35) 0px 5px 15px;
}
.dscrip-region{
  position: absolute;
  font-size: 5px;
  color:gray;
  top:8px;
  left:15px;
}
.dscrip-date{
  position: absolute;
    font-size: 12px;
    color: gray;
    top: 7px;
    right: 8px;
}
.place-detail{
  position: relative;
}
.place-content{
  position: relative;
  overflow: hidden;
}
.content-title{
  font-size: 11px;
  margin: 0 0 0 0;
  font-weight: bold;
}
.detail-price{
  position: absolute;
    margin: 0 0 0 0;
    font-size: 12px;
    top: 21px;
    left: 2px;
    color: cornflowerblue;
}

.place-dscript{
  position: relative;
  height: 30px;
  padding: 2px 3px 2px 3px;
  background-color: #ecf1fd;
}
.place-dscript p{
  background-color: #ecf1fd;
  font-weight: bold;
  margin:0;
}
.place-img{
    width:250px;
    height:150px;
    overflow:hidden;
    margin:0 auto;
}
img{
  width:100%;
    height:100%;
    object-fit:cover;
}

</style>
