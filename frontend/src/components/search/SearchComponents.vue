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
        <SearchBox @search="handle" />
      </td>
    </tr>
  </table>
</template>

<script setup>
import SearchBox from "@/components/search/SearchBox.vue";
import {defineEmits} from "vue";

const emit = defineEmits(["search"]);
function handle(item) {
  emit("search", item);
}
</script>

<style scoped>

td {
  vertical-align: center;
}

</style>