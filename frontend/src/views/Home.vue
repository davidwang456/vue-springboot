<template>
  <div class="home">
    <el-table :data="packages" style="width: 100%">
      <el-table-column prop="initiator" label="发起人"></el-table-column>
      <el-table-column prop="type" label="类型"></el-table-column>
      <el-table-column prop="domain" label="域名"></el-table-column>
      <el-table-column prop="pkgName" label="包名"></el-table-column>
      <el-table-column prop="pkgVersion" label="版本"></el-table-column>
      <el-table-column prop="repositoryName" label="仓库名"></el-table-column>
      <el-table-column prop="createTime" label="创建时间"></el-table-column>
    </el-table>
    
    <div class="pagination-container">
      <el-pagination
        @current-change="handleCurrentChange"
        :current-page="currentPage"
        :page-size="pageSize"
        layout="total, prev, pager, next"
        :total="total">
      </el-pagination>
    </div>
  </div>
</template>

<script>
import axios from 'axios'

export default {
  name: 'Home',
  data() {
    return {
      packages: [],
      currentPage: 1,
      pageSize: 20,
      total: 0
    }
  },
  created() {
    this.fetchData()
  },
  methods: {
    async fetchData() {
      try {
        const response = await axios.get(`/api/packages?pageNum=${this.currentPage}&pageSize=${this.pageSize}`)
        this.packages = response.data.list
        this.total = response.data.total
      } catch (error) {
        console.error('Error fetching data:', error)
      }
    },
    handleCurrentChange(val) {
      this.currentPage = val
      this.fetchData()
    }
  }
}
</script>

<style scoped>
.home {
  padding: 20px;
}
.pagination-container {
  margin-top: 20px;
  text-align: center;
}
</style> 