<template xmlns:v-slot="http://www.w3.org/1999/XSL/Transform">
  <div>
    <el-table :data="tableData" style="width: 100%">
      <el-table-column prop="ID" label="ID"></el-table-column>
      <el-table-column prop="className" label="分类名称"></el-table-column>
      <el-table-column label="产品管理">
        <template v-slot="scope">
          <el-button type="primary" size="small" :style="{backgroundColor: 'transparent', borderColor: 'transparent'}" @click="handleButtonClick(scope.row)">
            <i class="fa fa-edit" style="color: blue;"></i>
          </el-button>
        </template>
      </el-table-column>
      <el-table-column label="删除">
        <template v-slot="scope">
          <el-button type="danger" size="small" :style="{backgroundColor: 'transparent', borderColor: 'transparent'}"  @click="handleButtonClick(scope.row)">
            <i class="fa fa-trash" style="color: red;"></i>
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

    <div class="centered-form">
      <el-form label-width="100px" class="form-container">

        <el-form-item >
          <h2 class="form-title">新建分类</h2>
        </el-form-item>

        <div class="divider"></div> <!-- 添加的分割线 -->

        <el-form-item label="分类名称">
          <el-input v-model="categoryName"></el-input>
        </el-form-item>
      </el-form>
    </div>

  </div>
</template>

<style>
.centered-form {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
}

.form-container {
  border: 1px solid #ccc;
  padding: 20px;
}

.divider {
  border-top: 1px solid #ccc;
  margin: 20px 0;
}

.form-title {
  text-align: center;
  margin-bottom: 20px;
}
</style>

<script>

export default {
  name: "ManageCategory",
  data() {
    return {
      categoryName: '',
      tableData:  [
        {
        ID: "ID",
        className: "分类名称",
        },
        {
        ID: "ID",
        className: "分类名称",
        }
      ],
      currentPage: 1, // 当前页码
      pageSize: 5, // 每页显示的条数
      total: 0, // 数据总数
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
      // 根据当前页码和每页显示的条数从后端获取数据
      // 更新tableData和total
    },
    handleButtonClick(row) {
      // 在这里处理按钮点击事件
      console.log(row);
    },
    handleDelete(row) {
      // 处理删除按钮点击事件
      console.log("删除", row);
    }
  },
  mounted() {
    this.getData(); // 页面加载时初始化数据
  },
}
</script>

<style>

</style>