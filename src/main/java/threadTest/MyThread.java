package threadTest;

/**
 * @author Yandx
 * @version 1.0
 * @date created on 2019/12/24 15:06
 */
public class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("Thread run："+Thread.currentThread().getName());
    }
}
