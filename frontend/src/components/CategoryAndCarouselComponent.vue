<template>
  <div id="guidePage">
    <img id="catear" :style="{ visibility:'hidden'}" alt="catear" class="catear" src="../assets/HomePage/catear.png"/>
    <div id="categoryWithCarousel" class="categoryWithCarousel">
      <div class="headbar show1">
        <div class="head">
          <div class="leftMenu"><img align="center" alt="list" src="../assets/HomePage/list.png"
                                              style="height: 24px"></div>
          <div class="leftMenu">商品分类</div>
        </div>
        <div class="rightMenu">
          <div @mouseenter="showImage" @mouseleave="hideImage" style="float: left;">
             <a href=""><img alt="chaoshi" src="../assets/HomePage/chaoshi.png"/></a>
          </div>
          <div style="padding-left: 40px; float: left" @mouseenter="showImage" @mouseleave="hideImage">
            <a href=""><img alt="guoji" src="../assets/HomePage/guoji.png"/></a>
          </div>
          <div v-for="(category,index) in categories" :key="category.name" class="categoryTab">
            <a v-if="index<5" href="#" @mouseenter="showImage" @mouseleave="hideImage">{{ category.name }}</a>
          </div>
        </div>
      </div>
    </div>
    <CategoryMenuComponent></CategoryMenuComponent>
  </div>
</template>

<script setup>
import CategoryMenuComponent from "@/components/CategoryMenuComponent.vue";

let categories = [
  {name: "平板电视", icon: "#", href: ""},
  {name: "马桶", icom: "", href: ""},
  {name: "沙发", icon: "", href: ""},
  {name: "电热水器", icon: "", href: ""},
  {name: "冲浪板冲浪板", icon: "", href: ""},
  {name: "冲浪板", icon: "", href: ""},
  {name: "冲浪板", icon: "", href: ""},
  {name: "冲浪板", icon: "", href: ""},
  {name: "冲浪板", icon: "", href: ""},
  {name: "冲浪板", icon: "", href: ""},
  {name: "冲浪板", icon: "", href: ""},
  {name: "冲浪板", icon: "", href: ""},
  {name: "冲浪板", icon: "", href: ""},
  {name: "冲浪板", icon: "", href: ""},
  {name: "冲浪板", icon: "", href: ""},
];

function showImage() {
  //eslint-disable-next-line no-unused-vars
  const {left: left, right: right, top, width: width} = event.target.getBoundingClientRect();
  let catear = document.getElementById("catear");
  let destLeft = left + (width) / 2 - 45 / 2//找到box的中间位置,45是猫图片的长度（加上了padding）
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

#guidePage {
  margin-left: 1%;
  margin-right: 1%;
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