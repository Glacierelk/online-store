<template>
  <el-breadcrumb separator="/" class="custom-breadcrumb breadcrumb-center">
    <el-breadcrumb-item>
      <a class="category-link">所有分类</a>
    </el-breadcrumb-item>
    <el-breadcrumb-item v-if="currentCategory">
      <a class="category-link" @click="handleClick">{{ currentCategory }}</a>
    </el-breadcrumb-item>
    <el-breadcrumb-item v>修改商品属性</el-breadcrumb-item>
    <el-breadcrumb-item class="breadcrumb-button-right">
      <el-button type="primary" @click="submitForm">确认修改</el-button>
    </el-breadcrumb-item>
  </el-breadcrumb>

  <div class="form-container">
  <el-form :model="formData" label-width="150px" ref="myForm">
    <el-form-item v-for="index in rowCount.value" :label="formData[index-1].name" :key="index">
      <el-input v-model="formData[`input${index}`] " class="short-input"></el-input>
    </el-form-item>
  </el-form>
    </div>
</template>

<script>
import {useRouter} from "vue-router";
import axios from "axios";
import qs from "qs";
import {ref} from 'vue';

export default {
  data() {
    return {
      rowCount: ref([]),
      currentCategory: '当前分类',
      cid: '',
      tableData: [],
      dialogVisible: false, // 控制对话框的显示与隐藏
      router: useRouter(),
      productId: '',
      formData: {}
    };
  },

  methods: {
    getData() {
      const postUrl = '/product/details';

      // 发送网络请求获取后端数据
      axios.post(postUrl, qs.stringify({
        "id": this.id,
      })).then(response => {
        this.formData = response.data.data.properties;
        this.rowCount.value = this.formData.length;
        console.log("formData:" + this.formData[12].value);
        console.log(this.rowCount.value);

        for (let i = 1; i <= this.rowCount.value; i++) {
          this.formData[`input${i}`] = this.formData[i - 1].value;
        }
      })
          .catch(error => {
            // 请求失败，处理错误
            console.error('请求数据失败:', error);
          });
    },
    handleClick() {
      this.router.push({
        path:'/product',
        query: {
          cid: this.cid ,
          name:this.currentCategory,
        }
      });
    },
     submitForm(event) {
      event.preventDefault(); // 阻止表单默认提交行为
      this.$refs.myForm.validate(async (valid) => {
        if (valid) {
          console.log('表单验证成功');
          // 在这里执行表单提交逻辑
          let requests = []; // 存储所有请求
          for (let i = 1; i <= this.rowCount.value; i++) {
            console.log(this.formData[i-1].id+"____"+this.formData[`input${i}`]);
            requests.push(
                axios.post('/property/change', qs.stringify({
                  "id": this.formData[i-1].id,
                  "value": this.formData[`input${i}`],
                }))); // 或其他需要的值
          }

          try {
            const responses = await Promise.all(requests);

            let successAdded = false;
            let showAlert = false;

            responses.forEach(res => {
              if (res.data.flag) {
                successAdded = true; // 设置成功添加标志为true
              } else {
                showAlert = true;
              }
            });

            if (successAdded) {
              this.$message({
                type: 'success',
                message: "修改成功"
              });
            } else if (showAlert) {
              alert("修改失败，请重试！");
            }
          } catch (error) {
            console.error(error);
            alert("请求发生错误，请重试！");
          }
          window.location.reload();
        } else {
          // 表单验证失败，执行相应处理
          console.log('表单验证失败');
        }
      });
    },
  },

    created() {
      this.id = this.$route.query.id;
      this.currentCategory = this.$route.query.name;
      this.cid = this.$route.query.cid;
      // 使用获取到的 cid 值进行后续操作
      console.log(this.id);
    },

    mounted() {
      this.getData(); // 页面加载时初始化数据
      //console.log("111"); // 或者将表单数据发送至后端
    },
}
</script>

<style scoped>
.custom-breadcrumb {
  background-color: #f0f2f5;
  padding: 10px;
  margin-top: 10px;
  text-align: center;
  display: flex;
  align-items: center;
}

.custom-breadcrumb .el-breadcrumb-item {
  font-size: 14px;
  color: #333;
}

.category-link {
  cursor: pointer;
}

.category-link:hover {
  color: blue;
}

.breadcrumb-button {
  float: right;
}

.breadcrumb-button-right {
  margin-left: auto;
}

.centered-container {
  display: flex;
  justify-content: center;
  align-items: center;
}
.form-container {
  margin-top: 20px;
  display: flex;
  justify-content: center;
  /*align-items: center;*/
  /*height: 100vh; !* 可根据需要调整高度 *!*/
}
.short-input {
  width: 300px;
}

</style>