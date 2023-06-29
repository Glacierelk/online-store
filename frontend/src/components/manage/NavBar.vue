<template>
  <div class="navbar">
    <a @click="currentTab = 'category'">分类管理</a>
    <a @click="currentTab = 'user'">用户管理</a>
    <a @click="currentTab = 'order'">订单管理</a>
  </div>
</template>

<script>
import { ref } from 'vue';

export default {
  setup() {
    const currentTab = ref('user');

    return {
      currentTab
    };
  }
};
</script>

<style>
.navbar {
  background-color: #f2f2f2;
  padding: 10px;
}

.navbar a {
  margin-right: 10px;
}
</style>
