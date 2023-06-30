<script setup>
// import axios from "axios";
import {ref} from "vue";
import {useRouter} from "vue-router";

const router = useRouter();
let userNum = ref("");
let userGoods = 0;
let userName = ref("undefined");
let isLogin = false;

function login() {
  router.push("/user/login");
}

function register() {
  router.push("/user/register")
}

/*
function getUserNum() {
  axios.get("user/getUserNum")
      .then((res) => {
        userNum.value = res.data.userNum;
      })
      .catch(() => {
        console.log("获取在线人数失败");
      });
}

function getUserGoods() {
  axios.get("user/getUserGoods")
      .then((res) => {
        userGoods = res.data.userGoods;
      })
      .catch(() => {
        console.log("获取购物车商品数量失败");
      });
}

function checkLogin() {
  axios.get("user/checkLogin")
      .then((res) => {
        if (res.data.isLogin) {
          isLogin = true;
          userName.value = res.data.userName;
        } else {
          isLogin = false;
        }
      })
      .catch(() => {
        console.log("检查登录状态失败");
      });
}*/

</script>

<template>
  <nav id="top" class="top">
    <div class="pull-left">
      <router-link to="/">
        <span class="glyphicon glyphicon-home redColor" style="color:#C40000;margin:0"></span>
        天猫首页
      </router-link>
      <span>喵，欢迎来天猫</span>
      <span>在线人数:{{ userNum }}</span>

      <a v-if="isLogin" href="#">{{ userName }}</a>
      <a v-if="isLogin" href="#">退出</a>

      <a v-if="!isLogin" href="#" @click="login">请登录</a>
      <a v-if="!isLogin" href="#" @click="register">免费注册</a>
    </div>


    <div v-if="isLogin" class="pull-right">
      <a v-if="!isLogin" href="#">我的订单</a>
      <a href="#">
        <span class=" glyphicon glyphicon-shopping-cart redColor" style="color:#C40000;margin:0"></span>
        购物车&nbsp;<strong>{{ userGoods }}</strong>&nbsp;件</a>
    </div>
  </nav>
</template>

<style scoped>
#top {
  height: 40px;
  width: 100%;
  margin-left: 0;
  margin-right: 0;
}

.pull-left {
  margin-top: auto;
  margin-bottom: auto;
}

nav.top {
  padding-top: 5px;
  padding-bottom: 5px;
  border-bottom-style: solid;
  border-bottom-width: 1px;
  border-bottom-color: #e7e7e7;
  margin-left: 5px;
  margin-right: 5px;
  margin-top: 0;
  display: flex;
  justify-content: space-between;
}

nav.top span {
  margin-right: 20px;
}

nav.top span, nav.top a {
  color: #999;
  margin: 0 10px 0 10px;
}

nav.top a:hover {
  color: #C40000;
}
nav a {
  text-decoration: none;
}

nav.top {
  background-color: #f2f2f2;
}

nav.top div.row div {
  margin: 5px 0;
}

nav.top div.row div {
  background-color: lightgray;
  border: 1px solid gray;
}

div.pull-left{
  margin-left: 10px;
}
div.pull-right{
  margin-right: 10px;
}

</style>