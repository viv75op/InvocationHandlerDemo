package com.lz.proxy.demo.service;

import java.util.List;

/**
 * @author sy
 * @date 2019年11月26日
 */
public interface Bank {

    void setAccount(String account);

    List<String> getAllAccount();
}
