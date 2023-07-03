<script setup>
import Header from '@/components/user-facing/header-footer/HeaderComponent.vue';
import Footer from '@/components/user-facing/header-footer/FooterComponent.vue';
import SimpleSearchComponents from "@/components/user-facing/search/SimpleSearchComponents.vue";
import ProductDetailsComponent from "@/components/user-facing/ProductDetailsComponent.vue";

window.scroll({
  top: 0,
  left: 0,
  behavior: 'auto'
});
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