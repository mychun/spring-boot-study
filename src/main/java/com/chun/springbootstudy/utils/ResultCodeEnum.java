package com.chun.springbootstudy.utils;

import lombok.Getter;

@Getter
public enum ResultCodeEnum {
    //系统的
    SUCCESS(true,20000,"成功"),
    UNKNOWN_ERROR(false,20001,"未知错误"),
    PARAM_ERROR(false,20002,"参数错误"),
    NULL_POINT(false,20003, "空指针异常"),
    SERVICE_TIME_OUT(false,200005, "服务调用超时！"),
    ILLEGAL_ARGUMENT(false,200006, "非法参数！"),
    UNEXPECTED_EXCEPTION(false,200007, "系统发生异常，请联系管理员"),
    //业务的
    PARMETER_BIG_EXCEPTION(false,10002, "输入的图片张数不能超过50张"),
    ;

    // 响应是否成功
    private Boolean success;
    // 响应状态码
    private Integer code;
    // 响应信息
    private String message;

    ResultCodeEnum(boolean success, Integer code, String message) {
        this.success = success;
        this.code = code;
        this.message = message;
    }
}
