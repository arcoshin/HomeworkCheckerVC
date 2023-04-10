package ooday01;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

/**
 * ooday01
 * 面向對象的作業類Ver2.0
 */
public class HomeworkChecker {
    static String q1 = HomeworkCheckerTools.getQuestionName(1, "Student類與StudentTest類");
    static String q2 = HomeworkCheckerTools.getQuestionName(2, "Car類與CarTest類");

    /**
     * 作業檢測系統入口
     */
    private static void homeworkChecker() throws InterruptedException {
        System.out.println("======================================================================");
        System.out.println("Hint : 請輸入要檢查的題數(如第一題請輸入1，本次作業共2題，若想結束檢查請輸入99)");
        System.out.println("======================================================================");
        System.out.println(q1);//記得修改最大題數
        System.out.println(q2);//記得修改最大題數

        /**
         * 聲明scanner對象及初始化老師輸入的指令
         */
        int homeworkCheck = new Scanner(System.in).nextInt();


        /**
         * 作業查找分支系統
         */
        switch (homeworkCheck) {
            case 1:
                HomeworkCheckerTools.whatYouChoose(q1);
                question1();
                break;
            case 2:
                HomeworkCheckerTools.whatYouChoose(q2);
                question2();
                break;
            case 99:
                return;
            default:
                HomeworkCheckerTools.uRWrong();
                homeworkChecker();
        }
    }

    /**
     * 第一題演示
     */
    private static void question1() throws InterruptedException {
        HomeworkCheckerTools.waitForPreparing();
        //=======================================================
        System.out.println("Student:學生模板類展示開始=================================");
        System.out.println(
                        "/**\n" +
                        " * 學生模板類\n" +
                        " */\n" +
                        "public class Student {\n" +
                        "    /**\n" +
                        "     * 成員變量\n" +
                        "     */\n" +
                        "    String name;\n" +
                        "    int age;\n" +
                        "    String className;\n" +
                        "    String stuId;\n" +
                        "\n" +
                        "\n" +
                        "    /**\n" +
                        "     * 構造方法:給成員變量賦值\n" +
                        "     */\n" +
                        "    Student() {\n" +
                        "        this(\"無名氏\",999,\"未知\",\"未知\");\n" +
                        "        /**\n" +
                        "         * this():方法中調用構造方法(其實就是聲明一個對象給相同值的意思)\n" +
                        "         * 很少用，知道就行，因為即便不傳參去賦值給成員變量，在new的當下系統就會給予默認值;\n" +
                        "         */\n" +
                        "\n" +
                        "    }\n" +
                        "\n" +
                        "    /**\n" +
                        "     * this關鍵字表示\"當前對象\"(誰調用就是表示誰)\n" +
                        "     * this關鍵字只能在方法中使用，用來訪問該類的成員變量\n" +
                        "     * 一般方法中會默認使用(除非難以辨別)\n" +
                        "     */\n" +
                        "    Student(String name,int age,String className,String stuId){//構造方法(必須與類同名且沒有返回值也無void)\n" +
                        "        this.name = name;//此時this不可省略\n" +
                        "        this.age = age;//此時this不可省略\n" +
                        "        this.className = className;//此時this不可省略\n" +
                        "        this.stuId = stuId;//此時this不可省略\n" +
                        "    }\n" +
                        "\n" +
                        "    /**\n" +
                        "     * 方法\n" +
                        "     */\n" +
                        "    void study() {\n" +
                        "        System.out.println(this.name + \"正在學習...\");\n" +
                        "    }\n" +
                        "\n" +
                        "    void sayHi() {\n" +
                        "        System.out.println(\"大家好，我叫\" + this.name + \"，今年\" + this.age + \"歲，學號是\" + this.stuId + \"，目前在\" + this.className + \"學習...\");\n" +
                        "    }\n" +
                        "\n" +
                        "    void playWith(String anotherName) {\n" +
                        "        System.out.println(this.name + \"正在和\" + anotherName + \"一起玩......\");\n" +
                        "    }\n" +
                        "\n" +
                        "\n" +
                        "\n" +
                        "}\n"
        );
        System.out.println("Student:學生模板類展示結束=================================");
        //=======================================================
        Student studentSetByUser = new Student();
        //=======================================================
        System.out.println("現在開始展示調用方法，請輸入對應的學生相關數據以便進行測試......");

        System.out.println("請輸入學生姓名");
        studentSetByUser.name = new Scanner(System.in).nextLine();
        System.out.println("請輸入學生年齡(只能輸入整數)");
        studentSetByUser.age = new Scanner(System.in).nextInt();
        System.out.println("請輸入學生班級");
        studentSetByUser.className = new Scanner(System.in).nextLine();
        System.out.println("請輸入學生學號");
        studentSetByUser.stuId = new Scanner(System.in).nextLine();

        System.out.println("學生資訊輸入完畢");
        while (true) {
            System.out.println("請選擇要測試的方法: 1.sayHi() 2.study() 3.playWith 若想退出請輸入99");
            int chosenByUser = new Scanner(System.in).nextInt();

            switch (chosenByUser) {
                case 1:
                    studentSetByUser.sayHi();
                    System.out.println("測試完成，正在返回測試方法選單...");
                    break;
                case 2:
                    studentSetByUser.study();
                    System.out.println("測試完成，正在返回測試方法選單...");
                    break;
                case 3:
                    System.out.println("請輸入陪" + studentSetByUser.name + "玩耍的對象......");
                    String whoPlayWithStudentSetByUser = new Scanner(System.in).nextLine();
                    studentSetByUser.playWith(whoPlayWithStudentSetByUser);
                    System.out.println("測試完成，正在返回測試方法選單...");
                    break;
                case 99:
                    HomeworkCheckerTools.backToMenu();
                    return;
                default:
                    HomeworkCheckerTools.uRWrong();
                    break;
            }
        }

        //=======================================================
    }

