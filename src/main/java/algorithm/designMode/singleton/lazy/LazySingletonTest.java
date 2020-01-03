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
     * 导致实际instance对象尚未创建，但instance！=null这种情况出现，避免指令重排序导致的线程安全问题
     *
     */
    private volatile LazySingletonTest instance;

    public LazySingletonTest getInstance() {
        if (instance == null){
            synchronized (LazySingletonTest.class){
                //对类加锁，所有该类的对象用同一把锁，也就是说哪个线程先拿到了其他线程就被阻塞
                if (instance == null){
                    instance = new LazySingletonTest();
                }
            }
        }
        return instance;
    }
}
