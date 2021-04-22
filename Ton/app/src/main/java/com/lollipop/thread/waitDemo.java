package com.lollipop.thread;


public class waitDemo implements Runnable {
    private static final int MAX = 100000;
    private static int current = 0;
    private int index;

    public waitDemo(int index) {
        this.index = index;
    }

    @Override
    public void run() {
        while (true) {
            if (current > MAX) {
                return;
            }

            if (current % 10 == index) {
                System.out.println(Thread.currentThread().getName() + ":" + current++);
                current++; //此处为什么要把current放在打印下面，因为current++ 不是原子操作，所以要不这句话放下面，要不给这个方法加锁，参考下面写法

            }
        }
    }

//    @Override
//    public void run() {
//        synchronized (this) {
//            while (true) {
//                if (current > MAX) {
//                    return;
//                }
//
//                if (current % 10 == index) {
//                    System.out.println(Thread.currentThread().getName() + ":" + current);
//                      current++;
//                }
//            }
//        }
//    }

    public static void main(String[] args) {
        new Thread(new waitDemo(0), "thread-1").start();
        new Thread(new waitDemo(1), "thread-2").start();
        new Thread(new waitDemo(2), "thread-3").start();
        new Thread(new waitDemo(3), "thread-4").start();
        new Thread(new waitDemo(4), "thread-5").start();
        new Thread(new waitDemo(5), "thread-6").start();
        new Thread(new waitDemo(6), "thread-7").start();
        new Thread(new waitDemo(7), "thread-8").start();
        new Thread(new waitDemo(8), "thread-9").start();
        new Thread(new waitDemo(9), "thread-10").start();
    }

}
