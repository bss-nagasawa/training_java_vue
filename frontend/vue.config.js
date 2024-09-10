const { defineConfig } = require('@vue/cli-service');
const webpack = require('webpack');

module.exports = defineConfig({
  transpileDependencies: true,
  devServer: {
    proxy: {
      '/api': {
        target: 'http://localhost:8081', // Spring Bootのポートに合わせる
        changeOrigin: true,
      },
    },
    port: 8080 // Vue.jsのポートを変更
  },
  outputDir: 'dist', // ビルドされたファイルの出力先を適切なディレクトリに変更
  configureWebpack: {
    plugins: [
      new webpack.DefinePlugin({
        __VUE_PROD_HYDRATION_MISMATCH_DETAILS__: JSON.stringify(true)
      })
    ]
  }
});