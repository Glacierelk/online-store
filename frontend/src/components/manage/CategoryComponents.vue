<template >
  <div id = "categoryC">
<!--  <el-button-->
<!--      type="primary"-->
<!--      @click="addCategory"-->
<!--      style="position: absolute; top: 5px; right: 5px;width: 8%;font-size: 15px; margin-bottom: 0"-->
<!--  >添加分类-->
<!--  </el-button>-->

    <el-dialog title="添加属性" v-model="secondDialogVisible">
      <el-form :model="form" label-width="150px" @submit="submitForm">
        <el-form-item v-for="index in rowCount" :label="`属性 ${index}`" :key="index">
          <el-input v-model="form[`input${index}`]"></el-input>
        </el-form-item>
        <el-button type="primary" native-type="submit">提交</el-button>
      </el-form>
    </el-dialog>

    <el-dialog title="添加图片" v-model="thirdDialogVisible">
      <div>
        <input type="file" @change="onFileChange" />
        <button @click="upload">Upload</button>
      </div>
    </el-dialog>
  </div>

  <div class=table-container>
    <el-table stripe :data="tableData" style="width: 100%; margin-bottom: 20px">
      <el-table-column prop="id" sortable label="分类ID" width="450" align="center"></el-table-column>
      <el-table-column prop="name" label="分类名称" width="450" align="center" ></el-table-column>
      <el-table-column label="产品管理" width="450" align="center">
        <template v-slot="scope">
          <el-button type="primary" size="small" :style="{backgroundColor: 'transparent', borderColor: 'transparent'}" @click="handleManage(scope.row)">
            <i class="fa fa-edit" style="color: blue;"></i>
          </el-button>
        </template>
      </el-table-column>
      <el-table-column label="删除" width="450" align="center" >
        <template v-slot="scope">
          <el-button type="danger" size="small" :style="{backgroundColor: 'transparent', borderColor: 'transparent'}"  @click="handleDelete(scope.row)">
            <i class="fa fa-trash" style="color: red;"></i>
          </el-button>
        </template>
      </el-table-column>
      <el-table-column label="添加属性" align="center" width = "450" fixed="right">
        <template v-slot="scope">
          <el-button type="danger" size="small" :style="{backgroundColor: 'transparent', borderColor: 'transparent'}"  @click="addProperty(scope.row)">
            <i class="fa fas fa-plus" style="color: green;"></i>
          </el-button>
        </template>
      </el-table-column>
    </el-table>

    <div style="display: flex; justify-content: space-between; align-items: center; width: 100%;">
      <div style="flex-grow: 1; display: flex; justify-content: center;">
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
      <div>

        <el-button
            type="primary"
            @click="addCategory"
            style="margin-right: 20px;"
        >添加
        </el-button>
      </div>
    </div>
  </div>

</template>

<script>
import axios from "axios";
import qs from "qs";
import { ElMessageBox } from 'element-plus';
import {useRouter} from "vue-router";
//import {inject} from "vue";

function range(start, end, step = 1) {
  return Array.from({ length: Math.ceil((end - start) / step) + 1 }, (_, index) => start + (index * step));
}

