<script setup>
import axios from "axios";

function upload() {
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

</script>

<template>
  <input type="file" id="imageInput" />
  <button @click="upload">Upload</button>
</template>

<style scoped>

</style>