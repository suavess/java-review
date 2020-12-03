package com.suave.spring5.demo06.service.impl;

import com.suave.spring5.demo06.service.UserService;

/**
 * @author Suave
 * @date 2020/12/2 19:39
 */
public class UserServiceImpl implements UserService {
    @Override
    public void insert() {
        System.out.println("增加~");
    }

    @Override
    public void delete() {
        System.out.println("删除~");
    }

    @Override
    public void update() {
        System.out.println("更新~");
    }

    @Override
    public void select() {
        System.out.println("查询~");
    }
}
