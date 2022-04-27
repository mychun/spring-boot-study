package com.chun.springbootstudy.config;

public enum CacheType {
    //分别设置cachname为USERCACHE,消亡时间是 10s
    USERCACHE(10);

    private int expires;

    CacheType(int expires) {
        this.expires = expires;
    }

    public int getExpires() {
        return expires;
    }
}
