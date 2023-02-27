package com.lege;

/**
 * @author lege
 * @Description
 * @create 2023-02-27 15:48
 */
public class Polymorphic {
    public static void main(String[] args) {
        Animal cat = new Cat();
        cat.speak();
    }
}


class Animal {
    String name = "animal";

    public void speak() {
        System.out.println("我是一个动物");
    }
}

class Cat extends Animal{
    String name = "cat";

    @Override
    public void speak(){
        System.out.println("我是一只猫");
    }
}
