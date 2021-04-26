<template>
 <div class="content-area">
     <div class="login-div">
         <div>
             이미지
             <div>
                <h2>hello </h2>
             </div>
         </div>
         <div>
             <form name="loginForm" action="/login" method="post">

                  <div class="input">
                    <input type="text" name="">
                    <img src="/images/logo.png" alt="dd">
                  </div>
             </form>
         </div>
     </div>
 </div>
</template>

<script>
export default {
  name: 'login'
}
</script>

<style scoped>
.content-area{
  margin-top: 100px;
  width: 800px;
  margin: 0 auto;
}

.login-div{
  overflow: hidden;
  border-radius: 10px;
  display: flex;
  flex-wrap: nowrap;
  box-shadow: rgba(0, 0, 0, 0.07) 0px 1px 1px, rgba(0, 0, 0, 0.07) 0px 2px 2px, rgba(0, 0, 0, 0.07) 0px 4px 4px, rgba(0, 0, 0, 0.07) 0px 8px 8px, rgba(0, 0, 0, 0.07) 0px 16px 16px;
}

.login-div > div{
  width: 100%;
  min-height: 500px;
}
.login-div > div:first-child{
    background-color: #3CAEFF;
    position: relative;
}
.login-div > div:first-child  div{
    position: absolute;
    top: 220px;
    text-align: center;
    right: 200px;
    color:white;
    font-weight: bold;
}

input{
    border: 0;
    border-bottom-style: solid;
    border-width: 1px;
}
</style>
