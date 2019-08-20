package com.gxa.p2p.common.controller;

import com.gxa.p2p.common.pojo.LoginInfo;
import com.gxa.p2p.common.service.ILoginInfoService;
import com.gxa.p2p.common.util.JSONResult;
import com.gxa.p2p.common.util.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginInfoController {

    @Autowired
    private ILoginInfoService iLoginInfoService;

    // 注册时检查用户名是否存在
    @RequestMapping("checkUsername")
    @ResponseBody
    public boolean checkUsername(String username) {
        System.out.println("已进入LoginInfoController的checkUsername方法");
        int count  = iLoginInfoService.checkUsername(username);
        return count <= 0;
    }

    @RequestMapping("register")
    @ResponseBody
    public JSONResult register(String username, String password) {
        System.out.println("已进入LoginInfoController的register方法");
        JSONResult json = new JSONResult();
        try {
            iLoginInfoService.register(username, password);
            json.setSuccess(true);
        } catch (RuntimeException re) {
            json.setSuccess(false);
            json.setMsg(re.getMessage());
        }
        return json;
    }

    @RequestMapping("login")
    @ResponseBody
    public JSONResult login(String username, String password, HttpServletRequest request) {
        System.out.println("已进入LoginInfoController的login方法");
        LoginInfo loginInfo = iLoginInfoService.login(username, password, request, LoginInfo.USER_WEB);
        JSONResult json = new JSONResult();
        if(null == loginInfo){
            json.setSuccess(false);
            json.setMsg("登录失败,用户名或密码无效");
        }else {
            json.setSuccess(true);
        }
        return json;
    }

}

