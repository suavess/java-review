package com.suave.lambda;

/**
 * 推导lambda表达式
 *
 * @author Suave
 * @date 2020/11/18 16:56
 */
public class TestLambda1 {

    /**
     * 3.静态内部类
     */
    static class Like2 implements ILike {
        @Override
        public void lambda() {
            System.out.println("I like lambda2~");
        }
    }

    public static void main(String[] args) {
        ILike like = new Like();
        like.lambda();

        ILike like2 = new Like2();
        like2.lambda();

        /**
         * 4.局部内部类
         */
        class Like3 implements ILike {
            @Override
            public void lambda() {
                System.out.println("I like lambda3~");
            }
        }
        ILike like3 = new Like3();
        like3.lambda();

        /**
         * 5.匿名内部类
         */
        ILike like4 = new ILike(){
            @Override
            public void lambda() {
                System.out.println("I like lambda4~");
            }
        };
        like4.lambda();

        /**
         * 6.lambda简化
         */
        ILike like5 = ()->{
            System.out.println("I like lambda5~");
        };
        like5.lambda();
    }

}

/**
 * 1.定义一个函数式接口
 */
interface ILike {
    void lambda();
}

/**
 * 2.实现类
 */
class Like implements ILike {
    @Override
    public void lambda() {
        System.out.println("I like lambda~");
    }
}