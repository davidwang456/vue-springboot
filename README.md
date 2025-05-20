帮我一个基于 Spring Boot 和 Vue 的分页查询系统，该系统前后端不分离，后端使用 Spring Boot 和 MySQL 提供分页查询接口，前端使用 Vue 2.6.17 和 vue-router 3.6.5 展示分页数据，每页数据默认为 20 条。
技术栈
后端 ：Spring Boot 2.7.5、MySQL8,实体包含字段如下：Initiator、Type、Domain、pkgName、pkgVersion、RepositoryName、CreateTime。
前端 ：Vue 2.6.17、Vue-Router 3.6.5，node >=16  npm 编译后放到后端src/resources/public目录下
测试数据：自动生成10000条测试数据，插入数据库表进行展示验证。