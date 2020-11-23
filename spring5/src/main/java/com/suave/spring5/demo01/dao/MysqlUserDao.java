package com.suave.spring5.demo01.dao;

/**
 * @author Suave
 * @date 2020/11/23 10:41
 */
public class MysqlUserDao implements UserDao {
    @Override
    public void print() {
        System.out.println("MysqlUserDao~~~");
    }
}
