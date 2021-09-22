package com.atguigu.gmall0218.studytest.test01;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class ShareData {
    private int num = 1;//1:AA,2:BB,3:CC

    private Lock lock = new ReentrantLock();

    Condition cd1 = lock.newCondition();
    Condition cd2 = lock.newCondition();
    Condition cd3 = lock.newCondition();


    public void print5(int total) {
        lock.lock();

        try {
            // 判断
            while (num != 1) {
                cd1.await();
            }

            // 干活
            for (int i = 1; i <= 5; i++) {
                System.out.println(Thread.currentThread().getName() + "/t" + total + "/t" + i);

            }
            // 通知
            num=2;
            cd2.signal();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    public void print10(int total) {
        lock.lock();

        try {
            while(num!=2) {
                cd2.await();
            }
            for (int i = 1; i <=10 ; i++) {
                System.out.println(Thread.currentThread().getName() + "/t" + total + "/t" + i);

            }
            // 通知
            num=3;
            cd3.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void print15(int total) {
        lock.lock();
        try {

        while(num!=3) {

                cd3.await();
            }
            for (int i = 1; i <=15; i++) {
                System.out.println(Thread.currentThread().getName() + "/t" + total + "/t" + i);

            }
            // 通知
            num=1;
            cd1.signal();
        } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
            lock.unlock();
            }
        }
    }



public class ThreadOrderAccess {

    public static void main(String[] args) {
        ShareData shareData = new ShareData();

        new Thread(()->{
            for (int i = 1; i <=10 ; i++) {
                shareData.print5(i);

            }
        },"AA").start();

        new Thread(()->{
            for (int i = 1; i <=10 ; i++) {
                shareData.print10(i);

            }
        },"BB").start();

        new Thread(()->{
            for (int i = 1; i <=10 ; i++) {
                shareData.print15(i);

            }
        },"CC").start();

    }

}
