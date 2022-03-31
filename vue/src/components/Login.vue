<template>
<div style="width: 300px;height: 100px;position: absolute;left: 450px;top: 200px;">
  <el-form ref="form" :model="form1" label-width="80px">
    <el-form-item label="用户名">
      <el-input v-model="form1.username" placeholder="请输入用户名" style="width:200px"></el-input>
    </el-form-item>
    <el-form-item label="密码">
      <el-input v-model="form1.password" placeholder="请输入密码" style="width:200px" type="password"></el-input>
    </el-form-item>
    <el-form-item>
      <el-button type="primary" @click="onSubmit">登录</el-button>
    </el-form-item>
  </el-form>
</div>
</template>

<script>
import axios from "axios";
import event_bus from "@/event_bus";
export default {
  name: "Login",
  data(){
    return {
      form1:{
        username:'',
        password:'',
      }
    }
  },
  methods:{
    onSubmit(){
      axios({
        method:'POST',
        url:'http://localhost:8080/feng/login',
        data:this.form1
      }).then((res)=>{
        if(res.data===1){
          alert("欢迎登录")
          event_bus.$emit("formData1",this.form1)
          localStorage.setItem("username",this.form1.username)
          event_bus.$emit("change")
          this.$router.push('/main')
        }else{
          alert("用户名或密码出现错误，请仔细检查")
        }
      })
    }
  },
}
</script>

<style scoped>

</style>