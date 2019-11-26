package com.lz.proxy.demo.service.impl;

import com.lz.proxy.demo.service.Bank;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author sy
 * @date 2019年11月26日
 */
@Slf4j
public class BankImpl implements Bank {
    private static List<String> accounts = new ArrayList<>();

    @Override
    public void setAccount(String account) {
        BankImpl.accounts.add(account);
    }

    @Override
    public List<String> getAllAccount() {
        return BankImpl.accounts;
    }
}
