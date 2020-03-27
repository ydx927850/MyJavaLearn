package algorithm.designMode.singleton.hunger;

/**
 * 使用静态代码块初始化
 */
public class HungerSingletonTest2 {
    private HungerSingletonTest2(){}

    private static final HungerSingletonTest2 instance;

    static {
        instance = new HungerSingletonTest2();
    }

    public static HungerSingletonTest2 getInstance() {
        return instance;
    }
}
