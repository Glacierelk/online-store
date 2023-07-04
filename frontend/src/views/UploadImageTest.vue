<template>
  <div>
    <input type="file" @change="onFileChange" />
    <button @click="upload">Upload</button>
  </div>
</template>

<script>
import axios from "axios";

export default {
  data() {
    return {
      selectedFile: null
    };
  },
  methods: {
    onFileChange(e) {
      this.selectedFile = e.target.files[0];
    },
    upload() {
      let formData = new FormData();
      formData.append("file", this.selectedFile);
      formData.append("filename", this.selectedFile.name);
      formData.append("type", "type_single")
      formData.append("pid", 87)
      axios.post("/upload/product", formData, {
        headers: {
          "Content-Type": "multipart/form-data"
        }
      }).then(response => {
        console.log("file uploaded", response);
      }).catch(error => {
        console.error("file upload failed", error);
      });
    }
  }
};
</script>