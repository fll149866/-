package com.nysb.demo01.test01;

public class Random {
    public static void main(String[] args) {
        int [] num ={0,1};
        final java.util.Random random = new java.util.Random();
        int size = num.length;
        final int index = random.nextInt(size);
        System.out.println(size);
        System.out.println(index);
    }
}
