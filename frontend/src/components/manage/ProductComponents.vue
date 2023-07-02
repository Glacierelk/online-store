<template>
  <el-breadcrumb separator="/" class="custom-breadcrumb breadcrumb-center">
    <el-breadcrumb-item>
      <a class="category-link" @click="handleClick">所有分类</a>
    </el-breadcrumb-item>
    <el-breadcrumb-item v-if="currentCategory">{{ currentCategory }}</el-breadcrumb-item>
    <el-breadcrumb-item class="breadcrumb-button-right">
      <el-button type="primary" @click="handleAddProduct">添加商品</el-button>
    </el-breadcrumb-item>
  </el-breadcrumb>

  <el-dialog v-model="dialogVisible" title="新建产品" width="50%">
    <el-form ref="form" :model="formData" label-width="100px">
      <el-form-item label="产品名称">
        <el-input v-model="formData.productName"></el-input>
      </el-form-item>
      <el-form-item label="产品小标题">
        <el-input v-model="formData.productSubtitle"></el-input>
      </el-form-item>
      <el-form-item label="原价格">
        <el-input-number v-model="formData.originalPrice"></el-input-number>
      </el-form-item>
      <el-form-item label="优惠价格">
        <el-input-number v-model="formData.discountedPrice"></el-input-number>
      </el-form-item>
      <el-form-item label="库存">
        <el-input-number v-model="formData.inventory"></el-input-number>
      </el-form-item>
      <el-form-item>
        <div class="centered-container">
        <el-button type="primary" @click="submitAddForm" class="centered-button">提交</el-button>
        </div>
      </el-form-item>
    </el-form>
  </el-dialog>

  <el-dialog v-model="dialogVisible2" title="修改产品" width="50%">
    <el-form ref="form" :model="formData" label-width="100px">
      <el-form-item label="产品名称">
        <el-input v-model="formData.productName"></el-input>
      </el-form-item>
      <el-form-item label="产品小标题">
        <el-input v-model="formData.productSubtitle"></el-input>
      </el-form-item>
      <el-form-item label="原价格">
        <el-input-number v-model="formData.originalPrice"></el-input-number>
      </el-form-item>
      <el-form-item label="优惠价格">
        <el-input-number v-model="formData.discountedPrice"></el-input-number>
      </el-form-item>
      <el-form-item label="库存">
        <el-input-number v-model="formData.inventory"></el-input-number>
      </el-form-item>
      <el-form-item>
        <div class="centered-container">
          <el-button type="primary" @click="submitEditForm" class="centered-button">提交</el-button>
        </div>
      </el-form-item>
    </el-form>
  </el-dialog>

  <div class=table-container>
    <el-table stripe :data="tableData" style="width: 100%; margin-bottom: 20px">
      <el-table-column prop="id" label="ID" width="80" align="center"></el-table-column>
      <el-table-column prop="name" label="产品名称" width="480" align="center"></el-table-column>
      <el-table-column prop="subTitle" label="产品小标题" width="480" align="center"></el-table-column>
      <el-table-column prop="originalPrice" label="原价格" width="100" align="center"></el-table-column>
      <el-table-column prop="promotePrice" label="优惠价格" width="100" align="center"></el-table-column>
      <el-table-column prop="stock" label="库存数量" width="100" align="center"></el-table-column>
      <el-table-column label="编辑" width="100" align="center">
        <template v-slot="scope">
          <el-button type="primary" size="small" :style="{backgroundColor: 'transparent', borderColor: 'transparent'}" @click="handleEdit(scope.row)">
            <i class="fa fa-edit" style="color: blue;"></i>
          </el-button>
        </template>
      </el-table-column>
      <el-table-column label="删除" width="100" align="center">
        <template v-slot="scope">
          <el-button type="danger" size="small" :style="{backgroundColor: 'transparent', borderColor: 'transparent'}"  @click="handleDelete(scope.row)">
            <i class="fa fa-trash" style="color: red;"></i>
          </el-button>
        </template>
      </el-table-column>
      <el-table-column label="设置属性" width="100" align="center">
        <template v-slot="scope">
          <el-button type="danger" size="small" :style="{backgroundColor: 'transparent', borderColor: 'transparent'}"  @click="setProperty(scope.row)">
            <i class="fa fas fa-plus" style="color: green;"></i>
          </el-button>
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>
<script>
import axios from "axios";
import qs from "qs";
import {useRouter} from "vue-router";
import {ElMessageBox} from "element-plus";

