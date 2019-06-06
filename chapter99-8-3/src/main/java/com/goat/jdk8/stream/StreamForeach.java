package com.goat.jdk8.stream;


import com.goat.model.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class StreamForeach {

    List<Person> pers = new ArrayList<>();

    /** forEach 遍历 可以更改的不是副本  而是真正更改集合中的值 */
    @Test
    public void test1(){
        pers.add(new Person("1",1));
        pers.add(new Person("2",2));
        pers.forEach(x->x.setAge(111));
        System.out.println(pers);
    }



}