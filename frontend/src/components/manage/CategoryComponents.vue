<template >
  <div id = "categoryC">
  <el-button
      type="primary"
      @click="addCategory"
      style="position: absolute; top: 5px; right: 5px;width: 8%;font-size: 15px; margin-bottom: 0"
  >添加分类
  </el-button>

  <el-dialog title="添加" v-model="secondDialogVisible">
    <el-form :model="form" label-width="150px" @submit="submitForm">
      <el-form-item v-for="index in rowCount" :label="`属性 ${index}`" :key="index">
        <el-input v-model="form[`input${index}`]"></el-input>
      </el-form-item>
      <el-button type="primary" native-type="submit">提交</el-button>
    </el-form>
  </el-dialog>
  </div>

  <div class = table-container>
    <el-table :data="tableData" style="width: 100%">
      <el-table-column prop="id" label="ID"></el-table-column>
      <el-table-column prop="name" label="分类名称"></el-table-column>
      <el-table-column label="产品管理">
        <template v-slot="scope">
          <el-button type="primary" size="small" :style="{backgroundColor: 'transparent', borderColor: 'transparent'}" @click="handleManage(scope.row)">
            <i class="fa fa-edit" style="color: blue;"></i>
          </el-button>
        </template>
      </el-table-column>
      <el-table-column label="删除">
        <template v-slot="scope">
          <el-button type="danger" size="small" :style="{backgroundColor: 'transparent', borderColor: 'transparent'}"  @click="handleDelete(scope.row)">
            <i class="fa fa-trash" style="color: red;"></i>
          </el-button>
        </template>
      </el-table-column>
      <el-table-column label="添加属性">
        <template v-slot="scope">
          <el-button type="danger" size="small" :style="{backgroundColor: 'transparent', borderColor: 'transparent'}"  @click="addProperty(scope.row)">
            <i class="fa fas fa-plus" style="color: green;"></i>
          </el-button>
        </template>
      </el-table-column>
    </el-table>

    <div style="display: flex; justify-content: center;">
      <el-pagination
          @size-change="handleSizeChange"
          @current-change="handleCurrentChange"
          :current-page="currentPage"
          :page-sizes="[5,10,15]"
          :page-size="pageSize"
          :total="total"
          layout="sizes, prev, pager, next, jumper"
      ></el-pagination>
    </div>
  </div>
</template>

<script>
import axios from "axios";
import qs from "qs";
//import {inject} from "vue";

function range(start, end, step = 1) {
  return Array.from({ length: Math.ceil((end - start) / step) + 1 }, (_, index) => start + (index * step));
}

export default {

  name: "CategoryComponents",
//  inject:['ReloadComponent.vue'],                                 //注入App里的reload方法
  data() {
    return {
      form: {},
      rowCount: 5,
      secondDialogVisible: false,
      categoryName: '',
      inputValue: '',
      tableData: [],
      currentPage: 1, // 当前页码
      pageSize: 5, // 每页显示的条数
      total: 5, // 数据总数
    }
  },
  methods: {
    // 分页大小改变时触发
    handleSizeChange(val) {
      this.pageSize = val;
      this.getData();
    },
    // 当前页码改变时触发
    handleCurrentChange(val) {
      this.currentPage = val;
      this.getData();
    },
    // 获取数据
    getData() {
      const getUrl = 'category/listAllCategories';

      // 发送网络请求获取后端数据
      axios.get(getUrl)
          .then(response => {
            this.tableData=response.data.data;
            this.total = this.tableData.length;
            // console.log(this.total);
            //  console.log(this.currentPage,this.pageSize, this.total);
            // 请求成功，将返回的数据赋值给tableData和total
            this.tableData = [];
            for(let i = (this.currentPage-1)*this.pageSize, j=0; i < Math.min((this.currentPage-1)*this.pageSize + this.pageSize, this.total); i++) {
              this.tableData[j]=response.data.data[i];
              j++;
            }
          })
          .catch(error => {
            // 请求失败，处理错误
            console.error('请求数据失败:', error);
          });
      // 根据当前页码和每页显示的条数从后端获取数据
      // 更新tableData和total
    },
    handleManage(row) {
      // 在这里处理按钮点击事件
      console.log("管理",row);
    },
    handleDelete(row) {
      // 处理删除按钮点击事件
      const deleteUrl = 'category/delete?categoryId='+row.id;
      axios.delete(deleteUrl)
      window.location.reload();
    },
    addProperty() {
      this.$prompt('请输入对应分类想要添加的属性个数', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        inputPattern: /\d/,
        inputErrorMessage: '属性个数不正确'
      }).then(({value}) => {
        this.$message({
          type: 'success',
          message: '你的属性个数是: ' + value,
        });
        this.rowCount = range(1, value, 1);
        //this.rowCount=Array.from({ length: this.rowCount }, (v, i) => i + 1);
        console.log(this.rowCount);
        this.secondDialogVisible = true; // 打开第二个对话框);
        console.log(this.secondDialogVisible);
        console.log(this.row);
      }).catch(() => {
        this.$message({
          type: 'info',
          message: '取消输入'
        });
      });
    },
    addCategory(){
      this.$prompt('请输入新建种类名称', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        inputPattern: /^[\s\S]+$/,
        inputErrorMessage: '请不要输入空值'
      }).then(({value}) => {
        axios.post('category/add', qs.stringify({
          "categoryName": value,
        })).then((res) => {
          console.log(res);
          if (res.data.flag) {
            this.$message({
              type: 'success',
              message: '你新建的种类是: ' + value,
            });
            console.log(value);
            window.location.reload();
          } else {
            alert("添加失败，请重试！");
          }
        })
      }).catch(() => {
        this.$message({
          type: 'info',
          message: '取消输入'
        });
      });
    },

    submitForm(event) {
      event.preventDefault(); // 阻止表单默认提交行为
      // 在这里执行表单提交逻辑

      console.log(this.form); // 或者将表单数据发送至后端
    }
  },
  mounted() {
    this.getData(); // 页面加载时初始化数据
    console.log("111"); // 或者将表单数据发送至后端
  },
}
</script>

<style>
  #categoryC {
    margin-top: 100px;
  }
  .table-container {
    margin-top: 1px; /* 设置距离顶部的距离为20像素 */
  }
</style>
