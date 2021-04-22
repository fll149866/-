package com.nysb.demo01.utils;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomNum {

    public int getNum(int size){
        final Random random = new Random();
        final int index = random.nextInt(size);
        return index;
    }
}
