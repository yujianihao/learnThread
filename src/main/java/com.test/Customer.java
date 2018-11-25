package main.java.com.test;

import java.util.concurrent.Semaphore;

/**
 * @author yuj
 * @date 2018/11/23 12:43
 */
public class Customer implements Runnable {


    private Integer resource = 1;

    private Integer name;

    private Semaphore semaphore;

    public Customer(Semaphore semaphore, Integer name) {
        this.semaphore = semaphore;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "  开始处理 " + name + " 的业务");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " 处理完成 " + name + " 的业务");
        semaphore.release();
    }
}
