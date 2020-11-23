package com.suave.spring5.demo01.dao;

/**
 * @author Suave
 * @date 2020/11/23 10:42
 */
public class OracleUserDao implements UserDao {
    @Override
    public void print() {
        System.out.println("OracleUserDao~~~");
    }
}
