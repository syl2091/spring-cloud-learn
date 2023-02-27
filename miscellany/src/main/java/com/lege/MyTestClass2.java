package com.lege;

/**
 * @author lege
 * @Description
 * @create 2023-02-27 16:05
 */
public class MyTestClass2 {
    private static int a = 0;
    private static  int b;

    private MyTestClass2(){
        a++;
        b++;
    }

    private static final MyTestClass2 myTestClass2 = new MyTestClass2();

    public static MyTestClass2 getInstance(){
        return myTestClass2;
    }

    public int getA() {
        return a;
    }

    public  int getB() {
        return b;
    }

    public static void main(String[] args) {
        MyTestClass2 myTestClass2 = MyTestClass2.getInstance();
        System.out.println(myTestClass2.getA());
        System.out.println(myTestClass2.getB());
    }
}
