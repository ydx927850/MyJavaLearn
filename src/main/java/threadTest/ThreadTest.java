package threadTest;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Yandx
 * @version 1.0
 * @date created on 2019/12/24 15:48
 */
public class ThreadTest {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        ThreadTest t1 = new ThreadTest();
        ThreadTest t2 = new ThreadTest();
        executorService.execute(t1::func);
        executorService.execute(t2::func);
    }
    private Lock lock = new ReentrantLock();
    public void func() {
        lock.lock();
        try {
            for (int i = 0; i < 10; i++) {
                System.out.print(i + " ");
            }
        } finally {
            lock.unlock(); // 确保释放锁，从而避免发生死锁。
        }
    }
}
