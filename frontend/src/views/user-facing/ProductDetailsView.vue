<script setup>
import axios from "axios";
import Header from '@/components/user-facing/HeaderComponents.vue';
import Footer from '@/components/user-facing/FooterComponents.vue';
import SimpleSearchComponents from "@/components/search/SimpleSearchComponents.vue";
import qs from 'qs';
import {useRouter, useRoute} from "vue-router";
import {ref} from "vue";

const router = useRouter();
const route = useRoute();
const data = ref({});
const count = ref(0);
const leftImage = "";
const showImages = ref([]);
const activeTab = "tab1";

function getDetails(id) {
  axios.post('/product/details', qs.stringify({
    id: id
  }))
      .then(res => {
        console.log(res.data);
        if (res.status === 200 && res.data.flag) {
          data.value = res.data.data;
          console.log(data.value);

          data.value.images.forEach(item => {
            if (item.type === "type_single") {
              showImages.value.push(item.id);
            }
          })
        }
        else {
          alert("获取商品详情失败!");
          router.back();
        }
      })
      .catch(() => {
        alert("获取商品详情失败!");
        router.back();
      })
}

console.log(route.query.id);
getDetails(route.query.id);

function getCategoryPath() {
  return "../../assets/category/" + data.value.cid + ".jpg";
}

function getImagePath(id) {
  return require("../../assets/productSingleSmall/" + id + ".jpg");
}

function getComment() {
  return "累计评价" + data.value.comments.length;
}

</script>

<template>
  <div>
    <Header />
    <SimpleSearchComponents />
  </div>

  <div>
    <table class="product-show">
      <tr>
        <td>
          <img :src="getCategoryPath()" alt="商品图片">
        </td>
      </tr>

      <tr>
        <td>
          <table class="product-show-left">
            <tr>
              <td>
                <img :src="leftImage" alt="商品图片" />
              </td>
            </tr>

            <tr>
              <td>
                <img
                    v-for="item in showImages"
                    :key="item.id"
                    :src="getImagePath(item.id)"
                    alt="商品缩略图" />
              </td>
            </tr>
          </table>
        </td>

        <td>
          <table class="product-show-right">
            <tr>
              <td class="name">
                {{ data.value.name }}
              </td>
            </tr>

            <tr>
              <td>
                {{ data.value.subTitle }}
              </td>
            </tr>

            <tr>
              <td>
                <div class="price-show">
                  <div class="juhuasuan">
                    <span class="juhuasuanBig">聚划算</span>
                    <span>此商品即将参加聚划算，<span class="juhuasuanTime">1天19小时</span>后开始，</span>
                  </div>

                  <div>
                    <span class="common-font">价格</span>
                    <span>￥</span>
                    <span class="original-price-show">{{data.value.originalPrice}}</span>
                  </div>

                  <div>
                    <span class="common-font">促销价</span>
                    <span class="promote-dollar">￥</span>
                    <span class="promote-price-show">{{data.value.promotePrice}}</span>
                  </div>
                </div>
              </td>
            </tr>

            <tr>
              <td>
                <span class="common-font">数量</span>
                <el-input-number v-model="count" :min="1" :max="data.value.stock"></el-input-number>
                <span class="common-font">件&nbsp;库存{{data.value.stock}}件</span>
              </td>
            </tr>

            <tr>
              <td>
                <span class="common-font">
                  服务承诺&nbsp;极速退款&nbsp;赠运费险&nbsp;七天无理由退换
                </span>
              </td>
            </tr>

            <tr>
              <td>
                <el-button type="danger" plain>立即购买</el-button>
                <el-button type="danger">
                  <i class="fa fa-shopping-cart" aria-hidden="true"></i>
                  加入购物车
                </el-button>
              </td>
            </tr>
          </table>
        </td>
      </tr>
    </table>

    <el-tabs v-model="activeTab" type="card">
      <el-tab-pane label="商品详情" name="tab1">
        <div class="common-font">

        </div>
      </el-tab-pane>

      <el-tab-pane :label="getComment()" name="tab2">

      </el-tab-pane>
    </el-tabs>
  </div>

  <div>
    <Footer />
  </div>
</template>

<style scoped>

.name {
  font-size: 23px;
  font-weight: bold;
}

.juhuasuan {
  /* height: 40px; */
  background-color: #2DA77A;
  color: white;
  text-align: center;
  line-height: 40px;
  margin-top: 10px;
}

.juhuasuanBig {
  font-size: 18px;
  font-weight: bold;
  font-family: Arial,serif;
}

.juhuasuanTime {
  color: #FFC057;
  font-weight: bold;
}

</style>