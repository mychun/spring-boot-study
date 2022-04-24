package com.chun.springbootstudy.runners;

import com.chun.springbootstudy.config.GetMyApplicationPropertiesByConfPropertes;
import com.chun.springbootstudy.config.GetMyApplicationPropertiesByValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//继承CommandLineRunner，在springboot启动时，自动运行，可以做一些启动时的任务
@Component
public class MyOutputPropsRunner implements CommandLineRunner {
    private static final Logger LOGGER = LoggerFactory.getLogger(MyOutputPropsRunner.class);

    @Autowired
    private GetMyApplicationPropertiesByValue getMyApplicationPropertiesByValue;

    @Autowired
    private GetMyApplicationPropertiesByConfPropertes getMyApplicationPropertiesByConfPropertes;

    @Override
    public void run(String... args){
        LOGGER.info(getMyApplicationPropertiesByValue.toString());
        LOGGER.info(getMyApplicationPropertiesByConfPropertes.toString());
    }
}
