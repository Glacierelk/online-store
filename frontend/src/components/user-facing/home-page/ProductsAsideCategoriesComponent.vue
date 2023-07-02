<template>
  <div >
    <!--在这也加上一个mouseEnter事件，防止鼠标从tab上移动到表格上时，表格消失-->
    <!--在这也加上一个mouseEnter事件，防止鼠标从tab上移动到表格上时，表格消失-->
    <!--在这也加上一个mouseEnter事件，防止鼠标从tab上移动到表格上时，表格消失-->
    <!--  :id="index"可以改成:id="'tab'+index" 这样比较安全  -->
    <!--  :id="index"可以改成:id="'tab'+index" 这样比较安全  -->
    <!--  :id="index"可以改成:id="'tab'+index" 这样比较安全  -->
    <div @mouseenter="showMenu(index)" @mouseleave="hideMenu(index)" class="productsAsideCategories"  v-for="(category,index) in categories" :key="category.cid" :id="index">
        <div v-for="ps in category.products" :key="ps.id">
          <div class="row show1" v-if="ps.subTitle.length>0">
            <span  v-for="title in ps.subTitle.split(' ')" :key="title" style="margin-left: 30px;">
              <router-link :to="'/details?id='+ps.id">{{title}}</router-link>
            </span>
            <div style="margin-top: 20px" class="seperator"></div>
          </div>
        </div>
    </div>
  </div>
</template>

<script>
import SwiperComponent from "@/components/user-facing/home-page/SwiperComponent.vue";
import axios from "axios";
  export default {
    data(){
      return{
        categories:categories,
      }
    },
    methods: {
        showMenu:function(index){
          //alert(param)
          //html代码中用 :id="index" 绑定了一个id，即用index来作为id了,然后接下来直接用index作为id获取组件然后显示就行了
          //如果不想用这个index作为id，那么可以再次进行一个处理，用 index+一个名词 组成一个新的id 后赋值给它
          const a=document.getElementById(index)
          a.style.display="block"
          SwiperComponent.methods.hideSwiper()
      },
        hideMenu:function (index){
          const a=document.getElementById(index)
          a.style.display="none"
          SwiperComponent.methods.showSwiper()
        },
    },

  }


  var categories=[];
  //加上await阻塞请求，直到请求完成后再进行页面的刷新
  await axios.get("/category/homePageCategory").then(function (response){
    categories=response.data.data
    //alert(categories)
  },function (err){
    alert(err)
  }).catch(function (){
    alert("连接失败！！！")
  })



</script>

<style scoped>
div.productsAsideCategories {
  position: relative;
  width: 100%;
  height: 546px;
  background-color: white;
  /* 	padding-bottom:10px; */
  margin-left: 198px;
  display: none;
  left: 0;
  top: 0;
  z-index: 1;
}
div.productsAsideCategories a {
  text-decoration: none;
  color: #999;
  font-size: 14px;
  margin: 8px;
}

div.productsAsideCategories a:hover {
  color: #C40000;
  text-decoration: none;
}

div.productsAsideCategories div.row {
  padding: 20px 80px 0 80px;
}

div.productsAsideCategories div.row div.seperator {
  border-bottom-style: dashed;
  border-bottom-width: 1px;
  border-bottom-color: #e7e7e7;
}
</style>