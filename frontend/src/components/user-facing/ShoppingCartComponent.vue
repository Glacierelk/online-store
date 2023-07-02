<script>
import axios from "axios";
import {useRouter} from "vue-router";

export default {
  props: {
    userId: {
      type: Number,
      required: true
    }
  },
  data() {
    return {
      show: false,
      tableData: [],
      summary: 0,
      total: 0,
      selection: []
    }
  },
  methods: {
    getImagePath(imageId) {
      return require(`@/assets/productSingleSmall/${imageId}.jpg`);
    },
    async changeCount(cartId, count) {
      await axios.post('/cart/changeCount', {
        id: cartId,
        count: count
      })
          .then(res => {
            if (res.status === 200 && res.data.flag) {
              console.log("修改成功");
            } else {
              alert("修改失败!");
            }
          })
          .catch(err => {
            console.log(err);
          })
    },
    deleteCart(cartId) {
      axios.post('/cart/deleteGoods', {
        id: cartId
      })
          .then(res => {
            if (res.status === 200 && res.data.flag) {
              console.log("删除成功");
              this.tableData = this.tableData.filter(item => item.id !== cartId);
            } else {
              alert("删除失败!");
            }
          })
          .catch(err => {
            console.log(err);
          })
    },
    handleSelectionChange(selection){
      console.log(selection);
      this.selection = selection;
      let sum = 0;
      let cnt = 0;
      selection.forEach(item => {
        sum += item.count * item.product.promotePrice;
        cnt += item.count;
      })
      this.summary = sum.toFixed(2);
      this.total = cnt;
    },
    settlement() {
      alert("jiesuan")
    },
    deleteCarts() {
      if (this.selection.length === 0) {
        alert("请选择要删除的商品!");
        return;
      }
      axios.post('/cart/deleteGoods', {
        id: this.selection.map(item => item.id)
      })
          .then(res => {
            if (res.status === 200 && res.data.flag) {
              alert("删除成功");
              this.tableData = this.tableData.filter(item => !this.selection.includes(item));
            } else {
              alert("删除失败!");
            }
          })
          .catch(err => {
            console.log(err);
          })
    }
  },
  async mounted() {
    // alert(this.userId);
    this.show = false;
    await axios.get('/cart/show?id=' + this.userId)
        .then(res => {
          console.log(res.data);
          if (res.status === 200 && res.data.flag) {
            this.tableData = res.data.data;
          } else {
            alert("获取购物车失败!");
            useRouter().back();
          }
        })
        .catch(err => {
          console.log(err);
        })
    this.show = true;
  }
}

</script>

<template>

  <div>
    <el-table
        v-if="show"
        :data="tableData"
        class="cart-show"
        stripe
        :header-cell-style="{'text-align':'center'}"
        @selection-change="handleSelectionChange"
        width="100%"
    >
      <el-table-column type="selection" width="80" align="center" fixed="left" />

      <el-table-column label="商品图片" prop="imageId" align="center" width="100">
        <template v-slot="scope">
          <el-image :src="getImagePath(scope.row.imageId)"></el-image>
        </template>
      </el-table-column>

      <el-table-column label="商品信息" prop="product.name" align="left" width="800"/>

      <el-table-column label="单价" prop="product.promotePrice" align="center" width="200">
        <template v-slot="scope">
          <span class="price-show">￥&nbsp;{{scope.row.product.promotePrice}}</span>
        </template>
      </el-table-column>

      <el-table-column label="数量" prop="count" align="center" width="250">
        <template v-slot="scope">
          <el-input-number v-model="scope.row.count" :max="scope.row.product.stock" :min="1"
                           @change="changeCount(scope.row.id, scope.row.count)"></el-input-number>
        </template>
      </el-table-column>

      <el-table-column label="总价" align="center" width="150" fixed="right">
        <template v-slot="scope">
          <span class="price-show">￥&nbsp;{{scope.row.product.promotePrice * scope.row.count}}</span>
        </template>
      </el-table-column>

      <el-table-column label="操作" fixed="right" align="center" width="150">
        <template #header>
          <el-button type="danger" @click="deleteCarts" plain>批量删除</el-button>
        </template>
        <template v-slot="scope">
          <el-button type="danger" @click="deleteCart(scope.row.id)" plain>删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <div id="summary-row" v-if="show">
      <span style="vertical-align: center">已选商品&nbsp;</span>
      <span class="price-show">{{ this.total }}</span>
      <span style="vertical-align: center">&nbsp;件，总价&nbsp;</span>
      <span class="price-show" style="font-size: 23px; font-weight: bold">￥&nbsp;{{ this.summary }}</span>
      <el-button type="danger" @click="settlement" id="settlement-button">结算</el-button>
    </div>
  </div>

</template>

<style scoped>

.price-show {
  color: #C60A0A;
}

.el-table_6_column_41 {
  color: #C60A0A;
}

#summary-row {
  display: flex;
  align-items: center;
  justify-content: flex-end;
  background-color: #e5e5e5;
  height: 60px;
  margin-top: 20px;
  border-radius: 10px;
  vertical-align: center;
  text-align: center;
}

#settlement-button {
  font-size: 16px;
  font-weight: bold;
  padding: 18px 26px;
  margin-left: 30px;
  margin-right: 30px;
}

</style>