    /**
     * 第二題演示
     */
    private static void question2() throws InterruptedException {
        HomeworkCheckerTools.waitForPreparing();
        //=======================================================
        System.out.println("Car:汽車模板類展示開始=================================");
        System.out.println(
                        "/**\n" +
                        " * 汽車模板類\n" +
                        " */\n" +
                        "public class Car {\n" +
                        "    /**\n" +
                        "     * 屬性\n" +
                        "     */\n" +
                        "    String brand;//品牌\n" +
                        "    String color;//顏色\n" +
                        "    double price;//價格\n" +
                        "\n" +
                        "    /**\n" +
                        "     * 構造器\n" +
                        "     * @param brand 品牌\n" +
                        "     * @param color 車色\n" +
                        "     * @param price 車價\n" +
                        "     */\n" +
                        "    public Car(String brand, String color, double price) {\n" +
                        "        this.brand = brand;\n" +
                        "        this.color = color;\n" +
                        "        this.price = price;\n" +
                        "    }\n" +
                        "\n" +
                        "    void start() {//發動\n" +
                        "        System.out.println(\"這台\" + brand + \"牌(價值約\" + price + \"元的)\" + color + \"色車發動了\");\n" +
                        "    }\n" +
                        "\n" +
                        "    void run() {//行駛\n" +
                        "        System.out.println(\"這台\" + brand + \"牌(價值約\" + price + \"元)的\" + color + \"色車開始行駛了\");\n" +
                        "    }\n" +
                        "\n" +
                        "    void stop() {//煞車\n" +
                        "        System.out.println(\"這台\" + brand + \"牌(價值約\" + price + \"元)的\" + color + \"色車停下來了\");\n" +
                        "    }\n" +
                        "}\n"
        );
        System.out.println("Car:汽車模板類展示結束=================================");
        //=======================================================
        Car carSetByUser = new Car();
        //=======================================================
        System.out.println("現在開始展示調用方法，請輸入對應的汽車相關數據以便進行測試......");

        System.out.println("請輸入汽車廠牌");
        carSetByUser.brand = new Scanner(System.in).nextLine();
        System.out.println("請輸入汽車車色(不需包含\'色\'字)");
        carSetByUser.color = new Scanner(System.in).nextLine();
        System.out.println("請輸入汽車價格");
        carSetByUser.price = new Scanner(System.in).nextDouble();

        System.out.println("車輛資訊輸入完畢");
        while (true) {
            System.out.println("請選擇要測試的方法: 1.start() 2.run() 3.stop 若想退出請輸入99");
            int chosenByUser = new Scanner(System.in).nextInt();

            switch (chosenByUser) {
                case 1:
                    carSetByUser.start();
                    System.out.println("測試完成，正在返回測試方法選單...");
                    break;
                case 2:
                    carSetByUser.run();
                    System.out.println("測試完成，正在返回測試方法選單...");
                    break;
                case 3:
                    carSetByUser.stop();
                    System.out.println("測試完成，正在返回測試方法選單...");
                    break;
                case 99:
                    HomeworkCheckerTools.backToMenu();
                    return;
                default:
                    HomeworkCheckerTools.uRWrong();
                    break;
            }
        }

        //=======================================================
    }

