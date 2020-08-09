package com.lostsheep.technology.learning.mybatis;

import com.alibaba.fastjson.JSON;
import com.lostsheep.technology.learning.mybatis.domain.User;
import com.lostsheep.technology.learning.mybatis.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * <b><code>MybatisApiTest</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2020/7/26 2:16.
 *
 * @author dengzhen
 * @since technology-learning 1.0.0
 */
@Slf4j
@SpringBootTest(classes = MybatisRunApplication.class)
public class MybatisApiTest {
    
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelectOne() {
        User user = userMapper.selectById(1L);
        log.info("user:{}", JSON.toJSONString(user));
    }

    @Test
    public void testSelectAll() {
        List<User> users = userMapper.selectAll();
        log.info("users:{}", JSON.toJSONString(users));
    }
}
