<script setup>
import {ref, defineEmits} from 'vue';
import {useRouter} from "vue-router";

const router = useRouter();

let recomment = ["平衡车", "超大棒棒糖", "芜湖冲浪板"];
let keyword = ref("");
const emit = defineEmits(["search"]);

const search = () => {
  // alert(keyword.value)
  emit('search', keyword.value);
  if (!window.location.href.includes("search")) {
    router.push({path: "/search", query: {keyword: keyword.value}});
  }
}

function fastSearch(item) {
  keyword.value = item;
  // alert(keyword.value)
  search();
}
</script>

<template>
  <div class="searchDiv">
    <div style="overflow: hidden;">
      <input v-model="keyword" class="searchEnter" name="keyword" placeholder="电视机" type="text">
      <button class="searchButton" @click="search">搜索</button>
    </div>
    <div class="searchBelow">
      <span v-for="(item,index) in recomment" :key="item">
        <span class="item" @click="fastSearch(item)">{{ item }}</span>
        &nbsp; &nbsp;
        <span v-if="index<2">|</span>
        &nbsp; &nbsp;
      </span>
    </div>
  </div>
</template>

<style scoped>
div.searchBelow {
  margin-top: 10px;
  margin-left: -20px;
  text-align: center;
}

div.searchDiv {
  width: 400px;
  margin: 50px auto;
  align-items: center;
  overflow: hidden;
}

div.searchDiv input {
  flex: 1;
  width: 275px;
  border: 1px solid #c40000;
  height: 36px;
  margin-left: 2px;
  outline: none;
  float: left;
}

div.searchDiv button {
  width: 110px;
  height: 36px;
  border: 2px solid #c40000;
  background-color: #C40000;
  margin-left: 2px;
  color: white;
  font-size: 20px;
  font-weight: bold;
  float: left;
}

.item:hover {
  color: #ff6ba4;
}

.item {
  color: gray;
  text-decoration: none;
}

.searchButton {
  width: 15%;
}
</style>