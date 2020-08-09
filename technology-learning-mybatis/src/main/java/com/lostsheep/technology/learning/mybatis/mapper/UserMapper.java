package com.lostsheep.technology.learning.mybatis.mapper;

import com.lostsheep.technology.learning.mybatis.domain.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * <b><code>UserMapper</code></b>
 * <p/>
 * User 表数据操作
 * <p/>
 * <b>Creation Time:</b> 2020/7/26 1:55.
 *
 * @author dengzhen
 * @since technology-learning 1.0.0
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
