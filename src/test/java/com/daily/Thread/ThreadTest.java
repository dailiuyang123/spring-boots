package com.daily.Thread;

/**
 * Created by json on 2018/9/25.
 * Describe: 测试多线程
 */
public class ThreadTest {
    public static void main(String[] args) {
        Thread1 myA = new Thread1("A");
        Thread1 myB = new Thread1("B");
        Thread2 myC = new Thread2();

        //Runnable接口比继承Thread类所具有的优势：
        // 1）：适合多个相同的程序代码的线程去处理同一个资源
        // 2）：可以避免java中的单继承的限制
        // 3）：增加程序的健壮性，代码可以被多个线程共享，代码和数据独立

        //线程类的一些常用方法
        //notify(): 通知一个线程继续运行。
        //wait(): 强迫一个线程等待。          (释放锁)
        //sleep(): 强迫一个线程睡眠Ｎ毫秒     （不释放锁）

        //状态转换
        //新建状态（New） 就绪状态（Runnable） 运行状态（Running）阻塞状态（Blocked） 死亡状态（Dead）
        new Thread(myC, "C").start();
        new Thread(myC, "D").start();
//        myA.start();
//        myB.start();


    }

}


/**
 * 作者  json
 * 时间  2018/9/25 14:27
 * 描述  继承 thread 对象
 **/
class Thread1 extends Thread {

    private int count = 5;
    private String name;

    public Thread1(String name) {
        this.name = name;
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(name + "运行  count= " + count--);
            try {
                sleep((int) Math.random() * 10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}

/**
 * 作者  json
 * 时间  2018/9/25 14:27
 * 描述 实现runable 接口
 **/
class Thread2 implements Runnable {

    private int count = 15;

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + "运行  count= " + count--);
            try {
                Thread.sleep((int) Math.random() * 10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
