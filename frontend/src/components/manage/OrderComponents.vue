<template>
  <div>
    <el-table :data="orderData" style="width: 100%">
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
import {ref, computed, onMounted} from 'vue';
import axios from 'axios';
// eslint-disable-next-line no-unused-vars
import {ElMessageBox} from 'element-plus';
// eslint-disable-next-line no-unused-vars
import qs from "qs";

export default {
  name: "ManageOrder",
  setup() {
    const tableHeader = ref({
      id: "订单ID",
      status: "订单状态",
      price: "订单金额",
      amount: "商品数量",
      cname: "买家名称",
      createdate: "创建时间",
      paydate: "支付时间",
      deliverdate: "发货时间",
      confirmdate: "确认收货时间",
    });
    const orderData = ref([]);

    const processedTableHeader = computed(() => {
      const headers = {...tableHeader.value};
      delete headers.delete;
      return headers;
    });


    onMounted(() => {
      axios.get('http://localhost:8080/store/order/getAllOrders')
          .then(response => {
            orderData.value = response.data.data;
          })
          .catch(error => {
            console.error(error);
          });
    });

    return {
      processedTableHeader,
      orderData,
    }
  }
}
</script>
