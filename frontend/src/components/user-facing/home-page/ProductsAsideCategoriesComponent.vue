<template>
  <div >
    <!--在这也加上一个mouseEnter事件，防止鼠标从tab上移动到表格上时，表格消失-->
    <!--在这也加上一个mouseEnter事件，防止鼠标从tab上移动到表格上时，表格消失-->
    <!--在这也加上一个mouseEnter事件，防止鼠标从tab上移动到表格上时，表格消失-->
    <!--  :id="index"可以改成:id="'tab'+index" 这样比较安全  -->
    <!--  :id="index"可以改成:id="'tab'+index" 这样比较安全  -->
    <!--  :id="index"可以改成:id="'tab'+index" 这样比较安全  -->
    <div @mouseenter="showMenu(index)" @mouseleave="hideMenu(index)" class="productsAsideCategories"  v-for="(category,index) in categories" :key="category.cid" :id="index">
        <div class="row show1" v-for="ps in category.products" :key="ps.id">
          <span v-for="title in ps.subTitle.split(' ')" :key="title" style="margin-left: 30px;">
            <a href="#" v-if="ps.subTitle.length>0">
              {{title}}
            </a>
          </span>

          <div style="margin-top: 20px" class="seperator"></div>
        </div>
    </div>
  </div>
</template>

