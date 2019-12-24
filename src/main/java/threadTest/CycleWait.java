package threadTest;

/**
 * 主线程等待法处理子线程返回值
 * @author Yandx
 * @version 1.0
 * @date created on 2019/12/24 15:58
 */
public class CycleWait implements Runnable{
    private String value;
    @Override
    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        value = "we have data now";
    }

    public static void main(String[] args) throws InterruptedException {
        CycleWait c = new CycleWait();
        Thread t = new Thread(c);
        t.start();
        //1.主线程循环等待
//        while(c.value==null){
//            Thread.sleep(100);
//        }
        //2.join方法阻塞当前线程
        t.join();
        System.out.println(c.value);
    }
}
