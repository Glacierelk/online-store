<template>
  <el-tabs v-model="activeTab" @tab-click="handleClick" style="width: 80%;">
    <el-tab-pane label="所有订单"></el-tab-pane>
    <el-tab-pane label="待付款" ></el-tab-pane>
    <el-tab-pane label="待发货"></el-tab-pane>
    <el-tab-pane label="待收货"></el-tab-pane>
    <el-tab-pane label="待评价" ></el-tab-pane>
  </el-tabs>

  <div v-for="(order, orderIndex) in currentOrders" :key="orderIndex" style="width: 80%">

    <el-table :data="[order]" style="width: 100%">
      <el-table-column label="订单创建日期" align="center" width="200">
        <template v-slot="{ row }">
          <div style="margin-bottom: 70px;margin-top: 70px" v-for="(item, index) in row.orderItems" :key="index">
            {{ row.createDate.substring(0, 19) }}
          </div>
        </template>
      </el-table-column>
      <el-table-column label="订单编码" align="center" width="200">
        <template v-slot="{ row }">
          <div style="margin-bottom: 70px;margin-top: 70px" v-for="(item, index) in row.orderItems" :key="index">
            {{ row.orderCode }}
          </div>
        </template>
      </el-table-column>
      <el-table-column label="宝贝" align="left" width="500" header-align="center">
        <template v-slot="{ row }">
          <!--          <p style="text-align: left">{{ row.createDate }} 订单号：{{ row.orderCode }}</p>-->

          <div v-for="(item, index) in row.orderItems" :key="index" class="product-item">
            <div style="margin-top: 35px;margin-bottom: 35px"><img :src="getImagePath(item.imageId)" alt="Product Image"
                                                                   class="product-image" style="padding: 0px">
              &nbsp;&nbsp;&nbsp;&nbsp;
              <span class="itemName" @click="showDetails(item.pid)" style="font-size: 3px">
                {{ item.name }}
              </span>
            </div>
          </div>
        </template>
      </el-table-column>
      <el-table-column label="单价" align="center" width="200">
        <template v-slot="{ row }">
          <div style="margin-bottom: 70px;margin-top: 70px;color: red" v-for="(item, index) in row.orderItems"
               :key="index">
            ￥&nbsp;{{ item.promotePrice.toFixed(2) }}
          </div>
        </template>
      </el-table-column>
      <el-table-column label="数量" align="center" width="80">
        <template v-slot="{ row }">
          <div style=";margin-bottom: 70px;margin-top: 70px" v-for="(item, index) in row.orderItems" :key="index">
            <p>{{ item.count }}</p>
          </div>
        </template>
      </el-table-column>
      <el-table-column prop="totalPrice" label="实付款" align="center" width="120">
        <template v-slot="scope">
          <div style="color: red;font-size: 15px">
            ￥&nbsp;{{ scope.row.totalPrice.toFixed(2) }}
          </div>
        </template>
      </el-table-column>
      <el-table-column label="操作" fixed="right" align="center" width="300">
        <template v-slot="{ row }">
          <div class="button-container">
            <el-button v-if="row.status === 0" @click="pay(row)">付款</el-button>
            <el-button v-if="row.status === 1" @click="remind(row)">催发货</el-button>
            <el-button v-if="row.status === 2" @click="receive(row)">收货</el-button>
            <el-button v-if="row.status === 3" @click="comment(row)">评价</el-button>
          </div>
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>


<script>
import axios from 'axios'
import qs from "qs";
import router from "@/router";
import {ElMessageBox} from "element-plus";

export default {
  props: {
    userId: {
      type: Number,
      required: true
    }
  },
  data() {
    return {
      activeTab: '0',
      allOrders: [],  // 从后端获取的所有订单数据
      currentOrders: []  // 当前选中的订单
    }
  },
  methods: {
    showDetails(pid) {
      router.push({
        path: '/details',
        query: {
          id: pid
        }
      })
    },
    getImagePath(imageId) {
      return require(`@/assets/productSingleSmall/${imageId}.jpg`);
    },
    handleClick(event) {
      // 按照选中的标签筛选订单
      console.log(event.index);
      if (event.index === '0') {
        this.currentOrders = this.allOrders
      } else {
        this.currentOrders = this.allOrders.filter(order => order.status === parseInt(event.index-1))
      }
    },
    async fetchOrders() {
      const response = await axios.post('/order/getOrdersByUserId', qs.stringify({
        "uid": this.userId,
      }))
      // console.log(response.data)
      this.allOrders = response.data.data
      this.currentOrders = this.allOrders
    },

    pay(order) {
      // 实现付款逻辑
      ElMessageBox.confirm('确认付款吗?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        axios.post('/order/updateStatus', qs.stringify({
          "id": order.id,
          "status": order.status
        })).then(response => {
          if (response.data.flag) {
            this.$message({
              message: '付款成功',
              type: 'success'
            })
            this.fetchOrders()
          } else {
            this.$message({
              message: '付款失败',
              type: 'error'
            })
          }
        })

      }).catch(() => {
      });

    },
    remind(order) {
      // 实现催发货逻辑
      axios.post('/order/updateStatus', qs.stringify({
        "id": order.id,
        "status": order.status
      })).then(response => {
        if (response.data.flag) {
          this.$message({
            message: '发货成功',
            type: 'success'
          })
          this.fetchOrders()
        } else {
          this.$message({
            message: '发货失败',
            type: 'error'
          })
        }
      })
    },
    receive(order) {
      // 实现收货逻辑
      ElMessageBox.confirm('确认收货吗?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        axios.post('/order/updateStatus', qs.stringify({
          "id": order.id,
          "status": order.status
        })).then(response => {
          if (response.data.flag) {
            this.$message({
              message: '收货成功',
              type: 'success'
            })
            this.fetchOrders()
          } else {
            this.$message({
              message: '收货失败',
              type: 'error'
            })
          }
        })
      }).catch(() => {
      });
    },
    comment(order) {
      // 实现评价逻辑
      axios.post('/order/updateStatus', qs.stringify({
        "id": order.id,
        "status": order.status
      })).then(response => {
        console.log(response.data);
      })
    }

  },
  mounted() {
    this.fetchOrders()
  }
}
</script>

<style>
.el-tabs__item {
  font-size: 20px; /* 调整字体大小 */
  font-family: "宋体"; /* 调整字体 */
}

.el-tabs__item:hover {
  color: red; /* 调整颜色 */
}

.el-tabs__item.is-active {
  color: red; /* 调整颜色 */
}

.el-tabs__item:focus {
  color: red; /* 调整颜色 */
}

.el-tabs__active-bar {
  background-color: red; /* 调整颜色 */
}

.el-tabs {
  margin-left: 150px; /* 或者你需要的任何距离 */
  margin-right: 150px; /* 或者你需要的任何距离 */
}

.el-table {
  margin-left: 150px;
  margin-right: 150px;
}

.el-table {
  margin-bottom: 50px;
}

.itemName {
  cursor: pointer;
}

.itemName:hover {
  color: orangered;
}


</style>
