<template>
  <div id="guidePage">
    <img src="../assets/HomePage/catear.png" :style="{ visibility:'hidden'}" id="catear" class="catear" alt="catear"/>
    <div id="categoryWithCarousel" class="categoryWithCarousel">
      <div class="headbar show1">
        <div class="head">
          <span style="margin-left:10px"><img align="center" style="height: 24px" src="../assets/HomePage/list.png" alt="list"></span>
          <span style="margin-left:10px">商品分类</span>
        </div>
        <div class="rightMenu" >
    <span @mouseenter="showImage" @mouseleave="hideImage">
       <a href=""><img align="center" src="../assets/HomePage/chaoshi.png" alt="chaoshi"/></a>
    </span >
          <span style="padding-left: 40px;" @mouseenter="showImage" @mouseleave="hideImage">
        <a href=""><img align="center"  src="../assets/HomePage/guoji.png" alt="guoji"/></a>
    </span>
          <span @mouseenter="showImage" @mouseleave="hideImage" class="categoryTab" v-for="(category,index) in categories" :key="category.name">
                <a href="#" v-if="index<5">{{category.name}}</a>
    </span>
        </div>
      </div>
    </div>
    <CategoryMenuComponent></CategoryMenuComponent>
  </div>

</template>

<script setup>
  import CategoryMenuComponent from "@/components/CategoryMenuComponent.vue";
  let categories=[
      {name:"平板电视",icon:"#",href:""},
      {name:"马桶",icom:"",href:""},
      {name:"沙发",icon:"",href:""},
      {name:"电热水器",icon:"",href:""},
      {name:"冲浪板冲浪板",icon:"",href:""},
      {name:"冲浪板",icon:"",href:""},
      {name:"冲浪板",icon:"",href:""},
      {name:"冲浪板",icon:"",href:""},
      {name:"冲浪板",icon:"",href:""},
      {name:"冲浪板",icon:"",href:""},
      {name:"冲浪板",icon:"",href:""},
      {name:"冲浪板",icon:"",href:""},
      {name:"冲浪板",icon:"",href:""},
      {name:"冲浪板",icon:"",href:""},
      {name:"冲浪板",icon:"",href:""},
    ];

  function showImage() {
    //eslint-disable-next-line no-unused-vars
    const { left:left,right:right, top, width:width } = event.target.getBoundingClientRect();
    let catear=document.getElementById("catear");
    let destLeft=left+(width)/2-45/2//找到box的中间位置,45是猫图片的长度（加上了padding）
    let destLeftStr=""+destLeft+"px"
    catear.style.visibility="visible";
    catear.style.left=destLeftStr;
    //("aaa")
  }
  function hideImage() {
    let catear=document.getElementById("catear");
    catear.style.visibility="hidden";
  }
</script>

<style scoped>
  div#guidePage {

  }
  div.categoryWithCarousel {
    width: 100%;
    position: relative;
  }
  div.categoryWithCarousel div.headbar {
    background-color: #DD2727;
  }

  div.categoryWithCarousel div.eachCategory span {
    padding-right: 10px;
  }



  div.categoryWithCarousel div.rightMenu {
    display: inline-block;
  }

  div.categoryWithCarousel div.rightMenu img {
    height: 30px;
  }

  div.categoryWithCarousel div.rightMenu span {
    padding: 0 20px 0 20px;
  }

  div.categoryWithCarousel div.rightMenu a {
    font-size: 16px;
    color: white;
  }

  div.categoryWithCarousel div.head {
    width: 200px;
    background-color: #C60A0A;
    height: 36px;
    line-height: 36px;
    font-size: 16px;
    font-weight: bold;
    color: white;
    display: inline-block;
  }

  div.categoryWithCarousel a {
    text-decoration: none;
  }
  img#catear {
    width: 30px;
    position: relative;
  }

</style>