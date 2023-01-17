import com.study.demo.bean.MyThread;

/**
 * @author ：xurong02
 * @date ：2022/11/5 10:59 上午
 */
public class ThreadTest {
    public static void main(String[] args) throws InterruptedException {

        Thread.currentThread().interrupt();
        MyThread myThread1 = new MyThread();
        myThread1.start();
        myThread1.join();
        Thread.sleep(1000);
        myThread1.interrupt();
 //       Thread.currentThread().interrupt();
        System.out.println("是否停止1？="+myThread1.interrupted());
        System.out.println("是否停止2？="+myThread1.interrupted());

        System.out.println("end = "+System.currentTimeMillis());

    }
}
