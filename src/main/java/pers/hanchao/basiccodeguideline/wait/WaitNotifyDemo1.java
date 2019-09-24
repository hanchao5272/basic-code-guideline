package pers.hanchao.basiccodeguideline.wait;

/**
 * <p>两个线程交替打印0和1</P>
 *
 * @author hanchao
 */
public class WaitNotifyDemo1 {
    public static void main(String[] args) {
        //锁对象
        byte[] obj = new byte[0];

        new Thread(() ->{
            //锁住obj，别的线程用不了
            synchronized (obj){
                //保证循环打印
                while(true){
                    //我先打印
                    System.out.print(1);
                    //本轮打印完成之后，通知别人可以用这个对象锁
                    obj.notify();
                    try {
                        //我等着别人用，用完我继续
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        new Thread(() ->{
            synchronized (obj){
                while(true){
                    System.out.print(2);
                    obj.notify();
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
