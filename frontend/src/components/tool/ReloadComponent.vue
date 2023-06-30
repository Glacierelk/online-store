<template>
  <div id="reloadComponent">
    <router-view v-if="isRouterAlive"></router-view>
    <CategoryComponents />
  </div>
</template>

<script>
import CategoryComponents from '../manage/CategoryComponents'; // 导入子组件

export default {
  name: 'ReloadComponent',
  components: {
    CategoryComponents
  },
  provide() {    // 父组件中通过provide来提供变量，在子组件中通过inject来注入变量。
    return {
      reload: this.ReloadComponent
    }
  },
  data() {
    return {
      isRouterAlive: true  // 控制视图是否显示的变量
    }
  },
  methods: {
    reload() {
      this.isRouterAlive = false;  // 先关闭
      this.$nextTick(() => {
        this.isRouterAlive = true;  // 再打开
      })
    }
  }
}
</script>