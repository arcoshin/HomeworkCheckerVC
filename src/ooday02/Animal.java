package ooday02;

/**
 * 動物們的父類---動物類
 */
abstract class Animal {
    String name;
    int age;
    String color;

    Animal(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    void drink(){
        System.out.println(color + "色" + age + "歲的" + name + "正在喝水......");
    }

    abstract void eat();
//    {
//        System.out.println(color + "色" + age + "歲的" + name + "要開始吃飯了!!");
//    }
}

/**
 * 狗類
 */

class Dog extends Animal{
    Dog(String name, int age, String color) {
        super(name, age, color);
    }

    void lookHome() {
        System.out.println(name + "正在看家......");
    }

    @Override
    void eat() {
//        super.eat();
        System.out.println(name + "小狗正在啃骨頭......");
    }
}

/**
 * 雞類
 */

class Chick extends Animal{
    Chick(String name, int age, String color) {
        super(name, age, color);
    }

    void layEgg() {
        System.out.println(name + "正在下蛋呢......");
    }

    @Override
    void eat() {
//        super.eat();
        System.out.println(name + "小雞正在吃小米......");
    }
}

/**
 * 魚類
 */

class Fish extends Animal{
    Fish(String name, int age, String color) {
        super(name, age, color);
    }

    @Override
    void eat() {
//        super.eat();
        System.out.println(name + "小魚正在吃小蝦米......");
    }
}

