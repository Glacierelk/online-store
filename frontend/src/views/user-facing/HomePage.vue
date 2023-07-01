<template>
  <Header></Header>
  <SearchComponents></SearchComponents>
  <div class="categoryNavBar"><CategoryAndCarouselComponent></CategoryAndCarouselComponent></div>
  <BottomListComponent></BottomListComponent>
  <Footer></Footer>
</template>

<script setup>
  import Header from "@/components/user-facing/header-footer/HeaderComponents.vue";
  import Footer from "@/components/user-facing/header-footer/FooterComponents.vue";
  import SearchComponents from "@/components/user-facing/search/SearchComponents.vue";
  import CategoryAndCarouselComponent from "@/components/user-facing/home-page/CategoryAndCarouselComponent.vue";
  import BottomListComponent from "@/components/user-facing/home-page/BottomListComponent.vue";
</script>

<style scoped>
.categoryNavBar {
  width: 90%;
  margin-left: auto;
  margin-right: auto;
}
</style>