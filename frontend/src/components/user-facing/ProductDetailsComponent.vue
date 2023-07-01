<template>
  <div v-if="show" id="mainBody">
    <table class="product-show">
      <tr>
        <td colspan="2">
          <img :src="getCategoryPath(this.data.cid)" alt="商品图片" class="top-ad-image">
        </td>
      </tr>

      <tr style="margin-top: 20px">
        <td>
          <table class="product-show-left">
            <tr>
              <td>
                <div class="big-show-div">
                  <img :src="leftImage" alt="商品图片" class="big-show-image"/>
                </div>
              </td>
            </tr>

            <tr>
              <td>
                <img
                    v-for="item in showImages"
                    :key="item"
                    :src="getImagePath(item)"
                    alt="商品缩略图"/>
              </td>
            </tr>
          </table>
        </td>

        <td>
          <table class="product-show-right">
            <tr>
              <td class="name">
                {{ data.name }}
              </td>
            </tr>

            <tr>
              <td v-if="data.subTitle">
                {{ data.subTitle }}
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
                    <span class="original-price-show">{{ data.originalPrice }}</span>
                  </div>

                  <div>
                    <span class="common-font">促销价</span>
                    <span class="promote-dollar">￥</span>
                    <span class="promote-price-show">{{ data.promotePrice }}</span>
                  </div>
                </div>
              </td>
            </tr>

            <tr>
              <td v-if="data.stock">
                <span class="common-font">数量</span>
                <el-input-number v-model="count" :max="data.stock" :min="1"></el-input-number>
                <span class="common-font">件&nbsp;库存{{ data.stock }}件</span>
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
                <el-button plain type="danger">立即购买</el-button>
                <el-button type="danger">
                  <i aria-hidden="true" class="fa fa-shopping-cart"></i>
                  &nbsp;加入购物车
                </el-button>
              </td>
            </tr>
          </table>
        </td>
      </tr>
    </table>

    <el-tabs v-model="activeTab" type="card">
      <el-tab-pane label="商品详情" name="tab1">
        <div class="common-font table-content">
          产品参数 <br/>
          <div class="properties">
            <div v-for="item in data.properties" :key="item.id">
              <span>{{ item.name }}</span>
              <span>{{ item.value }}</span>
            </div>
          </div>
        </div>

        <div class="images table-content" align="center">
          <img
              v-for="item in detailImages"
              :key="item"
              :src="getDetailImagePath(item)"
              alt="商品详情图"/>
        </div>
      </el-tab-pane>

      <el-tab-pane :label="getComment(data.comments.length)" name="tab2">
        <div class="comment-show table-content">
          <div v-for="item in data.comments" :key="item.id">
            <div class="comment-show-header">
              <span>{{ item.user.name }}</span>
              <span>{{ item.createDate }}</span>
            </div>

            <div class="comment-show-content">
              {{ item.content }}
            </div>
          </div>
        </div>
      </el-tab-pane>
    </el-tabs>
  </div>
</template>

<script>
import axios from "axios";
import qs from 'qs';
import {useRouter, useRoute} from "vue-router";

export default {
  name: "ProductDetails",
  data() {
    return {
      show: false,
      router: useRouter(),
      route: useRoute(),
      count: 0,
      leftImage: "",
      data: {
        id: 0,
        name: "",
        subTitle: "",
        originalPrice: 0,
        promotePrice: 0,
        stock: 0,
        createDate: "",
        cid: 0,
        images: [],
        properties: [],
        content: []
      },
      showImages: [],
      detailImages: [],
      activeTab: "tab1",
    }
  },
  methods: {
    async getDetails(id) {
      await axios.post('/product/details', qs.stringify({
        id: id
      }))
          .then(res => {
            console.log(res.data);
            if (res.status === 200 && res.data.flag) {
              this.data = res.data.data;
              // console.log(this.data);
              // console.log(this.data.name)
              // console.log(res.data.data.cid);
              // console.log(this.data.cid + "------");

              this.data.images.forEach(item => {
                if (item.type === "type_single") {
                  this.showImages.push(item.id);
                } else {
                  this.detailImages.push(item.id)
                }
              });
              this.showImages.sort((a, b) => b - a)
              this.detailImages.sort((a, b) => b - a)
              this.leftImage = require("../../assets/productSingle/" + this.showImages[0] + ".jpg");

              this.show = true;
            } else {
              alert("获取商品详情失败!");
              this.router.back();
            }
          })
          .catch(() => {
            alert("获取商品详情失败!");
            this.router.back();
          })
    },
    getCategoryPath(id) {
      // let id = categoryImagePath;
      // console.log("../../assets/category/" + String(id) + ".jpg" + "^^^^^" + this.show)
      return require("../../assets/category/" + String(id) + ".jpg");
    },
    getImagePath(id) {
      // console.log("../../assets/productSingleSmall/" + String(id) + ".jpg")
      return require("../../assets/productSingleSmall/" + String(id) + ".jpg");
    },
    getDetailImagePath(id) {
      // console.log("../../assets/productDetail/" + id + ".jpg")
      return require("../../assets/productDetail/" + id + ".jpg");
    },
    getComment(count) {
      return "累计评价" + count;
    }
  },
  async mounted() {
    this.show = false;
    await this.getDetails(this.route.query.id);
    this.show = true;
  }
};

</script>

<style scoped>
#mainBody {
  width: 85%;
  margin-left: auto;
  margin-right: auto;
  //height: 1000px;
}

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
  font-family: Arial, serif;
}

.juhuasuanTime {
  color: #FFC057;
  font-weight: bold;
}

.big-show-div {
  border: #cccccc solid 1px;
  margin: 10px;
}

.big-show-image {
  padding: 5px;
  width: 100%;
}

.el-tabs {
  margin-top: 20px;
  margin-left: auto;
  margin-right: auto;
}

.top-ad-image {
  width: 100%;
}

.table-content {
  margin-left: auto;
  margin-right: auto;
}

.images {
  margin-left: auto;
  margin-right: auto;
}
</style>