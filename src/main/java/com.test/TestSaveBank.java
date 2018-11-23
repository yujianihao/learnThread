package main.java.com.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yuj
 * @date 2018/11/22 22:28
 */
public class TestSaveBank {

    public static void main(String[] args) {
        List<SaveAccount> list = new ArrayList<SaveAccount>();
        for(int i = 1; i < 100; i++) {
            SaveAccount saveAccount = new SaveAccount(i);
            list.add(saveAccount);
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(SaveAccount account: list) {
                    if (account.getSemaphore()) {
                        account.run();
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for(SaveAccount account: list) {
                    if (account.getSemaphore()) {
                        account.run();
                    }
                }
            }
        }).start();
    }
}
