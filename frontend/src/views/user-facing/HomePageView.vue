<template>
  <div class="homePageDiv">
    <Header></Header>
    <SearchComponents></SearchComponents>
    <div class="categoryNavBar">
      <CategoryAndCarouselComponent></CategoryAndCarouselComponent>
    </div>
    <BottomListComponent></BottomListComponent>
    <Footer></Footer>
  </div>
</template>

<script setup>
import Header from "@/components/user-facing/header-footer/HeaderComponent.vue";
import Footer from "@/components/user-facing/header-footer/FooterComponent.vue";
import SearchComponents from "@/components/user-facing/search/SearchComponents.vue";
import CategoryAndCarouselComponent from "@/components/user-facing/home-page/CategoryAndCarouselComponent.vue";
import BottomListComponent from "@/components/user-facing/home-page/BottomListComponent.vue";
</script>

<style scoped>

.homePageDiv {
  min-width: 1300px;
}

.categoryNavBar {
  margin-left: auto;
  margin-right: auto;
}
</style>