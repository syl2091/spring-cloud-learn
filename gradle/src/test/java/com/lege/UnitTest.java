package com.lege;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lege
 * @Description
 * @create 2022-08-18 15:56
 */
public class UnitTest {
    private List<Integer> list;

    @Before
    public void init(){
        list = new ArrayList();
        list.add(1);
        list.add(2);
    }

    @Test
    public void test(){
        System.out.println(list.toString());
    }
}