    /**
     * 程序入口
     */
    public static void main(String[] args) {

        try {
            homeworkChecker();
            HomeworkCheckerTools.ending();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    /**
     * HomeworkCheckerTools:工具類
     */
    private static abstract class HomeworkCheckerTools {//附屬靜態工具包類

        /**
         * 生成題目名稱的方法
         */
        private static String getQuestionName(int n, String title) {
            String questionName = n + "." + title;
            return questionName;
        }

        /**
         * 告知用戶輸入不合法的方法
         */
        private static void uRWrong() {
            try {
                throw new RuntimeException("輸入錯誤，請重新輸入");
            } catch (RuntimeException e) {
                e.printStackTrace();
            }
        }

        /**
         * 廣播說明客戶所選擇的業務
         */
        private static void whatYouChoose(String doSomething) {
            System.out.println("您所選擇的是" + doSomething);
        }

        /**
         * 開始演示question的方法
         */
        private static void waitForPreparing() throws InterruptedException {
            System.out.println("請稍後...正在為您生成本題的演示過程...");
            Thread.sleep(1000);
        }

        /**
         * 結束的方法
         */
        private static void ending() throws InterruptedException {
            System.out.println("感謝您的耐心檢查，系統正在關閉......");
            Thread.sleep(1000);
            System.out.println("END");
        }

        /**
         * 自動回到首頁的方法
         */
        private static void backToMenu() throws InterruptedException {
            System.out.println("本題展示完成，即將返回大題選單......");
            Thread.sleep(1000);
            HomeworkChecker.homeworkChecker();
        }

    }

    /**
     * 學生模板類
     */
    private static class Student {//作為靜態類方便調用
        /**
         * 成員變量
         */
        String name;
        int age;
        String className;
        String stuId;


        /**
         * 構造方法:給成員變量賦值
         */
        Student() {
            this("無名氏", 999, "未知", "未知");
            /**
             * this():方法中調用構造方法(其實就是聲明一個對象給相同值的意思)
             * 很少用，知道就行，因為即便不傳參去賦值給成員變量，在new的當下系統就會給予默認值;
             */

        }

        /**
         * this關鍵字表示"當前對象"(誰調用就是表示誰)
         * this關鍵字只能在方法中使用，用來訪問該類的成員變量
         * 一般方法中會默認使用(除非難以辨別)
         */
        Student(String name, int age, String className, String stuId) {//構造方法(必須與類同名且沒有返回值也無void)
            this.name = name;//此時this不可省略
            this.age = age;//此時this不可省略
            this.className = className;//此時this不可省略
            this.stuId = stuId;//此時this不可省略
        }

        /**
         * 方法
         */
        void study() {
            System.out.println(this.name + "正在學習...");
        }

        void sayHi() {
            System.out.println("大家好，我叫" + this.name + "，今年" + this.age + "歲，學號是" + this.stuId + "，目前在" + this.className + "學習...");
        }

        void playWith(String anotherName) {
            System.out.println(this.name + "正在和" + anotherName + "一起玩......");
        }


    }

    /**
     * 汽車模板類
     */
    public static class Car {
        /**
         * 屬性
         */
        String brand;//品牌
        String color;//顏色
        double price;//價格

        /**
         * 構造器
         * @param brand 品牌
         * @param color 車色
         * @param price 車價
         */
        public Car(String brand, String color, double price) {
            this.brand = brand;
            this.color = color;
            this.price = price;
        }

        public Car() {
        }

        void start() {//發動
            System.out.println("這台" + brand + "牌(價值約" + price + "元)的" + color + "色車發動了");
        }

        void run() {//行駛
            System.out.println("這台" + brand + "牌(價值約" + price + "元)的" + color + "色車開始行駛了");
        }

        void stop() {//煞車
            System.out.println("這台" + brand + "牌(價值約" + price + "元)的" + color + "色車停下來了");
        }
    }



}


