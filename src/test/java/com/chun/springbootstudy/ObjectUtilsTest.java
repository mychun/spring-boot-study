package com.chun.springbootstudy;

import com.chun.springbootstudy.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.ObjectUtils;

@SpringBootTest
public class ObjectUtilsTest {
    @Test
    public void test(){
        User user = new User();
        user.setAge(1);
        user.setAccount("chun");
        //System.out.println(ObjectUtils.nullSafeClassName(user));
        //
        //System.out.println(ObjectUtils.nullSafeHashCode(user));
        //
        //boolean[] bools = {true, false};
        //System.out.println(ObjectUtils.nullSafeToString(bools));
        //System.out.println(ObjectUtils.nullSafeToString(user));
        //System.out.println(ObjectUtils.getIdentityHexString(user));
        //System.out.println(ObjectUtils.identityToString(user));
        //System.out.println(ObjectUtils.getDisplayString(user));
        //System.out.println("------------------------------");
        String[] strs = null;
        System.out.println(ObjectUtils.isEmpty(strs));
        System.out.println(ObjectUtils.isArray(strs));

        String[] strs1 = {"a", "b", "c"};
        System.out.println(ObjectUtils.isArray(strs1));
        System.out.println(ObjectUtils.containsElement(strs1, "a"));

        User user1 = new User();
        User user2 = new User();
        System.out.println(ObjectUtils.nullSafeEquals(user1, user2));

        String[] strs2 = ObjectUtils.addObjectToArray(strs1, "d");
        System.out.println(ObjectUtils.nullSafeToString(strs1));
        System.out.println(ObjectUtils.nullSafeToString(strs2));

        Object[] objects = ObjectUtils.toObjectArray(user);
        System.out.println(ObjectUtils.nullSafeToString(objects));

    }
}
