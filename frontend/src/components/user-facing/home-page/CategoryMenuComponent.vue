<template>
  <div class="guideMenu" id="guideMenu">
    <div class="categoryMenu" id="categoryMenu">
      <div v-for="(category,index) in categories" :key="category.category_name">
        <div @mouseenter="showMenu(index,$event)" @mouseleave="hideMenu(index,$event)" v-if="index<16"  class="eachCategory" >
          <span><img height="18" align="center" class="eachCategoryImg" src="https://online-store-wenruyv.oss-cn-beijing.aliyuncs.com/HomePage/Clip.png" alt="clip"></span>
          <span style="margin-left: 10px;cursor: pointer" @click="fastSearch(category.category_name)">{{category.category_name}} </span>
          <span></span>
        </div>
      </div>

    </div>

    <ProductsAsideCategoriesComponent></ProductsAsideCategoriesComponent>
    <SwiperComponent></SwiperComponent>
  </div>
</template>

<script setup>
  import ProductsAsideCategoriesComponent from "@/components/user-facing/home-page/ProductsAsideCategoriesComponent.vue";
  import SwiperComponent from "@/components/user-facing/home-page/SwiperComponent.vue";
  import {defineEmits, ref} from "vue";
  import {useRouter} from "vue-router";
  const emit = defineEmits(["search"]);
  const router = useRouter();
  let keyword = ref("");

  function fastSearch(item) {
    keyword.value = item;
    // alert(keyword.value)
    search();
  }
  const search = () => {
    // alert(keyword.value)
    emit('search', keyword.value);
    if (!window.location.href.includes("search")) {
      router.push({path: "/search", query: {keyword: keyword.value}});
    }
  }
  var categories=ProductsAsideCategoriesComponent.data().categories
  function showMenu(index,e){
    //alert(index);
    e.target.style.backgroundColor="white"
    ProductsAsideCategoriesComponent.methods.showMenu(index);
  }
  function hideMenu(index,e) {
    e.target.style.backgroundColor="#e2e2e3"
    ProductsAsideCategoriesComponent.methods.hideMenu(index);
  }


</script>

<style scoped>
  ProductsAsideCategoriesComponent{
    float: left;
  }

  div.categoryMenu {
    float: left;
    width: 200px;
    background-color: #e2e2e3;
    /* 	padding-bottom:10px; */
    left: 0;
    top: 0;
    z-index: 1;
    text-align: left;
    border-style: solid;
    border-width: 1px;
    border-color: #e2e2e3;
    position: relative;
  }

  div.categoryMenu a {
    color: #000;
    text-decoration: none;
    margin-left: 10px;

  }

  div.categoryMenu a:hover {
    color: lightskyblue;
    text-decoration: none;
  }

  div.eachCategory {
    padding: 5px;
    border-style: solid;
    border-width: 1px;
    border-color: rgb(219, 217, 217);
  }
  img.eachCategoryImg {
    margin-left: 10px;
  }
</style>