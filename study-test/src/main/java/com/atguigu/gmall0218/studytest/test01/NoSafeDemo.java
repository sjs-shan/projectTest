package com.atguigu.gmall0218.studytest.test01;


import java.util.HashMap;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

public class NoSafeDemo {

    public static void main(String[] args) {
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
//        HashMap<String, String> map = new HashMap<>();

        for (int i = 1; i <=30 ; i++) {
            new Thread(()->{
                map.put(UUID.randomUUID().toString().substring(0,8),Thread.currentThread().getName());
                System.out.println(map);
            },String.valueOf(i)).start();

        }

    }

    private static void noSafeSet(){
        Set<String> set=new CopyOnWriteArraySet<>();
        for (int i = 1; i <=30 ; i++) {
            new Thread(() -> {
                set.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(set);

            }).start();

        }
    }


}
