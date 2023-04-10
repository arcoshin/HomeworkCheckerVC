package ooday04;

import java.util.Scanner;

/**
 * weekendHomework 2023.0X.XX
 * 作業類/周末作業類
 * HomeworkChecker.ver3.7
 *
 *
 *
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
        showQuestionList(questionList,questionList.length);//遍歷所有題目


        /**
         * 聲明scanner對象接收檢測員輸入的選擇
         */
        int checker = new Scanner(System.in).nextInt();//接收檢測者的選擇

        /**
         * 作業查找分支系統
         */
        whatUChooseFromMenu(checker,questionList);//將選擇派入選題分支

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
     * @param checker 跳轉目標的代碼
     * @param questionList 跳轉目標的名稱
     */
    protected static void whatUChooseFromMenu (int checker , Question[] questionList) throws InterruptedException {
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
     * @param max 本次開放題數
     */
    protected static void showQuestionList(Question[] questionList , int max) {
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
class QuestionDatabase extends HomeworkCheckerTools {
    /**
     * 將題目存入並生成題目列表(data)的方法:QB->HWC
     */
    public Question[] downloadQuestion() {
        Question[] data = new Question[2];//<<---------------------------------手動修改
        data[0] = new Question(1, "動物類相關練習", "多態應用");
        data[1] = new Question(2, "匿名內部類練習", "創建兩個匿名內部類對象");
//        data[2] = new Question(3, "", "");
//        data[3] = new Question(4, "", "");
//        data[4] = new Question(5, "", "");
//        data[5] = new Question(6, "", "");
//        data[6] = new Question(7, "", "");
//        data[7] = new Question(8, "", "");
//        data[8] = new Question(9, "", "");
//        data[9] = new Question(10, "", "");
        return data;
    }

    /**
     * 第一題演示
     */
    public static void question1() throws InterruptedException {
        waitForPreparing();
        //=======================================================
        System.out.println("以下為您展示代碼===========================================================");
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
                        "class Dog extends Animal implements Swim {\n" +
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
                        "        System.out.println(color + \"色\" + age + \"歲的狗狗\" + name + \"正在看家......\");\n" +
                        "    }\n" +
                        "\n" +
                        "    /**\n" +
                        "     * 重寫超類抽象方法\n" +
                        "     */\n" +
                        "    @Override\n" +
                        "    void eat() {\n" +
                        "        System.out.println(color + \"色\" + age + \"歲的狗狗\" + name + \"正在啃骨頭......\");\n" +
                        "    }\n" +
                        "\n" +
                        "    /**\n" +
                        "     * 重寫接口中的方法 : 一律必須public\n" +
                        "     */\n" +
                        "    @Override\n" +
                        "    public void swim() {\n" +
                        "        System.out.println(color + \"色\" + age + \"歲的狗狗\" + name + \"正在游泳......\");\n" +
                        "    }\n" +
                        "}\n" +
                        "\n" +
                        "/**\n" +
                        " * 雞類\n" +
                        " */\n" +
                        "class Chick extends Animal {\n" +
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
                        "        System.out.println(color + \"色\" + age + \"歲的小雞\" + name + \"正在下蛋呢......\");\n" +
                        "    }\n" +
                        "\n" +
                        "    /**\n" +
                        "     * 重寫超類抽象方法\n" +
                        "     */\n" +
                        "    @Override\n" +
                        "    void eat() {\n" +
                        "        System.out.println(color + \"色\" + age + \"歲的小雞\" + name + \"正在吃小米......\");\n" +
                        "    }\n" +
                        "}\n" +
                        "\n" +
                        "/**\n" +
                        " * 魚類\n" +
                        " */\n" +
                        "class Fish extends Animal implements Swim {\n" +
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
                        "        System.out.println(color + \"色\" + age + \"歲的小魚兒\" + name + \"正在吃小蝦米......\");\n" +
                        "    }\n" +
                        "\n" +
                        "    /**\n" +
                        "     * 重寫接口中的方法 : 一律必須public\n" +
                        "     */\n" +
                        "    @Override\n" +
                        "    public void swim() {\n" +
                        "        System.out.println(color + \"色\" + age + \"歲的小魚兒\" + name + \"正在游泳......\");\n" +
                        "    }\n" +
                        "}\n" +
                        "\n" +
                        "/**\n" +
                        " * 游泳接口類\n" +
                        " */\n" +
                        "interface Swim {\n" +
                        "    /**\n" +
                        "     * 接口中已經默認所有方法結為\"抽象方法\"---故\"abstract\"為灰色\n" +
                        "     * 看似普通方法，但接口中已經默認所有方法的前綴有\"abstract\"，意即實為抽象方法，不可有方法體\n" +
                        "     */\n" +
                        "    abstract void swim();\n" +
                        "}\n" +
                        "\n" +
                        "/**\n" +
                        " * 飼主類\n" +
                        " */\n" +
                        "class Master {\n" +
                        "    /**\n" +
                        "     * 餵動物的行為 ------可發現若傳參類型為子類，系統會自動向上造型\n" +
                        "     */\n" +
                        "    void feed(Animal animal) {\n" +
                        "        animal.eat();\n" +
                        "    }\n" +
                        "//    /**\n" +
                        "//     * 餵狗的行為\n" +
                        "//     */\n" +
                        "//    void feed(Dog dog) {\n" +
                        "//        dog.eat();\n" +
                        "//    }\n" +
                        "//    /**\n" +
                        "//     * 餵雞的行為\n" +
                        "//     */\n" +
                        "//    void feed(Chick chick) {\n" +
                        "//        chick.eat();\n" +
                        "//    }\n" +
                        "//    /**\n" +
                        "//     * 餵魚的行為\n" +
                        "//     */\n" +
                        "//    void feed(Fish fish) {\n" +
                        "//        fish.eat();\n" +
                        "//    }\n" +
                        "}\n" +
                        "\n" +
                        "/**\n" +
                        " * 多態演示類\n" +
                        " */\n" +
                        "class AnimalDemo {\n" +
                        "    public static void seDay01(String[] args) {\n" +
                        "        //聲明Animal型數組animals，包含三個Dog型元素，三個Chick型元素，兩個Fish型元素------向上造型(自動類型轉換)\n" +
                        "        Animal[] animals = new Animal[3 + 3 + 2];\n" +
                        "        for (int i = 0; i < animals.length; i++) {\n" +
                        "            animals[0] = new Dog(\"小黑\", 1, \"黑\");\n" +
                        "            animals[1] = new Dog(\"小黃\", 1, \"黃\");\n" +
                        "            animals[2] = new Dog(\"小白\", 1, \"白\");\n" +
                        "            animals[3] = new Chick(\"小黑\", 1, \"黑\");\n" +
                        "            animals[4] = new Chick(\"小白\", 1, \"白\");\n" +
                        "            animals[5] = new Chick(\"小黃\", 1, \"黃\");\n" +
                        "            animals[6] = new Fish(\"小黑\", 1, \"黑\");\n" +
                        "            animals[7] = new Fish(\"小白\", 1, \"白\");\n" +
                        "\n" +
                        "            /**\n" +
                        "             * 訪問屬性與方法時，是由該對象目前的類型決定 : 目前全部向上造型(自動類型轉換)為Animal型\n" +
                        "             */\n" +
                        "            System.out.println(animals[i].name);//輸出每隻動物的名字\n" +
                        "            animals[i].eat();//每隻動物吃飯\n" +
                        "            animals[i].drink();//每隻動物喝水\n" +
                        "\n" +
                        "            /**\n" +
                        "             * 若要訪問特有數據 : 現在可以使用instanceof確認類型是否匹配，如是則向下轉型(強制轉換)為所匹配類型，即可調用特有屬性\n" +
                        "             */\n" +
                        "            Master master = new Master();\n" +
                        "            if (animals[i] instanceof Dog) {//與Dog類型匹配時\n" +
                        "                ((Dog) animals[i]).lookHome();//強轉後調用狗類特有方法\n" +
                        "//  冗餘              //((Dog) animals[i]).swim();//強轉後調用狗類接口方法---------------------------但是代碼冗餘\n" +
                        "                master.feed(animals[i]);//餵養動物方法的形參限定動物類 : 此處可發現調用方法傳參時，系統可以自動向上造型(自動類型轉換)\n" +
                        "            }\n" +
                        "\n" +
                        "            if (animals[i] instanceof Chick) {//與Chick類型匹類時\n" +
                        "                ((Chick) animals[i]).layEgg();//強轉後調用雞類特有方法\n" +
                        "                master.feed(animals[i]);//餵養動物方法的形參限定動物類 : 此處可發現調用方法傳參時，系統可以自動向上造型(自動類型轉換)\n" +
                        "            }\n" +
                        "\n" +
                        "//  冗餘          if (animals[i] instanceof Fish) {//與Fish類型匹類時\n" +
                        "//  冗餘              //((Fish) animals[i]).swim();//強轉後調用魚類接口方法---------------------------但是代碼冗餘\n" +
                        "//  冗餘              master.feed(animals[i]);//餵養動物方法的形參限定動物類 : 此處可發現調用方法傳參時，系統可以自動向上造型(自動類型轉換)\n" +
                        "//  冗餘          }\n" +
                        "\n" +
                        "            /**\n" +
                        "             * 解決代碼冗餘 : 游泳接口為重複，以多態的概念強轉後調用，可以有效解決代碼冗餘問題(可讀性、擴展性都更好)\n" +
                        "             */\n" +
                        "            if (animals[i] instanceof Swim) {//適用於所有實現Swim接口的類\n" +
                        "                ((Swim) animals[i]).swim();//以多態的概念解決代碼冗與\n" +
                        "            }\n" +
                        "\n" +
                        "            /**\n" +
                        "             * 大師心得 : 代碼能父類絕不子類，大範圍的複用性、兼容性以及養護性都較高\n" +
                        "             */\n" +
                        "        }\n" +
                        "    }\n" +
                        "}"
        );
        System.out.println("以下為您展示運行結果.=======================================================");
        //背景代碼存放區開始=========================================================================================
        //聲明Animal型數組animals，包含三個Dog型元素，三個Chick型元素，兩個Fish型元素------向上造型(自動類型轉換)
        Animal[] animals = new Animal[3 + 3 + 2];
        for (int i = 0; i < animals.length; i++) {
            animals[0] = new Dog("小黑", 1, "黑");
            animals[1] = new Dog("小黃", 1, "黃");
            animals[2] = new Dog("小白", 1, "白");
            animals[3] = new Chick("小黑", 1, "黑");
            animals[4] = new Chick("小白", 1, "白");
            animals[5] = new Chick("小黃", 1, "黃");
            animals[6] = new Fish("小黑", 1, "黑");
            animals[7] = new Fish("小白", 1, "白");

            System.out.println(animals[i].name);//輸出每隻動物的名字
            animals[i].eat();//每隻動物吃飯
            animals[i].drink();//每隻動物喝水

            Master master = new Master();
            if (animals[i] instanceof Dog) {//與Dog類型匹配時
                ((Dog) animals[i]).lookHome();//強轉後調用狗類特有方法
                master.feed(animals[i]);//餵養動物方法的形參限定動物類 : 此處可發現調用方法傳參時，系統可以自動向上造型(自動類型轉換)
            }

            if (animals[i] instanceof Chick) {//與Chick類型匹類時
                ((Chick) animals[i]).layEgg();//強轉後調用雞類特有方法
                master.feed(animals[i]);//餵養動物方法的形參限定動物類 : 此處可發現調用方法傳參時，系統可以自動向上造型(自動類型轉換)
            }

            if (animals[i] instanceof Swim) {//適用於所有實現Swim接口的類
                ((Swim) animals[i]).swim();//以多態的概念解決代碼冗與
            }
        }
        //背景代碼存放區結束=========================================================================================
        //=======================================================
        backToMenu();
    }

    /**
     * 第二題演示
     */
    public static void question2() throws InterruptedException {
        waitForPreparing();
        //=======================================================
        System.out.println("以下為您展示代碼===========================================================");
        System.out.println(
                        "/**\n" +
                        " * 匿名內部類的演示類 : 應用率高，要重點掌握!!!\n" +
                        " * 特別重點:\n" +
                        " *\n" +
                        " * 1.若想創建一派生類對象，且該對象只創建一次，則推薦使用，可以大幅簡化代碼\n" +
                        " *\n" +
                        " * 2.匿名內部類不可以修改外面局部變量的值\n" +
                        " *\n" +
                        " * 3.面試題 : 匿名內部類有獨立的class文件嗎? (字節碼文件)  答 : 有!!!所有內部類都有!\n" +
                        " * 在專案資料夾/out資料夾/當前文件所在包位置/可以發現 : 外部類名 + $ + 內部類名(此處匿名內部類則為1,2,3,4).class文件即是\n" +
                        " */\n" +
                        "public class AnonInnerClassDemo {\n" +
                        "    public static void seDay01(String[] args) {\n" +
                        "        /**\n" +
                        "         * 匿名內部類時，系統自動完成了兩件事\n" +
                        "         * 1).\"創建了Aoo的派生類\"，但是該類沒有名字!\n" +
                        "         * 2).為該派生類創造了一個對象，名為o1，並且\"向上造型為Aoo類型!\"\n" +
                        "         * 3).大括號中的內容為派生類的類體\n" +
                        "         */\n" +
                        "        Aoo o1 = new Aoo() {//匿名內部類\n" +
                        "            /**\n" +
                        "             * 既是派生類(子類)，則超類(父類)中的抽象方法必須重寫完整\n" +
                        "             */\n" +
                        "            @Override\n" +
                        "            void show() {\n" +
                        "                System.out.println(\"此處已成功執行抽象類Aoo的子類對象，o1的show()的方法...\");\n" +
                        "            }\n" +
                        "        };\n" +
                        "\n" +
                        "        /**\n" +
                        "         * 匿名內部類時，系統自動完成了兩件事\n" +
                        "         * 1).\"創建了Aoo的派生類\"，但是該類沒有名字!\n" +
                        "         * 2).為該派稱類創造了一個對象，名為o2，並且\"向上轉型為Aoo類型!\"\n" +
                        "         * 3).大括號中的內容為派生類的類體\n" +
                        "         */\n" +
                        "        Aoo o2 = new Aoo() {//匿名內部類\n" +
                        "            /**\n" +
                        "             * 既是派生類(子類)，則超類(父類)中的抽象方法必須重寫完整\n" +
                        "             */\n" +
                        "            @Override\n" +
                        "            void show() {\n" +
                        "                System.out.println(\"此處已成功執行抽象類Aoo的子類對象，o2的show()的方法...\");\n" +
                        "            }\n" +
                        "        };\n" +
                        "\n" +
                        "        /**\n" +
                        "         * 可以生成非常多次的 new Aoo(){}\n" +
                        "         * 但本質上是產生Aoo無數個新的派生類然後再創建該類對象\n" +
                        "         * 因此o1,o2...等匿名內部類對象之間，其實並沒有關係!!!!!\n" +
                        "         * 另外要特別注意 : 匿名內部類不可以修改外部成員變量的值!!!!!!\n" +
                        "         */\n" +
                        "\n" +
                        "        /**\n" +
                        "         * 調用匿名內部類的資源，則直接使用該派生類的對象調用即可\n" +
                        "         */\n" +
                        "        o1.show();\n" +
                        "        o2.show();\n" +
                        "\n" +
                        "        /**\n" +
                        "         * 接口的匿名內部類 :\n" +
                        "         * 直接以線程任務類為例，並重寫執行體run\n" +
                        "         */\n" +
                        "        Runnable r1 = new Runnable() {\n" +
                        "            @Override\n" +
                        "            public void run() {\n" +
                        "                System.out.println(\"線程任務A已確實執行......\");\n" +
                        "            }\n" +
                        "        };\n" +
                        "        new Thread(r1).start();//聲明一線程對象，排程任務A，並啟動線程\n" +
                        "\n" +
                        "        Runnable r2 = new Runnable() {\n" +
                        "            @Override\n" +
                        "            public void run() {\n" +
                        "                System.out.println(\"線程任務B已確實執行......\");\n" +
                        "            }\n" +
                        "        };\n" +
                        "        new Thread(r2).start();//聲明一線程對象，排程任務B，並啟動線程\n" +
                        "    }\n" +
                        "}\n" +
                        "\n" +
                        "/**\n" +
                        " * 抽象類範例\n" +
                        " */\n" +
                        "abstract class Aoo {\n" +
                        "    abstract void show();\n" +
                        "}\n"
        );
        System.out.println("以下為您展示運行結果.=======================================================");
        //背景代碼存放區開始=========================================================================================
        Aoo o1 = new Aoo() {//匿名內部類
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
         * 調用匿名內部類的資源
         */
        o1.show();
        o2.show();

        /**
         * 接口的匿名內部類 :
         */
        Runnable r1 = new Runnable() {//實現一線程任務接口
            @Override
            public void run() {
                System.out.println("線程任務A已確實執行......");
            }
        };
        new Thread(r1).start();//聲明一線程對象，排程任務A，並啟動線程

        Runnable r2 = new Runnable() {//實現一線程任務接口
            @Override
            public void run() {
                System.out.println("線程任務B已確實執行......");
            }
        };
        new Thread(r2).start();//聲明一線程對象，排程任務B，並啟動線程

        //背景代碼存放區結束=========================================================================================
        //=======================================================
        Runnable r3 = new Runnable() {
            @Override
            public void run() {
                try {
                    backToMenu();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        new Thread(r3).start();//聲明一線程對象，排程回到主頁的程序，並啟動線程
    }

    /**
     * 第三題演示
     */
    public static void question3() throws InterruptedException {
        waitForPreparing();
        //=======================================================

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


