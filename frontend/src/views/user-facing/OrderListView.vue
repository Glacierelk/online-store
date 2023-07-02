<script setup>
import Header from "@/components/user-facing/header-footer/HeaderComponent.vue";
import Footer from "@/components/user-facing/header-footer/FooterComponent.vue";
import SimpleSearchComponents from "@/components/user-facing/search/SimpleSearchComponents.vue";
import OrderListComponent from "@/components/user-facing/OrderListComponent.vue";
import {useRoute} from "vue-router";

const route = useRoute();
const uid = parseInt(route.query.id.toString());
</script>

<template>
<div style="width: 100%">
  <Header />
  <SimpleSearchComponents />
  <Suspense>
    <OrderListComponent :userId = "uid" id = "order-list" />
  </Suspense>
  <Footer />
</div>
</template>

<style scoped>
#order-list {
  width: 80%;
  margin: 0 auto 20px;
}
</style>