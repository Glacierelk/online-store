<template>
  <table align="center">
    <tr>
      <td>
        <div class="imgDiv" >
          <a href="#">
            <img id="logo" src="../../assets/header/logo.gif" class="logo" alt="logo">
          </a>
        </div>
      </td>
      <td>
        <form action="#" method="post" >
          <div class="searchDiv">
            <input class="searchEnter" name="keyword" type="text" placeholder="时尚男鞋  太阳镜 ">
            <button  type="submit" class="searchButton">搜索</button>
            <div class="searchBelow" >
              <span v-for="(item,index) in recomment" :key="item">
                <a  class="item" href="#">{{item}}</a>
                <a></a>
                <span v-if="index<2">|</span>
              </span>
            </div>
          </div>
        </form>
      </td>
    </tr>
  </table>
</template>

<script setup>
let recomment= ["平衡车","超大棒棒糖","芜湖冲浪板"];

</script>

<style scoped>
  div.searchBelow {
    margin-top: 10px;
    margin-left: -20px;
    text-align: center;
  }

  div.searchBelow a {
    padding: 0 20px 0 20px;
    font-size: 14px;
  }


  div.searchDiv {
    background-color: #C40000;
    width: 400px;
    margin: 50px auto;
    padding: 1px;
    height: 40px;
    display: block;
  }

  div.searchDiv input {
    width: 275px;
    border: 1px solid transparent;
    height: 36px;
    margin-left: 2px;
    outline:none;
  }

  div.searchDiv button {
    width: 110px;
    border: 1px solid transparent;
    background-color: #C40000;
    color: white;
    font-size: 20px;
    font-weight: bold;
  }
  a:hover {
    color: red;
  }
  a.item{
    color: gray;
    text-decoration: none;
  }
</style>