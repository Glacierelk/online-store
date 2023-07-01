<script setup>
import Header from "@/components/user-facing/header-footer/HeaderComponents.vue";
import Footer from "@/components/user-facing/header-footer/FooterComponents.vue";
import SimpleSearchComponents from "@/components/user-facing/search/SimpleSearchComponents.vue";
import ShoppingCartComponent from "@/components/user-facing/ShoppingCartComponent.vue";
import { useRoute } from "vue-router";

const route = useRoute();
const uid = parseInt(route.query.id.toString());
</script>

<template>
  <Header />
  <SimpleSearchComponents />
  <Suspense>
    <ShoppingCartComponent :userId="uid" id="shopping-cart" />
  </Suspense>
  <Footer />
</template>

<style scoped>

#shopping-cart {
  width: 80%;
  margin: 0 auto 20px;
}

</style>