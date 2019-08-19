package com.gxa.p2p.common.controller;

import com.gxa.p2p.common.service.ILoginInfoService;
import com.gxa.p2p.common.util.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginInfoController {

    @Autowired
    private ILoginInfoService iLoginInfoService;

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
            System.out.println("已经执行完setSuccess方法hhhh");
        } catch (RuntimeException re) {
            json.setSuccess(false);
            json.setMsg(re.getMessage());
        }
        return json;
    }

    @RequestMapping("login")
    @ResponseBody
    public JSONResult login(String username, String password) {
        System.out.println("已进入LoginInfoController的login方法");
        JSONResult json = new JSONResult();
        try {
            iLoginInfoService.login(username, password);
            json.setSuccess(true);
            System.out.println("已经执行完setSuccess方法");
        } catch (RuntimeException re) {
            json.setSuccess(false);
            json.setMsg(re.getMessage());
        }
        return json;
    }

}

