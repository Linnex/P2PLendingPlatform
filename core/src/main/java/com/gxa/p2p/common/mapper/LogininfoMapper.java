package com.gxa.p2p.common.mapper;

import com.gxa.p2p.common.pojo.LoginInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LogininfoMapper {
    /**
     * 根据用户名查询用户数量
     *
     * @param username
     * @return int
     */
    int selectCountByUsername(String username);

    /**
     * 新用户注册
     *
     * @param loginInfo
     *
     */
    int insert(LoginInfo loginInfo);

    LoginInfo select(@Param("username") String username, @Param("password") String password);

}