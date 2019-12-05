package algorithm.designMode.singleton.hunger;

/**
 * 优化饿汉模式，减少其资源消耗
 * 实现思路是通过私有嵌套
 * 只有当调用getInstance的时候才会去实例化Nested这个嵌套的私有内部类，此时去实例化外层的对象
 */
public class HungerSingletonTest3 {
    private HungerSingletonTest3(){}

    private static HungerSingletonTest3 instance;

    private HungerSingletonTest3 getInstance(){
        return Nested.instance;
    }

    private static class Nested{
        static final HungerSingletonTest3 instance = new HungerSingletonTest3();
    }
}
