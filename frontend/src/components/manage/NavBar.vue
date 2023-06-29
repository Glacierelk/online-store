<template>
  <div id = "header">
    <div id = "logo">
      <a href="/manage/user"><img src="@/assets/header/simpleLogo.png"  alt="logo" class="logo" /></a>
    </div>
    <el-tabs v-model="activeTab">
      <el-tab-pane label="分类管理" name="tab1">
        <!-- 这里是分类管理的内容 -->
      </el-tab-pane>
      <el-tab-pane label="用户管理" name="tab2">
        <!-- 这里是用户管理的内容 -->
      </el-tab-pane>
      <el-tab-pane label="订单管理" name="tab3">
        <!-- 这里是订单管理的内容 -->
      </el-tab-pane>
    </el-tabs>
  </div>
</template>

<script>
export default {
  data() {
    return {
      activeTab: 'tab1'
    };
  }
};
</script>

<style>
img {
  float: left;
}
#logo {
  margin-top: 25px;
  margin-bottom: 15px;
  margin-left: 20px;
  overflow: hidden;
}
.el-tabs {
  text-align: center;
  --el-font-size-base: 20px;
  margin-left: 20px;
  margin-right: 20px;
}
</style>