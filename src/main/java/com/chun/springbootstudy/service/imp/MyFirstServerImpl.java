package com.chun.springbootstudy.service.imp;

import com.chun.springbootstudy.service.MyFirstServer;
import org.springframework.stereotype.Service;

@Service
public class MyFirstServerImpl implements MyFirstServer {
    @Override
    public String hello() {
        return "Hello Chun";
    }
}
