package com.chun.springbootstudy;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class CollectionUtilsTest {
    @Test
    public void test(){
        Map<String, String> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        System.out.println(CollectionUtils.isEmpty(map));
        System.out.println(CollectionUtils.isEmpty(list));

        map.put("name", "mike");
        list.add("aaa");
        System.out.println(CollectionUtils.isEmpty(map));
        System.out.println(CollectionUtils.isEmpty(list));

        System.out.println(CollectionUtils.containsInstance(list, "aaa"));
        System.out.println(CollectionUtils.contains(list.iterator(), "aaa"));

        List<String> list1 = new ArrayList<>();
        list1.add("bbb");
        list1.add("aaa");
        System.out.println(CollectionUtils.containsAny(list, list1));

        List<String> list2 = new ArrayList<>();
        list2.add("ccc");
        list2.add("ccc");
        list2.add("aaa");
        System.out.println(CollectionUtils.hasUniqueObject(list));
        System.out.println(CollectionUtils.hasUniqueObject(list2));

    }
}
