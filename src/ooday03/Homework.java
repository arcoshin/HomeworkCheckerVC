package ooday03;

/**
 * 動物測試類
 */
class Homework {
    public static void main(String[] args) {
        /**
         * 創建測試對象
         */
        Dog2 dog = new Dog2("小黑", 1, "黑");
        System.out.println("======以下調用" + dog.name + "的屬性與行為======");
        /**
         * 調用狗的每個屬性
         */
        System.out.println("有一隻" + dog.color + "狗叫做" + dog.name + "，今年" + dog.age + "歲");
        System.out.println();
        /**
         * 調用狗每的行為
         */
        dog.eat();//重寫超類方法
        dog.drink();//複用超類方法
        dog.swim2();//重寫接口方法
        dog.lookHome();//狗類特定方法
        System.out.println("=========================================================================");

        /**
         * 創建測試對象
         */
        Chick2 chick = new Chick2("小白", 1, "白");
        System.out.println("======以下調用" + chick.name + "的屬性與行為======");
        /**
         * 調用雞的每個屬性
         */
        System.out.println("有一隻" + chick.color + "雞叫做" + chick.name + "，今年" + chick.age + "歲");
        System.out.println();
        /**
         * 調用雞的每個行為
         */
        chick.eat();//重寫超類方法
        chick.drink();//複用超類方法
        chick.layEgg();//雞類特定方法
        System.out.println("=========================================================================");

        /**
         * 創建測試對象
         */
        Fish2 fish = new Fish2("小金", 1, "金");
        System.out.println("======以下調用" + fish.name + "的屬性與行為======");
        /**
         * 調用魚的每個屬性
         */
        System.out.println("有一隻" + fish.color + "魚叫做" + fish.name + "，今年" + fish.age + "歲");
        System.out.println();
        /**
         * 調用魚的每個行為
         */
        fish.eat();//重寫超類方法
        fish.drink();//複用超類方法
        fish.swim2();//重寫接口方法
        System.out.println("=========================================================================");
    }

}

/**
 * 動物們的父類---動物類
 */
abstract class Animal2 {
    /**
     * 共有屬性
     */
    String name;
    int age;
    String color;

    /**
     * 構造器
     */
    Animal2(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    /**
     * 共有方法
     */
    void drink() {
        System.out.println(color + "色" + age + "歲的" + name + "正在喝水......");
    }

    /**
     * 抽象方法
     */
    abstract void eat();
}

/**
 * 狗類
 */
class Dog2 extends Animal2 implements Swim2 {
    /**
     * 子類構造 : super()調用父類有參構造器
     */
    Dog2(String name, int age, String color) {
        super(name, age, color);
    }

    /**
     * 特有方法
     */
    void lookHome() {
        System.out.println(name + "正在看家......");
    }

    /**
     * 重寫超類抽象方法
     */
    @Override
    void eat() {
        System.out.println(name + "正在啃骨頭......");
    }

    /**
     * 重寫接口中的方法 : 一律必須public
     */
    @Override
    public void swim2() {
        System.out.println(color + "色" + age + "歲的狗狗" + name + "正在游泳......");
    }
}

/**
 * 雞類
 */
class Chick2 extends Animal2 {
    /**
     * 子類構造 : super()調用父類有參構造器
     */
    Chick2(String name, int age, String color) {
        super(name, age, color);
    }

    /**
     * 特有方法
     */
    void layEgg() {
        System.out.println(name + "正在下蛋呢......");
    }

    /**
     * 重寫超類抽象方法
     */
    @Override
    void eat() {
        System.out.println(name + "正在吃小米......");
    }
}

/**
 * 魚類
 */
class Fish2 extends Animal2 implements Swim2 {
    /**
     * 子類構造 : super()調用父類有參構造器
     */
    Fish2(String name, int age, String color) {
        super(name, age, color);
    }

    /**
     * 重寫超類抽象方法
     */
    @Override
    void eat() {
        System.out.println(name + "正在吃小蝦米......");
    }

    /**
     * 重寫接口中的方法 : 一律必須public
     */
    @Override
    public void swim2() {
        System.out.println(color + "色" + age + "歲的小魚" + name + "正在游泳......");
    }
}

/**
 * 游泳類
 */
interface Swim2 {
    void swim2();
}





