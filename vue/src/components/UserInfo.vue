<template>
<div id="div1">
  <el-form ref="form" :model="form" label-width="80px">
    <el-form-item label="用户名">
      <span>{{form.username}}</span>
    </el-form-item>
    <el-form-item label="昵称">
      <el-input v-model="form.nickName" v-show="edit" style="width:200px"></el-input>
      <span v-show="!edit">{{form.nickName}}</span>
    </el-form-item>
    <el-form-item label="地址">
      <el-input v-model="form.address" v-show="edit" style="width:200px" type="textarea" :row="4" resize="none"></el-input>
      <span v-show="!edit">{{form.address}}</span>
    </el-form-item>
    <el-form-item>
      <el-button type="primary" @click="onSubmit" v-show="edit">提交</el-button>
      <el-button type="primary" @click="changeState" v-show="!edit">修改用户信息</el-button>
    </el-form-item>
  </el-form>
</div>
</template>

<script>
import axios from "axios";

export default {
  name: "UserInfo",
  data(){
    return {
      form:{
        username:"",
        password:"",
        nickName:'',
        address:''
      },
      name:localStorage.getItem("username"),
      edit:false
    }
  },
  methods:{
    changeState(){
      this.edit = !this.edit
    },
    onSubmit(){
      axios({
        method:'POST',
        url:'http://localhost:8080/feng/updateUserInfo',
        data: this.form
      }).then((res)=>{
        this.form = res.data
      })
      this.edit = !this.edit
    }
  },
  mounted() {
    axios({
      method:'POST',
      url:'http://localhost:8080/feng/userInfo',
      data: {username:this.name}
    }).then((res)=>{
      this.form = res.data
    })
  }
}
</script>

<style scoped>
#div1{
  position: absolute;
  left:400px;
  top:70px;
}
</style>