package com.lege;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lege
 * @Description
 * @create 2023-02-27 16:53
 */
public class ArrayListDemo {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        ArrayList list = new ArrayList<Integer>();
        System.out.println(getArrayListElementDataLength(list));
        list.add(1);
        System.out.println(getArrayListElementDataLength(list));
    }

    public static int getArrayListElementDataLength(ArrayList list) throws NoSuchFieldException, IllegalAccessException {
        Class<? extends ArrayList> listClass = list.getClass();
        Field field = listClass.getDeclaredField("elementData");
        field.setAccessible(true);
        Object[] o = (Object[]) field.get(list);
        return o.length;
    }
}
