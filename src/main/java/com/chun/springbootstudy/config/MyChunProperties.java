package com.chun.springbootstudy.config;

import com.chun.springbootstudy.domain.MyPojo;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

@Component
@ConfigurationProperties("chun")
@Data
public class MyChunProperties {
    private boolean enabled;
    private InetAddress remoteAddress;
    private final Security security = new Security();

    private final List<MyPojo> list = new ArrayList<>();

    @Data
    public class Security{
        private String name;
        private String password;
    }
}
