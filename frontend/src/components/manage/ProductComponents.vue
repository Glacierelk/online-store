<template>
  <div>
    <el-navbar>
      <el-navbar-item index="1">首页</el-navbar-item>
      <el-navbar-item index="2">产品</el-navbar-item>
      <el-navbar-item index="3">关于我们</el-navbar-item>
      <el-navbar-item index="4">联系我们</el-navbar-item>
    </el-navbar>
  </div>
</template>

<script>
import { ElNavbar, ElNavbarItem } from 'element-plus';
export default {
  name: "ProductComponents",
  components: {
    ElNavbar,
    ElNavbarItem
  }

}
</script>

<style scoped>

</style>