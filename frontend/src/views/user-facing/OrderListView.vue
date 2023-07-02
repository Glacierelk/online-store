<script setup>

import Header from "@/components/user-facing/header-footer/HeaderComponent.vue";
import Footer from "@/components/user-facing/header-footer/FooterComponent.vue";
import OrderListComponent from "@/components/user-facing/OrderListComponent.vue";

</script>

<template>
  <Header />
  <Suspense>
    <OrderListComponent />
  </Suspense>
  <Footer />
</template>

<style scoped>

</style>