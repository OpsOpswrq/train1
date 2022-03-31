const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true,
  devServer:{
    proxy:{
      '/feng':{
        target:"http://localhost:7878",
        pathRewrite:{'^/feng':''},//重写的路径
        ws:true,
        changeOrigin:true
      },
    }
  }
})
