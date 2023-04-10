package ooday04;

/**
 * 直接以此類為測試類
 */
class Homework {
    public static void main(String[] args) {
        /**
         * Animal測試
         */
        //聲明Animal型數組animals，包含三個Dog型元素，三個Chick型元素，兩個Fish型元素------向上造型(自動類型轉換)
        Animal2[] animals = new Animal2[3 + 3 + 2];
        for (int i = 0; i < animals.length; i++) {
            animals[0] = new Dog2("小黑", 1, "黑");
            animals[1] = new Dog2("小黃", 1, "黃");
            animals[2] = new Dog2("小白", 1, "白");
            animals[3] = new Chick2("小黑", 1, "黑");
            animals[4] = new Chick2("小白", 1, "白");
            animals[5] = new Chick2("小黃", 1, "黃");
            animals[6] = new Fish2("小黑", 1, "黑");
            animals[7] = new Fish2("小白", 1, "白");

            System.out.println(animals[i].name);//輸出每隻動物的名字
            animals[i].eat();//每隻動物吃飯
            animals[i].drink();//每隻動物喝水

            Master2 master = new Master2();
            if (animals[i] instanceof Dog2) {//與Dog類型匹配時
                ((Dog2) animals[i]).lookHome();//強轉後調用狗類特有方法(向下轉型)
                master.feed(animals[i]);//餵養動物方法的形參限定動物類 : 此處可發現調用方法傳參時，系統可以自動向上造型(自動類型轉換)
            }

            if (animals[i] instanceof Chick2) {//與Chick類型匹類時
                ((Chick2) animals[i]).layEgg();//強轉後調用雞類特有方法(向下轉型)
                master.feed(animals[i]);//餵養動物方法的形參限定動物類 : 此處可發現調用方法傳參時，系統可以自動向上造型(自動類型轉換)
            }

            if (animals[i] instanceof Swim2) {//適用於所有實現Swim接口的類
                ((Swim2) animals[i]).swim();//以多態的概念解決代碼冗與
            }

        }

        /**
         * 匿名內部類測試
         */
        /**
         *
         */
        Aoo o1 = new Aoo() {//匿名內部類
            /**
             * 既是派生類(子類)，則超類(父類)中的抽象方法必須重寫完整
             */
            @Override
            void show() {
                System.out.println("此處已成功執行抽象類Aoo的子類對象，o1的show()的方法...");
            }
        };

        Aoo o2 = new Aoo() {//匿名內部類
            /**
             * 既是派生類(子類)，則超類(父類)中的抽象方法必須重寫完整
             */
            @Override
            void show() {
                System.out.println("此處已成功執行抽象類Aoo的子類對象，o2的show()的方法...");
            }
        };

        /**
         * 調用匿名內部類的資源，
         */
        o1.show();
        o2.show();

        /**
         * 接口的匿名內部類 : Lambda
         */
        Inter i1 = () -> System.out.println("已成功調用i1重寫後的test方法");
        i1.test();

        Inter i2 = () -> System.out.println("已成功調用i2重寫後的test方法");
        i2.test();

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
        System.out.println(color + "色" + age + "歲的狗狗" + name + "正在看家......");
    }

    /**
     * 重寫超類抽象方法
     */
    @Override
    void eat() {
        System.out.println(color + "色" + age + "歲的狗狗" + name + "正在啃骨頭......");
    }

    /**
     * 重寫接口中的方法 : 一律必須public
     */
    @Override
    public void swim() {
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
        System.out.println(color + "色" + age + "歲的小雞" + name + "正在下蛋呢......");
    }

    /**
     * 重寫超類抽象方法
     */
    @Override
    void eat() {
        System.out.println(color + "色" + age + "歲的小雞" + name + "正在吃小米......");
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
        System.out.println(color + "色" + age + "歲的小魚兒" + name + "正在吃小蝦米......");
    }

    /**
     * 重寫接口中的方法 : 一律必須public
     */
    @Override
    public void swim() {
        System.out.println(color + "色" + age + "歲的小魚兒" + name + "正在游泳......");
    }
}

/**
 * 游泳接口類
 */
interface Swim2 {
    /**
     * 接口中已經默認所有方法結為"抽象方法"---故"abstract"為灰色
     * 看似普通方法，但接口中已經默認所有方法的前綴有"abstract"，意即實為抽象方法，不可有方法體
     */
    abstract void swim();
}

/**
 * 飼主類
 */
class Master2 {
    /**
     * 餵動物的行為 ------可發現若傳參類型為子類，系統會自動向上造型
     */
    void feed(Animal2 animal) {
        animal.eat();
    }
}

