package com.codersongs.leetcode;

/**
 * @author wusongsong
 * @date 2019/5/24
 */
public class TestInner {
    public static void main(String[] args) {
        final String str = "hapjin";

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for(int i = 0; i < 10; i++)
                    System.out.println(str);
            }
        }).start();

        System.out.println("main thread finished");
    }
}
