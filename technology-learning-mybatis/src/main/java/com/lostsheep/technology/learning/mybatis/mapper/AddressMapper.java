package com.lostsheep.technology.learning.mybatis.mapper;

import com.lostsheep.technology.learning.mybatis.domain.Address;
import org.apache.ibatis.annotations.Mapper;

/**
 * <b><code>AddressMapper</code></b>
 * <p/>
 * Address 表操作 mapper
 * <p/>
 * <b>Creation Time:</b> 2020/7/26 23:39.
 *
 * @author dengzhen
 * @since technology-learning 1.0.0
 */
@Mapper
public interface AddressMapper extends BaseMapper<Address> {

    /**
     * 查询地址
     * @param id
     * @return
     */
    String selectAddressName(Long id);
}
