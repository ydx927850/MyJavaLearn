package threadTest;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author Yandx
 * @version 1.0
 * @date created on 2019/12/24 16:10
 */
public class FutureTaskTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> task = new FutureTask<>(new MyCallable());
        Thread thread = new Thread(task);
        thread.start();
        //获取子任务状态
        if (!task.isDone()){
            System.out.println("subTask is doing now,please wait");
        }
        System.out.println(task.get());
    }

}
