<template>
<div>
  <div id="div1">
    <router-link style="text-decoration: none" active-class="active" to="/main/deliverArticle" class="div1">发布</router-link><br><br><br><br><br><br>
    <router-link style="text-decoration: none" active-class="active" to="/main/articleList" class="div1">社区</router-link><br><br><br><br><br><br>
    <router-link style="text-decoration: none" active-class="active" to="/main/userInfo" class="div1">个人信息</router-link><br><br><br><br>
  </div>
  <div id="div2">
    <keep-alive include="ArticleContent">
      <router-view></router-view>
    </keep-alive>
  </div>
</div>
</template>

<script>
import axios from "axios";

export default {
  name: "MainPage",
  mounted() {
    axios({
      method:'POST',
      url:'http://localhost:8080/feng/auth',
    }).then((res)=>{
      if(res.data!==1) {
        this.$router.push("/login")
        alert("请先登录！")
      }
    })
  },
}
</script>

<style scoped>
#div1{
  position: absolute;
  left: 10px;
  top:130px;
}
.div1{
  font-size: 20px;
}
.active{
  color: red;
  font-size: 25px;
}
#div2{
  position: absolute;
  left:100px;
  top:130px;
}
</style>