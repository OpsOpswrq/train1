<template>
<div>
    <div id="div1">
      <router-link style="text-decoration: none" active-class="active" to="/login" class="div1" v-show="!exit&&!name">登录</router-link>
      <router-link style="text-decoration: none" active-class="active" to="/createUserInfo" class="div1" v-show="!exit&&!name">注册</router-link>
      <router-link style="text-decoration: none" active-class="active" to="/main" class="div1" v-show="exit||name">主页</router-link>
      <el-button type="danger" @click="logout" style="width: 80px;height: 30px;" class="div1" v-show="exit||name">注销</el-button>
    </div>
  <div id="div2">
      <router-view></router-view>
  </div>
</div>
</template>

<script>
import axios from "axios";
import event_bus from "@/event_bus";

export default {
  name: "App",
  data(){
    return{
      form1:{
        username:'',
        password:'',
      },
      exit:false,
    }
  },
  computed:{
    name(){
      return localStorage.getItem("username")
    }
  },
  methods:{
    logout(){
      axios({
        method:'POST',
        url:'http://localhost:8080/feng/logout',
        data:this.form1
      }).then((res)=>{
        if(res.data===1) {
          this.$router.push("/login")
          this.$router.go(0)
          this.exit = !this.exit
          localStorage.removeItem("username")
          alert("欢迎下次光临")
        }else{
          alert("账号有问题！")
        }
      })
    }
  },
  mounted() {
    event_bus.$on("formData1",(data)=>{
      this.form1 = data
    })
    event_bus.$on("change",()=>{
      this.exit = !this.exit
    })
  }
}
</script>

<style scoped>
.active{
  color: red;
  font-size: 20px;
}
.div1{
  margin-left: 10px;
  margin-right: 10px;
}
#div1{
  position: absolute;
  left:1100px;
  top:20px;
  width: 300px;
  height: 50px;
}
#div2{
  position: absolute;
  left:100px;
  top:80px;
  align-content: center;
  width: 1300px;
  height:720px;
}
</style>