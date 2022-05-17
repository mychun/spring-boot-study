package com.chun.springbootstudy.service.imp;

import com.chun.springbootstudy.service.Fruit;
import org.springframework.stereotype.Service;

// @Service
public class Apple implements Fruit {
    public Apple() {
        System.out.println("Apple......");
    }

    @Override
    public void sell() {
        System.out.println("苹果2元一斤");
    }
}
