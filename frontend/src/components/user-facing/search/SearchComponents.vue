<template>
  <table style="margin-left: auto; margin-right: auto">
    <tr>
      <td>
        <div class="imgDiv">
          <router-link to="/">
            <img id="logo" alt="logo" class="logo"
                 src="https://online-store-wenruyv.oss-cn-beijing.aliyuncs.com/header/logo.gif">
          </router-link>
        </div>
      </td>
      <td>
        <SearchBox @search="handle"/>
      </td>
    </tr>
  </table>
</template>

<script setup>
import SearchBox from "@/components/user-facing/search/SearchBox.vue";
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