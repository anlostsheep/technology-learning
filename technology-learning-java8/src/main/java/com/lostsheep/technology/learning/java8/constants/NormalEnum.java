package com.lostsheep.technology.learning.java8.constants;

import lombok.Getter;

/**
 * <b><code>NormalEnum</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2022/3/11
 *
 * @author lostsheep
 * @since technology-learning
 */
@Getter
public enum NormalEnum implements NormalInterface {
    /**
     * admin
     */
    ROOT_ADMIN("系统管理员", 0),

    /**
     * level1 admin
     */
    LEVEL_ONE_ADMIN("等级 1 管理员", 1),

    /**
     * user
     */
    NORMAL_USER("普通用户", 99);

    private final String role;
    private final Integer code;

    NormalEnum(String role, Integer code) {
        this.role = role;
        this.code = code;
    }

    public static Integer getRoleCodeByRoleName(String roleName) {
        for (NormalEnum normalEnum : NormalEnum.values()) {
            if (normalEnum.getRole().equals(roleName)) {
                return normalEnum.getCode();
            }
        }

        return null;
    }

    @Override
    public String op() {
        return null;
    }
}
