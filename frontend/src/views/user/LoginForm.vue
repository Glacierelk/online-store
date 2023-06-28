<template>
  <div id="header">
    <Header></Header>
  </div>

  <div id="login">
    <div class="container">
      <el-form class="form-wrap" label-width="60px" @submit.passive.prevent="submitForm">
        <h2>登录</h2>
        <el-form-item class="label" label="用户名" prop="username">
          <el-input v-model.trim="username" clearable required></el-input>
        </el-form-item>
        <el-form-item class="label" label="密码" prop="password">
          <el-input v-model.trim="password" clearable required show-password type="password"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button native-type="submit" type="danger">登录</el-button>
        </el-form-item>
        <el-form-item>
          <a class="register" href="#">没有账号？注册新账号</a>
        </el-form-item>
      </el-form>
    </div>
  </div>

  <div id="footer">
    <Footer></Footer>
  </div>
</template>

<script setup>
import axios from "axios";
import Header from "@/components/LoginAndRegisterHeader.vue";
import Footer from "@/components/FooterComponents.vue";
import {ref} from "vue";
import {ElForm, ElFormItem, ElInput, ElButton} from "element-plus";
import {useRouter} from "vue-router";

let router = useRouter();
let username = ref("");
let password = ref("");

function submitForm() {
  alert(username.value)
  alert(password.value)
  //TODO 修改地址
  axios.post('http://localhost:8080/store/user/login', {
    name: username.value,
    password: password.value,
  })
      .then((res) => {
        console.log(res);
        if (res.data.flag) {
          alert("登录成功,即将跳转！");
          router.push('/user/register');
        } else {
          alert("登录失败，请重试！");
          username.value = "";
          password.value = "";
        }
      })
      .catch(() => {
        alert("登录失败，请重试！");
        username.value = "";
        password.value = "";
      });
}

</script>

<style scoped>
#header {
  margin-top: 30px;
  margin-bottom: 30px;
  margin-left: 15px;
  overflow: hidden;
}

#login {
  height: 100vh;
  width: 90%;
  background-image: url("@/assets/login/6702.png");
  margin-left: auto;
  margin-right: auto;
}

.container {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 95%;
  float: right;
  width: 35%;
  margin-right: 2%;
}

.form-wrap {
  width: 400px;
  background-color: #fff;
  border-radius: 10px;
  box-shadow: 0 0 20px rgba(0, 0, 0, 0.15);
  padding: 40px;
}

h2 {
  margin-bottom: 16px;
}

.el-form-item__content > .el-input {
  width: 100%;
}

.el-button--danger{
  width: 100%;
  margin-top: 10px;
}

.el-button--danger:hover {
  background-color: #ee0c63;
}

.register {
  margin-top: 16px;
  text-align: right;
}

.label {
  font-weight: bold;
}
</style>