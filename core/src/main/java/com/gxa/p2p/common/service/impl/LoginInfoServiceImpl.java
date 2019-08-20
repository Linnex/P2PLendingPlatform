package com.gxa.p2p.common.service.impl;

import com.gxa.p2p.common.mapper.LoginInfoMapper;
import com.gxa.p2p.common.pojo.Account;
import com.gxa.p2p.common.pojo.LoginInfo;
import com.gxa.p2p.common.service.IAccountService;
import com.gxa.p2p.common.service.ILoginInfoService;
import com.gxa.p2p.common.util.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Service
public class LoginInfoServiceImpl implements ILoginInfoService {
    @Autowired
    private LoginInfoMapper loginInfoMapper;

    @Autowired
    private IAccountService iAccountService;

    /**
     * 检查用户名是否已存在
     *
     * @param username
     * @return 返回用户个数
     */
    @Override
    public int checkUsername(String username) {
        System.out.println("已进入LoginInfoServiceImpl的checkUsername方法");
        int count = loginInfoMapper.selectCountByUsername(username);
        return count;
    }


    /**
     * 新用户注册
     * @param username
     * @param password
     */
    @Override
    public void register(String username, String password) {
        /*
         * 逻辑思路
         * 1. 判断用户名是否存在
         * 2. 如果不存在,设值并保存这个对象
         * 3. 如果存在,直接抛错
         *
         */
        int count = checkUsername(username);

        if (count <= 0) {
            LoginInfo li = new LoginInfo();
            li.setUsername(username);
            li.setPassword(password);
            li.setState(LoginInfo.STATE_NORMAL);
            loginInfoMapper.insert(li);

            // 初始化账户信息Account
            Long id = li.getId();
            Account account = new Account();
            account.setId(id);
            iAccountService.add(account);

        } else {
            // 如果存在,直接抛错
            throw new RuntimeException("用户名已存在!");
        }

    }

    /**
     * 用户登陆
     * @param username
     * @param password
     */
    @Override
    public LoginInfo login(String username, String password, HttpServletRequest request, int usertype) {
        LoginInfo loginInfo = loginInfoMapper.login(username,password,usertype);

        if (loginInfo != null) {
            /* 将登录用户的数据，通过UserContext工具类，存放至session*/
            UserContext.putLoginInfo(loginInfo);
        } else {
//            iplog.setState(Iplog.LOGIN_FAILED);
        }
        return loginInfo;

    }


}
