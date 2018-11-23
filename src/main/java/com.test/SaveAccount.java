package main.java.com.test;

import java.util.Random;

/**
 * @author yuj
 * @date 2018/11/22 21:37
 */
public class SaveAccount implements Runnable {

    /**
     * 保存的汇率
     */
    private Integer i = 1;

    private Integer semaphore = 1;

    public SaveAccount(int n) {
        i = n;
    }

    public SaveAccount() {
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " 保存多少万：" + i);
    }

    /**
     * 获取字段
     */
    public Boolean getSemaphore() {
        synchronized(semaphore) {
            System.out.println(Thread.currentThread().getName() + "  semaphore" + semaphore + " SaveAccount :" + i);
            if (semaphore > 0) {
                --semaphore;
                return true;
            }
            return false;
        }
    }
}
