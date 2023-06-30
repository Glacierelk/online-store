<template>
  <table style="margin-left: auto; margin-right: auto">
    <tr>
      <td>
        <div class="imgDiv">
          <a href="#">
            <img id="logo" alt="logo" class="logo" src="../../assets/header/logo.gif">
          </a>
        </div>
      </td>
      <td>
        <div class="searchDiv">
          <div style="overflow: hidden;">
            <input v-model="keyword" class="searchEnter" name="keyword" placeholder="电视机" type="text">
            <button class="searchButton" @click="search">搜索</button>
          </div>
          <div class="searchBelow">
              <span v-for="(item,index) in recomment" :key="item">
                <a class="item" href="#" @click="fastSearch(item)">{{ item }}</a>
                &nbsp; &nbsp;
                <span v-if="index<2">|</span>
                &nbsp; &nbsp;
              </span>
          </div>
        </div>
      </td>
    </tr>
  </table>
</template>

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
  if (window.location.href.split('/').pop() !== "search") {
    router.push({path: "/search", query: {keyword: keyword.value}});
  }
}

function fastSearch(item) {
  keyword.value = item;
  // alert(keyword.value)
  search();
}

</script>

<style scoped>
div.searchBelow {
  margin-top: 10px;
  margin-left: -20px;
  text-align: center;
}

div.searchBelow a {
//padding: 0 20px 0 20px; font-size: 14px;
}


div.searchDiv {
  width: 400px;
  margin: 50px auto;
//padding: 1px; height: 40px;
  display: block;
  align-items: center;
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

a:hover {
  color: #ff6ba4;
}

a.item {
  color: gray;
  text-decoration: none;
}

.searchButton {
  width: 15%;
}
</style>