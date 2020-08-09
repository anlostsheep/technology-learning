package com.lostsheep.technology.learning.mybatis.domain;

import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

/**
 * <b><code>User</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2020/7/26 1:55.
 *
 * @author dengzhen
 * @since technology-learning 1.0.0
 */
@Data
public class User {
    
    private Long id;
    
    private String username;
    
    private String password;
    
    private Long age;
    
    private String gender;
    
    //private Address address;
    
    private String address;
    
    private Long addressId;
    
    private String creator;
    
    private String modifier;
    
    private Timestamp createTime;
    
    private Timestamp modifyTime;
    
    private List<Car> cars;
}
