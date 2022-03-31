<template>
<div style="width: 300px;height: 300px;position: absolute;left: 450px;top: 150px;">
  <el-form ref="form" :model="form" label-width="80px">
    <el-form-item label="用户名">
      <el-input v-model="form.username"  style="width:200px" placeholder="请输入用户名"></el-input>
    </el-form-item>
    <el-form-item label="密码">
      <el-input v-model="form.password"  style="width:200px" type="password" placeholder="请输入密码"></el-input>
    </el-form-item>
    <el-form-item label="昵称">
      <el-input v-model="form.nickName"  style="width:200px" placeholder="请输入昵称"></el-input>
    </el-form-item>
    <el-form-item label="地址">
      <el-input v-model="form.address"  style="width:200px" placeholder="请输入地址" type="textarea" :row="5" resize="none"></el-input>
    </el-form-item>
    <el-form-item>
      <el-button type="primary" @click="onSubmit">立即创建</el-button>
    </el-form-item>
  </el-form>
</div>
</template>

<script>
import axios from "axios";

export default {
  name: "CreateUser",
  data(){
    return {
      form:{
        username:'',
        password:'',
        nickName:'',
        address:'',
      }
    }
  },
  methods:{
    onSubmit(){
      axios({
        method:'POST',
        url:'http://localhost:8080/feng/adduser',
        data:this.form
      }).then((res)=>{
        if(res.data===1){
          alert("恭喜你成功创建成功")
          this.$router.push({path:'/login'})
        }else{
          alert("出现重名，请另取名字")
        }
      })
    }
  }
}
</script>

<style scoped>

</style>