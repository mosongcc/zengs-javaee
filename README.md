zengs-javaee
===============================

# Java项目基础架构

1. 表结构生成实体类
2. 实体类生成insert
3. 实体类生成update，条件对象key value
4. 实体类生成delete, 条件对象 key value
5. 实体类单表查询所有 ,条件对象 key value
6.实体类单表查询分页，条件对象key value，分页对象  ，返回 List<Map> ,根据字段名转为List<Entity>
7.多表查询 ，自定一个xml文件

    '''
    <mapper><sql id="seleuser">select * from aaa where b=? limit ?,?</sql></mapper>
    '''

         ，返回 List<Map> ,根据字段名转为List<Entity>

普通框架生成大量无效文件，借鉴hibernate的对象操作，借鉴mybatis的xml文件存储sql

要求：
1. 每张表都必须有一个实体类；
2. 实体类字段名必须是数据库字段一致；
（规则：对数据库字段变小写字母，对第二位开始的‘_’下划线符号删除且改变后面的一个字母大写）