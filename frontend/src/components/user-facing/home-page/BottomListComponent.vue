<template>
    <div class="tabList">
      <div class="listRow" v-for="(row,rowIndex) in titles" :key="row[0]">
        <div class="rowTitle"><span class="divider">&nbsp;</span><span class="rowName"><strong>{{categories[rowIndex].category_name}}</strong></span></div>
        <el-row  :gutter="100" >
          <el-col class="listCol" :span="4" v-for="(col,colIndex) in titles[rowIndex]" :key="col">
            <div v-if="colIndex<5">
              <div @mouseleave="itemTabLeave($event)" @mouseenter="itemTabHover($event)" class="itemTab">
                <div class="imgTab">
                  <img class="imgInTab" :src="images[rowIndex][colIndex]" alt="pic">
                </div>
                <div class="textTab">
                  <span  class="textInTab">{{titles[rowIndex][colIndex]}}</span>
                </div>
                <div class="priceTab">
                  <span  class="priceInTab">{{prices[rowIndex][colIndex]}}</span>
                </div>
              </div>
            </div>
          </el-col>
        </el-row>
      </div>
    </div>
</template>

<script>
export default {
  name: "BottomListComponent",
  data(){
    return{
      categories:categories,
      images:images,
      titles:titles,
      prices:prices,
      }
    },
  methods:{
    itemTabHover:function (e){
      e.target.style.borderColor="skyblue"
      e.target.style.opacity=0.7
    },
    itemTabLeave:function (e){
      e.target.style.borderColor="white"
      e.target.style.opacity=1
    }
  }
}

var categories=[{"category_name": "冰箱","cid": 76,"products": [
    {"id": 449,"name": "MeiLing/美菱 BCD-560WUCX对开门电冰箱家用冰箱WIFI智能风冷无霜","originalPrice": 11111, "promotePrice": 2222,"images": [{"id": 4573, "pid": 0, "type": "type_single"}]},
    {"id": 450,"name": "MeiLing/美菱 BCD-560WUCX对开门电冰箱家用冰箱WIFI智能风冷无霜","originalPrice": 1221, "promotePrice": null,"images": [{"id": 4573, "pid": 0, "type": "type_single"}]},
    {"id": 451,"name": "MeiLing/美菱 BCD-560WUCX对开门电冰箱家用冰箱WIFI智能风冷无霜","originalPrice": 111121, "promotePrice": 35,"images": [{"id": 4573, "pid": 0, "type": "type_single"}]},
    {"id": 452,"name": "MeiLing/美菱 BCD-560WUCX对开门电冰箱家用冰箱WIFI智能风冷无霜","originalPrice": 1211, "promotePrice": 272,"images": [{"id": 4573, "pid": 0, "type": "type_single"}]},
    {"id": 453,"name": "MeiLing/美菱 BCD-560WUCX对开门电冰箱家用冰箱WIFI智能风冷无霜","originalPrice": 11111, "promotePrice": 22776,"images": [{"id": 4573, "pid": 0, "type": "type_single"}]},
    {"id": 454,"name": "MeiLing/美菱 BCD-560WUCX对开门电冰箱家用冰箱WIFI智能风冷无霜","originalPrice": 11311, "promotePrice": 242,"images": [{"id": 4573, "pid": 0, "type": "type_single"}]},
    {"id": 455,"name": "MeiLing/美菱 BCD-560WUCX对开门电冰箱家用冰箱WIFI智能风冷无霜","originalPrice": 15141, "promotePrice": 4522,"images": [{"id": 4573, "pid": 0, "type": "type_single"}]},
  ]},
  {"category_name": "电视机","cid": 76,"products": [
      {"id": 456,"name": "MeiLing/美菱 BCD-560WUCX对开门电冰箱家用冰箱WIFI智能风冷无霜","originalPrice": 11111, "promotePrice": 2222,"images": [{"id": 4573, "pid": 0, "type": "type_single"}]},
      {"id": 457,"name": "MeiLing/美菱 BCD-560WUCX对开门电冰箱家用冰箱WIFI智能风冷无霜","originalPrice": 1221, "promotePrice": null,"images": [{"id": 4573, "pid": 0, "type": "type_single"}]},
      {"id": 458,"name": "MeiLing/美菱 BCD-560WUCX对开门电冰箱家用冰箱WIFI智能风冷无霜","originalPrice": 111121, "promotePrice": 35,"images": [{"id": 4573, "pid": 0, "type": "type_single"}]},
      {"id": 459,"name": "MeiLing/美菱 BCD-560WUCX对开门电冰箱家用冰箱WIFI智能风冷无霜","originalPrice": 1211, "promotePrice": 272,"images": [{"id": 4573, "pid": 0, "type": "type_single"}]},
      {"id": 460,"name": "MeiLing/美菱 BCD-560WUCX对开门电冰箱家用冰箱WIFI智能风冷无霜","originalPrice": 11111, "promotePrice": 22776,"images": [{"id": 4573, "pid": 0, "type": "type_single"}]},
      {"id": 461,"name": "MeiLing/美菱 BCD-560WUCX对开门电冰箱家用冰箱WIFI智能风冷无霜","originalPrice": 11311, "promotePrice": 242,"images": [{"id": 4573, "pid": 0, "type": "type_single"}]},
      {"id": 462,"name": "MeiLing/美菱 BCD-560WUCX对开门电冰箱家用冰箱WIFI智能风冷无霜","originalPrice": 15141, "promotePrice": 4522,"images": [{"id": 4573, "pid": 0, "type": "type_single"}]},
    ]},
]
var images=[];
var prices=[];
var titles=[];
for (let i=0;i<categories.length;i++)
{
  images.push([])
  prices.push([]);
  titles.push([]);
  for(let j=0;j<categories[i].products.length;j++)
  {
    //require中文件的路径必须使用拼接的方式，不要写死，require中文件的路径必须要使用拼接的方式，不要写死
    //require中文件的路径必须使用拼接的方式，不要写死
    let src=require('../../../assets/productSingleMiddle/'+categories[i].products[j].images[0].id+'.jpg');
    images[i].push(src);//直接取第一张图片
    if(categories[i].products[j].promotePrice==null) //如果没有打折价那么就获取原价
    {
      prices[i].push(categories[i].products[j].originalPrice);
    }
    else
    {
      prices[i].push(categories[i].products[j].promotePrice);

    }

    titles[i].push(categories[i].products[j].name); //商品的名称作为标题


  }
}




</script>

<style scoped>


div.tabList{
  margin-top: 30px;
  padding: 10px 10px 10px 10px;
  background-color:#F5F5F5;
  margin-left: 5%;
  margin-right:5%;
}

img.imgInTab{
  width: 100%;
  height: 100%;
}
span.textInTab{
  width: 100%;
  height: 100%;
  font-size: 13px;
}

span.priceInTab{
  width: 100%;
  height: 100%;
}



div.priceTab{
  width: 100%;
  margin-left: 10px;
  font-size: 18px;
  color: orangered;
}

div.imgTab{
  text-align: center;
  width: 100%;
  height: 65%;
}

div.textTab{
  padding: 10px 10px 10px 10px;
  width: 100%;
  height: 25%;
}

div.itemTab{
  width: 200px;
  height: 300px;
  background-color: white;
  border-style: solid;
  border-width: 2px;
  border-color: white;
  margin-bottom: 15px;
  margin-left: 50%;
}

span.rowName{
  font-size: 18px;
  margin-left: 30px;
  color:#646464;
}

span.divider{
  background-color: greenyellow;
  font-size: 20px;
  margin-left: 2px;
}

div.rowTitle{
  margin-bottom: 10px;
}

</style>