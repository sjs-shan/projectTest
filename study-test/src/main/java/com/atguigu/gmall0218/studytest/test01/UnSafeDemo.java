package com.atguigu.gmall0218.studytest.test01;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class ShareOne{

    private int num =0;

    private Lock lock=new ReentrantLock();

    Condition cd =lock.newCondition();


    public void inc() {
        lock.lock();

        try {
            while(num!=0){
                cd.await();
            }
            num++;
            System.out.println(Thread.currentThread().getName() + "/t" + num);

            cd.signalAll();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {

            lock.unlock();
        }
    }

    public void des() {
        lock.lock();


        try {
            while(num!=1) {
                cd.await();
            }
            num--;
            System.out.println(Thread.currentThread().getName() + "/t" + num);
            cd.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


}


public class UnSafeDemo {

    public static void main(String[] args) {
        ShareOne shareOne = new ShareOne();
        new Thread(() ->{
            for (int i = 1; i <=10 ; i++) {
                shareOne.inc();

            }
        },"AA").start();

        new Thread(()->{
            for (int i = 1; i <=10 ; i++) {
                shareOne.des();

            }
        },"BB").start();
//        new Thread(() ->{
//            for (int i = 1; i <=10 ; i++) {
//                shareOne.inc();
//
//            }
//        },"CC").start();
//        new Thread(()->{
//            for (int i = 1; i <=10 ; i++) {
//                shareOne.des();
//
//            }
//        },"DD").start();
    }
}
