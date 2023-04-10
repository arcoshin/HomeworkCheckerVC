package ooday03;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Scanner;


/**
 * weekendHomework 2023.03.28
 * 接口練習的作業類
 * HomeworkChecker.ver3.3
 * <p>
 * <p>
 * <p>
 * =====================
 * Update Information:
 * =====================
 * 1.Question Method->StaticInnerClass(Class.method():...)
 * 2.HomeworkChecker extends HomeworkCheckerTools(method():...)
 * 3.AutoEntering Array.length causing by a new Array System : Question[]
 * 4.Taking lots of programs into Methods making system looks clearer.
 * 5.New Class : database (design......)
 * =====================
 * Next Goal:
 * =====================
 * 1.Semi-automatic press question class;(trying io)
 * 2.Trying set another container to replace ArraySystem, it maybe...
 * (1.)static Question[]...(Now)
 * (2.)static Collection
 * (3.)static Map...(Goal)
 * 3.Thinking about using Reflection would make Systems better ?
 * 4.Whether if building a "KeyAdapter" system to replace some Scanners ?
 * <p>
 * <p>
 * 20230328_XCX
 */
class HomeworkChecker extends HomeworkCheckerTools {
    /**
     * 加載題目資料庫中的數據:不用每次進到系統就加載一次，所以放系統外
     */
    public static Question[] questionList = new QuestionDatabase().downloadQuestion();

    /**
     * 作業檢測系統入口
     */
    public static void homeworkChecker() throws InterruptedException {

        /**
         * 進入選單主頁
         */
        showMenuTip(questionList);//選單主頁的輸入提示
        showQuestionList(questionList, questionList.length);//遍歷所有題目


        /**
         * 聲明scanner對象接收檢測員輸入的選擇
         */
        int checker = new Scanner(System.in).nextInt();//接收檢測者的選擇

        /**
         * 作業查找分支系統
         */
        whatUChooseFromMenu(checker, questionList);//將選擇派入選題分支

        /**
         * 防止多重跳轉間重複執行本方法，添加return讓執行至此時，一定結束本次方法。
         */
        return;
    }

