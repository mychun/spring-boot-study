package com.chun.springbootstudy.exceptionhanlder;

import com.chun.springbootstudy.resp.R;
import com.chun.springbootstudy.utils.ResultCodeEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import java.util.stream.Collectors;

@ControllerAdvice
@ResponseBody //为了异常处理完之后给调用方输出一个 json 格式的封装 数据
public class GlobalExceptionHandler {
    private static final Logger LOG = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    private R handlerException(Exception ex){
        LOG.error("系统内部异常：{}", ex.getMessage());
        return R.setResult(ResultCodeEnum.UNEXPECTED_EXCEPTION);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public R handleIllegalAccessException(IllegalArgumentException ex) {
        LOG.error("非法参数异常：{}", ex.getMessage());
        return R.setResult(ResultCodeEnum.ILLEGAL_ARGUMENT);
    }

    @ExceptionHandler(BusinessErrorException.class)
    public R handleBusinessError(BusinessErrorException ex) {
        Integer code = ex.getCode();
        String message = ex.getMessage();
        LOG.error("业务异常：{}", message);
        return R.error().code(code).message(message);
    }

    /**
     * validato异常处理
     * @param ex
     * @return
     */
    @ExceptionHandler(value = {BindException.class, ValidationException.class, MethodArgumentNotValidException.class})
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public R handleValidatedException(Exception ex) {
        Integer code = HttpStatus.BAD_REQUEST.value();
        String message = null;

        if (ex instanceof MethodArgumentNotValidException) {
            // BeanValidation exception
            MethodArgumentNotValidException e = (MethodArgumentNotValidException) ex;
            message = e.getBindingResult().getAllErrors().stream()
                    .map(ObjectError::getDefaultMessage)
                    .collect(Collectors.joining("; "));
        } else if (ex instanceof ConstraintViolationException) {
            // BeanValidation GET simple param
            ConstraintViolationException e = (ConstraintViolationException) ex;
            message = e.getConstraintViolations().stream()
                    .map(ConstraintViolation::getMessage)
                    .collect(Collectors.joining("; "));
        } else if (ex instanceof BindException) {
            // BeanValidation GET object param
            BindException e = (BindException) ex;
            message = e.getAllErrors().stream()
                    .map(ObjectError::getDefaultMessage)
                    .collect(Collectors.joining("; "));
        }

        return R.error().code(code).message(message);
    }
}
