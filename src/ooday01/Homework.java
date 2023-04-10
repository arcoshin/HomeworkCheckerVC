package ooday01;


public class Homework {
    public static void main(String[] args) {
        /**=======================
         * Student類與StudentTest類
         * ======================*/

        System.out.println("====StudentTest展示開始======================================================");

        Student unknownName1 = new Student();//克隆人
        unknownName1.sayHi();
        Student unknownName2 = new Student();//克隆人
        unknownName2.sayHi();

        Student zs = new Student("張三", 20, "jsd2303", "001");
        Student ls = new Student("李四", 25, "jsd2303", "002");
        Student ww = new Student("王五", 30, "jsd2303", "003");

        zs.sayHi();
        ls.study();
        ww.practiceJavaWith("XJX");

        System.out.println("====StudentTest展示結束======================================================");
        System.out.println();//換行，排版用
        /**====================
         * Car類與CarTest類
         * ==================*/

        System.out.println("========================CarTest展示開始======================================");

        Car carA = new Car("賓利","黑",12000000);
        Car carB = new Car("雷克薩斯","白",6000000);
        Car carC = new Car("速霸陸","藍",1300000);
        Car carD = new Car("三菱","灰",500000);

        carA.startFail();
        carB.runFeeling();
        carC.stop();
        carD.showOff();

        System.out.println("========================CarTest展示結束======================================");


    }

    /**
     * 學生模板類
     */
    private static class Student {//為本作業類之靜態內部類，所有內容僅可於本作業中直接使用
        /**
         * 學生屬性:所有屬性僅可在本作業類中使用
         */
        private String name;
        private int age;
        private String className;
        private String stuId;

        private Student() {//假設無參一律生出無名氏克隆人
            this("無名氏", 0, "CloneClass", "未知");
        }

        /**
         * 構造器:僅可在本作業類中使用
         *
         * @param name      學生姓名
         * @param age       學生年齡
         * @param className 學生班級
         * @param stuId     學生學號
         */
        private Student(String name, int age, String className, String stuId) {
            this.name = name;
            this.age = age;
            this.className = className;
            this.stuId = stuId;
        }

        /**
         * 學生行為方法:所有方法皆只可在本作業類中使用
         */
        private void sayHi() {//打招呼行為
            System.out.println("大家好，我叫" + name + "，今年" + age + "歲，學號是" + stuId + "，目前在" + className + "學習...");
        }

        private void study() {//讀書行為
            System.out.println(name + "正在用功讀書......");
        }

        private void practiceJavaWith(String name) {//練習JAVA的行為
            System.out.println(this.name + "正在和" + name + "一起練習JAVA~");
        }
    }

    /**
     * 汽車模板類
     */
    private static class Car {//為本作業類之靜態內部類，所有內容僅可於本作業中直接使用
        /**
         * 車輛屬性:所有屬性僅可在本作業類中使用
         */
        private String brand;
        private String color;
        private int price;//小數很醜

        /**
         * 構造器:僅可在本作業類中使用
         *
         * @param brand 車輛品牌
         * @param color 車身顏色
         * @param price 車輛價格
         */
        private Car(String brand, String color, int price) {
            this.brand = brand;
            this.color = color;
            this.price = price;
        }

        /**
         * 車輛動作方法:所有方法皆只可在本作業類中使用
         */
        private void startFail() {//發動失敗的動作
            System.out.println("那台價值約" + price + "元的車居然發不動了");
        }

        private void runFeeling() {//描述行駛時的感受的動作
            System.out.println(brand + "的車行駛時的使用者體驗非常棒!");
        }

        private void stop() {//停車的動作
            System.out.println("那台" + color + "色的車突然停下來了!!");
        }

        private void showOff () {//只是為了一口氣展示所有屬性的炫耀動作
            System.out.println("那台" + this.brand + "的" + color + "色車價值約" + price + "元");
        }


    }
}


