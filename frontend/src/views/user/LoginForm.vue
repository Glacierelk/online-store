<template>
<!--  <div id="header">-->
<!--    <Header></Header>-->
<!--  </div>-->
  <div id="login">
    <div class="container">
      <el-form class="form-wrap" label-width="60px" v-bind="submitForm">
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
// import Header from "@/components/SearchComponents.vue";
import axios from "axios";
// import Header from "@/components/HeaderComponents.vue";
import Footer from "@/components/FooterComponents.vue";
import {ref} from "vue";
import {ElForm, ElFormItem, ElInput, ElButton} from "element-plus";

const username = ref("");
const password = ref("");

function submitForm() {
  if (!this.username || !this.password) {
    this.$message.error('请输入用户名或密码');
    return;
  }

  axios.post('user/login', {
    u_name: this.username,
    u_password: this.password,
  })
      .then((res) => {
        console.log(res)
        if (res.data.flag) {
          alert("登录成功,即将跳转！")
          window.location.href = "person.html";
        } else {
          alert("登录失败，请重试！")
          this.username = ""
          this.password = ""
        }
      })
      .catch(() => {
        alert("登录失败，请重试！")
        this.username = ""
        this.password = ""
      });
  return false
}

</script>

<style scoped>
.container {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
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