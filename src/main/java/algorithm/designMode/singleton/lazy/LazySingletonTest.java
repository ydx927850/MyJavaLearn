package algorithm.designMode.singleton.lazy;

/**
 * 懒汉模式单例实现 --> 只有在需要的时候才去创建实例
 * 为了避免多线程出错，需要加锁
 * 通过双重检查锁来提高效率
 */
public class LazySingletonTest {
    private LazySingletonTest(){}

    private LazySingletonTest instance;

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
