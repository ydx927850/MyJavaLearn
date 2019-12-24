package threadTest;

/**
 * @author Yandx
 * @version 1.0
 * @date created on 2019/12/24 15:48
 */
public class ThreadTest {
    public static void main(String[] args) {
        MyThread tr1 = new MyThread();
        MyThread tr2 = new MyThread();
        MyThread tr3 = new MyThread();
        tr1.start();
        tr2.start();
        tr3.start();
        MyRunnable mr1 = new MyRunnable();
        MyRunnable mr2 = new MyRunnable();
        MyRunnable mr3 = new MyRunnable();
        Thread t1 = new Thread(mr1);
        Thread t2 = new Thread(mr2);
        Thread t3 = new Thread(mr3);
        t1.start();
        t2.start();
        t3.start();
    }
}
