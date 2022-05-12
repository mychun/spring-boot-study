package com.chun.springbootstudy;

import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class StringUtilsTest {
    @Test
    public void test(){
        String str = "a";
        System.out.println(StringUtils.isBlank(str));
        System.out.println(str.isEmpty());
        System.out.println(str.isBlank());
        System.out.println(StringUtils.containsIsoControlCharacter(str));

    }
}
