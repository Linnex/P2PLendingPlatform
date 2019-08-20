package com.gxa.p2p.common.controller;

import com.gxa.p2p.common.pojo.Account;
import com.gxa.p2p.common.pojo.LoginInfo;
import com.gxa.p2p.common.service.IAccountService;
import com.gxa.p2p.common.util.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class PersonalController {
    @Autowired
    private IAccountService iAccountService;

    @RequestMapping("personal")
    public String personalCenter(Model model) {

        LoginInfo loginInfo = UserContext.getLoginInfo();
        Account currentAccount = iAccountService.getCurrentAccount(loginInfo.getId());
        System.out.println(currentAccount.toString());
        model.addAttribute("account", currentAccount);

        List<String> list=new ArrayList<>();
        list.add(currentAccount.getUsableamount().toString());
        list.add(currentAccount.getFreezedamount().toString());
        list.add(currentAccount.getUnreceiveinterest().toString());
        list.add(currentAccount.getUnreceiveprincipal().toString());
        list.add(currentAccount.getUnreturnamount().toString());
        BigDecimal count=new BigDecimal(0);
        for(String s:list) {
            count = count.add(new BigDecimal(s));
        }
        model.addAttribute("count", count);
        return "personal";
    }

}
