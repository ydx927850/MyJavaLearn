package threadTest;

/**
 * 测试wait和sleep方法
 * wait方法释放锁
 * sleep方法不释放锁
 * Thread A is start
 * Thread A is waiting lock
 * Thread A get lock
 * Thread B is start
 * Thread B is waiting lock
 * Thread A do wait method  -- 线程A执行了wait方法，释放了锁，从而使得线程B可以继续执行
 * Thread B get lock
 * Thread B do sleep method -- 线程B执行sleep方法，此时不会释放锁，所以线程A无法重新抢占CPU执行，必须等待B完成后释放锁才可以继续进行
 * Thread B is done
 * Thread A is done
 * @author Yandx
 * @version 1.0
 * @date created on 2019/12/26 8:52
 */
@SuppressWarnings({"warning", "AlibabaAvoidManuallyCreateThread"})
public class WaitSleepTest {
    public static void main(String[] args) throws InterruptedException {
        final Object lock = new Object();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread A is start");
                System.out.println("Thread A is waiting lock");
                synchronized (lock){
                    try {
                        System.out.println("Thread A get lock");
                        Thread.sleep(20);
                        System.out.println("Thread A do wait method");
                        lock.wait();
                        System.out.println("Thread A is done");
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        //让主线程sleep10ms，确保A线程先执行
        Thread.sleep(10);
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread B is start");
                System.out.println("Thread B is waiting lock");
                synchronized (lock){
                    try {
                        System.out.println("Thread B get lock");
                        System.out.println("Thread B do sleep method");
                        Thread.sleep(20);
                        lock.notifyAll();
                        //不会对锁影响，因此A被唤醒后会进入锁池等待B释放锁
                        Thread.yield();
                        Thread.sleep(2000);
                        System.out.println("Thread B is done");
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

}
