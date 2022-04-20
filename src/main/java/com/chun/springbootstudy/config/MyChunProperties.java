package com.chun.springbootstudy.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.net.InetAddress;

@Component
@ConfigurationProperties("chun")
@Data
public class MyChunProperties {
    private boolean enabled;
    private InetAddress remoteAddress;
    private final Security security = new Security();

    @Data
    public class Security{
        private String name;
        private String password;
    }
}