export default {
  data() {
    return {
      currentCategory: '当前分类',
      cid:'',
      tableData: [
      ],
      dialogVisible: false, // 控制对话框的显示与隐藏
      dialogVisible2: false,
      router : useRouter(),
      productId:'',
      formData: {
        productName: '',
        productSubtitle: '',
        originalPrice: 0,
        discountedPrice: 0,
        inventory: 0
      }
    };
  },
  methods: {
    getData() {
      const postUrl = 'category/searchCategoryProperty';

      // 发送网络请求获取后端数据
      axios.post(postUrl, qs.stringify({
        "cid": this.cid,
      })).then(response => {
            this.tableData=response.data.data;
            console.log(this.tableData);
          })
          .catch(error => {
            // 请求失败，处理错误
            console.error('请求数据失败:', error);
          });
      // 根据当前页码和每页显示的条数从后端获取数据
      // 更新tableData和total
    },
    handleAddProduct() {
      // 处理按钮点击事件的逻辑
      this.dialogVisible = true; // 打开对话框
      console.log("按钮被点击");
    },

    handleDelete(row) {
      console.log(row.id);
      ElMessageBox.confirm('确定要删除吗？', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      })
          .then(() => {
            // 用户点击了确定按钮
            const deleteUrl = 'product/delete?id=' + row.id;

            axios.delete(deleteUrl)
                .then(() => {
                  // 删除成功，刷新页面
                  window.location.reload();
                })
                .catch(error => {
                  // 处理删除失败的情况
                  console.error(error);
                  alert("删除发生错误，请重试！");
                });
          })
          .catch(() => {
            // 用户点击了取消按钮或者点击了弹窗外部区域，不执行任何操作
          });
    },
    handleEdit(row){
      this.productId = row.id;
      this.dialogVisible2 = true; // 打开对话框
      console.log(row.id);

    },
    setProperty(row){
      console.log(row.id);
      this.router.push({
        path:'/property',
        query: {
          name: this.currentCategory ,
          id:row.id,
          cid:this.cid,
        }
      });
      console.log("点击了所有分类");
    },

    // eslint-disable-next-line no-unused-vars
    handleClick() {
      // 处理点击事件，例如跳转到对应的分类页面
      this.router.push({
        path:'/manage',
      });
      console.log("点击了所有分类");
      // 执行相应的逻辑...
    },

    async submitAddForm() {
      // 在此处提交表单数据的逻辑
      console.log(this.formData);
      event.preventDefault(); // 阻止表单默认提交行为
      // 在这里执行表单提交逻辑
      let requests = []; // 存储所有请求

        requests.push(
            axios.post('/product/add', qs.stringify({
              "name": this.formData.productName,
              "originalPrice": this.formData.originalPrice,
              "promotePrice": this.formData.discountedPrice,
              "stock": this.formData.inventory,
              "subTitle": this.formData.productSubtitle,
              "cid": this.cid,
            }))
        );

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
            message: "添加成功"
          });
        } else if (showAlert) {
          alert("添加失败，请重试！");
        }
      } catch (error) {
        console.error(error);
        alert("请求发生错误，请重试！");
      }
      window.location.reload();
    },

    async submitEditForm() {
      // 在此处提交表单数据的逻辑
      console.log(this.formData);
      event.preventDefault(); // 阻止表单默认提交行为
      // 在这里执行表单提交逻辑
      let requests = []; // 存储所有请求

      requests.push(
          axios.post('/product/editProduct', qs.stringify({
            "id":this.productId,
            "name": this.formData.productName,
            "originalPrice": this.formData.originalPrice,
            "promotePrice": this.formData.discountedPrice,
            "stock": this.formData.inventory,
            "subTitle": this.formData.productSubtitle,
            "cid": this.cid,
          }))
      );

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
    }
  },
  created() {
    this.cid = this.$route.query.cid;
    this.currentCategory = this.$route.query.name;
    // 使用获取到的 cid 值进行后续操作
    console.log(this.cid);
  },
  mounted() {
    this.getData(); // 页面加载时初始化数据
    //console.log("111"); // 或者将表单数据发送至后端
  },
};
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


</style>