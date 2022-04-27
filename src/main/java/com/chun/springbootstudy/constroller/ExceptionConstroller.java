package com.chun.springbootstudy.constroller;

import com.chun.springbootstudy.exceptionhanlder.BusinessErrorException;
import com.chun.springbootstudy.resp.R;
import com.chun.springbootstudy.utils.ResultCodeEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exception")
public class ExceptionConstroller {
    private static final Logger LOG = LoggerFactory.getLogger(ExceptionConstroller.class);

    @GetMapping("/nullPointerException")
    public R nullPointerException(){
        String str = null;
        LOG.info("长度: {}", str.length());
        return R.ok();
    }

    @GetMapping("/exception")
    public R exception(){
        LOG.info("长度: {}", 1 / 0);
        return R.ok();
    }

    @RequestMapping("/business")
    public R business() {
        int num = 10;
        if (num >= 10) throw new BusinessErrorException(ResultCodeEnum.PARMETER_BIG_EXCEPTION);
        return R.ok();
    }
}