export default {

  name: "CategoryComponents",
//  inject:['ReloadComponent.vue'],                                 //注入App里的reload方法
  data() {
    return {
      cid:'',
      selectedFile: null,
      form: {},
      rowCount: [],
      rowCountNum:0,
      router : useRouter(),
      rowId:0,
      secondDialogVisible: false,
      thirdDialogVisible: false,
      categoryName: '',
      inputValue: '',
      tableData: [],
      total:0,
      currentPage: 1, // 当前页码
      pageSize: 10, // 每页显示的条数
    }
  },
  methods: {
    onFileChange(e) {
      this.selectedFile = e.target.files[0];
    },
    upload() {
      let formData = new FormData();
      formData.append("file", this.selectedFile);
      formData.append("filename", this.selectedFile.name);
      formData.append("id", this.cid);
      axios.post("/upload/category", formData, {
        headers: {
          "Content-Type": "multipart/form-data"
        }
      }).then(response => {
        console.log("file uploaded", response);
        window.location.reload();
      }).catch(error => {
        console.error("file upload failed", error);
      });
    },
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
             console.log(this.currentPage,this.pageSize, this.total);
            // 请求成功，将返回的数据赋值给tableData和total
            this.tableData = [];
            for(let i = (this.currentPage-1)*this.pageSize, j=0; i < Math.min((this.currentPage-1)*this.pageSize + this.pageSize, this.total); i++) {
              this.tableData[j]=response.data.data[i];
              j++;
              console.log(i);
              console.log(response.data.data[i]);
              console.log(this.tableData[j]);
            }
            //this.tableData = response.data.data; // 假设返回的数据是一个数组
            //console.log(this.tableData)
            //this.total = this.tableData.length;
            console.log(this.total);
          })
          .catch(error => {
            // 请求失败，处理错误
            console.error('请求数据失败:', error);
          });
      // 根据当前页码和每页显示的条数从后端获取数据
      // 更新tableData和total
    },
    handleManage(row) {
      this.router.push({
          path:'/product',
          query: {
            cid: row.id ,
            name:row.name,
          }
    });
      console.log("管理", row.cid);
    },
    handleDelete(row) {
      ElMessageBox.confirm('确定要删除吗？', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      })
          .then(() => {
            // 用户点击了确定按钮
            const deleteUrl = 'category/delete?categoryId=' + row.id;

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
    addProperty(row) {
      this.$prompt('请输入对应分类想要添加的属性个数', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        inputPattern: /\d/,
        inputErrorMessage: '属性个数不正确'
      }).then(({value}) => {
        this.rowCountNum = value;
        this.rowCount = range(1, value, 1);
        // eslint-disable-next-linerow.id;
        this.rowId = row.id;
        console.log(row.id);
        //this.rowCount=Array.from({ length: this.rowCount }, (v, i) => i + 1);
        //console.log(this.rowCount);
        this.secondDialogVisible = true; // 打开第二个对话框);
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
          this.cid = res.data.data;
          console.log("cid是"+this.cid);
          if (res.data.flag) {
            this.$message({
              type: 'success',
              message: '你新建的种类是: ' + value,
            });
            //console.log(value);
            this.thirdDialogVisible = true
            //window.location.reload();
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

    async submitForm(event) {
      event.preventDefault(); // 阻止表单默认提交行为
      // 在这里执行表单提交逻辑
      console.log("行数是" + this.rowCount);
      let requests = []; // 存储所有请求

      for (let i = 1; i <= this.rowCountNum; i++) {
        const inputValue = this.form[`input${i}`];
        requests.push(
            axios.post('property/add', qs.stringify({
              "cid": this.rowId,
              "name": inputValue,
            }))
        );
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
            message: "添加成功"
          });

          this.clearForm();
          this.secondDialogVisible = false;
        } else if (showAlert) {
          alert("添加失败，请重试！");
        }
      } catch (error) {
        console.error(error);
        alert("请求发生错误，请重试！");
      }

      this.clearForm();
      this.secondDialogVisible = false;
      // 或者将表单数据发送至后端
    },

    clearForm() {
      // 将表单中的各个输入元素重置为空字符串或默认值
      for (let i = 1; i <= this.rowCountNum; i++) {
        this.form[`input${i}`] = '';
      }
    }
  },
  mounted() {
    this.getData(); // 页面加载时初始化数据
    //console.log("111"); // 或者将表单数据发送至后端
  },
}
</script>

<style>
#categoryC {
  margin-top: 0px;
}

.table-container {
  margin-top: 0px; /* 设置距离顶部的距离为20像素 */
}

.el-input__inner {
  font-size: 15px;
}

.el-button {
  align-items: center;
  --el-font-size-base: 15px;

}


.fileupload {
  width: 100%;
  height: 100%;

}

</style>
