package com.gxa.p2p.common.service;

import com.gxa.p2p.common.pojo.Account;

public interface IAccountService {
    /**
     * 新增账户信息
     *
     * @param account
     */
    void add(Account account);

    /**
     * 得到当前登陆用户对应的Account对象
     *
     * @return
     */
    Account getCurrentAccount(Long id);

    /**
     * 更新账户信息需要乐观锁支持
     *
     * @param account
     */
    void update(Account account);

}
