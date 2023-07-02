<script setup>
import SearchBox from "@/components/user-facing/search/SearchBox.vue";
import {defineEmits} from "vue";

const emit = defineEmits(["search"]);
function handle(item) {
  emit("search", item);
}
</script>

<template>
  <table id="simpleSearch">
    <tr>
      <td style="margin-right: 50%; text-align: left">
        <img src="../../../assets/header/simpleLogo.png" alt="logo" style="float: left" />
      </td>
      <td style="text-align: right">
        <SearchBox @click="handle" style="float: right;" />
      </td>
    </tr>
  </table>
</template>

<style scoped>
#simpleSearch {
  overflow: hidden;
  width: 70%;
  align-items: center;
  margin-left: auto;
  margin-right: auto;
  //border: red 1px solid;
  height: 50px;
}

td {
  vertical-align: center;
}
</style>