<script>
import SwiperComponent from "@/components/user-facing/home-page/SwiperComponent.vue";
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
    }
  }
      var categories=[
      {"category_name": "冰箱","cid": 76,"products": [
          {"id": 449,"name": "MeiLing/美菱 BCD-560WUCX对开门电冰箱家用冰箱WIFI智能风冷无霜","subTitle": "家用冰箱1 WIFI智能 风冷无霜",},
          {"id": 450,"name": "MeiLing/美菱 BCD-560WUCX对开门电冰箱家用冰箱WIFI智能风冷无霜","subTitle": "家用冰箱1 WIFI智能 风冷无霜",},
          {"id": 451,"name": "MeiLing/美菱 BCD-560WUCX对开门电冰箱家用冰箱WIFI智能风冷无霜","subTitle": "家用冰箱1 WIFI智能 风冷无霜",},
          {"id": 452,"name": "MeiLing/美菱 BCD-560WUCX对开门电冰箱家用冰箱WIFI智能风冷无霜","subTitle": "家用冰箱1 WIFI智能 风冷无霜",},
          {"id": 453,"name": "MeiLing/美菱 BCD-560WUCX对开门电冰箱家用冰箱WIFI智能风冷无霜","subTitle": "家用冰箱1 WIFI智能 风冷无霜",},
          {"id": 454,"name": "MeiLing/美菱 BCD-560WUCX对开门电冰箱家用冰箱WIFI智能风冷无霜","subTitle": "家用冰箱1 WIFI智能 风冷无霜",},
        ]},
      {"category_name": "马桶","cid": 77,"products": [
          {"id": 455,"name": "MeiLing/美菱 BCD-560WUCX对开门电冰箱家用冰箱WIFI智能风冷无霜","subTitle": "家用冰2 WIFI智能 风冷无霜",},
          {"id": 456,"name": "MeiLing/美菱 BCD-560WUCX对开门电冰箱家用冰箱WIFI智能风冷无霜","subTitle": "家用冰2 WIFI智能 风冷无霜",},
          {"id": 457,"name": "MeiLing/美菱 BCD-560WUCX对开门电冰箱家用冰箱WIFI智能风冷无霜","subTitle": "家用冰2 WIFI智能 风冷无霜",},
          {"id": 458,"name": "MeiLing/美菱 BCD-560WUCX对开门电冰箱家用冰箱WIFI智能风冷无霜","subTitle": "家用冰2 WIFI智能 风冷无霜",},
          {"id": 459,"name": "MeiLing/美菱 BCD-560WUCX对开门电冰箱家用冰箱WIFI智能风冷无霜","subTitle": "家用冰2 WIFI智能 风冷无霜",},
          {"id": 460,"name": "MeiLing/美菱 BCD-560WUCX对开门电冰箱家用冰箱WIFI智能风冷无霜","subTitle": "家用冰2 WIFI智能 风冷无霜",},
        ]},
      {"category_name": "平板电视","cid": 78,"products": [
          {"id": 461,"name": "MeiLing/美菱 BCD-560WUCX对开门电冰箱家用冰箱WIFI智能风冷无霜","subTitle": "家用冰箱3 WIFI智能 风冷无霜",},
          {"id": 462,"name": "MeiLing/美菱 BCD-560WUCX对开门电冰箱家用冰箱WIFI智能风冷无霜","subTitle": "家用冰3箱 WIFI智能 风冷无霜",},
          {"id": 463,"name": "MeiLing/美菱 BCD-560WUCX对开门电冰箱家用冰箱WIFI智能风冷无霜","subTitle": "家用冰箱3 WIFI智能 风冷无霜",},
          {"id": 464,"name": "MeiLing/美菱 BCD-560WUCX对开门电冰箱家用冰箱WIFI智能风冷无霜","subTitle": "家用冰箱3 WIFI智能 风冷无霜",},
          {"id": 465,"name": "MeiLing/美菱 BCD-560WUCX对开门电冰箱家用冰箱WIFI智能风冷无霜","subTitle": "家用冰箱3 WIFI智能 风冷无霜",},
          {"id": 466,"name": "MeiLing/美菱 BCD-560WUCX对开门电冰箱家用冰箱WIFI智能风冷无霜","subTitle": "家用冰箱3 WIFI智能 风冷无霜",},
        ]},
      {"category_name": "空调","cid": 79,"products": [
          {"id": 467,"name": "MeiLing/美菱 BCD-560WUCX对开门电冰箱家用冰箱WIFI智能风冷无霜","subTitle": "家用冰箱4 WIFI智能 风冷无霜",},
          {"id": 468,"name": "MeiLing/美菱 BCD-560WUCX对开门电冰箱家用冰箱WIFI智能风冷无霜","subTitle": "家用冰箱4 WIFI智能 风冷无霜",},
          {"id": 469,"name": "MeiLing/美菱 BCD-560WUCX对开门电冰箱家用冰箱WIFI智能风冷无霜","subTitle": "家用冰箱4 WIFI智能 风冷无霜",},
          {"id": 470,"name": "MeiLing/美菱 BCD-560WUCX对开门电冰箱家用冰箱WIFI智能风冷无霜","subTitle": "家用冰箱4 WIFI智能 风冷无霜",},
          {"id": 471,"name": "MeiLing/美菱 BCD-560WUCX对开门电冰箱家用冰箱WIFI智能风冷无霜","subTitle": "家用冰箱4 WIFI智能 风冷无霜",},
          {"id": 472,"name": "MeiLing/美菱 BCD-560WUCX对开门电冰箱家用冰箱WIFI智能风冷无霜","subTitle": "家用冰箱4 WIFI智能 风冷无霜",},
        ]},
      {"category_name": "扫地机器人","cid": 80,"products": [
          {"id": 449,"name": "MeiLing/美菱 BCD-560WUCX对开门电冰箱家用冰箱WIFI智能风冷无霜","subTitle": "家用冰箱5 WIFI智能 风冷无霜",},
          {"id": 450,"name": "MeiLing/美菱 BCD-560WUCX对开门电冰箱家用冰箱WIFI智能风冷无霜","subTitle": "家用冰箱5 WIFI智能 风冷无霜",},
          {"id": 451,"name": "MeiLing/美菱 BCD-560WUCX对开门电冰箱家用冰箱WIFI智能风冷无霜","subTitle": "家用冰箱5 WIFI智能 风冷无霜",},
          {"id": 452,"name": "MeiLing/美菱 BCD-560WUCX对开门电冰箱家用冰箱WIFI智能风冷无霜","subTitle": "家用冰箱5 WIFI智能 风冷无霜",},
          {"id": 453,"name": "MeiLing/美菱 BCD-560WUCX对开门电冰箱家用冰箱WIFI智能风冷无霜","subTitle": "家用冰箱5 WIFI智能 风冷无霜",},
          {"id": 454,"name": "MeiLing/美菱 BCD-560WUCX对开门电冰箱家用冰箱WIFI智能风冷无霜","subTitle": "家用冰箱5 WIFI智能 风冷无霜",},
        ]},
        {"category_name": "冰箱","cid": 76,"products": [
            {"id": 449,"name": "MeiLing/美菱 BCD-560WUCX对开门电冰箱家用冰箱WIFI智能风冷无霜","subTitle": "家用冰箱1 WIFI智能 风冷无霜",},
            {"id": 450,"name": "MeiLing/美菱 BCD-560WUCX对开门电冰箱家用冰箱WIFI智能风冷无霜","subTitle": "家用冰箱1 WIFI智能 风冷无霜",},
            {"id": 451,"name": "MeiLing/美菱 BCD-560WUCX对开门电冰箱家用冰箱WIFI智能风冷无霜","subTitle": "家用冰箱1 WIFI智能 风冷无霜",},
            {"id": 452,"name": "MeiLing/美菱 BCD-560WUCX对开门电冰箱家用冰箱WIFI智能风冷无霜","subTitle": "家用冰箱1 WIFI智能 风冷无霜",},
            {"id": 453,"name": "MeiLing/美菱 BCD-560WUCX对开门电冰箱家用冰箱WIFI智能风冷无霜","subTitle": "家用冰箱1 WIFI智能 风冷无霜",},
            {"id": 454,"name": "MeiLing/美菱 BCD-560WUCX对开门电冰箱家用冰箱WIFI智能风冷无霜","subTitle": "家用冰箱1 WIFI智能 风冷无霜",},
          ]},
        {"category_name": "冰箱","cid": 76,"products": [
            {"id": 449,"name": "MeiLing/美菱 BCD-560WUCX对开门电冰箱家用冰箱WIFI智能风冷无霜","subTitle": "家用冰箱1 WIFI智能 风冷无霜",},
            {"id": 450,"name": "MeiLing/美菱 BCD-560WUCX对开门电冰箱家用冰箱WIFI智能风冷无霜","subTitle": "家用冰箱1 WIFI智能 风冷无霜",},
            {"id": 451,"name": "MeiLing/美菱 BCD-560WUCX对开门电冰箱家用冰箱WIFI智能风冷无霜","subTitle": "家用冰箱1 WIFI智能 风冷无霜",},
            {"id": 452,"name": "MeiLing/美菱 BCD-560WUCX对开门电冰箱家用冰箱WIFI智能风冷无霜","subTitle": "家用冰箱1 WIFI智能 风冷无霜",},
            {"id": 453,"name": "MeiLing/美菱 BCD-560WUCX对开门电冰箱家用冰箱WIFI智能风冷无霜","subTitle": "家用冰箱1 WIFI智能 风冷无霜",},
            {"id": 454,"name": "MeiLing/美菱 BCD-560WUCX对开门电冰箱家用冰箱WIFI智能风冷无霜","subTitle": "家用冰箱1 WIFI智能 风冷无霜",},
          ]},
        {"category_name": "冰箱","cid": 76,"products": [
            {"id": 449,"name": "MeiLing/美菱 BCD-560WUCX对开门电冰箱家用冰箱WIFI智能风冷无霜","subTitle": "家用冰箱1 WIFI智能 风冷无霜",},
            {"id": 450,"name": "MeiLing/美菱 BCD-560WUCX对开门电冰箱家用冰箱WIFI智能风冷无霜","subTitle": "家用冰箱1 WIFI智能 风冷无霜",},
            {"id": 451,"name": "MeiLing/美菱 BCD-560WUCX对开门电冰箱家用冰箱WIFI智能风冷无霜","subTitle": "家用冰箱1 WIFI智能 风冷无霜",},
            {"id": 452,"name": "MeiLing/美菱 BCD-560WUCX对开门电冰箱家用冰箱WIFI智能风冷无霜","subTitle": "家用冰箱1 WIFI智能 风冷无霜",},
            {"id": 453,"name": "MeiLing/美菱 BCD-560WUCX对开门电冰箱家用冰箱WIFI智能风冷无霜","subTitle": "家用冰箱1 WIFI智能 风冷无霜",},
            {"id": 454,"name": "MeiLing/美菱 BCD-560WUCX对开门电冰箱家用冰箱WIFI智能风冷无霜","subTitle": "家用冰箱1 WIFI智能 风冷无霜",},
          ]},
        {"category_name": "冰箱","cid": 76,"products": [
            {"id": 449,"name": "MeiLing/美菱 BCD-560WUCX对开门电冰箱家用冰箱WIFI智能风冷无霜","subTitle": "家用冰箱1 WIFI智能 风冷无霜",},
            {"id": 450,"name": "MeiLing/美菱 BCD-560WUCX对开门电冰箱家用冰箱WIFI智能风冷无霜","subTitle": "家用冰箱1 WIFI智能 风冷无霜",},
            {"id": 451,"name": "MeiLing/美菱 BCD-560WUCX对开门电冰箱家用冰箱WIFI智能风冷无霜","subTitle": "家用冰箱1 WIFI智能 风冷无霜",},
            {"id": 452,"name": "MeiLing/美菱 BCD-560WUCX对开门电冰箱家用冰箱WIFI智能风冷无霜","subTitle": "家用冰箱1 WIFI智能 风冷无霜",},
            {"id": 453,"name": "MeiLing/美菱 BCD-560WUCX对开门电冰箱家用冰箱WIFI智能风冷无霜","subTitle": "家用冰箱1 WIFI智能 风冷无霜",},
            {"id": 454,"name": "MeiLing/美菱 BCD-560WUCX对开门电冰箱家用冰箱WIFI智能风冷无霜","subTitle": "家用冰箱1 WIFI智能 风冷无霜",},
          ]},
        {"category_name": "冰箱","cid": 76,"products": [
            {"id": 449,"name": "MeiLing/美菱 BCD-560WUCX对开门电冰箱家用冰箱WIFI智能风冷无霜","subTitle": "家用冰箱1 WIFI智能 风冷无霜",},
            {"id": 450,"name": "MeiLing/美菱 BCD-560WUCX对开门电冰箱家用冰箱WIFI智能风冷无霜","subTitle": "家用冰箱1 WIFI智能 风冷无霜",},
            {"id": 451,"name": "MeiLing/美菱 BCD-560WUCX对开门电冰箱家用冰箱WIFI智能风冷无霜","subTitle": "家用冰箱1 WIFI智能 风冷无霜",},
            {"id": 452,"name": "MeiLing/美菱 BCD-560WUCX对开门电冰箱家用冰箱WIFI智能风冷无霜","subTitle": "家用冰箱1 WIFI智能 风冷无霜",},
            {"id": 453,"name": "MeiLing/美菱 BCD-560WUCX对开门电冰箱家用冰箱WIFI智能风冷无霜","subTitle": "家用冰箱1 WIFI智能 风冷无霜",},
            {"id": 454,"name": "MeiLing/美菱 BCD-560WUCX对开门电冰箱家用冰箱WIFI智能风冷无霜","subTitle": "家用冰箱1 WIFI智能 风冷无霜",},
          ]},
        {"category_name": "冰箱","cid": 76,"products": [
            {"id": 449,"name": "MeiLing/美菱 BCD-560WUCX对开门电冰箱家用冰箱WIFI智能风冷无霜","subTitle": "家用冰箱1 WIFI智能 风冷无霜",},
            {"id": 450,"name": "MeiLing/美菱 BCD-560WUCX对开门电冰箱家用冰箱WIFI智能风冷无霜","subTitle": "家用冰箱1 WIFI智能 风冷无霜",},
            {"id": 451,"name": "MeiLing/美菱 BCD-560WUCX对开门电冰箱家用冰箱WIFI智能风冷无霜","subTitle": "家用冰箱1 WIFI智能 风冷无霜",},
            {"id": 452,"name": "MeiLing/美菱 BCD-560WUCX对开门电冰箱家用冰箱WIFI智能风冷无霜","subTitle": "家用冰箱1 WIFI智能 风冷无霜",},
            {"id": 453,"name": "MeiLing/美菱 BCD-560WUCX对开门电冰箱家用冰箱WIFI智能风冷无霜","subTitle": "家用冰箱1 WIFI智能 风冷无霜",},
            {"id": 454,"name": "MeiLing/美菱 BCD-560WUCX对开门电冰箱家用冰箱WIFI智能风冷无霜","subTitle": "家用冰箱1 WIFI智能 风冷无霜",},
          ]},
        {"category_name": "冰箱","cid": 76,"products": [
            {"id": 449,"name": "MeiLing/美菱 BCD-560WUCX对开门电冰箱家用冰箱WIFI智能风冷无霜","subTitle": "家用冰箱1 WIFI智能 风冷无霜",},
            {"id": 450,"name": "MeiLing/美菱 BCD-560WUCX对开门电冰箱家用冰箱WIFI智能风冷无霜","subTitle": "家用冰箱1 WIFI智能 风冷无霜",},
            {"id": 451,"name": "MeiLing/美菱 BCD-560WUCX对开门电冰箱家用冰箱WIFI智能风冷无霜","subTitle": "家用冰箱1 WIFI智能 风冷无霜",},
            {"id": 452,"name": "MeiLing/美菱 BCD-560WUCX对开门电冰箱家用冰箱WIFI智能风冷无霜","subTitle": "家用冰箱1 WIFI智能 风冷无霜",},
            {"id": 453,"name": "MeiLing/美菱 BCD-560WUCX对开门电冰箱家用冰箱WIFI智能风冷无霜","subTitle": "家用冰箱1 WIFI智能 风冷无霜",},
            {"id": 454,"name": "MeiLing/美菱 BCD-560WUCX对开门电冰箱家用冰箱WIFI智能风冷无霜","subTitle": "家用冰箱1 WIFI智能 风冷无霜",},
          ]},
        {"category_name": "冰箱","cid": 76,"products": [
            {"id": 449,"name": "MeiLing/美菱 BCD-560WUCX对开门电冰箱家用冰箱WIFI智能风冷无霜","subTitle": "家用冰箱1 WIFI智能 风冷无霜",},
            {"id": 450,"name": "MeiLing/美菱 BCD-560WUCX对开门电冰箱家用冰箱WIFI智能风冷无霜","subTitle": "家用冰箱1 WIFI智能 风冷无霜",},
            {"id": 451,"name": "MeiLing/美菱 BCD-560WUCX对开门电冰箱家用冰箱WIFI智能风冷无霜","subTitle": "家用冰箱1 WIFI智能 风冷无霜",},
            {"id": 452,"name": "MeiLing/美菱 BCD-560WUCX对开门电冰箱家用冰箱WIFI智能风冷无霜","subTitle": "家用冰箱1 WIFI智能 风冷无霜",},
            {"id": 453,"name": "MeiLing/美菱 BCD-560WUCX对开门电冰箱家用冰箱WIFI智能风冷无霜","subTitle": "家用冰箱1 WIFI智能 风冷无霜",},
            {"id": 454,"name": "MeiLing/美菱 BCD-560WUCX对开门电冰箱家用冰箱WIFI智能风冷无霜","subTitle": "家用冰箱1 WIFI智能 风冷无霜",},
          ]},
        {"category_name": "冰箱","cid": 76,"products": [
            {"id": 449,"name": "MeiLing/美菱 BCD-560WUCX对开门电冰箱家用冰箱WIFI智能风冷无霜","subTitle": "家用冰箱1 WIFI智能 风冷无霜",},
            {"id": 450,"name": "MeiLing/美菱 BCD-560WUCX对开门电冰箱家用冰箱WIFI智能风冷无霜","subTitle": "家用冰箱1 WIFI智能 风冷无霜",},
            {"id": 451,"name": "MeiLing/美菱 BCD-560WUCX对开门电冰箱家用冰箱WIFI智能风冷无霜","subTitle": "家用冰箱1 WIFI智能 风冷无霜",},
            {"id": 452,"name": "MeiLing/美菱 BCD-560WUCX对开门电冰箱家用冰箱WIFI智能风冷无霜","subTitle": "家用冰箱1 WIFI智能 风冷无霜",},
            {"id": 453,"name": "MeiLing/美菱 BCD-560WUCX对开门电冰箱家用冰箱WIFI智能风冷无霜","subTitle": "家用冰箱1 WIFI智能 风冷无霜",},
            {"id": 454,"name": "MeiLing/美菱 BCD-560WUCX对开门电冰箱家用冰箱WIFI智能风冷无霜","subTitle": "家用冰箱1 WIFI智能 风冷无霜",},
          ]},
        {"category_name": "冰箱","cid": 76,"products": [
            {"id": 449,"name": "MeiLing/美菱 BCD-560WUCX对开门电冰箱家用冰箱WIFI智能风冷无霜","subTitle": "家用冰箱1 WIFI智能 风冷无霜",},
            {"id": 450,"name": "MeiLing/美菱 BCD-560WUCX对开门电冰箱家用冰箱WIFI智能风冷无霜","subTitle": "家用冰箱1 WIFI智能 风冷无霜",},
            {"id": 451,"name": "MeiLing/美菱 BCD-560WUCX对开门电冰箱家用冰箱WIFI智能风冷无霜","subTitle": "家用冰箱1 WIFI智能 风冷无霜",},
            {"id": 452,"name": "MeiLing/美菱 BCD-560WUCX对开门电冰箱家用冰箱WIFI智能风冷无霜","subTitle": "家用冰箱1 WIFI智能 风冷无霜",},
            {"id": 453,"name": "MeiLing/美菱 BCD-560WUCX对开门电冰箱家用冰箱WIFI智能风冷无霜","subTitle": "家用冰箱1 WIFI智能 风冷无霜",},
            {"id": 454,"name": "MeiLing/美菱 BCD-560WUCX对开门电冰箱家用冰箱WIFI智能风冷无霜","subTitle": "家用冰箱1 WIFI智能 风冷无霜",},
          ]},
        {"category_name": "冰箱","cid": 76,"products": [
            {"id": 449,"name": "MeiLing/美菱 BCD-560WUCX对开门电冰箱家用冰箱WIFI智能风冷无霜","subTitle": "家用冰箱1 WIFI智能 风冷无霜",},
            {"id": 450,"name": "MeiLing/美菱 BCD-560WUCX对开门电冰箱家用冰箱WIFI智能风冷无霜","subTitle": "家用冰箱1 WIFI智能 风冷无霜",},
            {"id": 451,"name": "MeiLing/美菱 BCD-560WUCX对开门电冰箱家用冰箱WIFI智能风冷无霜","subTitle": "家用冰箱1 WIFI智能 风冷无霜",},
            {"id": 452,"name": "MeiLing/美菱 BCD-560WUCX对开门电冰箱家用冰箱WIFI智能风冷无霜","subTitle": "家用冰箱1 WIFI智能 风冷无霜",},
            {"id": 453,"name": "MeiLing/美菱 BCD-560WUCX对开门电冰箱家用冰箱WIFI智能风冷无霜","subTitle": "家用冰箱1 WIFI智能 风冷无霜",},
            {"id": 454,"name": "MeiLing/美菱 BCD-560WUCX对开门电冰箱家用冰箱WIFI智能风冷无霜","subTitle": "家用冰箱1 WIFI智能 风冷无霜",},
          ]},
        {"category_name": "冰箱","cid": 76,"products": [
            {"id": 449,"name": "MeiLing/美菱 BCD-560WUCX对开门电冰箱家用冰箱WIFI智能风冷无霜","subTitle": "家用冰箱1 WIFI智能 风冷无霜",},
            {"id": 450,"name": "MeiLing/美菱 BCD-560WUCX对开门电冰箱家用冰箱WIFI智能风冷无霜","subTitle": "家用冰箱1 WIFI智能 风冷无霜",},
            {"id": 451,"name": "MeiLing/美菱 BCD-560WUCX对开门电冰箱家用冰箱WIFI智能风冷无霜","subTitle": "家用冰箱1 WIFI智能 风冷无霜",},
            {"id": 452,"name": "MeiLing/美菱 BCD-560WUCX对开门电冰箱家用冰箱WIFI智能风冷无霜","subTitle": "家用冰箱1 WIFI智能 风冷无霜",},
            {"id": 453,"name": "MeiLing/美菱 BCD-560WUCX对开门电冰箱家用冰箱WIFI智能风冷无霜","subTitle": "家用冰箱1 WIFI智能 风冷无霜",},
            {"id": 454,"name": "MeiLing/美菱 BCD-560WUCX对开门电冰箱家用冰箱WIFI智能风冷无霜","subTitle": "家用冰箱1 WIFI智能 风冷无霜",},
          ]},
        {"category_name": "冰箱","cid": 76,"products": [
            {"id": 449,"name": "MeiLing/美菱 BCD-560WUCX对开门电冰箱家用冰箱WIFI智能风冷无霜","subTitle": "家用冰箱1 WIFI智能 风冷无霜",},
            {"id": 450,"name": "MeiLing/美菱 BCD-560WUCX对开门电冰箱家用冰箱WIFI智能风冷无霜","subTitle": "家用冰箱1 WIFI智能 风冷无霜",},
            {"id": 451,"name": "MeiLing/美菱 BCD-560WUCX对开门电冰箱家用冰箱WIFI智能风冷无霜","subTitle": "家用冰箱1 WIFI智能 风冷无霜",},
            {"id": 452,"name": "MeiLing/美菱 BCD-560WUCX对开门电冰箱家用冰箱WIFI智能风冷无霜","subTitle": "家用冰箱1 WIFI智能 风冷无霜",},
            {"id": 453,"name": "MeiLing/美菱 BCD-560WUCX对开门电冰箱家用冰箱WIFI智能风冷无霜","subTitle": "家用冰箱1 WIFI智能 风冷无霜",},
            {"id": 454,"name": "MeiLing/美菱 BCD-560WUCX对开门电冰箱家用冰箱WIFI智能风冷无霜","subTitle": "家用冰箱1 WIFI智能 风冷无霜",},
          ]},
        {"category_name": "冰箱","cid": 76,"products": [
            {"id": 449,"name": "MeiLing/美菱 BCD-560WUCX对开门电冰箱家用冰箱WIFI智能风冷无霜","subTitle": "家用冰箱1 WIFI智能 风冷无霜",},
            {"id": 450,"name": "MeiLing/美菱 BCD-560WUCX对开门电冰箱家用冰箱WIFI智能风冷无霜","subTitle": "家用冰箱1 WIFI智能 风冷无霜",},
            {"id": 451,"name": "MeiLing/美菱 BCD-560WUCX对开门电冰箱家用冰箱WIFI智能风冷无霜","subTitle": "家用冰箱1 WIFI智能 风冷无霜",},
            {"id": 452,"name": "MeiLing/美菱 BCD-560WUCX对开门电冰箱家用冰箱WIFI智能风冷无霜","subTitle": "家用冰箱1 WIFI智能 风冷无霜",},
            {"id": 453,"name": "MeiLing/美菱 BCD-560WUCX对开门电冰箱家用冰箱WIFI智能风冷无霜","subTitle": "家用冰箱1 WIFI智能 风冷无霜",},
            {"id": 454,"name": "MeiLing/美菱 BCD-560WUCX对开门电冰箱家用冰箱WIFI智能风冷无霜","subTitle": "家用冰箱1 WIFI智能 风冷无霜",},
          ]},
    ];





</script>

<style scoped>
div.productsAsideCategories {
  position: relative;
  width: 100%;
  height: 606px;
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