package threadTest;

import java.util.concurrent.Callable;

/**
 * @author Yandx
 * @version 1.0
 * @date created on 2019/12/24 16:09
 */
public class MyCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        String value = "test";
        System.out.println("Ready to work");
        Thread.sleep(5000);
        System.out.println("Finished work");
        return value;
    }
}
