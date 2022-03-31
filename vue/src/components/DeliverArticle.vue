<template>
<div id="div1">
  <el-form ref="form" :model="form" label-width="80px">
    <el-form-item label="标题">
      <el-input v-model="form.title"  style="width:200px" placeholder="请输入标题"></el-input>
    </el-form-item>
    <el-form-item label="内容">
      <el-input  type="textarea" :rows="2" placeholder="请输入内容" v-model="form.content" resize="none"></el-input>
    </el-form-item>
    <el-form-item>
      <el-button type="primary" @click="onSubmit">发布</el-button>
    </el-form-item>
  </el-form>
</div>
</template>

<script>
import axios from "axios";

export default {
  name: "DeliverArticle",
  data(){
    return {
      form:{
        content:"",
        title:"",
        author:localStorage.getItem("username")
      }
    }
  },
  methods:{
    onSubmit(){
      console.log(this.form)
      axios({
        method: "POST",
        url:"http://localhost:8080/feng/deliverArticle",
        data:this.form,
      }).then((res)=>{
        if(res.data===1){
          this.$router.go(-1)
          alert("发布成功")
        }
      })
    }
  }
}
</script>

<style scoped>
#div1{
  position: absolute;
  left:380px;
  top:100px;
}
</style>