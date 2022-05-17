package com.chun.springbootstudy.domain;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
// @Lazy延迟加载到容器
// 直接在这里使用@Lazy会出现不生效的情况
// 这是由于 注入到其它类时，其它类是要马上使用Diana这个类的，所以不生效
// 如果注入到的类也使用@Lazy，这里的就会生效
@Lazy
public class Diana {
    public Diana() {
        System.out.println("Hello, My name is Diana");
    }

    public void r(){
        System.out.println("Diana make R");
    }
}
