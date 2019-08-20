package com.gxa.p2p.common.service;

import com.gxa.p2p.common.pojo.LoginInfo;

import javax.servlet.http.HttpServletRequest;

public interface ILoginInfoService {
    int checkUsername(String username);
    void register(String username, String password);
    /**
     * 用户登录
     *  @param username
     * @param password
     */
    LoginInfo login(String username, String password, HttpServletRequest request, int usertype);


}
