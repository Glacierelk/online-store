const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true,
  devServer: {
    open: false,
    port: 8081,

  },

})

module.exports = {
  css: {
    loaderOptions: {
      sass: {
        prependData: `@import "~bootstrap/scss/bootstrap.scss";`
      }
    }
  }
};
