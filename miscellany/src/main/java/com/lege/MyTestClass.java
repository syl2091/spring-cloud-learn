package com.lege;


import java.util.ArrayList;

/**
 * @author lege
 * @Description
 * @create 2023-02-27 16:01
 */
public class MyTestClass {
    private static MyTestClass myTestClass = new MyTestClass();


    private static int a = 2;
    private static int b;

    private MyTestClass() {
        a++;
        b++;
    }

    public static MyTestClass getInstance() {
        return myTestClass;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public static void main(String[] args) {
        MyTestClass myTestClass = MyTestClass.getInstance();
        System.out.println(myTestClass.getA());
        System.out.println(myTestClass.getB());
    }
}
