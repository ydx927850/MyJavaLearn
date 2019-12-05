package algorithm.designMode.singleton.hunger;

/**
 *   单例模式
 *   1.单例模式只能有一个实例
 *   2.单例类必须自己创建自己的唯一实例
 *   3.单例类必须给其他所有对象提供这一实例
 *
 *  饿汉单例模式：在类初始化的时候就创建实例
 *  线程安全的，但是消耗资源(可能只用静态方法，此时就不需要实例化对象)
 */
public class HungerSingletonTest1 {
    private HungerSingletonTest1(){

    }
    //该实例对象的引用是不可以修改的
    private static final HungerSingletonTest1 instance = new HungerSingletonTest1();

    public static HungerSingletonTest1 getInstance() {
        return instance;
    }
}
