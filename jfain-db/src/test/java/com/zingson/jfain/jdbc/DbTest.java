package com.zingson.jfain.jdbc;

import com.alibaba.druid.pool.DruidDataSource;
import com.zingson.jfain.example.entity.User;
import com.zingson.jfain.jdbc.dialect.Criteria;
import com.zingson.jfain.jdbc.dialect.MysqlDialect;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;


/**
 * 数据库操作类测试，数据源加载完成后，可在项目任务位置使用
 */
public class DbTest {

    Logger log = LoggerFactory.getLogger(this.getClass());

    public DataSource diurdDataSource(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl("jdbc:mysql://dev-mysql.s.zingson.com:3306/test");
        dataSource.setUsername("zingson");
        dataSource.setPassword("zingson.server");
        return dataSource;
    }

    /**
     * 初始化数据源
     */
    @Before
    public void before(){
        Db.init(
                new DbConfig(diurdDataSource(),new MysqlDialect())
        );
        log.info("Load datasource....");
    }

    @Test
    public void saveTest() throws Exception {
        log.info("Test ...");
        User user = new User();
        user.setId(14);
        user.setUserName("jfain13");
        user.setPassword("123qwe13");
        Db.insert(user);
        // OK
    }

    @Test
    public void updateTest() throws Exception {
        log.info("Test ...");
        User  user = new User();
        user.setId(14);
        user.setUserName("jfa");
        user.setPassword("123");
        Db.update(user,new Criteria().andEqualTo("id",14));
        // OK
    }

    @Test
    public void deleteTest() throws Exception {
        log.info("Test ...");
        Db.delete(User.class,Criteria.build().andEqualTo("id",14));
        // OK
    }


    @Test
    public void txTest(){
        log.info("Test ...");
        try {
            Db.tx((db)->{
                db.insert(new User(17,"jfain15","1513"));
                db.insert(new User(18,"jfain16","1613116131161311613116131161311613116131"));//超出长度出错
                return 0;
            });
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // OK
    }

    // 查询功能测试
    @Test
    public void queryForListTest(){
        try {
            List<User> list = Db.queryForList(User.class);
            System.out.println(list);
            List<Map<String, ?>> list2 = Db.queryForListMap(User.class);
            System.out.println(list2);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void paginate(){
        try {
            Page<User> page = Db.paginate(User.class,0,9);
            System.out.println(page.getList());
            System.out.println(page.getTotalPage());
            System.out.println(page.getTotalRow());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}