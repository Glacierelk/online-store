<template>
  <div>
    <div id="logo">
      <a href="/manage"><img src="https://online-store-wenruyv.oss-cn-beijing.aliyuncs.com/header/simpleLogo.png" alt="logo" class="logo" /></a>
    </div>
    <el-tabs v-model="activeTab">
      <el-tab-pane label="分类管理" name="tab1">
        <Category />
      </el-tab-pane>

      <el-tab-pane label="用户管理" name="tab2">
        <User />
      </el-tab-pane>

      <el-tab-pane label="订单管理" name="tab3">
        <Order />
      </el-tab-pane>
    </el-tabs>
  </div>
</template>

<script setup>
import {ref} from "vue";
import Category from "@/components/manage/CategoryComponents.vue";
import User from "@/components/manage/UserComponents.vue";

//TODO 这个页面有问题, 显示后会崩溃
import Order from "@/components/manage/OrderComponents.vue";


let activeTab = ref("tab1");
</script>

<style>
img {
  float: left;
}
#logo {
  margin-top: 25px;
  margin-bottom: 20px;
  margin-left: 20px;

  overflow: hidden;
}
.el-tabs {
  text-align: center;
  --el-font-size-base: 20px;
  /*align-self: center
  ;*/
  margin-left: 20px;
  margin-right: 20px;
}
</style>
