spring-framework.md
==========================
Spring 框架模块化结构
--------------------------

# 模块划分
- ul-commons
- ul-framework
- ul-spring-jdbc
- ul-mybatis
- ul-jdbc
- ul-webapp

## ul-commons
工具类模块

## ul-framework
1. Spring配置加载，取代xml文件配置。 
2. 项目默认包规则如下：
    - Spring上下文注解扫描包 com.ul.app
    - Spring Servlet扫描包 com.ul.app.*.controller
 
## ul-spring-jdbc
Spring jdbc操作封装代码

## ul-webapp
WEB项目发布模块，如果是API项目，此模块为空，只用于开发运行测试。