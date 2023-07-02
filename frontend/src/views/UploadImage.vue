<script setup>
import axios from "axios";

function uploadImage() {
  var input = document.getElementById("imageInput");
  var file = input.files[0];

  var formData = new FormData();
  formData.append("image", file);

  axios.post("/upload/test", formData)
      .then(function(response) {
        console.log("图片上传成功");
        console.log(response.data)
      })
      .catch(function(error) {
        console.log("图片上传失败");
        console.log(error);
      });
}

// function submitUpload() {
//   this.$refs.upload.submit();
// }

function handleExceed() {
  this.$message.warning('超出了限制个数');
}

function handleRemove(file) {
  return this.$confirm(`确定移除 ${file.name}？`);
}

function handleBeforeUpload(file) {
  const uploadLimit = 2
  const uploadTypes = ['jpg', 'png', 'jpeg']
  const filetype = file.name.replace(/.+\./, '')
  const isRightSize = (file.size || 0) / 1024 / 1024 < uploadLimit
  if (!isRightSize) {
    this.$message.error('文件大小超过 ' + uploadLimit + 'MB')
    return false
  }

  if (uploadTypes.indexOf(filetype.toLowerCase()) === -1) {
    this.$message.warning({
      message: '请上传后缀名为jpg、png、jpej的附件'
    })
    return false
  }

  return true
}


</script>

<template>
  <input type="file" id="imageInput" />
  <button @click="uploadImage">Upload</button>

  <el-upload
      name="image"
      class="upload-demo"
      action="http://localhost:8729/store/upload/test"
      :on-remove="handleRemove"
      :limit="1"
      :on-exceed="handleExceed"
      :before-upload="handleBeforeUpload"
      :auto-upload="false"
  >
    <el-button type="primary">Click to upload</el-button>
    <template #tip>
      <div class="el-upload__tip">
        jpg/png files with a size less than 500KB.
      </div>
    </template>
  </el-upload>
</template>

<style scoped>

</style>