package jvm.dynamicdispatch;

/**
 * 静态分配的例子
 *
 * @author Yandx
 * @version 1.0
 * @date created on 2019/8/21 19:28
 */
public class StaticDispatchExample {
    static abstract class Human {
    }

    static class Man extends Human {
    }

    static class Woman extends Human {
    }

    public void sayHello(Human person){
        System.out.println("hello human!");
    }

    public void sayHello(Man person){
        System.out.println("hello man!");
    }

    public void sayHello(Woman person){
        System.out.println("hello woman!");
    }

    public static void main(String[] args) {
        Human man = new Man();
        Human woman = new Woman();
        StaticDispatchExample staticDispatchExample = new StaticDispatchExample();
        //静态类型为Human
        staticDispatchExample.sayHello(man);
        //静态类型为Human
        staticDispatchExample.sayHello(woman);
        man = new Woman();
        //静态类型为Human
        staticDispatchExample.sayHello(man);
        //静态类型为Woman
        staticDispatchExample.sayHello((Woman)man);
    }
}
