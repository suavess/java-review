package com.suave.lambda;

/**
 * @author Suave
 * @date 2020/11/18 17:15
 */
public class TestLambda2 {

    public static void main(String[] args) {

        ILove love = a -> System.out.println("I love you -> " + a);
        love.love(2);
    }
}

interface ILove {
    void love(int a);
}

