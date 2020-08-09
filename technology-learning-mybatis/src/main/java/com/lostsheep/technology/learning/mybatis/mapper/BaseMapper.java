package com.lostsheep.technology.learning.mybatis.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <b><code>BaseMapper</code></b>
 * <p/>
 * 基类 mapper 接口
 * <p/>
 * <b>Creation Time:</b> 2020/7/26 23:15.
 *
 * @author dengzhen
 * @since technology-learning 1.0.0
 */
public interface BaseMapper<T> {

    /**
     * 根据 id 查找
     * @param id id
     * @return T
     */
    T selectById(Long id);

    /**
     * 查询所有
     * @return List<T>
     */
    List<T> selectAll();

    /**
     * 插入一条记录
     * @param t T
     * @return 影响行数
     */
    int insertAnRecord(T t);

    /**
     * 批量插入记录
     * @param list List<T>
     * @return 影响行数
     */
    int batchInsertRecord(@Param("list") List<T> list);

    /**
     * 根据 id 删除
     * @param id id
     * @return 影响行数
     */
    int deleteById(Long id);

    /**
     * 批量删除
     * @param list List<Long>
     * @return 影响行数
     */
    int batchDeleteRecord(@Param("list") List<Long> list);

    /**
     * 更新单条数据
     * @param t T
     * @return 影响行数
     */
    int updateAnRecord(T t);

    /**
     * 批量更新数据
     * @param list List<T>
     * @return 影响行数
     */
    int batchUpdateRecord(@Param("list") List<T> list);
}
