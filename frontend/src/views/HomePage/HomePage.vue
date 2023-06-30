<template>
  <Header></Header>
  <SearchComponents></SearchComponents>
  <CategoryAndCarouselComponent></CategoryAndCarouselComponent>
  <div class="blank"></div>
  <Footer></Footer>

</template>

<script setup>
  import Header from "@/components/user-facing/HeaderComponents.vue";
  import Footer from "@/components/user-facing/FooterComponents.vue";
  import SearchComponents from "@/components/user-facing/SearchComponents.vue";
  import CategoryAndCarouselComponent from "@/components/CategoryAndCarouselComponent.vue";
</script>

<style scoped>
div.blank {
  height: 1000px;
  width: 1000px;
}
</style>