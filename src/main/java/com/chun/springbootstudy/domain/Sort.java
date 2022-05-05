package com.chun.springbootstudy.domain;

import lombok.Data;

@Data
public class Sort {
    /**
     * ASC或DESC
     */
    private String order;
    /**
     * 指定排序的字段
     */
    private String Field;
}