    /**
     * 程序入口
     */
    public static void main(String[] args) {
        try {
            HomeworkChecker HC = new HomeworkChecker();
            HC.homeworkChecker();//進入系統
            ending();//退出系統
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}

/**
 * 題目模板類
 */
class Question {
    /**
     * 題目屬性
     */
    int num;//題目序號
    String questionName;//題目名稱
    String questionContent;//題目要求內文

    /**
     * 題目構造器
     *
     * @param num             題目序號
     * @param questionName    題目名稱
     * @param questionContent 題目要求內文
     */
    public Question(int num, String questionName, String questionContent) {
        this.num = num;
        this.questionName = questionName;
        this.questionContent = questionContent;
    }
}

/**
 * 本系統工具類
 */
class HomeworkCheckerTools {
    /**
     * 主選單分支業務
     *
     * @param checker      跳轉目標的代碼
     * @param questionList 跳轉目標的名稱
     */
    protected static void whatUChooseFromMenu(int checker, Question[] questionList) throws InterruptedException {
        if (checker == 99) {//選擇99則直接結束本方法
            return;
        } else if (checker > 0 && checker <= questionList.length) {//homeworkCheck != 99 but 10>=homeworkCheck>=max
            for (int i = 1; i <= questionList.length; i++) {//題數指針
                if (checker == i) {
                    whatYouChoose(questionList[i - 1].questionName);//數組中，下標(i-1)的內容 == 第i題的內容
                    goToQuestion(i);//去到第i題，但該業務結束後會自動回到本系統入口
                    return;
                }
            }
        } else {//others->Enter again!
            uRWrong();//錯了，重來
            HomeworkChecker.homeworkChecker();
            return;
        }
    }

    /**
     * 選題首頁的輸入提示方法
     */
    protected static void showMenuTip(Question[] questionList) {
        System.out.println("======================================================================");
        System.out.println("Hint : 請輸入要檢查的題數(如第一題請輸入1，本次作業共" + questionList.length + "題，若想結束檢查請輸入99)");
        System.out.println("======================================================================");
    }

    /**
     * 遍歷所有題目的方法
     *
     * @param max 本次開放題數
     */
    protected static void showQuestionList(Question[] questionList, int max) {
        for (int i = 0; i < HomeworkChecker.questionList.length; i++) {//遍歷題目列表
            System.out.println(questionList[i].num + "." + questionList[i].questionName);
        }
    }

    /**
     * 執行question?的方法
     */
    protected static void goToQuestion(int num) throws InterruptedException {
        switch (num) {
            case 1:
                QuestionDatabase.question1();
                break;
            case 2:
                QuestionDatabase.question2();
                break;
            case 3:
                QuestionDatabase.question3();
                break;
            case 4:
                QuestionDatabase.question4();
                break;
            case 5:
                QuestionDatabase.question5();
                break;
            case 6:
                QuestionDatabase.question6();
                break;
            case 7:
                QuestionDatabase.question7();
                break;
            case 8:
                QuestionDatabase.question8();
                break;
            case 9:
                QuestionDatabase.question9();
                break;
            case 10:
                QuestionDatabase.question10();
                break;
        }
    }

    /**
     * 回到首頁的方法
     */
    protected static void backToMenu() throws InterruptedException {
        System.out.println("本題展示完成，即將返回大題選單......");
        Thread.sleep(1000);
        HomeworkChecker.homeworkChecker();
    }

    /**
     * 告知用戶輸入不合法的方法
     */
    protected static void uRWrong() {
        try {
            throw new RuntimeException("輸入錯誤，請重新輸入");
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

    /**
     * 廣播說明客戶所選擇的業務
     */
    protected static void whatYouChoose(String doSomething) {
        System.out.println("您所選擇的是" + doSomething);
    }

    /**
     * 開始演示question的方法
     */
    protected static void waitForPreparing() throws InterruptedException {
        System.out.println("請稍候...正在為您生成本題的演示過程...");
        Thread.sleep(1000);
    }

    /**
     * 告別的方法
     */
    protected static void ending() throws InterruptedException {
        System.out.println("感謝您的耐心檢查，系統正在關閉......");
        Thread.sleep(1000);
        System.out.println("END");
    }

}

/**
 * 資料庫類(尚須手動更新)
 */
class QuestionDatabase extends HomeworkCheckerTools {
    /**
     * 將題目存入並生成題目列表(data)的方法:QB->HWC
     */
    public Question[] downloadQuestion() {
        Question[] data = new Question[3];//<<---------------------------------手動修改
        data[0] = new Question(1, "動物類相關練習", "新增游泳接口類");
        data[1] = new Question(2, "RefArrayDemo類", "引用數組相關練習");
        data[2] = new Question(3, "達內員工管理系統設計圖", "作圖題");
//        data[3] = new Question(4, "Addition隨機加法運算", "練習for循環");
//        data[4] = new Question(5, "九九乘法表", "練習雙重for循環");
//        data[5] = new Question(6, "MaxOfArray球最大並放最後一位", "練習數組、循環");
//        data[6] = new Question(7, "生成N為驗證碼", "練習數組、循環和方法");
//        data[7] = new Question(8, "找出2~100中所有素數", "練習雙重for循環");
//        data[8] = new Question(9, "機票打折系統", "練習分支與方法");
//        data[9] = new Question(10, "去大去小平均的打分計算", "練習數組、循環和方法");
        return data;
    }

    /**
     * 第一題演示
     */
    public static void question1() throws InterruptedException {
        waitForPreparing();
        //=======================================================
        System.out.println(
                "/**\n" +
                        " * 動物們的父類---動物類\n" +
                        " */\n" +
                        "abstract class Animal {\n" +
                        "    /**\n" +
                        "     * 共有屬性\n" +
                        "     */\n" +
                        "    String name;\n" +
                        "    int age;\n" +
                        "    String color;\n" +
                        "\n" +
                        "    /**\n" +
                        "     * 構造器\n" +
                        "     */\n" +
                        "    Animal(String name, int age, String color) {\n" +
                        "        this.name = name;\n" +
                        "        this.age = age;\n" +
                        "        this.color = color;\n" +
                        "    }\n" +
                        "\n" +
                        "    /**\n" +
                        "     * 共有方法\n" +
                        "     */\n" +
                        "    void drink() {\n" +
                        "        System.out.println(color + \"色\" + age + \"歲的\" + name + \"正在喝水......\");\n" +
                        "    }\n" +
                        "\n" +
                        "    /**\n" +
                        "     * 抽象方法\n" +
                        "     */\n" +
                        "    abstract void eat();\n" +
                        "}\n" +
                        "\n" +
                        "/**\n" +
                        " * 狗類\n" +
                        " */\n" +
                        "class Dog extends Animal implements Swim{\n" +
                        "    /**\n" +
                        "     * 子類構造 : super()調用父類有參構造器\n" +
                        "     */\n" +
                        "    Dog(String name, int age, String color) {\n" +
                        "        super(name, age, color);\n" +
                        "    }\n" +
                        "\n" +
                        "    /**\n" +
                        "     * 特有方法\n" +
                        "     */\n" +
                        "    void lookHome() {\n" +
                        "        System.out.println(name + \"正在看家......\");\n" +
                        "    }\n" +
                        "\n" +
                        "    /**\n" +
                        "     * 重寫超類抽象方法\n" +
                        "     */\n" +
                        "    @Override\n" +
                        "    void eat() {\n" +
                        "        System.out.println(name + \"正在啃骨頭......\");\n" +
                        "    }\n" +
                        "\n" +
                        "    /**\n" +
                        "     * 重寫接口中的方法 : 一律必須public\n" +
                        "     */\n" +
                        "    @Override\n" +
                        "    public void swim() {\n" +
                        "        System.out.println(color +\"色\" + age +\"歲的狗狗\" + name + \"正在游泳......\");\n" +
                        "    }\n" +
                        "}\n" +
                        "\n" +
                        "/**\n" +
                        " * 雞類\n" +
                        " */\n" +
                        "class Chick extends Animal{\n" +
                        "    /**\n" +
                        "     * 子類構造 : super()調用父類有參構造器\n" +
                        "     */\n" +
                        "    Chick(String name, int age, String color) {\n" +
                        "        super(name, age, color);\n" +
                        "    }\n" +
                        "\n" +
                        "    /**\n" +
                        "     * 特有方法\n" +
                        "     */\n" +
                        "    void layEgg() {\n" +
                        "        System.out.println(name + \"正在下蛋呢......\");\n" +
                        "    }\n" +
                        "\n" +
                        "    /**\n" +
                        "     * 重寫超類抽象方法\n" +
                        "     */\n" +
                        "    @Override\n" +
                        "    void eat() {\n" +
                        "        System.out.println(name + \"正在吃小米......\");\n" +
                        "    }\n" +
                        "}\n" +
                        "\n" +
                        "/**\n" +
                        " * 魚類\n" +
                        " */\n" +
                        "class Fish extends Animal implements Swim{\n" +
                        "    /**\n" +
                        "     * 子類構造 : super()調用父類有參構造器\n" +
                        "     */\n" +
                        "    Fish(String name, int age, String color) {\n" +
                        "        super(name, age, color);\n" +
                        "    }\n" +
                        "\n" +
                        "    /**\n" +
                        "     * 重寫超類抽象方法\n" +
                        "     */\n" +
                        "    @Override\n" +
                        "    void eat() {\n" +
                        "        System.out.println(name + \"正在吃小蝦米......\");\n" +
                        "    }\n" +
                        "\n" +
                        "    /**\n" +
                        "     * 重寫接口中的方法 : 一律必須public\n" +
                        "     */\n" +
                        "    @Override\n" +
                        "    public void swim() {\n" +
                        "        System.out.println(color +\"色\" + age +\"歲的小魚\" + name + \"正在游泳......\");\n" +
                        "    }\n" +
                        "}\n" +
                        "\n" +
                        "/**\n" +
                        " * 游泳類\n" +
                        " */\n" +
                        "interface Swim {\n" +
                        "    void swim();\n" +
                        "}" +
                        "\n" +
                        "/**\n" +
                        " * 動物測試類\n" +
                        " */\n" +
                        "class AnimalDemo {\n" +
                        "    public static void seDay01(String[] args) {\n" +
                        "        /**\n" +
                        "         * 創建測試對象\n" +
                        "         */\n" +
                        "        Dog dog = new Dog(\"小黑\", 1, \"黑\");\n" +
                        "        System.out.println(\"======以下調用\" + dog.name + \"的屬性與行為======\");\n" +
                        "        /**\n" +
                        "         * 調用狗的每個屬性\n" +
                        "         */\n" +
                        "        System.out.println(\"有一隻\" + dog.color + \"狗叫做\" + dog.name + \"，今年\" + dog.age + \"歲\");\n" +
                        "        System.out.println();\n" +
                        "        /**\n" +
                        "         * 調用狗每的行為\n" +
                        "         */\n" +
                        "        dog.eat();//重寫超類方法\n" +
                        "        dog.drink();//複用超類方法\n" +
                        "        dog.swim();//重寫接口方法\n" +
                        "        dog.lookHome();//狗類特定方法\n" +
                        "        \n" +
                        "        /**\n" +
                        "         * 創建測試對象\n" +
                        "         */\n" +
                        "        Chick chick  = new Chick(\"小白\", 1, \"白\");\n" +
                        "        System.out.println(\"======以下調用\" + chick.name + \"的屬性與行為======\");\n" +
                        "        /**\n" +
                        "         * 調用雞的每個屬性\n" +
                        "         */\n" +
                        "        System.out.println(\"有一隻\" + chick.color + \"雞叫做\" + chick.name + \"，今年\" + chick.age + \"歲\");\n" +
                        "        System.out.println();\n" +
                        "        /**\n" +
                        "         * 調用雞的每個行為\n" +
                        "         */\n" +
                        "        chick.eat();//重寫超類方法\n" +
                        "        chick.drink();//複用超類方法\n" +
                        "        chick.layEgg();//雞類特定方法\n" +
                        "        \n" +
                        "        /**\n" +
                        "         * 創建測試對象\n" +
                        "         */\n" +
                        "        Fish fish = new Fish(\"小金\", 1, \"金\");\n" +
                        "        System.out.println(\"======以下調用\" + fish.name + \"的屬性與行為======\");\n" +
                        "        /**\n" +
                        "         * 調用魚的每個屬性\n" +
                        "         */\n" +
                        "        System.out.println(\"有一隻\" + fish.color + \"魚叫做\" + fish.name + \"，今年\" + fish.age + \"歲\");\n" +
                        "        System.out.println();\n" +
                        "        /**\n" +
                        "         * 調用魚的每個行為\n" +
                        "         */\n" +
                        "        fish.eat();//重寫超類方法\n" +
                        "        fish.drink();//複用超類方法\n" +
                        "        fish.swim();//重寫接口方法\n" +
                        "    }\n" +
                        "}\n"
        );

        System.out.println("正在輸出程序結果......");

        //背景代碼存放區開始
        /**
         * 創建測試對象
         */
        Dog dog = new Dog("小黑", 1, "黑");
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
        dog.swim();//重寫接口方法
        dog.lookHome();//狗類特定方法

        /**
         * 創建測試對象
         */
        Chick chick = new Chick("小白", 1, "白");
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

        /**
         * 創建測試對象
         */
        Fish fish = new Fish("小金", 1, "金");
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
        fish.swim();//重寫接口方法
        //背景代碼存放區結束
        //=======================================================
        backToMenu();
    }

    /**
     * 第二題演示
     */
    public static void question2() throws InterruptedException {
        waitForPreparing();
        //=======================================================
        System.out.println(
                "/**\n" +
                        " * 引用類型數組的演示\n" +
                        " */\n" +
                        "public class RefArrayDemo {\n" +
                        "    public static void seDay01(String[] args) {\n" +
                        "        //聲明Dog型數組dogs，包含三個元素，默認值為null\n" +
                        "        Dog[] dogs = new Dog[3];\n" +
                        "        dogs[0] = new Dog(\"小黑\", 2, \"黑\");\n" +
                        "        dogs[1] = new Dog(\"小白\", 3, \"白\");\n" +
                        "        dogs[2] = new Dog(\"小黃\", 4, \"黃\");\n" +
                        "        for (int i = 0; i < dogs.length; i++) {\n" +
                        "            System.out.println(\"======以下調用\" + dogs[i].name + \"的屬性與行為======\");\n" +
                        "            /**\n" +
                        "             * 調用每隻狗的屬性\n" +
                        "             */\n" +
                        "            System.out.println(\"有一隻\" + dogs[i].color + \"狗叫做\" + dogs[i].name + \"，今年\" + dogs[i].age + \"歲\");\n" +
                        "            System.out.println();\n" +
                        "            /**\n" +
                        "             * 調用每隻狗的行為\n" +
                        "             */\n" +
                        "            dogs[i].eat();//重寫超類方法\n" +
                        "            dogs[i].drink();//複用超類方法\n" +
                        "            dogs[i].swim();//重寫接口方法\n" +
                        "            dogs[i].lookHome();//狗類特定方法\n" +
                        "        }\n" +
                        "\n" +
                        "        //聲明Chick型數組chicks，包含三個元素，默認值為null\n" +
                        "        Chick[] chicks = new Chick[3];\n" +
                        "        chicks[0] = new Chick(\"小紅\", 1, \"紅\");\n" +
                        "        chicks[1] = new Chick(\"小黑\", 1, \"黑\");\n" +
                        "        chicks[2] = new Chick(\"小花\", 1, \"花\");\n" +
                        "        for (int i = 0; i < chicks.length; i++) {\n" +
                        "            System.out.println(\"======以下調用\" + chicks[i].name + \"的屬性與行為======\");\n" +
                        "            /**\n" +
                        "             * 調用每隻雞的屬性\n" +
                        "             */\n" +
                        "            System.out.println(\"有一隻\" + chicks[i].color + \"雞叫做\" + chicks[i].name + \"，今年\" + chicks[i].age + \"歲\");\n" +
                        "            System.out.println();\n" +
                        "            /**\n" +
                        "             * 調用每隻雞的行為\n" +
                        "             */\n" +
                        "            chicks[i].eat();//重寫超類方法\n" +
                        "            chicks[i].drink();//複用超類方法\n" +
                        "            chicks[i].layEgg();//雞類特定方法\n" +
                        "        }\n" +
                        "\n" +
                        "        //聲明Fish型數組fish，包含三個元素，默認值為null\n" +
                        "        Fish[] fish = new Fish[2];\n" +
                        "        fish[0] = new Fish(\"小金\", 2, \"金\");\n" +
                        "        fish[1] = new Fish(\"小銀\", 2, \"銀\");\n" +
                        "        for (int i = 0; i < fish.length; i++) {\n" +
                        "            System.out.println(\"======以下調用\" + fish[i].name + \"的屬性與行為======\");\n" +
                        "            /**\n" +
                        "             * 調用每隻魚的屬性\n" +
                        "             */\n" +
                        "            System.out.println(\"有一隻\" + fish[i].color + \"魚叫做\" + fish[i].name + \"，今年\" + fish[i].age + \"歲\");\n" +
                        "            System.out.println();\n" +
                        "            /**\n" +
                        "             * 調用每隻魚的行為\n" +
                        "             */\n" +
                        "            fish[i].eat();//重寫超類方法\n" +
                        "            fish[i].drink();//複用超類方法\n" +
                        "            fish[i].swim();//重寫接口方法\n" +
                        "        }\n" +
                        "\n" +
                        "    }\n" +
                        "}\n"
        );

        System.out.println("正在輸出程序結果......");

        //背景代碼存放區開始
        //聲明Dog型數組dogs，包含三個元素，默認值為null
        Dog[] dogs = new Dog[3];
        dogs[0] = new Dog("小黑", 2, "黑");
        dogs[1] = new Dog("小白", 3, "白");
        dogs[2] = new Dog("小黃", 4, "黃");
        for (int i = 0; i < dogs.length; i++) {
            System.out.println("======以下調用" + dogs[i].name + "的屬性與行為======");
            /**
             * 調用每隻狗的屬性
             */
            System.out.println("有一隻" + dogs[i].color + "狗叫做" + dogs[i].name + "，今年" + dogs[i].age + "歲");
            System.out.println();
            /**
             * 調用每隻狗的行為
             */
            dogs[i].eat();//重寫超類方法
            dogs[i].drink();//複用超類方法
            dogs[i].swim();//重寫接口方法
            dogs[i].lookHome();//狗類特定方法
            System.out.println("=========================================================================");
        }

        //聲明Chick型數組chicks，包含三個元素，默認值為null
        Chick[] chicks = new Chick[3];
        chicks[0] = new Chick("小紅", 1, "紅");
        chicks[1] = new Chick("小黑", 1, "黑");
        chicks[2] = new Chick("小花", 1, "花");
        for (int i = 0; i < chicks.length; i++) {
            System.out.println("======以下調用" + chicks[i].name + "的屬性與行為======");
            /**
             * 調用每隻雞的屬性
             */
            System.out.println("有一隻" + chicks[i].color + "雞叫做" + chicks[i].name + "，今年" + chicks[i].age + "歲");
            System.out.println();
            /**
             * 調用每隻雞的行為
             */
            chicks[i].eat();//重寫超類方法
            chicks[i].drink();//複用超類方法
            chicks[i].layEgg();//雞類特定方法
            System.out.println("=========================================================================");
        }

        //聲明Fish型數組fish，包含三個元素，默認值為null
        Fish[] fish = new Fish[2];
        fish[0] = new Fish("小金", 2, "金");
        fish[1] = new Fish("小銀", 2, "銀");
        for (int i = 0; i < fish.length; i++) {
            System.out.println("======以下調用" + fish[i].name + "的屬性與行為======");
            /**
             * 調用每隻魚的屬性
             */
            System.out.println("有一隻" + fish[i].color + "魚叫做" + fish[i].name + "，今年" + fish[i].age + "歲");
            System.out.println();
            /**
             * 調用每隻魚的行為
             */
            fish[i].eat();//重寫超類方法
            fish[i].drink();//複用超類方法
            fish[i].swim();//重寫接口方法
            System.out.println("=========================================================================");
        }

        //背景代碼存放區結束
        //=======================================================
        backToMenu();
    }

    /**
     * 第三題演示
     */
    public static void question3() throws InterruptedException {
        waitForPreparing();
        //=======================================================
        String[] args = {};
        Question3Show.main(args);
        System.out.println("請檢查桌面工具列以確定畫板程序是否被IDEA覆蓋......");
        //=======================================================
        backToMenu();
    }

    /**
     * 第四題演示
     */
    public static void question4() throws InterruptedException {
        waitForPreparing();
        //=======================================================

        //=======================================================
        backToMenu();
    }

    /**
     * 第五題演示
     */
    public static void question5() throws InterruptedException {
        waitForPreparing();
        //=======================================================

        //=======================================================
        backToMenu();
    }

    /**
     * 第六題演示
     */
    public static void question6() throws InterruptedException {
        waitForPreparing();
        //=======================================================

        //=======================================================
        backToMenu();
    }

    /**
     * 第七題演示
     */
    public static void question7() throws InterruptedException {
        waitForPreparing();
        //=======================================================

        //=======================================================
        backToMenu();
    }

    /**
     * 第八題演示
     */
    public static void question8() throws InterruptedException {
        waitForPreparing();
        //=======================================================

        //=======================================================
        backToMenu();
    }

    /**
     * 第九題演示
     */
    public static void question9() throws InterruptedException {
        waitForPreparing();
        //=======================================================

        //=======================================================
        backToMenu();
    }

    /**
     * 第十題演示
     */
    public static void question10() throws InterruptedException {
        waitForPreparing();
        //=======================================================

        //=======================================================
        backToMenu();
    }

}

class Question3Show extends JPanel {
    public static ImageIcon image;

    @Override
    public void paint(Graphics g) {
        image = new ImageIcon("src/ooday03/img/TmoocEmployeeSystemDesign.png");
        image.paintIcon(this, g, 0, 0);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        Question3Show panel = new Question3Show();
        frame.add(panel);
        frame.setSize(880 + 16, 601 + 39);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}


