package threadTest;

import java.util.concurrent.*;

/**
 * @author Yandx
 * @version 1.0
 * @date created on 2019/12/24 16:16
 */
public class ThreadPoolTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<String> future = executorService.submit(new MyCallable());
        if (!future.isDone()){
            System.out.println("subTask is doing now,please wait");
        }
        System.out.println(future.get());
    }
}
