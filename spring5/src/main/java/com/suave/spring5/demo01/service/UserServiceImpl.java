package com.suave.spring5.demo01.service;

import com.suave.spring5.demo01.dao.UserDao;

/**
 * @author Suave
 * @date 2020/11/23 10:40
 */
public class UserServiceImpl implements UserService {
    @Override
    public void print(UserDao userDao) {
        userDao.print();
    }
}
