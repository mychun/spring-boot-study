package com.chun.springbootstudy.constroller;

import com.chun.springbootstudy.resp.JsonResponse;
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
    public JsonResponse nullPointerException(){
        String str = null;
        LOG.info("长度: {}", str.length());
        return new JsonResponse();
    }

    @GetMapping("/exception")
    public JsonResponse exception(){
        LOG.info("长度: {}", 1 / 0);
        return new JsonResponse();
    }
}
