package ooday02;

import java.util.Scanner;

/**
 * 繼承相關練習的作業類
 * HomeworkChecker.ver3.1
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
 * 20230325_XCX
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
        whatUChooseFromMenu(checker, questionList);//選題分支

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
            homeworkChecker();//進入系統
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
        System.out.println("請稍後...正在為您生成本題的演示過程...");
        Thread.sleep(1000);
    }

    /**
     * 結束的方法
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
class QuestionDatabase {
    /**
     * 將題目存入並生成題目列表(data)的方法:QB->HWC
     */
    public Question[] downloadQuestion() {
        Question[] data = new Question[2];//<<---------------------------------手動修改
        data[0] = new Question(1, "Person", "繼承相關練習");
        data[1] = new Question(2, "Animal", "繼承相關練習");
//        data[2] = new Question(3, "計算1~100數字和", "練習for循環");
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
        HomeworkCheckerTools.waitForPreparing();
        //=======================================================
        System.out.println("以下展示父類/超類------Person類");
        System.out.println(
                "class Person {\n" +
                        "    /**\n" +
                        "     * 共有屬性\n" +
                        "     */\n" +
                        "    String name;\n" +
                        "    int age;\n" +
                        "    String address;\n" +
                        "\n" +
                        "    public Person(String name, int age, String address) {\n" +
                        "        this.name = name;\n" +
                        "        this.age = age;\n" +
                        "        this.address = address;\n" +
                        "    }\n" +
                        "\n" +
                        "    /**\n" +
                        "     * 共有方法\n" +
                        "     */\n" +
                        "    void eat() {\n" +
                        "        System.out.println(name + \"正在吃飯...\");\n" +
                        "    }\n" +
                        "\n" +
                        "    void sleep() {\n" +
                        "        System.out.println(name + \"正在睡覺...\");\n" +
                        "    }\n" +
                        "\n" +
                        "    void sayHi() {\n" +
                        "        System.out.println(\"大家好，我叫\" + name + \"，今年\" + age + \"歲，來自\" + address);\n" +
                        "    }\n" +
                        "\n" +
                        "}"
        );

        System.out.println("以下展示子類/派生類------Student、Teacher及Doctor類");
        System.out.println(
                "class Student extends Person {\n" +
                        "    String className;\n" +
                        "    String stuId;\n" +
                        "\n" +
                        "    public Student(String name, int age, String address, String className, String stuId) {\n" +
                        "        super(name, age, address);\n" +
                        "        this.className = className;\n" +
                        "        this.stuId = stuId;\n" +
                        "    }\n" +
                        "\n" +
                        "    void study() {\n" +
                        "        System.out.println(name + \"同學正在用功念書......\");\n" +
                        "    }\n" +
                        "\n" +
                        "    @Override\n" +
                        "    void sayHi() {\n" +
                        "        super.sayHi();\n" +
                        "        System.out.println(\"目前就讀的是\" + className + \"班，學號為\" + stuId + \"，很高興認識大家\");\n" +
                        "    }\n" +
                        "}\n" +
                        "\n" +
                        "class Teacher extends Person {\n" +
                        "    double salary;\n" +
                        "\n" +
                        "    public Teacher(String name, int age, String address, double salary) {\n" +
                        "        super(name, age, address);\n" +
                        "        this.salary = salary;\n" +
                        "    }\n" +
                        "\n" +
                        "    void teach() {\n" +
                        "        System.out.println(name + \"老師正在教學......\");\n" +
                        "    }\n" +
                        "\n" +
                        "    @Override\n" +
                        "    void sayHi() {\n" +
                        "        super.sayHi();\n" +
                        "        System.out.println(\"目前是名老師，月薪約\" + salary + \"元\");\n" +
                        "    }\n" +
                        "}\n" +
                        "\n" +
                        "class Doctor extends Person{\n" +
                        "    String level;\n" +
                        "\n" +
                        "    Doctor(String name,int age,String address,String level){\n" +
                        "        super(name, age, address);\n" +
                        "        this.level = level;\n" +
                        "    }\n" +
                        "\n" +
                        "    void cut() {\n" +
                        "        System.out.println(name + \"醫師正在進行手術.....\");\n" +
                        "    }\n" +
                        "}\n"
        );

        System.out.println("以下為您展示聲明過程------PersonTest類");
        System.out.println(
                "class PersonTest {\n" +
                        "    public static void seDay01(String[] args) {\n" +
                        "        Student zs = new Student(\"張三\", 25, \"台北\", \"jsd2203\", \"001\");\n" +
                        "        //共有行為\n" +
                        "        zs.eat();\n" +
                        "        zs.sleep();\n" +
                        "        zs.sayHi();\n" +
                        "        //特定行為\n" +
                        "        zs.study();\n" +
                        "\n" +
                        "        Teacher ls = new Teacher(\"李四\", 45, \"台南\", 120000);\n" +
                        "        //共有行為\n" +
                        "        ls.eat();\n" +
                        "        ls.sleep();\n" +
                        "        ls.sayHi();\n" +
                        "        //特定行為\n" +
                        "        ls.teach();\n" +
                        "\n" +
                        "        Doctor ww = new Doctor(\"王五\", 55, \"台中\", \"急診\");\n" +
                        "        //共有行為\n" +
                        "        ww.eat();\n" +
                        "        ww.sleep();\n" +
                        "        ww.sayHi();\n" +
                        "        //特定行為\n" +
                        "        ww.cut();\n" +
                        "    }\n" +
                        "}"
        );

        //=======================================================
        HomeworkCheckerTools.backToMenu();
    }

    /**
     * 第二題演示
     */
    public static void question2() throws InterruptedException {
        HomeworkCheckerTools.waitForPreparing();
        //=======================================================
        System.out.println("以下展示父類/超類------Animal類");
        System.out.println(
                        "/**\n" +
                        " * 動物們的父類---Animal類\n" +
                        " */\n" +
                        "abstract class Animal {\n" +
                        "    String name;\n" +
                        "    int age;\n" +
                        "    String color;\n" +
                        "\n" +
                        "    Animal(String name, int age, String color) {\n" +
                        "        this.name = name;\n" +
                        "        this.age = age;\n" +
                        "        this.color = color;\n" +
                        "    }\n" +
                        "\n" +
                        "    void drink(){\n" +
                        "        System.out.println(color + \"色\" + age + \"歲的\" + name + \"正在喝水......\");\n" +
                        "    }\n" +
                        "\n" +
                        "    abstract void eat();\n" +
                        "}"
        );

        System.out.println("以下展示子類/派生類------Dog、Chick及Fish類");
        System.out.println(
                        "/**\n" +
                        " * 狗類\n" +
                        " */\n" +
                        "\n" +
                        "class Dog extends Animal{\n" +
                        "    Dog(String name, int age, String color) {\n" +
                        "        super(name, age, color);\n" +
                        "    }\n" +
                        "\n" +
                        "    void lookHome() {\n" +
                        "        System.out.println(name + \"正在看家......\");\n" +
                        "    }\n" +
                        "\n" +
                        "    @Override\n" +
                        "    void eat() {\n" +
                        "        System.out.println(name + \"小狗正在啃骨頭......\");\n" +
                        "    }\n" +
                        "}\n" +
                        "\n" +
                        "/**\n" +
                        " * 雞類\n" +
                        " */\n" +
                        "\n" +
                        "class Chick extends Animal{\n" +
                        "    Chick(String name, int age, String color) {\n" +
                        "        super(name, age, color);\n" +
                        "    }\n" +
                        "\n" +
                        "    void layEgg() {\n" +
                        "        System.out.println(name + \"正在下蛋呢......\");\n" +
                        "    }\n" +
                        "\n" +
                        "    @Override\n" +
                        "    void eat() {\n" +
                        "        System.out.println(name + \"小雞正在吃小米......\");\n" +
                        "    }\n" +
                        "}\n" +
                        "\n" +
                        "/**\n" +
                        " * 魚類\n" +
                        " */\n" +
                        "\n" +
                        "class Fish extends Animal{\n" +
                        "    Fish(String name, int age, String color) {\n" +
                        "        super(name, age, color);\n" +
                        "    }\n" +
                        "\n" +
                        "    @Override\n" +
                        "    void eat() {\n" +
                        "        System.out.println(name + \"小魚正在吃小蝦米......\");\n" +
                        "    }\n" +
                        "}"
        );

        System.out.println("以下為您展示聲明過程------AnimalTest類");
        System.out.println(
                "class AnimalTest {\n" +
                        "    public static void seDay01(String[] args) {\n" +
                        "        Dog dog = new Dog(\"來福\", 12, \"黑\");\n" +
                        "        dog.eat();//重寫方法\n" +
                        "        dog.drink();//共有方法\n" +
                        "        dog.lookHome();//特有方法\n" +
                        "\n" +
                        "        Chick chick = new Chick(\"嗶嗶\", 1, \"黃\");\n" +
                        "        chick.eat();//重寫方法\n" +
                        "        chick.drink();//共有方法\n" +
                        "        chick.layEgg();//特有方法\n" +
                        "\n" +
                        "        Fish fish = new Fish(\"提莫\", 30, \"橘\");\n" +
                        "        fish.eat();//重寫方法\n" +
                        "        fish.drink();//共有方法\n" +
                        "\n" +
                        "        Animal[] animalList = new Animal[12];//(3,4,5)\n" +
                        "        animalList[0] = new Dog(\"d1\",1,\"黑\");\n" +
                        "        animalList[1] = new Dog(\"d2\",2,\"白\");\n" +
                        "        animalList[2] = new Dog(\"d3\",3,\"花\");\n" +
                        "        animalList[3] = new Chick(\"c1\",1,\"紅\");\n" +
                        "        animalList[4] = new Chick(\"c2\",2,\"橙\");\n" +
                        "        animalList[5] = new Chick(\"c3\",3,\"黃\");\n" +
                        "        animalList[6] = new Chick(\"c4\",4,\"綠\");\n" +
                        "        animalList[7] = new Fish(\"f1\",1,\"藍\");\n" +
                        "        animalList[8] = new Fish(\"f2\",2,\"靛\");\n" +
                        "        animalList[9] = new Fish(\"f3\",3,\"紫\");\n" +
                        "        animalList[10] = new Fish(\"f4\",4,\"黑\");\n" +
                        "        animalList[11] = new Fish(\"f5\",5,\"白\");\n" +
                        "        for (int i = 0; i < animalList.length; i++) {\n" +
                        "            animalList[i].eat();\n" +
                        "            animalList[i].drink();\n" +
                        "        }\n" +
                        "\n" +
                        "    }\n" +
                        "}"
        );

        //=======================================================
        HomeworkCheckerTools.backToMenu();
    }

    /**
     * 第三題演示
     */
    public static void question3() throws InterruptedException {
        HomeworkCheckerTools.waitForPreparing();
        //=======================================================

        //=======================================================
        HomeworkCheckerTools.backToMenu();
    }

    /**
     * 第四題演示
     */
    public static void question4() throws InterruptedException {
        HomeworkCheckerTools.waitForPreparing();
        //=======================================================

        //=======================================================
        HomeworkCheckerTools.backToMenu();
    }

    /**
     * 第五題演示
     */
    public static void question5() throws InterruptedException {
        HomeworkCheckerTools.waitForPreparing();
        //=======================================================

        //=======================================================
        HomeworkCheckerTools.backToMenu();
    }

    /**
     * 第六題演示
     */
    public static void question6() throws InterruptedException {
        HomeworkCheckerTools.waitForPreparing();
        //=======================================================

        //=======================================================
        HomeworkCheckerTools.backToMenu();
    }

    /**
     * 第七題演示
     */
    public static void question7() throws InterruptedException {
        HomeworkCheckerTools.waitForPreparing();
        //=======================================================

        //=======================================================
        HomeworkCheckerTools.backToMenu();
    }

    /**
     * 第八題演示
     */
    public static void question8() throws InterruptedException {
        HomeworkCheckerTools.waitForPreparing();
        //=======================================================

        //=======================================================
        HomeworkCheckerTools.backToMenu();
    }

    /**
     * 第九題演示
     */
    public static void question9() throws InterruptedException {
        HomeworkCheckerTools.waitForPreparing();
        //=======================================================

        //=======================================================
        HomeworkCheckerTools.backToMenu();
    }

    /**
     * 第十題演示
     */
    public static void question10() throws InterruptedException {
        HomeworkCheckerTools.waitForPreparing();
        //=======================================================

        //=======================================================
        HomeworkCheckerTools.backToMenu();
    }

}


