<script setup>
import Header from '@/components/user-facing/header-footer/HeaderComponents.vue';
import Footer from '@/components/user-facing/header-footer/FooterComponents.vue';
import SimpleSearchComponents from "@/components/user-facing/search/SimpleSearchComponents.vue";
import ProductDetailsComponent from "@/components/user-facing/ProductDetailsComponent.vue";
</script>

<template>
  <Header/>
  <SimpleSearchComponents/>
  <Suspense>
    <ProductDetailsComponent/>
  </Suspense>
  <Footer/>
</template>

<style scoped>
ProductDetailsComponent {
  //width: 85%;
  margin-left: auto;
  margin-right: auto;
}
</style>