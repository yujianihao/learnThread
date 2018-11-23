package main.java.com.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author yuj
 * @date 2018/11/23 13:26
 */
public class TestCustomer {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(2);
        ExecutorService es = Executors.newCachedThreadPool();
        for (int i = 0; i < 100; i++) {
            es.submit(new Customer(semaphore, i));
        }
        es.shutdown();
    }
}
