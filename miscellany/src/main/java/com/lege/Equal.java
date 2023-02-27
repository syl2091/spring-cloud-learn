package com.lege;

/**
 * @author lege
 * @Description
 * @create 2023-02-27 16:28
 */
public class Equal {

    public static void main(String[] args) {
        int a = 1000;
        int b = 1000;
        System.out.println(a == b);
        Integer a1 = 1000;
        Integer b1 = 1000;
        System.out.println(a1 == b1);
        Integer a2 = 1;
        Integer b2 = 1;
        System.out.println(a2 == b2 );
        Integer a3 = new Integer(1);
        Integer b3 = new Integer(1);
        System.out.println(a3 == b3);
    }
}
