package com.chun.springbootstudy.exceptionhanlder;

import com.chun.springbootstudy.SpringbootstudyApplication;
import com.chun.springbootstudy.resp.JsonResponse;
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
    public JsonResponse handlerNullPointException(NullPointerException ex){
        LOG.error("空指针异常：{}", ex.getMessage());
        return new JsonResponse("500", "空指针异常");
    }
}
