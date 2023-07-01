<template xmlns:v-slot="http://www.w3.org/1999/XSL/Transform">
  <div>
    <el-table :data="orderData.slice((currentPage-1)*pageSize, currentPage*pageSize)" style="width: 100%">
      <el-table-column prop="id" label="订单ID" align="center" width="150"></el-table-column>
      <el-table-column prop="uid" label="买家ID" align="center" width="150"></el-table-column>
      <el-table-column prop="orderCode" label="订单编号" align="center" width="200"></el-table-column>
      <el-table-column prop="productCount" label="商品总数" align="center" width="80"></el-table-column>
      <el-table-column prop="totalPrice" label="总金额" align="center" width="150">
        <template v-slot="scope">
          {{ scope.row.totalPrice.toFixed(2) }}
        </template>
      </el-table-column>
      <el-table-column prop="createDate" label="创建时间" align="center" width="200"></el-table-column>
      <el-table-column prop="payDate" label="支付时间" align="center" width="200"></el-table-column>
      <el-table-column prop="deliveryDate" label="发货时间" align="center" width="200"></el-table-column>
      <el-table-column prop="confirmDate" label="确认时间" align="center" width="200"></el-table-column>
      <el-table-column prop="status" label="订单状态" align="center" min-width="100"
      >
        <template v-slot="scope">
          {{ getStatusDescription(scope.row.status) }}
        </template>
      </el-table-column>
      <el-table-column
          label="操作" width="100px"
          fixed="right"
      >
        <template v-slot="scope">
          <el-button
              v-if="scope.row.status === 1"
              @click="deliveryOrder(scope.row.id,scope.row.status)" type="primary" size="small">发货
          </el-button>
        </template>
      </el-table-column>
    </el-table>
    <div class="pagination-container">
      <el-pagination
          @size-change="handleSizeChange"
          @current-change="handleCurrentChange"
          :current-page="currentPage"
          :page-sizes="[5, 10, 20, 50]"
          :page-size="pageSize"
          layout="total, sizes, prev, pager, next, jumper"
          :total="orderData.length">
      </el-pagination>
    </div>
  </div>
</template>

<script>
import axios from 'axios';
import qs from "qs";

export default {
  name: 'OrderComponents',
  data() {
    return {
      orderData: [], // 数据初始化为空
      currentPage: 1,
      pageSize: 5
    };
  },
  mounted() {
    this.fetchData(); // 页面加载时获取数据
  },
  methods: {
    getStatusDescription(status) {
      switch (status) {
        case 0:
          return '待付款';
        case 1:
          return '待发货';
        case 2:
          return '待收货';
        case 3:
          return '待评价';
        case 4:
          return '订单完成';
        default:
          return '未知状态'; // 用于处理可能存在的未知状态
      }
    },
    fetchData() {
      axios.get('/order/getAllOrders')
          .then(response => {
            this.orderData = response.data.data; // 将获取到的数据赋值给orderData
          })
          .catch(error => {
            console.error(error);
          });
    },
    handleSizeChange(val) {
      this.pageSize = val;
      this.currentPage = 1;
    },
    handleCurrentChange(val) {
      this.currentPage = val;
    },
    deliveryOrder(orderId,status){
      axios.post('/order/updateStatus', qs.stringify({
        "id": orderId,
        "status": status,
      }))
          .then(res => {
            if(res.data.flag){
              console.log(res.data);
              this.$message({
                message: '发货成功',
                type: 'success'
              });
              this.fetchData();
            }else {
              this.$message({
                message: '发货失败',
                type: 'error'
              });
            }
          })
          .catch(error => {
            console.error(error);
          });
    }
  }
};
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