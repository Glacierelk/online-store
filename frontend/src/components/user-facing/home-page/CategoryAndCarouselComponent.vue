<template>
  <div id="guidePage">
    <img id="catear" :style="{ visibility:'hidden'}" alt="catear" class="catear" src="../../../assets/HomePage/catear.png"/>
    <div id="categoryWithCarousel" class="categoryWithCarousel">
      <div class="headbar show1">
        <div class="head">
          <div class="leftMenu"><img align="center" alt="list" src="../../../assets/HomePage/list.png" style="height: 24px"></div>
          <div class="leftMenu">商品分类</div>
        </div>
        <div class="rightMenu">
          <div @mouseenter="showImage" @mouseleave="hideImage" style="float: left;">
             <a href=""><img alt="chaoshi" src="../../../assets/HomePage/chaoshi.png"/></a>
          </div>
          <div style="margin-left: 20px; float: left" @mouseenter="showImage" @mouseleave="hideImage">
            <a href=""><img alt="guoji" src="../../../assets/HomePage/guoji.png"/></a>
          </div>
          <div v-for="(category,index) in categories" :key="category.cid" class="categoryTab">
            <a  v-if="index<5" href="#" @mouseenter="showImage" @mouseleave="hideImage">{{ category.category_name }}</a>
          </div>
        </div>
      </div>
    </div>
    <CategoryMenuComponent></CategoryMenuComponent>
  </div>
</template>

<script setup>
import CategoryMenuComponent from "@/components/user-facing/home-page/CategoryMenuComponent.vue";
import ProductsAsideCategoriesComponent from "@/components/user-facing/home-page/ProductsAsideCategoriesComponent.vue";

let categories =ProductsAsideCategoriesComponent.data().categories

function showImage(event) {

  //eslint-disable-next-line no-unused-vars
  const {left: left, right: right,top: top, width: width} = event.target.getBoundingClientRect();
  let catear = document.getElementById("catear");
  //要记得减去margin-left的部分，margin-left是%5,所以用window.innerwidth先得到窗口的宽度，之后再乘以5%来获取需要减去的宽度
  let destLeft = left-window.innerWidth*0.05+width/2-30/2//找到box的中间位置,45是猫图片的长度（加上了padding）
  let destLeftStr = "" + destLeft + "px"
  catear.style.visibility = "visible";
  catear.style.left = destLeftStr;
  //("aaa")
}

function hideImage() {
  let catear = document.getElementById("catear");
  catear.style.visibility = "hidden";
}
</script>

<style scoped>
div.tab{
  width: 1px;
}

#guidePage {
  width: 90%;
  margin-left: 5%;
}

div.categoryWithCarousel {
  width: 100%;
}

div.categoryWithCarousel div.headbar {
  background-color: #DD2727;
}

div.categoryWithCarousel div.eachCategory div {
  padding-right: 10px;
}


div.categoryWithCarousel div.rightMenu {
  display: inline-block;
}

div.categoryWithCarousel div.rightMenu img {
  height: 30px;
}

div.categoryWithCarousel div.rightMenu div {
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

.rightMenu {
  overflow: hidden;
  width: 80%;
}

.categoryTab {
  width: auto;
  float: left;
  margin-top: 2px;
}

.head {
  float: left;
  width: 20%;
}

.leftMenu {
  float: left;
  padding-left: 20px;
  padding-right: 20px;
}

.head {
  overflow: hidden;
}

.rightMenu {
  margin-top: auto;
  margin-bottom: auto;
}

</style>