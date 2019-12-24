package threadTest;

/**
 * @author Yandx
 * @version 1.0
 * @date created on 2019/12/24 14:51
 */
public class RunTest {
    public static void main(String[] args) {
        System.out.println("Main Thread："+Thread.currentThread().getName());
        MyThread myThread = new MyThread();
        myThread.run();
    }
}
