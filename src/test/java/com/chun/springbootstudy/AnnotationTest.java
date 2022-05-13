package com.chun.springbootstudy;

import com.chun.springbootstudy.annotations.MyAnnotaion;
import com.chun.springbootstudy.constroller.TestCustomAnnotaionController;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.annotation.Annotation;

@SpringBootTest
public class AnnotationTest {
    @Test
    public void getAllAnnotationsTest(){
        // 获取该class里面的所有注解
        for (Annotation a : TestCustomAnnotaionController.class.getAnnotations()) {
            // System.out.println(a);

            // 取注解的属性值
            if(a instanceof MyAnnotaion){
                System.out.println(((MyAnnotaion) a).message());
            }
        }
    }

    @Test
    public void getTargetAnnotationTest(){
        final MyAnnotaion annotation = TestCustomAnnotaionController.class.getAnnotation(MyAnnotaion.class);
        if (annotation != null) {
            System.out.println(annotation.message());
        }
    }
}
