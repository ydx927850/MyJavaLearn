package threadTest;

/**
 * @author Yandx
 * @version 1.0
 * @date created on 2019/12/24 15:48
 */
public class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Thread run："+Thread.currentThread().getName());
    }
}
