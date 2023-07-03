<script setup>

</script>

<template>
  <div id="footer" class="footer" style="display: block;">
    <div id="footer_ensure" class="footer_ensure">
      <a href="https://www.tmall.com/">
        <img src="https://online-store-wenruyv.oss-cn-beijing.aliyuncs.com/footer/ensure.png" alt="ensure">
      </a>
    </div>

    <div id="footer_desc" class="footer_desc">

      <div class="descColumn">
        <span class="descColumnTitle">购物指南</span>
        <a href="#" >免费注册</a>
        <a href="#" >开通支付宝</a>
        <a href="#" >支付宝充值</a>
      </div>
      <div class="descColumn">
        <span class="descColumnTitle">京东保障</span>
        <a href="#" >发票保障</a>
        <a href="#" >售后规则</a>
        <a href="#" >缺货赔付</a>
      </div>
      <div class="descColumn">
        <span class="descColumnTitle">支付方式</span>
        <a href="#" >快捷支付</a>
        <a href="#" >信用卡</a>
        <a href="#" >蚂蚁花呗</a>
        <a href="#" >货到付款</a>
      </div>
      <div class="descColumn">
        <span class="descColumnTitle">商家服务</span>
        <a href="#" >商家入驻</a>
        <a href="#" >商家中心</a>
        <a href="#" >京东智库</a>
        <a href="#" >京东规则</a>
        <a href="#" >物流服务</a>
        <a href="#" >喵言喵语</a>
        <a href="#" >运营服务</a>
      </div>
      <div class="descColumn">
        <span class="descColumnTitle">手机天猫</span>
        <a href="#" ><img src="https://online-store-wenruyv.oss-cn-beijing.aliyuncs.com/footer/ma.png" alt="ma"></a>
      </div>

    </div>

    <div style="clear:both"></div>
    <img id="cateye" class="cateye" src="https://online-store-wenruyv.oss-cn-beijing.aliyuncs.com/footer/cateye.png" alt="cateye">
    <div id="copyright" class="copyright">
      <div class="white_link" >
        <a href="#" >关于天猫</a> &nbsp;
        <a href="#" >帮助中心</a> &nbsp;
        <a href="#" >开放平台</a> &nbsp;
        <a href="#" >诚聘英才</a> &nbsp;
        <a href="#" >联系我们</a> &nbsp;
        <a href="#" >网站合作</a> &nbsp;
        <a href="#" >法律声明</a> &nbsp;
        <a href="#" >知识产权</a> &nbsp;
        <a href="#" >廉正举报</a> &nbsp;
      </div>
      <div class="white_link" >
        <a href="#" >阿里巴巴集团</a><span class="slash">&nbsp; | &nbsp;</span>
        <a href="#" >淘宝网</a><span class="slash">&nbsp; | &nbsp;</span>
        <a href="#" >天猫</a><span class="slash">&nbsp; | &nbsp;</span>
        <a href="#" >聚划算</a><span class="slash">&nbsp; | &nbsp;</span>
        <a href="#" >全球速卖通</a><span class="slash">&nbsp; | &nbsp;</span>
        <a href="#" >阿里旅行·去啊 </a><span class="slash">&nbsp; | &nbsp;</span>
        <a href="#" >万网</a><span class="slash">&nbsp; | &nbsp;</span>
        <a href="#" >高德</a><span class="slash">&nbsp; | &nbsp;</span>
        <a href="#" >优视</a><span class="slash">&nbsp; | &nbsp;</span>
        <a href="#" >友盟</a><span class="slash">&nbsp; | &nbsp;</span>
        <a href="#" >虾米</a><span class="slash">&nbsp; | &nbsp;</span>
        <a href="#" >天天动听</a><span class="slash">&nbsp; | &nbsp;</span>
        <a href="#" >来往</a><span class="slash">&nbsp; | &nbsp;</span>
        <a href="#" >钉钉</a><span class="slash">&nbsp; | &nbsp;</span>
        <a href="#" >支付宝</a>
      </div>

      <div class="license">
        <span>增值电信业务经营许可证： 浙B2-20110446</span>
        <span>网络文化经营许可证：浙网文[2015]0295-065号</span>
        <span>互联网医疗保健信息服务 审核同意书 浙卫网审【2014】6号 </span>
        <span>互联网药品信息服务资质证书编号：浙-（经营性）-2012-0005</span>
        <div class="copyRightYear">© 2003-2016 TMALL.COM 版权所有</div>
        <div style="margin-top: 1%; margin-bottom: 5px">
          <img src="https://online-store-wenruyv.oss-cn-beijing.aliyuncs.com/footer/copyRight1.jpg" alt="copyRight1">
          <img src="https://online-store-wenruyv.oss-cn-beijing.aliyuncs.com/footer/copyRight2.jpg" alt="copyRight2">
        </div>
      </div>
    </div>
  </div>
</template>

<style scoped>
  div.footer {
    position: relative;
    text-align: left;
    margin: 0 0;
    border-top-style: solid;
    border-top-width: 1px;
    border-top-color: #e7e7e7;
  }

  div.footer_ensure {
    margin-top: 24px;
    margin-bottom: 24px;
    text-align: center;
  }

  div.footer_desc {
    //border-top-style: solid;
    //border-top-width: 1px;
    //border-top-color: #e7e7e7;
    padding-top: 30px;
    margin-left: 10%;
  }

  div.copyright {
    background-color: black;
    margin-left: auto;
    margin-right: auto;
  }

  #copyright a,span.slash{
    color: #e7e7e7;

  }

  div.license,div.footer_desc a{
    color: gray;
  }

  div.license{
    margin-left: 3%;
    margin-right: 3%;
    margin-bottom: 3%;
  }

  a {
    text-decoration: none;
  }

  div.footer div.copyright div.white_link {
    padding: 10px 0;
    margin-left: 3%;
  }


  div.footer_desc a {
    font-size: 13px;
  }

  div.footer_desc div.descColumn  {
    color: #646464;
    font-weight: bold;
    font-size: 16px;
    width: 19%;
    float: left;
  }

  div.footer_desc a {
    display: block;
    padding-top: 3px;
  }

  div.footer_desc a:hover{
    color: red;
  }

  img.cateye {
    margin-left: 100px;
  }
</style>