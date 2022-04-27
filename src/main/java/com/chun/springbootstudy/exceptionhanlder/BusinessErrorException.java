package com.chun.springbootstudy.exceptionhanlder;

import com.chun.springbootstudy.utils.ResultCodeEnum;
import lombok.Data;

@Data
public class BusinessErrorException extends RuntimeException {
    private static final long serialVersionUID = -7480022450501760611L;

    /*** 异常码 */
    private Integer code;

    /*** 异常提示信息 */
    private String message;

    public BusinessErrorException(ResultCodeEnum resultCodeEnum){
        this.code = resultCodeEnum.getCode();
        this.message = resultCodeEnum.getMessage();
    }
}
