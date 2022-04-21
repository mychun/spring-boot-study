package com.chun.springbootstudy;

import com.chun.springbootstudy.domain.Pet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringbootstudyApplication {

    public static void main(String[] args) {

        final ConfigurableApplicationContext run = SpringApplication.run(SpringbootstudyApplication.class, args);

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
