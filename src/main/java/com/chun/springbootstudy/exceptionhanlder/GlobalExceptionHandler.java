package com.chun.springbootstudy.exceptionhanlder;

import com.chun.springbootstudy.resp.R;
import com.chun.springbootstudy.utils.ResultCodeEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@ResponseBody //为了异常处理完之后给调用方输出一个 json 格式的封装 数据
public class GlobalExceptionHandler {
    private static final Logger LOG = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    //指定的异常类型，出现时使用改方法处理
    @ExceptionHandler(NullPointerException.class)
    //指定响应的状态码
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public R handlerNullPointException(NullPointerException ex){
        LOG.error("空指针异常：{}", ex.getMessage());
        return R.setResult(ResultCodeEnum.NULL_POINT);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    private R handlerException(Exception ex){
        LOG.error("异常：{}", ex.getMessage());
        return R.setResult(ResultCodeEnum.UNEXPECTED_EXCEPTION);
    }

    @ExceptionHandler(BusinessErrorException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public R handleBusinessError(BusinessErrorException ex) {
        Integer code = ex.getCode();
        String message = ex.getMessage();
        LOG.error("业务异常：{}", message);
        return R.error().code(code).message(message);
    }
}
