package com.chun.springbootstudy.customvalidator;

import lombok.extern.slf4j.Slf4j;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;

@Slf4j
public class EnumStringValidator implements ConstraintValidator<EnumString, String> {
    private List<String> enumStringList;

    @Override
    public void initialize(EnumString constraintAnnotation) {
        log.info("EnumStringValidator initialize.....");
        // @EnumString(value = {"男", "女"}, message = "性别只允许为男或女")
        // constraintAnnotation.value(): 获取value的值
        enumStringList = Arrays.asList(constraintAnnotation.value());
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        // value是需要校验的值
        if (value == null) {
            return true;
        }
        return enumStringList.contains(value);
    }
}

