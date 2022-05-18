package com.chun.springbootstudy.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class AppleCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        // 这里可以使用做业务逻辑，判断是否返回true，来确定注入
        final String name = context.getEnvironment().getProperty("fruit.name");
        return "apple".equalsIgnoreCase(name);
    }
}
