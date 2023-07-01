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
      selection: [],
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
      axios.post('/cart/delete', {
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
    },
    getSum() {
      let sums = ["总计", "", "", "", "", "", ""];
      let sum = 0;
      this.selection.forEach(item => {
        sum += item.count * item.product.promotePrice;
      })
      sums[5] = "￥ " + String(sum.toFixed(2));
      return sums;
    },
    isSummaryRow(scope) {
      return scope.row.id === this.tableData.length + 1;
    },
    settlement() {
      alert("jiesuan")
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
  <el-table
      v-if="show"
      :data="tableData"
      class="cart-show"
      stripe
      :header-cell-style="{'text-align':'center'}"
      @selection-change="handleSelectionChange"
      show-summary
      :summary-method="getSum"
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

    <el-table-column label="操作" fixed="right" align="center" width="100">
      <template v-slot="scope">
        <el-button v-if="isSummaryRow(scope)" type="danger" @click="settlement">结算</el-button>
        <el-button v-else type="danger" @click="deleteCart(scope.row.id)" plain>删除</el-button>
      </template>
    </el-table-column>

  </el-table>


</template>

<style scoped>

.price-show {
  color: #C60A0A;
}

.el-table_6_column_41 {
  color: #C60A0A;
}

</style>