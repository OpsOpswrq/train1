<template>
<div id="div1">
  <ul v-for="(item,index) in form" :key="item.id" id="div2">
    <li>
      <div style="width:1100px;height:200px;background-color:#EBEEF5;">
        <el-form ref="form" label-width="80px">
          <el-form-item>
            <el-button type="primary" class="btn" @click="item.edit=!item.edit" v-show="!item.edit&&item.author===name">修改文章</el-button>
            <el-button type="primary" class="btn" @click="commitContent(item.id,index)" v-show="item.edit&&item.author===name">提交</el-button>
            <el-button type="danger" class="btn" @click="deleteArticle(item.id)" v-show="!item.edit&&item.author===name">删除文章</el-button>
            <el-button style="visibility: hidden"></el-button>
          </el-form-item>
          <el-form-item label="标题" style="width: 300px;" id="form3">
            <el-input v-model="item.title" v-show="item.edit" style="width:200px"></el-input>
            <span style="font-size: 25px;" v-show="!item.edit">{{item.title}}</span>
          </el-form-item>
          <el-form-item label="作者" id="form1">
            <span>{{item.author}}</span>
          </el-form-item>
          <el-form-item id="form2">
            <el-input type="textarea" v-model="item.content" v-show="item.edit" style="width:1000px;" resize="none"></el-input>
            <span v-show="!item.edit">{{item.content}}</span>
          </el-form-item>
        </el-form>
      </div>
    </li>
  </ul>
</div>
</template>

<script>
import axios from "axios";
export default {
  name: "ArticleContent",
  data(){
    return{
      form:{
          id:'',
          author:'',
          content:'',
          title:'',
        },
      name:""
    }
  },
  methods:{
    commitContent(id,index){
      this.form[index].edit = !this.form[index].edit
      axios({
        method:'POST',
        url:'http://localhost:8080/feng/updateArticle',
        data:{id:id,
          content:this.form[index].content,
          title:this.form[index].title
        }
      }).then((res)=>{
          if(res.data===1){
            this.$router.go(0)
            alert("修改成功")
          }else{
            this.$router.go(0)
            alert("不可以修改别人的文章")
          }
        })
    },
    deleteArticle(id){
      axios({
        method:'POST',
        url:'http://localhost:8080/feng/deleteArticle',
        data:{id:id}
      }).then((res)=>{
        if(res.data===1){
          this.$router.go(0)
          alert("删除成功")
        }else{
          this.$router.go(0)
          alert("不可以删除别人的文章")
        }
      })
    }
  },
  mounted() {
    axios({
      method:'GET',
      url:'http://localhost:8080/feng/allArticles',
    }).then((res)=>{
      this.form = res.data
      this.form.forEach((item)=>{
        this.$set(item,'edit',false)
      })
    })
    this.name=localStorage.getItem("username")
  }
}
</script>

<style scoped>
#div1{
  position: absolute;
  left:20px;
  top:-150px;
  width:1050px;
  height: 600px;
}
ul,li{
  list-style: none;
}
#div2{
  padding-top: 5px;
  padding-bottom: 5px;
  margin-bottom: 30px;
  margin-top: 30px;
}
#form1{
  position: relative;
  left:85%;
  top:-130px;
  width: 100px;
}
#form2{
  position: relative;
  left:-5%;
  top:-140px;
}
.btn{
  position: relative;
  left:75%;
  top:-30px;
  height:30px;
}
#form3{
  position: relative;
  top:-60px;
}
</style>