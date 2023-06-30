<template>
  <div>
    <Header></Header>
    <SearchComponents @search="search"></SearchComponents>
  </div>

<!--  <ul v-infinite-scroll="load" class="infinite-list" style="overflow: auto">-->
<!--    <li v-for="i in rowCount" :key="i" class="infinite-list-item">{{ i }}</li>-->
<!--  </ul>-->

  <div>
    <Footer></Footer>
  </div>
</template>

<script setup>
// import { ref, computed } from 'vue'
import Header from '@/components/user-facing/HeaderComponents.vue'
import SearchComponents from "@/components/user-facing/SearchComponents.vue";
import Footer from "@/components/user-facing/FooterComponents.vue";
import axios from "axios";
import qs from "qs";

function search() {
  alert("search")
  axios.post('/product/search', qs.stringify({
    "name": "",
  }))
      .then(res => {
        console.log(res.data);
      })
      .catch(() => {
        alert("搜索失败，请重试！");
      })
}

</script>

<style>

.infinite-list {
  height: 300px;
  padding: 0;
  margin-top: 2%;
  margin-left: auto;
  margin-right: auto;
  list-style: none;
  width: 95%;
  display: grid; /* 使用网格布局 */
  grid-template-columns: repeat(4, 1fr); /* 每行展示四个列 */
  gap: 20px; /* 列之间的间距 */
}

.infinite-list .infinite-list-item {
  display: flex;
  align-items: center;
  justify-content: center;
  height: 50px;
  background: var(--el-color-primary-light-9);
  color: var(--el-color-primary);
}
</style>
