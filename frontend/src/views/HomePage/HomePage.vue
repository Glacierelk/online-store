<template>
  <Header></Header>
  <SearchComponents></SearchComponents>
  <CategoryAndCarouselComponent></CategoryAndCarouselComponent>
  <BottomListComponent></BottomListComponent>
  <Footer></Footer>

</template>

<script setup>
  import Header from "@/components/user-facing/HeaderComponents.vue";
  import Footer from "@/components/user-facing/FooterComponents.vue";
  import SearchComponents from "@/components/user-facing/SearchComponents.vue";
  import CategoryAndCarouselComponent from "@/components/CategoryAndCarouselComponent.vue";
  import BottomListComponent from "@/components/BottomListComponent.vue";
</script>

<style scoped>
</style>