package com.lz.proxy.demo.proxy;

import com.lz.proxy.demo.service.Bank;
import com.lz.proxy.demo.service.impl.BankImpl;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author sy
 * @date 2019年11月26日
 */
@Slf4j
public class BankInvocationHandler implements InvocationHandler {

    public static final String HANDLER_CONSTANT = "AAAAA";
    private Bank bank;

    public BankInvocationHandler(BankImpl bank) {
        this.bank = bank;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getName().startsWith("set")) {
            log.info("test set invocation handler proxy !");
            args[0] = args[0].toString() + HANDLER_CONSTANT;
            return method.invoke(bank, args);
        } else {
            log.info("test get invocation handler proxy !");
            bank.getAllAccount().add("hahaha");
            return method.invoke(bank, args);
        }
    }
}
