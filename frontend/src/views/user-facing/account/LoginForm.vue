<template>
  <div id="header">
    <Header></Header>
  </div>

  <div id="login">
    <div class="container">
      <el-form class="form-wrap" label-width="60px">
        <h2 align="center">登录</h2>
        <el-form-item class="label" label="用户名" prop="username">
          <el-input v-model.trim="username" clearable required @keyup.enter="submitForm"></el-input>
        </el-form-item>
        <el-form-item class="label" label="密码" prop="password">
          <el-input v-model.trim="password" clearable required show-password type="password"
                    @keyup.enter="submitForm"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="danger" @click="submitForm">登录</el-button>
        </el-form-item>
        <el-form-item>
          <router-link class="register" to="/user/register">没有账号？注册新账号</router-link>
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

axios.defaults.withCredentials = false;
import Header from "@/components/user-facing/header-footer/LoginAndRegisterHeader.vue";
import Footer from "@/components/user-facing/header-footer/FooterComponent.vue";
import {ref} from "vue";
import {ElForm, ElFormItem, ElInput, ElButton} from "element-plus";
import {useRouter} from "vue-router";
import qs from "qs";

const router = useRouter();
const username = ref("");
const password = ref("");
import {ElMessage} from "element-plus";

function submitForm() {

  if (username.value === "admin" && password.value === "admin") {
    router.push('/manage')
    return false;
  }

  if (username.value === "" || password.value === "") {

    ElMessage({
      message: '用户名或密码不能为空!',
      type: 'error',
      duration: 2 * 1000
    });
    return false;
  }

  //TODO 修改地址
  axios.post('/user/login', qs.stringify({
    "username": username.value,
    "password": password.value,
  }))
      .then((res) => {
        // console.log(res);
        // if (res.status === 204) {
        //   return;
        // }
        //
        if (res.data.flag) {
          ElMessage({
            message: '登录成功!',
            type: 'success',
            duration: 2 * 1000
          });
          router.push('/');
        } else {
          ElMessage({
            message: '登录失败，请重试!',
            type: 'error',
            duration: 2 * 1000
          });
          username.value = "";
          password.value = "";
        }
      })
      .catch(() => {
        ElMessage({
          message: '登录失败，请重试!',
          type: 'error',
          duration: 2 * 1000
        });
        username.value = "";
        password.value = "";
      });

  return false;
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
  background-image: url("https://online-store-wenruyv.oss-cn-beijing.aliyuncs.com/login/6702.png");
  background-size: cover;
  background-repeat: no-repeat;
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
  height: 300px;
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

.el-button--danger {
  width: 100%;
  margin-top: 10px;
}

.el-button--danger:hover {
  background-color: #ee0c63;
}

.register {
  text-align: right;
}

.label {
  font-weight: bold;
}
</style>