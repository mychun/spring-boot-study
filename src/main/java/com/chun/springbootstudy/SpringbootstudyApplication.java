package com.chun.springbootstudy;

import com.chun.springbootstudy.domain.Pet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.env.ConfigurableEnvironment;

@SpringBootApplication
@ImportResource(locations = "classpath:my-application.xml")
public class SpringbootstudyApplication {

    private static final Logger LOG = LoggerFactory.getLogger(SpringbootstudyApplication.class);

    public static void main(String[] args) {
        //        final ConfigurableApplicationContext run = SpringApplication.run(SpringbootstudyApplication.class, args);

        final SpringApplication application = new SpringApplication(SpringbootstudyApplication.class);
        final ConfigurableEnvironment env = application.run(args).getEnvironment();

        LOG.info("启动成功！！");
        LOG.info("地址: \thttp://127.0.0.1:{}", env.getProperty("server.port"));

        //查看容器里的所有组件
//        String[] names = run.getBeanDefinitionNames();
//        for (String name : names){
//            System.out.println(name);
//        }
//
//        Pet pet01 = run.getBean("德玛西亚", Pet.class);
//        Pet pet02 = run.getBean("德玛西亚", Pet.class);
//        System.out.println("是否相等：" + (pet01 == pet02));
//        System.out.println("是否相同：" + pet01.equals(pet02));
    }

}
