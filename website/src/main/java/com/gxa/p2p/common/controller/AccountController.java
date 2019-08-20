package com.gxa.p2p.common.controller;

import com.gxa.p2p.common.pojo.LoginInfo;
import com.gxa.p2p.common.util.UserContext;;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 个人中心 - 账户信息
 * 
 * @author novo
 * 
 */
@Controller
public class AccountController {



	@RequestMapping("personal2")
	public String personalCenter(Model model) {

		LoginInfo loginInfo = UserContext.getLoginInfo();
		System.out.println("已进入AccountController的personalCenter方法");
		return "personal";
	}

}
