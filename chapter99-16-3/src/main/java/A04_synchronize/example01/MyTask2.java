package A04_synchronize.example01;



/**
 * Created by 64274 on 2018/7/20.
 * @author 山羊来了
 * @Description: TODO
 * @date 2018/7/20---13:25
 */
public class MyTask2 extends MyTaskTemplate implements Runnable  {

    private int tickets = 50;

    @Override
    public void run() {
        long startTime=System.currentTimeMillis();
        while (true) {
            synchronized (this) {   //该代码块 一次只能有一个线程进入
                if (tickets <= 0) {
                    break;
                }
                sleep();
                System.out.println(Thread.currentThread().getName() + "抢到了" + tickets--);
            }
        }
        long endTime=System.currentTimeMillis();
        cacul(startTime,endTime);
    }

}
