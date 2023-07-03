<template>
  <el-tabs v-model="activeTab" style="width: 80%;" @tab-click="handleClick">
    <el-tab-pane label="所有订单"></el-tab-pane>
    <el-tab-pane label="待付款"></el-tab-pane>
    <el-tab-pane label="待发货"></el-tab-pane>
    <el-tab-pane label="待收货"></el-tab-pane>
    <el-tab-pane label="待评价"></el-tab-pane>
  </el-tabs>

  <div v-for="(order, orderIndex) in currentOrders" :key="orderIndex" style="width: 80%">

    <el-table :data="[order]" stripe style="width: 100%">
      <el-table-column align="center" label="订单创建日期" width="200">
        <template v-slot="{ row }">
          <div :key="index" style="margin-bottom: 70px;margin-top: 70px">
            {{ row.createDate.substring(0, 19) }}
          </div>
        </template>
      </el-table-column>
      <el-table-column align="center" label="订单编码" width="200">
        <template v-slot="{ row }">
          <div :key="index" style="margin-bottom: 70px;margin-top: 70px">
            {{ row.orderCode }}
          </div>
        </template>
      </el-table-column>
      <el-table-column align="left" header-align="center" label="宝贝" width="500">
        <template v-slot="{ row }">
          <!--          <p style="text-align: left">{{ row.createDate }} 订单号：{{ row.orderCode }}</p>-->

          <div v-for="(item, index) in row.orderItems" :key="index" class="product-item">
            <div style="margin-top: 35px;margin-bottom: 35px"><img :src="getImagePath(item.imageId)" alt="Product Image"
                                                                   class="product-image" style="padding: 0">
              &nbsp;&nbsp;&nbsp;&nbsp;
              <span class="itemName" style="font-size: 3px" @click="showDetails(item.pid)">
                {{ item.name }}
              </span>
            </div>
          </div>
        </template>
      </el-table-column>
      <el-table-column align="center" label="单价" width="200">
        <template v-slot="{ row }">
          <div v-for="(item, index) in row.orderItems" :key="index"
               style="margin-bottom: 70px;margin-top: 70px;color: red">
            ￥&nbsp;{{ item.promotePrice.toFixed(2) }}
          </div>
        </template>
      </el-table-column>
      <el-table-column align="center" label="数量" width="80">
        <template v-slot="{ row }">
          <div v-for="(item, index) in row.orderItems" :key="index" style=";margin-bottom: 70px;margin-top: 70px">
            <p>{{ item.count }}</p>
          </div>
        </template>
      </el-table-column>
      <el-table-column align="center" label="实付款" prop="totalPrice" width="120">
        <template v-slot="scope">
          <div style="color: red;font-size: 15px">
            ￥&nbsp;{{ scope.row.totalPrice.toFixed(2) }}
          </div>
        </template>
      </el-table-column>
      <el-table-column align="center" fixed="right" label="操作" width="300">
        <template v-slot="{ row }">
          <div class="button-container">
            <el-button v-if="row.status === 0" @click="pay(row)" type="danger" plain>付款</el-button>
            <el-button v-if="row.status === 1" @click="remind(row)">催发货</el-button>
            <el-button v-if="row.status === 2" @click="receive(row)" type="success" plain>收货</el-button>
            <el-button v-if="row.status === 3" @click="comment(row)" type="primary" plain>评价</el-button>
            <i v-if="row.status === 4" class="fa fas fa-check-circle" style="color: green;font-size: xx-large"></i>
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
      return "https://online-store-wenruyv.oss-cn-beijing.aliyuncs.com/productSingleSmall/" + imageId + ".jpg"
    },
    handleClick(event) {
      // 按照选中的标签筛选订单
      console.log(event.index);
      if (event.index === '0') {
        this.currentOrders = this.allOrders
      } else if (this.allOrders) {
        this.currentOrders = this.allOrders.filter(order => order.status === parseInt(event.index - 1))
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
            this.activeTab = '0'
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
          this.activeTab = '0'
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
            this.activeTab = '0'
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
      ElMessageBox.prompt('请填写评价', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        inputPattern: /\S/,
        inputErrorMessage: '评价不能为空'
      }).then(({value}) => {
        // 创建一个空的 promises 数组，用于存放所有的评价请求
        let commentPromises = [];

        // 遍历订单中的每个商品
        order.orderItems.forEach(item => {
          // 为每个商品创建一个评价请求，并将该请求添加到 promises 数组中
          let commentPromise = axios.post('/comment/addComment', qs.stringify({
            "pid": item.pid,
            "uid": this.userId,
            "content": value
          }));
          commentPromises.push(commentPromise);
        });

        // 使用 Promise.all 执行所有的评价请求
        Promise.all(commentPromises)
            .then(responses => {
              // 判断所有的评价请求是否都成功
              let allSuccess = responses.every(response => response.data.flag);

              if (allSuccess) {
                // 如果所有的评价请求都成功，更新订单状态
                axios.post('/order/updateStatus', qs.stringify({
                  "id": order.id,
                  "status": order.status
                }));
                this.$message({
                  message: '评价成功',
                  type: 'success'
                });
                this.fetchOrders();
                this.activeTab = '0'
              } else {
                this.$message({
                  message: '部分评价失败',
                  type: 'error'
                });
              }
            })
            .catch(() => {
              this.$message({
                message: '评价失败',
                type: 'error'
              });
            });
      }).catch(() => {
        // 用户取消评价
      });
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
