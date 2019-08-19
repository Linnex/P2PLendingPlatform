package com.gxa.p2p.common.service.impl;

import com.gxa.p2p.common.mapper.LogininfoMapper;
import com.gxa.p2p.common.pojo.LoginInfo;
import com.gxa.p2p.common.service.ILoginInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginInfoServiceImpl implements ILoginInfoService {
    @Autowired
    private LogininfoMapper logininfoMapper;

    /**
     * 检查用户名是否已存在
     *
     * @param username
     * @return 返回用户个数
     */
    @Override
    public int checkUsername(String username) {
        System.out.println("已进入LoginInfoServiceImpl的checkUsername方法");
        int count = logininfoMapper.selectCountByUsername(username);
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
            logininfoMapper.insert(li);
        } else {
            // 如果存在,直接抛错
            throw new RuntimeException("用户名asdassda存在!");
        }

    }

    /**
     * 用户登陆
     * @param username
     * @param password
     */
    @Override
    public LoginInfo login(String username, String password) {
        LoginInfo li = logininfoMapper.select(username, password);
        if(li!=null){
            return li;
        }else {
            throw new RuntimeException("用户名不存在仔仔!");
        }
    }


}
