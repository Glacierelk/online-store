<template xmlns:v-bind="http://www.w3.org/1999/xhtml" xmlns:v-on="http://www.w3.org/1999/xhtml">
  <div class="app">
    <div class="navbar">
      <div class="buttons">
        <button v-on:mouseover="highlight" v-on:mouseleave="unhighlight" v-bind:class="{highlight: isHighlight1}" >分类管理</button>
        <button v-on:mouseover="highlight2" v-on:mouseleave="unhighlight2" v-bind:class="{highlight: isHighlight2}">用户管理</button>
        <button v-on:mouseover="highlight3" v-on:mouseleave="unhighlight3" v-bind:class="{highlight: isHighlight3}">订单管理</button>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      isHighlight1: false,
      isHighlight2: false,
      isHighlight3: false,
    }
  },
  methods: {
    highlight() {
      this.isHighlight1 = true;
    },
    unhighlight() {
      this.isHighlight1 = false;
    },
    highlight2() {
      this.isHighlight2 = true;
    },
    unhighlight2() {
      this.isHighlight2 = false;
    },
    highlight3() {
      this.isHighlight3 = true;
    },
    unhighlight3() {
      this.isHighlight3 = false;
    },
  }
}
</script>

<style scoped>
.navbar {
  background-color: grey;
  display: flex;
  justify-content: start;
  padding: 20px;
  width: 100%;
}
.buttons {
  display: flex;
  justify-content: space-between;
  width: 33%; /* Buttons take up 1/3 of the navbar */
}
button {
  color: white;
  background-color: black;
  border: none;
  cursor: pointer;
  width: calc((33% - 2*10px) / 3); /* Each button takes up 1/3 of the available space for buttons, subtracting the margin */
  margin: 0 10px;
  text-align: center;
}
button.highlight {
  color: yellow;
}
</style>
