<template>
  <div>
    <el-table :data="userData.slice((currentPage-1)*pageSize, currentPage*pageSize)" style="width: 100%">
      <el-table-column prop="id" label="用户ID" align="center" width="450"></el-table-column>
      <el-table-column prop="username" label="用户名称" align="center" width="450"></el-table-column>
      <el-table-column prop="email" label="用户邮箱" align="center" width="450"></el-table-column>
      <el-table-column prop="address" label="用户地址" align="center" width="450"></el-table-column>
      <el-table-column
          label="操作"
          fixed="right"
          width="170"
      >
        <template v-slot="scope">
          <el-button @click="confirmDelete(scope.row.id)" type="danger" size="small">删除</el-button>
        </template>
      </el-table-column>
      <div class="pagination-container">
        <el-pagination
            @size-change="handleSizeChange"
            @current-change="handleCurrentChange"
            :current-page="currentPage"
            :page-sizes="[5, 10, 20, 50]"
            :page-size="pageSize"
            layout="total, sizes, prev, pager, next, jumper"
            :total="userData.length">
        </el-pagination>
      </div>
    </el-table>
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
      pageSize: 5,
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
            console.log(response.data)
            this.userData = response.data.data;
          })
          .catch(error => {
            console.error(error);
          });
    },
    deleteUser(userId) {
      axios.post('/user/deleteUser', qs.stringify({
        "id": userId,
      }))
          .then(() => {
            this.userData = this.userData.filter(user => user.id !== userId);
          })
          .catch(error => {
            console.error(error);
          });
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