package A07_pool.example00;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by 64274 on 2019/4/30.
 一个线程池中 有多个处于可运行状态的线程，当向线程池中添加 Runnable 或 Callable 接口对象时，
 就会有一个线程来执行对应的 run() 方法 或  call() 方法 。如果方法执行完毕，则该线程并不会终止，
 而是继续在线程池中处于可运行状态，等待运行新的任务。 如果要关闭线程池，使用 shutdownNow() 方法

 独立运行1000个线程所占用的内存：9767776字节
 独立创建1000个线程所消耗的时间：2155毫秒
 使用连接池运行1000个线程所占用的内存：6214976字节
 使用连接池创建1000个线程所消耗的时间：147毫秒

 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/4/30---10:43
 */
public class ThreadPoolTest {

    public static void main(String[] args) {
        Runtime run = Runtime.getRuntime();// 创建Runtime对象
        run.gc();// 运行垃圾回收器，这样可以减少误差
        long freeMemory = run.freeMemory();// 获得当前虚拟机的空闲内存
        long currentTime = System.currentTimeMillis();// 获得当前虚拟机的时间
        for (int i = 0; i < 10000; i++) {// 独立运行1000个线程
            new Thread(new TempThread()).start();
        }
        System.out.println("独立运行1000个线程所占用的内存：" + (freeMemory - run.freeMemory()) + "字节");// 查看内存的变化
        System.out.println("独立创建1000个线程所消耗的时间：" + (System.currentTimeMillis() - currentTime) + "毫秒");// 查看时间的变化

        run.gc();// 运行垃圾回收器
        freeMemory = run.freeMemory();// 获得当前虚拟机的空闲内存
        currentTime = System.currentTimeMillis();// 获得当前虚拟机的时间
        ExecutorService executorService = Executors.newFixedThreadPool(2);// 创建线程池
        for (int i = 0; i < 1000; i++) {// 使用线程池运行1000个线程
            executorService.submit(new TempThread());
        }
        System.out.println("使用连接池运行1000个线程所占用的内存：" + (freeMemory - run.freeMemory()) + "字节");// 查看内存的变化
        System.out.println("使用连接池创建1000个线程所消耗的时间：" + (System.currentTimeMillis() - currentTime) + "毫秒");// 查看时间的变化

        executorService.shutdownNow();
    }
}
