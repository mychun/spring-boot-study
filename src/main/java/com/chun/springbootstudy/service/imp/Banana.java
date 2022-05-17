package com.chun.springbootstudy.service.imp;

import com.chun.springbootstudy.service.Fruit;
import org.springframework.stereotype.Service;

// @Service
public class Banana implements Fruit {
    public Banana() {
        System.out.println("Banana......");
    }

    @Override
    public void sell() {
        System.out.println("香蕉3元一串");
    }
}