<template>
  <div id = "body">
    <el-table :data="userData" style="width: 100%; text-align: center">
      <el-table-column
          :prop="index"
          :label="item"
          v-for="(item, index) in processedTableHeader"
          :key="index"
      >
      </el-table-column>
      <el-table-column
          label="操作"
      >
        <template v-slot="scope">
          <el-button @click="confirmDelete(scope.row.id)" type="danger" size="small">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
import { ref, computed, onMounted } from 'vue';
import axios from 'axios';
import { ElMessageBox } from 'element-plus';
import qs from "qs";

export default {
  name: "ManageUser",
  setup() {
    const tableHeader = ref({
      id: "用户ID",
      username: "用户名称",
      email: "用户邮箱",
      address: "用户地址",
    });
    const userData = ref([]);

    const processedTableHeader = computed(() => {
      const headers = { ...tableHeader.value };
      delete headers.delete;
      return headers;
    });

    const deleteUser = (userId) => {
      axios.post('/user/deleteUser', qs.stringify({
            "id": userId,
          }))
          .then(() => {
            userData.value = userData.value.filter(user => user.id !== userId);
          })
          .catch(error => {
            console.error(error);
          });
    }

    const confirmDelete = (userId) => {
      ElMessageBox.confirm('确认删除此用户吗?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        deleteUser(userId);
      }).catch(() => { });
    }

    onMounted(() => {
      axios.get('/user/getAllUser')
          .then(response => {
            userData.value = response.data;
          })
          .catch(error => {
            console.error(error);
          });
    });

    return {
      processedTableHeader,
      userData,
      confirmDelete
    }
  }
}
</script>

<style>
#body {
  margin-top: 20px;
  width: 95%;
  text-align: center;
}

.el-table {
  text-align: center;
}
</style>
