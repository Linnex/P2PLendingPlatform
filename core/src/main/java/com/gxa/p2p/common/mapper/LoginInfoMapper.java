package com.gxa.p2p.common.mapper;

import com.gxa.p2p.common.pojo.LoginInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LoginInfoMapper {
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

    /**
     * 用户登录
     *
     * @param username
     * @param password
     * @param usertype
     * @return
     */
    LoginInfo login(@Param("username") String username,
                    @Param("password") String password,
                    @Param("usertype") int usertype);

}