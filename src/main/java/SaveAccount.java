
import java.util.Random;

/**
 * @author yuj
 * @date 2018/11/22 21:37
 */
public class SaveAccount implements Runnable {

    /**
     * 保存的汇率
     */
    private static  Integer i = 1;

    private Integer semaphore = 1;

    public SaveAccount() {
        i++;
    }

    @Override
    public void run() {
        Random random = new Random(10);
        int second = random.nextInt(10000);
        try {
            Thread.sleep(second);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("保存多少万：" + i);

    }

    /**
     * 获取字段
     */
    public Integer getSemaphore() {
        synchronized(semaphore) {
            --semaphore;
            System.out.println("semaphore" + semaphore + " SaveAccount :" + 1);
            return semaphore;
        }
    }
}
