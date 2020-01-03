package threadTest;

/**
 * notify是随机去唤醒等待池中的一个线程进入锁池
 * notifyAll则是将等待池中的全部线程都唤醒
 * @author Yandx
 * @version 1.0
 * @date created on 2019/12/26 9:29
 */
public class NotifyAllAndNotifyTest {
    /**
     * volatile保证了不同线程对这个变量进行操作时的可见性，即一个线程修改了某个变量的值，这新值对其他线程来说是立即可见的。（实现可见性）
     */
    private volatile boolean go = false;

    public static void main(String[] args) throws InterruptedException {
        NotifyAllAndNotifyTest test = new NotifyAllAndNotifyTest();
        Runnable waitTask = () -> {
            try {
                test.shouldGo();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread() + " has finished");
        };

        Runnable notifyTask = () -> {
            test.go();
            System.out.println(Thread.currentThread() + " has finished");
        };

        Thread t1 = new Thread(waitTask, "WT1");
        Thread t2 = new Thread(waitTask, "WT2");
        Thread t3 = new Thread(waitTask, "WT3");
        t1.start();
        t2.start();
        t3.start();
        //保证等待线程都启动并进入等待池
        Thread.sleep(200);
        Thread t4 = new Thread(notifyTask, "NT1");
        t4.start();
    }

    private synchronized void shouldGo() throws InterruptedException {
        while (!go) {
            System.out.println(Thread.currentThread() + " is going to wait on this object");
            wait();
            System.out.println(Thread.currentThread() + " is woken up");
        }
        go = false;
    }

    private synchronized void go() {
        if (!go){
            System.out.println(Thread.currentThread()+" is going to notify one or all wait thread");
            go = true;
//            notify();
            notifyAll();
        }
    }
}
