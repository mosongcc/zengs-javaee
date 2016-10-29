zen-generate web项目架构
================================

1. entity模块用于实体类生成,dto生成。

2. jdbc 数据库操作封装，提供给其他项目使用，作为模块发布包。 sql文件通过xml配置，启动缓存到Map
  定义一个jdbc对象，spring 注入，调用带有自定义@jdbcTans注解的方法时，调用对象的指定方法，设置开启事务

3. web ，service  controller等业务处理调用jdbc示例。 使用spring控制事务

4. 待定，生成单表增删查该

5. 待定，使用spring boot

