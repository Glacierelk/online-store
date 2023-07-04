<template>
  <div>
    <el-table :data="userData.slice((currentPage-1)*pageSize, currentPage*pageSize)" stripe
              style="width: 100%;margin-left: 0;margin-right: 0">
      <el-table-column align="center" label="用户ID" prop="id" sortable width="450"></el-table-column>
      <el-table-column align="center" label="用户名称" prop="username" width="450"></el-table-column>
      <el-table-column align="center" label="用户邮箱" prop="email" width="450"></el-table-column>
      <el-table-column align="center" label="用户地址" prop="address" width="450"></el-table-column>
      <el-table-column
          fixed="right"
          label="操作"
          width="170"
      >
        <template v-slot="scope">
          <el-button size="small" type="danger" @click="confirmDelete(scope.row.id)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <div class="pagination-container">
      <el-pagination
          :current-page="currentPage"
          :page-size="pageSize"
          :page-sizes="[5, 10, 20, 50]"
          :total="userData.length"
          layout="total, sizes, prev, pager, next, jumper"
          @size-change="handleSizeChange"
          @current-change="handleCurrentChange">
      </el-pagination>
    </div>
  </div>
</template>

<script>
// import { ref, computed, onMounted } from 'vue';
import axios from 'axios';
import {ElMessageBox} from 'element-plus';
import qs from "qs";

export default {
  name: "ManageUser",
  data() {
    return {
      currentPage: 1,
      pageSize: 10,
      userData: [],
    };
  },
  mounted() {
    this.fetchData(); // 页面加载时获取数据
  },
  methods: {
    fetchData() {
      axios.get('/user/getAllUser')
          .then(response => {
            this.userData = response.data.data;
          })
          .catch();
    },
    deleteUser(userId) {
      axios.post('/user/deleteUser', qs.stringify({
        "id": userId,
      }))
          .then(() => {
            this.userData = this.userData.filter(user => user.id !== userId);
          })
          .catch();
    },

    confirmDelete(userId) {
      ElMessageBox.confirm('确认删除此用户吗?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {

        this.deleteUser(userId);
      }).catch(() => {
      });
    },
    handleSizeChange(val) {
      this.pageSize = val;
      this.currentPage = 1;
    },
    handleCurrentChange(val) {
      this.currentPage = val;
    },
  }
}
</script>

<style scoped>
.pagination-container {
  display: flex;
  justify-content: center;
  align-items: center;
  padding: 20px 0;
}

.el-input__inner {
  font-size: 15px;
}
</style>