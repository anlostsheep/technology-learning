package com.lostsheep.technology.learning.mybatis;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * <b><code>Mysql8Test</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2023/5/30.
 *
 * @author dengzhen
 * @since technology-learning
 */
@SpringBootTest(classes = MybatisRunApplication.class)
@Slf4j
public class Mysql8Test {

    @Test
    public void testConnect() {
        Statement statement = null;
        Connection conn = null;
        try {
            //1 导入驱动jar包
            //2 注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //3 获取数据库连接对象
            conn = DriverManager.getConnection(" jdbc:mysql://192.168.63.2:3308/app_formsys_eb?useUnicode=true&characterEncoding=UTF-8&allowMultiQueries=true", "app_formsys_eb", "ZegSpABPTy31GptT");
            //4 定义sql语句
            String sql = "show table status";
            //获取执行sql的对象
            statement = conn.createStatement();
            int i = statement.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //释放资源
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }
}
