package algorithm.designMode.singleton.lazy;

/**
 * 懒汉模式单例实现 --> 只有在需要的时候才去创建实例
 * 为了避免多线程出错，需要加锁
 * 通过双重检查锁来提高效率
 */
public class LazySingletonTest {
    private LazySingletonTest(){}

    /**
     * 加volatile是为了避免instance = new LazySingletonTest()这一步的指令重排序导致instance的内存地址先于初始化对象发生，
     * (1)分配 memory
     * (2)将instance引用指向内存空间
     * (3)初始化instance实例对象
     * 导致实际instance对象尚未创建，但instance！=null这种情况出现，避免指令重排序导致的线程安全问题
     *
     */
    private static volatile LazySingletonTest instance;

    public static LazySingletonTest getInstance() {
        if(instance == null){
            synchronized (LazySingletonTest.class){
                if(instance == null){
                    instance = new LazySingletonTest();
                }
            }
        }
        return instance;
    }
}
