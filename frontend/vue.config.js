module.exports = {
  devServer: {
    proxy: {
      '/api': {
        target: 'http://localhost:8080',
        changeOrigin: true
      }
    }
  },
  // 生产环境配置
  outputDir: '../src/main/resources/public',
  assetsDir: 'static',
  indexPath: 'index.html'
} 