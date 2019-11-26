package com.lz.proxy.demo;

import com.lz.proxy.demo.proxy.BankInvocationHandler;
import com.lz.proxy.demo.service.Bank;
import com.lz.proxy.demo.service.impl.BankImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.lang.reflect.Proxy;
import java.util.List;

@Slf4j
public class TestInvocationHandler {
    private static final String ACCOUNT = "nihao123";
    public static final String HANDLER_CONSTANT = "AAAAA";

    @Test
    public void TestProxySet() {
        Bank bank = (Bank) buildBackByProxy();
        addAccounts(bank);
        assert (ACCOUNT + HANDLER_CONSTANT).equals(bank.getAllAccount().get(0));
    }

    /**
     * debug 模式下，会多次调用invoke方法，据说时method.toString的原因，具体未去追查
     */
    @Test
    public void TestProxyGet() {
        Bank bank = (Bank) buildBackByProxy();
        List<String> result = bank.getAllAccount();
        log.info("accounts is {}", result.toString());
        assert (result.get(0)).equals("hahaha");
    }


    private void addAccounts(Bank bank) {
        bank.setAccount(TestInvocationHandler.ACCOUNT);
    }


    private Object buildBackByProxy() {
        return Proxy.newProxyInstance(Bank.class.getClassLoader(),
                new Class[]{Bank.class}, new BankInvocationHandler(new BankImpl()));
    }
}