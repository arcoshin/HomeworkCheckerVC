package ooday05;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 訪問修飾符、final、static、枚舉的相關練習作業類
 * HomeworkChecker.ver3.8
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

        int checker = 0;
        try {
            checker = new Scanner(System.in).nextInt();//接收檢測者的選擇
        } catch (Exception e) {

        }

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
    protected static void whatUChooseFromMenu (int checker ,Question[] questionList) throws InterruptedException {
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
    protected static void showQuestionList(Question[] questionList ,int max) {
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
class QuestionDatabase extends HomeworkCheckerTools{
    /**
     * 將題目存入並生成題目列表(data)的方法:QB->HWC
     */
    public Question[] downloadQuestion() {
        Question[] data = new Question[4];//<<---------------------------------手動修改
        data[0] = new Question(1, "Point類與GetterSetter類", "演示訪問修飾符練習");
        data[1] = new Question(2, "StaticVar,StaticMethod,StaticBlock,StaticDemo...等類", "演示Static相關練習");
        data[2] = new Question(3, "StaticFinalDemo類", "常量相關練習");
        data[3] = new Question(4, "Seasons與EnumTest相關演示", "枚舉相關練習");
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
                        " * 點類\n" +
                        " */\n" +
                        "public class Point {\n" +
                        "    private int x;\n" +
                        "    private int y;\n" +
                        "\n" +
                        "    public int getX() {\n" +
                        "        return x;\n" +
                        "    }\n" +
                        "\n" +
                        "    public void setX(int x) {\n" +
                        "        this.x = x;\n" +
                        "    }\n" +
                        "\n" +
                        "    public int getY() {\n" +
                        "        return y;\n" +
                        "    }\n" +
                        "\n" +
                        "    public void setY(int y) {\n" +
                        "        this.y = y;\n" +
                        "    }\n" +
                        "\n" +
                        "    @Override\n" +
                        "    public String toString() {\n" +
                        "        return \"Point{\" +\n" +
                        "                \"x=\" + x +\n" +
                        "                \", y=\" + y +\n" +
                        "                '}';\n" +
                        "    }\n" +
                        "}\n" +
                        "\n" +
                        "class GetterSetterDemo {\n" +
                        "    public static void seDay01(String[] args) {\n" +
                        "        Point p = new Point();\n" +
                        "        /**\n" +
                        "         * 相當於\n" +
                        "         * p.x = 1;\n" +
                        "         * p.y = 2;\n" +
                        "         */\n" +
                        "        p.setX(1);\n" +
                        "        p.setY(2);\n" +
                        "\n" +
                        "        /**\n" +
                        "         * 相當於\n" +
                        "         * int x = p.x\n" +
                        "         * int y = p.y\n" +
                        "         * System.out.println(x,y);\n" +
                        "         */\n" +
                        "        int x = p.getX();\n" +
                        "        int y = p.getY();\n" +
                        "\n" +
                        "        System.out.println(p);\n" +
                        "    }\n" +
                        "}\n"
        );
        System.out.println("以下為您展示運行結果========================================================");
        //背景代碼儲存區開始
        Point p = new Point();

        p.setX(1);
        p.setY(2);

        int x = p.getX();
        int y = p.getY();

        System.out.println(p);
        //背景代碼儲存區結束
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
                        " * 靜態關鍵字演示類 : 靜態變量 靜態方法 靜態代碼塊\n" +
                        " */\n" +
                        "public class StaticDemo {\n" +
                        "    public static void seDay01(String[] args) {\n" +
                        "        /**\n" +
                        "         * 一個類中的成員變量包含兩種: 實例變量 與 靜態變量(或稱類變量)\n" +
                        "         * 實例變量屬於對象，只能通過對象訪問\n" +
                        "         * 靜態變量屬於類本身，一般建議使用類名打點訪問\n" +
                        "         *\n" +
                        "         * 又靜態資源全類共享，\n" +
                        "         * 因此本案例可發現靜態資源出現了累加現象(所有修改共用一份數據)\n" +
                        "         */\n" +
                        "        StaticVar o1 = new StaticVar();\n" +
                        "        o1.show();\n" +
                        "\n" +
                        "        StaticVar o2 = new StaticVar();\n" +
                        "        o2.show();\n" +
                        "\n" +
                        "        StaticVar o3 = new StaticVar();\n" +
                        "        o3.show();\n" +
                        "\n" +
                        "\n" +
                        "        /**\n" +
                        "         * 靜態代碼塊於內存中，是在加載類時就執行一次\n" +
                        "         * 因此會在構造器(方法)之前執行，而且只會執行一次\n" +
                        "         */\n" +
                        "        StaticBlock s1 = new StaticBlock();\n" +
                        "        StaticBlock s2 = new StaticBlock();\n" +
                        "        StaticBlock s3 = new StaticBlock();\n" +
                        "\n" +
                        "\n" +
                        "    }\n" +
                        "}\n" +
                        "\n" +
                        "/**\n" +
                        " * 成員變量解釋類: 包含 實例變量 與 靜態變量\n" +
                        " */\n" +
                        "class StaticVar {\n" +
                        "    int a;//實例變量\n" +
                        "    static int b;//靜態變量\n" +
                        "\n" +
                        "    public StaticVar() {\n" +
                        "        a++;\n" +
                        "        b++;\n" +
                        "    }\n" +
                        "\n" +
                        "    void show() {\n" +
                        "        System.out.println(\"a=\" + a + \",b=\" + b);\n" +
                        "    }\n" +
                        "}\n" +
                        "\n" +
                        "/**\n" +
                        " * 靜態方法演示類\n" +
                        " */\n" +
                        "class StaticMethod {\n" +
                        "    int a; //實例變量，由對象訪問\n" +
                        "    static int b;//靜態變量(類變量)，由類名訪問\n" +
                        "\n" +
                        "    void show(){//有隱式this(系統默認提供，因為實例資源屬於對象，this即是指代調用的當前對象)\n" +
                        "        System.out.println(this.a);//完整寫法\n" +
                        "        System.out.println(StaticMethod.b);//完整寫法\n" +
                        "    }\n" +
                        "\n" +
                        "    static void test() {//無隱式this，因為靜態資源屬於類\n" +
                        "        /**\n" +
                        "         * 無隱式this代表沒有對象調用\n" +
                        "         * 但實例變量只能通過實例對象調用\n" +
                        "         * 所以此處代碼編譯錯誤\n" +
                        "         */\n" +
                        "\n" +
                        "//        System.out.println(a);//編譯錯誤，靜態方法中不可直接訪實例成員\n" +
                        "        StaticMethod s = new StaticMethod();\n" +
                        "        System.out.println(s.a);//生成實例就可以，但一般不這麼做\n" +
                        "\n" +
                        "        System.out.println(b);//完整寫法，默認類名打點訪問\n" +
                        "    }\n" +
                        "}\n" +
                        "\n" +
                        "/**\n" +
                        " * 靜態代碼塊\n" +
                        " */\n" +
                        "class StaticBlock {\n" +
                        "    static {//靜態代碼塊\n" +
                        "        System.out.println(\"靜態代碼塊\");\n" +
                        "    }\n" +
                        "\n" +
                        "    public StaticBlock() {\n" +
                        "        System.out.println(\"構造方法\");\n" +
                        "    }\n" +
                        "}\n"
        );
        System.out.println("以下為您展示運行結果========================================================");
        //背景代碼儲存區開始
        StaticVar o1 = new StaticVar();
        o1.show();

        StaticVar o2 = new StaticVar();
        o2.show();

        StaticVar o3 = new StaticVar();
        o3.show();

        StaticBlock s1 = new StaticBlock();
        StaticBlock s2 = new StaticBlock();
        StaticBlock s3 = new StaticBlock();
        //背景代碼儲存區結束
        //=======================================================
        backToMenu();
    }

    /**
     * 第三題演示
     */
    public static void question3() throws InterruptedException {
        waitForPreparing();
        //=======================================================
        System.out.println("以下為您展示代碼===========================================================");
        System.out.println(
                        "/**\n" +
                        " * 常量演示類\n" +
                        " */\n" +
                        "class StaticFinalDemo {\n" +
                        "    public static void seDay01(String[] args) {\n" +
                        "        System.out.println(\"PI = \" + Loo.PI);//常量具備static修飾，屬於靜態資源，也是透過類名調用\n" +
                        "    }\n" +
                        "}\n" +
                        "\n" +
                        "//常量演示\n" +
                        "class Loo {\n" +
                        "    public final static double PI = 3.14159;//通常是公開的，標準的常量聲明\n" +
                        "//    public final static double NUM;//編譯錯誤，常量必須在聲明時一併初始化，且後續即無法更改\n" +
                        "}"
        );
        System.out.println("以下為您展示運行結果========================================================");
        //背景代碼儲存區開始
        System.out.println("PI = " + Loo.PI);//常量具備static修飾，屬於靜態資源，也是透過類名調用
        //背景代碼儲存區結果
        //=======================================================
        backToMenu();
    }

    /**
     * 第四題演示
     */
    public static void question4() throws InterruptedException {
        waitForPreparing();
        //=======================================================
        System.out.println("以下為您展示代碼===========================================================");
        System.out.println(
                        "/**\n" +
                        " * 枚舉測試類\n" +
                        " */\n" +
                        "public class EnumTest {\n" +
                        "    public static void seDay01(String[] args) {\n" +
                        "        /**\n" +
                        "         * 遍歷枚舉\n" +
                        "         */\n" +
                        "        Seasons[] seasons = Seasons.values();//Seasons.values():獲取所有枚舉對象並返回數組類型\n" +
                        "        System.out.println(Arrays.toString(seasons));//遍歷數組\n" +
                        "\n" +
                        "        /**\n" +
                        "         * 枚舉的生成\n" +
                        "         */\n" +
                        "//        Seasons o = new Seasons();//編譯錯誤，枚舉構造器為私有的，無法像類一樣直接調用\n" +
                        "        Seasons s = Seasons.WINTER;//獲取WINTER對象\n" +
                        "        switch (s) {//switch天生識別枚舉，所以case不需要加類名打點調用(後期常常搭配使用)\n" +
                        "            case SPRING:\n" +
                        "                System.out.println(\"春天到了...\");\n" +
                        "                break;\n" +
                        "            case SUMMER:\n" +
                        "                System.out.println(\"夏天到了...\");\n" +
                        "                break;\n" +
                        "            case AUTUMN:\n" +
                        "                System.out.println(\"秋天到了...\");\n" +
                        "                break;\n" +
                        "            case WINTER:\n" +
                        "                System.out.println(\"冬天到了...\");\n" +
                        "                break;\n" +
                        "        }\n" +
                        "    }\n" +
                        "}\n" +
                        "\n" +
                        "/**\n" +
                        " * 枚舉類範例 : 季節枚舉\n" +
                        " */\n" +
                        "enum Seasons {\n" +
                        "    SPRING,SUMMER,AUTUMN,WINTER;//表示Seasons中固定的四個對象都是常量\n" +
                        "}"
        );

        System.out.println(
                        "/**\n" +
                        " * 枚舉類的另外一種演示\n" +
                        " */\n" +
                        "enum Seasons {\n" +
                        "    SPRING(\"春天\", \"溫暖\"),\n" +
                        "    SUMMER(\"夏天\", \"炎熱\"),\n" +
                        "    AUTUMN(\"秋天\", \"涼爽\"),\n" +
                        "    WINTER(\"冬天\", \"寒冷\"),\n" +
                        "    ;\n" +
                        "    private String seasonName;//季節名稱\n" +
                        "    private String seasonDesc;//季節描述\n" +
                        "\n" +
                        "    Seasons(String seasonName, String seasonDesc) {\n" +
                        "        this.seasonName = seasonName;\n" +
                        "        this.seasonDesc = seasonDesc;\n" +
                        "    }\n" +
                        "\n" +
                        "    public String getSeasonName() {\n" +
                        "        return seasonName;\n" +
                        "    }\n" +
                        "\n" +
                        "    public void setSeasonName(String seasonName) {\n" +
                        "        this.seasonName = seasonName;\n" +
                        "    }\n" +
                        "\n" +
                        "    public String getSeasonDesc() {\n" +
                        "        return seasonDesc;\n" +
                        "    }\n" +
                        "\n" +
                        "    public void setSeasonDesc(String seasonDesc) {\n" +
                        "        this.seasonDesc = seasonDesc;\n" +
                        "    }\n" +
                        "\n" +
                        "    @Override\n" +
                        "    public String toString() {\n" +
                        "        return \"(\"\n" +
                        "                + seasonName\n" +
                        "                + ','\n" +
                        "                + seasonDesc +\n" +
                        "                ')';\n" +
                        "    }\n" +
                        "}\n" +
                        "\n" +
                        "public class EnumDemo {\n" +
                        "    public static void seDay01(String[] args) {\n" +
                        "        Seasons s = Seasons.WINTER;\n" +
                        "        System.out.println(s);\n" +
                        "\n" +
                        "        Seasons[] seasons = Seasons.values();\n" +
                        "        System.out.println(\"Seasons = \" + Arrays.toString(seasons));\n" +
                        "\n" +
                        "\n" +
                        "    }\n" +
                        "}\n"
        );
        System.out.println("以下為您展示運行結果========================================================");
        //背景代碼儲存區開始

        /**
         * 遍歷枚舉
         */
        Seasons[] seasons = Seasons.values();//Seasons.values():獲取所有枚舉對象並返回數組類型
        System.out.println(Arrays.toString(seasons));//遍歷數組

        /**
         * 枚舉的生成
         */
        Seasons s = Seasons.WINTER;//獲取WINTER對象
        switch (s) {
            case SPRING:
                System.out.println("春天到了...");
                break;
            case SUMMER:
                System.out.println("夏天到了...");
                break;
            case AUTUMN:
                System.out.println("秋天到了...");
                break;
            case WINTER:
                System.out.println("冬天到了...");
                break;
        }
        System.out.println("另一種演示的結果...");
        System.out.println(
                        "(冬天,寒冷)\n" +
                        "Seasons = [(春天,溫暖), (夏天,炎熱), (秋天,涼爽), (冬天,寒冷)]\n"
        );
        //背景代碼儲存區結束
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


