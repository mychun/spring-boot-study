package com.chun.springbootstudy.exceptionhanlder;

public enum BusinessMsgEnum {
    /**
     * 参数异常
     */
    PARMETER_EXCEPTION("102", "参数异常"),

    /**
     * 等待超时
     */
    SERVICE_TIME_OUT("103", "服务调用超时！"),

    /**
     * 参数过大
     */
    PARMETER_BIG_EXCEPTION("102", "输入的图片张数不能超过50张"),

    /**
     * 500: 一般的服务器异常
     */
    UNEXPECTED_EXCEPTION("500", "系统发生异常，请联系管理员");
    //还可以定义更多业务异常

    /*** 消息码 */
    private String code;
    /*** 消息内容 */
    private String message;

    BusinessMsgEnum(String code, String message){
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setMsg(String message) {
        this.message = message;
    }
}
