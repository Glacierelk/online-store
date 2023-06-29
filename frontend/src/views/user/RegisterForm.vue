<script setup>
import axios from "axios";
import Header from "@/components/user-facing/LoginAndRegisterHeader.vue";
import Footer from "@/components/user-facing/FooterComponents.vue";
import {ref} from "vue";
import qs from "qs";
import { useRouter } from "vue-router";

const router = useRouter();
const username = ref("");
const email = ref("");
const address = ref("");
const password = ref("");
const message = ref("");

function submitForm() {
  if (username.value.length < 4 || username.value.length > 16) {
    message.value = '用户名长度应在4-16位之间!';
    return false;
  }

  if (password.value.length < 6 || password.value.length > 16) {
    message.value = '密码长度应在6-16位之间!';
    return false;
  }

  //TODO delete?
  let reg
  reg = new RegExp(/^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[^]{6,16}$/);
  if (!reg.test(password.value)) {
    message.value = '密码要包含大写字母、数字小写字母、特殊字符中的至少三种!';
    return false;
  }

  //TODO 修改地址
  axios.post('http://localhost:8080/store/user/register', qs.stringify({
    "username": username.value,
    "email": email.value,
    "address": address.value,
    "password": password.value
  }))
      .then(response => {
        console.log(response)
        if (response.data.flag) {
          message.value = '注册成功,将自动跳转...';
          router.push('/user/login');
        }
        else {
          message.value = '注册失败,用户名已存在,请重试!';
          username.value = "";
          password.value = "";
          email.value = "";
        }
      })
      .catch(error => {
        console.error(error);
        message.value = '注册失败,请重试!';
      });
  return false;
}

</script>

<template>
  <div id="header">
    <Header></Header>
  </div>

  <div id="register">
    <h2>用户注册</h2>
    <form @submit.prevent="submitForm">
      <label>用户名<span class="required">&nbsp;*</span></label>
      <input required type="text" v-model="username">
      <br>

      <label>电子邮箱<span class="required">&nbsp;*</span></label>
      <input required type="email" v-model="email"><br>

      <label>邮寄地址<span class="required">&nbsp;*</span></label>
      <textarea v-model="address"></textarea><br>

      <label>用户密码<span class="required">&nbsp;*</span></label>
      <input required type="password" v-model="password"><br>

      <button type="submit">注册</button>
    </form>
    <p>{{ message }}</p>
  </div>

  <div id="footer">
    <Footer></Footer>
  </div>
</template>

<style scoped>
#header {
  margin-top: 30px;
  margin-bottom: 30px;
  margin-left: 15px;
  overflow: hidden;
}

#register {
  max-width: 50%;
  margin: 50px auto;
  padding: 20px;
  background-color: #fff;
  border-radius: 10px;
  box-shadow: 0 3px 10px rgba(0, 0, 0, 0.2);
}

label {
  text-align: left;
}

h2 {
  text-align: center;
  margin-bottom: 20px;
}

form {
  display: flex;
  flex-direction: column;
}

label {
  font-weight: bold;
  margin-bottom: 10px;
}

input[type="text"], input[type="email"], input[type="password"], textarea {
  padding: 10px;
  margin-bottom: 15px;
  border: 1px solid #ccc;
  border-radius: 5px;
  background-color: #f9f9f9;
  transition: all 0.3s ease;
}

input[type="text"]:focus, input[type="email"]:focus, input[type="password"]:focus, textarea:focus {
  outline: none;
  box-shadow: 0 0 5px #ff6ba4;
  border-color: #ff6b97;
}

select {
  padding: 10px;
  margin-bottom: 15px;
  border: 1px solid #ccc;
  border-radius: 5px;
  background-color: #f9f9f9;
  transition: all 0.3s ease;
  appearance: none;
}

textarea {
  max-width: 97%;
  min-width: 97%;
}

select:focus {
  outline: none;
  box-shadow: 0 0 5px #ff6bb5;
  border-color: #ff4191;
}

button[type="submit"] {
  padding: 10px;
  border: none;
  border-radius: 5px;
  background-color: #ff6bae;
  color: #fff;
  font-weight: bold;
  cursor: pointer;
  transition: all 0.3s ease;
}

button[type="submit"]:hover {
  background-color: #ff3387;
}

p {
  text-align: center;
  margin-top: 20px;
  font-weight: bold;
  color: #f00;
}

.required {
  color: red;
}
</style>