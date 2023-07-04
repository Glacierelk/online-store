<template>
  <div class="tabList">
    <div v-for="(row,rowIndex) in titles" :key="row[0]" class="listRow">
      <div class="rowTitle"><span class="divider">&nbsp;</span><span
          class="rowName"><strong>{{ categories[rowIndex].category_name }}</strong></span></div>
      <el-row :gutter="100">
        <el-col v-for="(col,colIndex) in titles[rowIndex]" :key="col" :span="4" class="listCol">
          <div v-if="colIndex<5">
            <router-link :to="'/details?id='+categories[rowIndex].products[colIndex].id">
              <div class="itemTab" @mouseenter="itemTabHover($event)" @mouseleave="itemTabLeave($event)">
                <div class="imgTab">
                  <img :src="images[rowIndex][colIndex]" alt="pic" class="imgInTab">
                </div>
                <div class="textTab">
                  <span class="textInTab">{{ titles[rowIndex][colIndex] }}</span>
                </div>
                <div class="priceTab">
                  <span class="priceInTab">￥ {{ prices[rowIndex][colIndex].toFixed(2) }}</span>
                </div>
              </div>
            </router-link>
          </div>
        </el-col>
      </el-row>
    </div>
    <div class="endIconDiv">
      <img alt="END" class="endIconImg" src="https://online-store-wenruyv.oss-cn-beijing.aliyuncs.com/site/end.png">
    </div>
  </div>
</template>

<script>
import ProductsAsideCategoriesComponent from "@/components/user-facing/home-page/ProductsAsideCategoriesComponent.vue";
export default {
  name: "BottomListComponent",
  data() {
    return {
      categories: categories,
      images: images,
      titles: titles,
      prices: prices,
    }
  },
  methods: {
    itemTabHover: function (e) {
      e.target.style.borderColor = "skyblue"
      e.target.style.opacity = 0.7
    },
    itemTabLeave: function (e) {
      e.target.style.borderColor = "white"
      e.target.style.opacity = 1
    },
  }
}

var categories = ProductsAsideCategoriesComponent.data().categories;
var images = [];
var prices = [];
var titles = [];
for (let i = 0; i < categories.length; i++) {
  images.push([])
  prices.push([]);
  titles.push([]);
  for (let j = 0; j < categories[i].products.length; j++) {
    //require中文件的路径必须使用拼接的方式，不要写死
    let src = 'https://online-store-wenruyv.oss-cn-beijing.aliyuncs.com/productSingleMiddle/';
    // console.log(categories[i].products[j].images[0].urlPath)
    console.log(categories[i].products[j].images[0])
    if (categories[i].products[j].images[0].urlPath !== null) {
      src += categories[i].products[j].images[0].urlPath;
    } else {
      src += categories[i].products[j].images[0].id;
    }
    src += '.jpg';
    images[i].push(src);//直接取第一张图片
    if (categories[i].products[j].promotePrice == null) //如果没有打折价那么就获取原价
    {
      prices[i].push(categories[i].products[j].originalPrice);
    } else {
      prices[i].push(categories[i].products[j].promotePrice);
    }

    titles[i].push(categories[i].products[j].name); //商品的名称作为标题
  }
}
</script>

<style scoped>

div.tabList {
  margin-top: 30px;
  padding: 10px 10px 10px 10px;
  background-color: #F5F5F5;
  margin-left: 5%;
  margin-right: 5%;
}

img.imgInTab {
  width: 100%;
  height: 100%;
}

span.textInTab {
  width: 100%;
  height: 100%;
  font-size: 13px;
}

span.priceInTab {
  width: 100%;
  height: 100%;
}


div.priceTab {
  width: 100%;
  margin-left: 10px;
  font-size: 18px;
  color: orangered;
}

div.imgTab {
  text-align: center;
  width: 100%;
  height: 65%;
}

div.endIconDiv {
  text-align: center;
  margin-top: 20px;
  margin-bottom: 30px;
}

div.textTab {
  padding: 10px 10px 10px 10px;
  width: 100%;
  height: 25%;
}

div.itemTab {
  width: 200px;
  height: 300px;
  background-color: white;
  border-style: solid;
  border-width: 2px;
  border-color: white;
  margin-bottom: 35px;
  margin-left: 50%;
}

span.rowName {
  font-size: 18px;
  margin-left: 30px;
  color: #646464;
}

span.divider {
  background-color: greenyellow;
  font-size: 20px;
  margin-left: 2px;
}

div.rowTitle {
  margin-bottom: 10px;
}
.itemTab{
  cursor: pointer;
}
</style>