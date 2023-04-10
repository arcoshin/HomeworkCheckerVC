package ooday02;

import java.awt.*;

/**
 * 作業測試類 : Homework
 * <p>
 * Trans----------------------------
 * Person -> Human 類
 * Student -> Learner 類
 * Teacher -> Master 類
 * Doctor -> Surgeon 類
 * <p>
 * Animal -> LivingCreature 類
 * Dog -> Hound 類
 * Chick -> Fowl 類
 * Fish -> Shark 類
 */
class Homework {
    public static void main(String[] args) {
        /**
         * 人類:
         * 創建對象、調用方法測試
         */
        Learner zs = new Learner("張三", 25, "台北", "JSD230315", "001");
        //共有行為
        zs.sayHi();
        zs.eat();
        zs.sleep();
        //特定行為
        zs.study();

        Master ls = new Master("李四", 45, "台南", 120000);
        //共有行為
        zs.sayHi();
        ls.eat();
        ls.sleep();
        //特定行為
        ls.teach();

        Surgeon ww = new Surgeon("王五", 55, "台中", "急診");
        //共有行為
        zs.sayHi();
        ww.eat();
        ww.sleep();
        //特定行為
        ww.cut();

        /**
         * 動物類
         * 創建三個狗對象三個雞對象兩個魚對象並測試
         */
        LivingCreature[] livingCreaturesList = new LivingCreature[3 + 3 + 2];
        Hound dog1 = new Hound("dog1", 2, "黑");
        Hound dog2 = new Hound("dog2", 4, "紅");
        Hound dog3 = new Hound("dog3", 6, "橙");
        Fowl chick1 = new Fowl("chick1", 1, "黃");
        Fowl chick2 = new Fowl("chick2", 3, "綠");
        Fowl chick3 = new Fowl("chick3", 5, "藍");
        Shark fish1 = new Shark("fish1", 20, "靛");
        Shark fish2 = new Shark("fish2", 40, "紫");

        /**
         * 測試吃的行為:重寫方法
         */
        System.out.println("以下測試動物們吃的方法------重寫方法");
        dog1.eat();
        chick1.eat();
        fish1.eat();

        livingCreaturesList[0] = dog1;
        livingCreaturesList[1] = dog2;
        livingCreaturesList[2] = dog3;
        livingCreaturesList[3] = chick1;
        livingCreaturesList[4] = chick2;
        livingCreaturesList[5] = chick3;
        livingCreaturesList[6] = fish1;
        livingCreaturesList[7] = fish2;

        /**
         * 測試喝的行為:共有方法
         */
        System.out.println("以下測試動物們喝的方法------共有方法");
        for (int i = 0; i < livingCreaturesList.length; i++) {
            livingCreaturesList[i].drink();
        }

        System.out.println("以下測試動物們的特定行為------特有方法");
        new Hound("狗", 99, "白").lookHome();
        new Fowl("雞", 99, "金").layEggs();

    }
}

class Human {//人類
    /**
     * 共有屬性
     */
    String name;
    int age;
    String address;

    /**
     * 構造器
     */
    public Human(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    /**
     * 共有方法
     */
    void eat() {
        System.out.println(name + "正在吃......");
    }

    void sleep() {
        System.out.println(name + "正在睡......");
    }

    void sayHi() {
        System.out.println("你好我叫做" + name + "，今年" + age + "歲了，" + "來自" + address);
    }
}

class Learner extends Human {//學習者類
    /**
     * 特有屬性
     */
    String className;
    String stuId;

    /**
     * 構造器
     */
    public Learner(String name, int age, String address, String className, String stuId) {
        super(name, age, address);
        this.className = className;
        this.stuId = stuId;
    }

    /**
     * 特有方法
     */
    void study() {
        System.out.println(name + "正在念書......");
    }

    /**
     * 重寫方法
     */
    @Override
    void sayHi() {
        super.sayHi();
        System.out.println("目前就讀班級為" + className + "學號是" + stuId + "請大家多多指教......");
    }
}

class Master extends Human {//大師類
    /**
     * 特有屬性
     */
    double salary;

    /**
     * 構造器
     */
    public Master(String name, int age, String address, double salary) {
        super(name, age, address);
        this.salary = salary;
    }

    /**
     * 特有方法
     */
    void teach() {
        System.out.println(name + "正在教課......");
    }

    /**
     * 重寫方法
     */
    @Override
    void sayHi() {
        super.sayHi();
        System.out.println("目前是一位薪資約" + salary + "的大學教師");
    }

}

class Surgeon extends Human {//外科醫生類
    /**
     * 特有屬性
     */
    String title;

    /**
     * 構造器
     */
    public Surgeon(String name, int age, String address, String title) {
        super(name, age, address);
        this.title = title;
    }

    /**
     * 特有方法
     */
    void cut() {
        System.out.println(name + "正在手術......");
    }

}

abstract class LivingCreature {//生物類
    /**
     * 共有屬性
     */
    String name;
    int age;
    String color;

    /**
     * 構造器
     */
    public LivingCreature(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    /**
     * 共有方法
     */
    abstract void eat();

    void drink() {
        System.out.println("那隻" + color + "色" + age + "歲的" + name + "正在喝水......");
    }

}

class Hound extends LivingCreature {//獵犬類

    /**
     * 構造器
     */
    public Hound(String name, int age, String color) {
        super(name, age, color);
    }

    /**
     * 特有方法
     */
    void lookHome() {
        System.out.println("那隻" + color + "色" + age + "歲的" + name + "正在看家......");
    }

    /**
     * 重寫方法
     */
    @Override
    void eat() {
        System.out.println(name + "要吃飯了，這餐是啃骨頭......");
    }

}

class Fowl extends LivingCreature {//禽類

    /**
     * 構造器
     */
    public Fowl(String name, int age, String color) {
        super(name, age, color);
    }

    /**
     * 特有方法
     */
    void layEggs() {
        System.out.println("那隻" + color + "色" + age + "歲的" + name + "下蛋了!!!!!!");
    }

    /**
     * 重寫方法
     */
    @Override
    void eat() {
        System.out.println(name + "要吃飯了，今天吃的是小米");
    }

}

class Shark extends LivingCreature {//鯊魚類

    /**
     * 構造器
     */
    public Shark(String name, int age, String color) {
        super(name, age, color);
    }

    /**
     * 重寫方法
     */
    @Override
    void eat() {
        System.out.println(name + "餓了，正在海洋來回狩獵著......");
    }

}
