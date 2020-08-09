package com.lostsheep.technology.learning.mybatis.mapper;

import com.lostsheep.technology.learning.mybatis.domain.Car;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <b><code>CarMapper</code></b>
 * <p/>
 * Car 表操作 mapper
 * <p/>
 * <b>Creation Time:</b> 2020/7/27 0:11.
 *
 * @author dengzhen
 * @since technology-learning 1.0.0
 */
@Mapper
public interface CarMapper extends BaseMapper<Car> {

    /**
     * 根据 userId 查找列表
     * @param userId userId
     * @return List<Car>
     */
    List<Car> selectByUserId(@Param("userId") Long userId);
}
