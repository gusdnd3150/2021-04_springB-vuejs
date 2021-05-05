<template>
   <div class="best-place-area">

    <div class="place-card">
      <div class="place-img">
        <img src="@/assets/sample3.jpg">
      </div>
      <div class="place-conent">
        <h3>"봄날이 왔어요~"</h3>
        <div class="content-date">
          <p>2021-05-21</p>
        </div>
        <p>이미지를 둘러싸고 있는 div에 맞게 확장시켜 div에 꽉 차게 하고 싶은 경우가 있을 수 있습니다. 이런 경우 몇 가지 방법을 사용할 수 있습니다.</p>
      </div>
    </div>

    <div class="place-card">
      <div class="place-img">
        <img src="@/assets/sample2.png">
      </div>
      <div class="place-conent">
        <h3>"훈이와 함께 남한산성"</h3>
        <div class="content-date">
          <p>2021-05-21</p>
        </div>
        <p>이미지를 둘러싸고 있는 div에 맞게 확장시켜 div에 꽉 차게 하고 싶은 경우가 있을 수 있습니다. 이런 경우 몇 가지 방법을 사용할 수 있습니다.</p>
      </div>
    </div>
    <div class="place-card">
      <div class="place-img">
        <img src="@/assets/sample.png">
      </div>
      <div class="place-conent">
        <h3>"부산야경"</h3>
        <div class="content-date">
          <p>2021-05-21</p>
        </div>
        <p>이미지를 둘러싸고 있는 div에 맞게 확장시켜 div에 꽉 차게 하고 싶은 경우가 있을 수 있습니다. 이런 경우 몇 가지 방법을 사용할 수 있습니다.</p>
      </div>
    </div>
    <div class="place-card">
      <div class="place-img">
        <img src="@/assets/sample9.jpg">
      </div>
      <div class="place-conent">
        <h3>"여친의 달밤체조"</h3>
        <div class="content-date">
          <p>2021-05-21</p>
        </div>
        <p>이미지를 둘러싸고 있는 div에 맞게 확장시켜 div에 꽉 차게 하고 싶은 경우가 있을 수 있습니다. 이런 경우 몇 가지 방법을 사용할 수 있습니다.</p>
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
}

.place-card{
  display: flex;
  flex-wrap: wrap;
  justify-content: center;
  margin-bottom: 20px;
}
.place-card > div{
  flex-basis: 420px;
  margin-right: 14px;
  margin-top: 18px;
}

.place-img{
  overflow: hidden;
  border-radius: 20px;
}
img{
  max-width: 100%;
  border-radius: 20px;
  transition: all 0.2s;
}
img:hover{
  transform: scale(1.1);
}
.place-conent{
  text-align: left;
}
.place-conent > h3{
  margin-bottom: 2px;
}
.content-date{
  background-color: #ecf1fd;
  padding: 1px 10px 1px 10px;
}
@media (max-width:750px){
  .place-card{
    flex-direction: column;
  }
  .place-card > div{
    flex-basis: 100%;
  }
}
</style>
