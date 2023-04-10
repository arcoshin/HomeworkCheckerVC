package stringRegex;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

/**
 * weekendHomework 2023.04.01
 * String、Regex、包裝類練習作業類
 * HomeworkChecker.ver3.8
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
 * 20230401_XCX
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
        int checker = 0;
        try {
            checker = new Scanner(System.in).nextInt();//接收檢測者的選擇
        } catch (Exception e) {//保證任何異常都能繼續執行

        }

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
    int questionNum;//題目序號
    String questionName;//題目名稱
    String questionContent;//題目要求內文

    /**
     * @param questionNum     題目序號
     * @param questionName    題目名稱
     * @param questionContent 題目要求內文
     */
    public Question(int questionNum, String questionName, String questionContent) {
        this.questionNum = questionNum;
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
            HomeworkChecker.homeworkChecker();//回選單重選
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
            System.out.println(questionList[i].questionNum + "." + questionList[i].questionName);
            System.out.println(questionList[i].questionContent);
            System.out.println();
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
     * 預告即將為您展示代碼運行結果的方法
     */
    protected static void willShowURun() {
        System.out.println("以下為您展示運行結果......");
    }

    /**
     * 預告即將為您展示代碼運行結果的方法
     */
    protected static void willShowUCode() {
        System.out.println("以下為您展示代碼......");
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
        Question[] data = new Question[3];//<<---------------------------------手動修改
        data[0] = new Question(1, "StringAPI about Regex", "String類型中支持正則表達式的相關方法");
        data[1] = new Question(2, "Object類", "設計Point類，重寫toString&equals");
        data[2] = new Question(3, "包裝類", "相關轉換、自動拆裝箱及常見的兩個應用");
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
        System.out.println("請選擇要看的小題: 1.matches()方法 2.replaceAll()方法 3.split()方法 99.跳回大題選單");
        int checker = 0;
        try {
            checker = new Scanner(System.in).nextInt();
        } catch (Exception e) {

        }

        if (checker >= 1 && checker <= 3) {
            toQuestion1(checker);
            return;
        } else if (checker == 99){
            HomeworkChecker.homeworkChecker();
            return;
        } else {
            uRWrong();
            question1();
        }
        //=======================================================
        //背景代碼存放區開始----------------------------------------
        //背景代碼存放區結束----------------------------------------
        backToMenu();
    }

    public static void toQuestion1(int n) throws InterruptedException {
        switch (n) {
            case 1:
                whatYouChoose("1-1.matches()方法");
                willShowUCode();
                System.out.println(
                        "/**\n" +
                                " * boolean Matches(String regex):\n" +
                                " * 驗證當前給定字符串是否符合正則表達式regex\n" +
                                " */\n" +
                                "public class MatchesDemo {\n" +
                                "    public static void seDay01(String[] args) {\n" +
                                "        /**\n" +
                                "         * 信箱正則表達式:\n" +
                                "         * [a-zA-Z0-9_]+@[a-zA-Z0-9]+(\\.[a-zA-z]+)+\n" +
                                "         */\n" +
                                "\n" +
                                "        String email = \"1ar2co3sh4in@gmail.com.tw\";\n" +
                                "        /**\n" +
                                "         * 注意\n" +
                                "         * \\.中的\"\\\"是正則表達式中的轉義字符\n" +
                                "         * \\\\.中的第一個\"\\\"則是JAVA系統中的轉義字符\n" +
                                "         */\n" +
                                "        String mailRegex = \"[a-zA-Z0-9_]+@[a-zA-Z0-9]+(\\\\.[a-zA-z]+)+\";\n" +
                                "\n" +
                                "        boolean matches = email.matches(mailRegex);\n" +
                                "\n" +
                                "        if (matches) {\n" +
                                "            System.out.println(\"信箱格式正確\");\n" +
                                "        } else {\n" +
                                "            System.out.println(\"輸入格式錯誤\");\n" +
                                "        }\n" +
                                "\n" +
                                "    }\n" +
                                "}\n"
                );
                willShowURun();
                //背景代碼存放區開始----------------------------------------
                String email = "1ar2co3sh4in@gmail.com.tw";
                String mailRegex = "[a-zA-Z0-9_]+@[a-zA-Z0-9]+(\\.[a-zA-z]+)+";

                boolean matches = email.matches(mailRegex);

                if (matches) {
                    System.out.println("信箱格式正確");
                } else {
                    System.out.println("輸入格式錯誤");
                }
                //背景代碼存放區結束----------------------------------------
                System.out.println("本小題執行完畢，正在返回第一大題......");
                Thread.sleep(1000);
                question1();
                break;
            case 2:
                whatYouChoose("1-2.replaceAll()方法");
                willShowUCode();
                System.out.println(
                        "/**\n" +
                                " * String replaceAll(String regex,String s)\n" +
                                " * 將當前字符串中符合正則表達式regex的部分替換為字符串s並返回\n" +
                                " *\n" +
                                " * 注意 :\n" +
                                " * replaceAll(String regex,String s)支持正則表達式\n" +
                                " * 但是replace(String old,String new)不支持正則表達式\n" +
                                " */\n" +
                                "public class ReplaceAllDemo {\n" +
                                "    public static void seDay01(String[] args) {\n" +
                                "        String line = \"TMD,你這個SB,簡直SJB\";\n" +
                                "//        String lineRegex = \"[A-Z]+\";\n" +
                                "        String lineRegex = \"(TMD|SB|SJB)\";\n" +
                                "\n" +
                                "        /**\n" +
                                "         * 將符合正則表達式條件的字符串替換為XXX\n" +
                                "         */\n" +
                                "        String newLine = line.replaceAll(lineRegex, \"XXX\");\n" +
                                "\n" +
                                "        /**\n" +
                                "         * 常用於禁言或兒童觀賞保護系統\n" +
                                "         */\n" +
                                "        System.out.println(newLine);\n" +
                                "\n" +
                                "        /**\n" +
                                "         * 利用取代切除資源\n" +
                                "         * String replace(String target,String replacement)\n" +
                                "         * 將所給字符串中的所有符合字符串\"target\"的位置替換為字符串\"replacement\"並返回\n" +
                                "         */\n" +
                                "        String message = \"abc123def123ghi123\";\n" +
                                "        String result = message.replace(\"123\", \"\");//替換成空形同切除\n" +
                                "        System.out.println(result);\n" +
                                "\n" +
                                "        /**\n" +
                                "         * replace(String old,String new)不支持正則表達式，但格式正確所以不會報錯\n" +
                                "         */\n" +
                                "        lineRegex = \"(1|2|3)\";\n" +
                                "        result = message.replace(lineRegex,\"\");\n" +
                                "        System.out.println(result);//無效\n" +
                                "\n" +
                                "\n" +
                                "    }\n" +
                                "}\n"
                );
                willShowURun();
                //背景代碼存放區開始----------------------------------------
                String line = "TMD,你這個SB,簡直SJB";
                String lineRegex = "(TMD|SB|SJB)";
                String newLine = line.replaceAll(lineRegex, "XXX");
                System.out.println(newLine);

                String message = "abc123def123ghi123";
                String result = message.replace("123", "");
                System.out.println(result);

                lineRegex = "(1|2|3)";
                result = message.replace(lineRegex, "");
                System.out.println(result);
                //背景代碼存放區結束----------------------------------------
                System.out.println("本小題執行完畢，正在返回第一大題......");
                Thread.sleep(1000);
                question1();
                break;
            case 3:
                whatYouChoose("1-3.split()方法");
                willShowUCode();
                System.out.println(
                        "/**\n" +
                                " * String[] split(String regex):\n" +
                                " * 將當前字符串依照滿足正則表達式的部分進行分割，並將分割的結果以\"字符串數組\"的形式返回\n" +
                                " */\n" +
                                "public class SplitDemo {\n" +
                                "    public static void seDay01(String[] args) {\n" +
                                "        String line = \"abc123def456ghi\";\n" +
                                "        String[] data = line.split(\"[0-9]+\");//按照數字拆分\"abc\",\"def\",\"ghi\"三等份\n" +
                                "        System.out.println(Arrays.toString(data));//[abc, def, ghi]\n" +
                                "\n" +
                                "        line = \".12.456.78.16541.....0..111.............\";\n" +
                                "        /**\n" +
                                "         * 按照\".\"來拆分，所以使用\".\"，而正則表達式中\".\"有特殊意義，其表示任意字元，故須以\"\\.\"轉義\n" +
                                "         * 又JAVA中\"\\\"本身也有特殊意義，其表示轉義，故須以\"\\\\.\"再次轉義\n" +
                                "         *\n" +
                                "         * 如字符串中，第一個元素即是可拆分對象，則返回數組之第一個元素為空白字符串\n" +
                                "         * 如果字符串中，出現兩續兩個以上可拆分對象，則其中也會多拆出一個空字符\n" +
                                "         */\n" +
                                "        data = line.split(\"\\\\.\");\n" +
                                "        System.out.println(Arrays.toString(data));//[, 12, 456, 78, 16541, , , , , 0, , 111]\n" +
                                "        System.out.println(data.length);//12\n" +
                                "    }\n" +
                                "}\n"
                );
                willShowURun();
                //背景代碼存放區開始----------------------------------------
                String lines = "abc123def456ghi";
                String[] data = lines.split("[0-9]+");
                System.out.println(Arrays.toString(data));

                line = ".12.456.78.16541.....0..111.............";
                data = line.split("\\.");
                System.out.println(Arrays.toString(data));
                System.out.println(data.length);
                //背景代碼存放區結束----------------------------------------
                System.out.println("本小題執行完畢，正在返回第一大題......");
                Thread.sleep(1000);
                question1();
                break;
            default:
                uRWrong();
                break;
        }
    }

    /**
     * 第二題演示
     */
    public static void question2() throws InterruptedException {
        waitForPreparing();
        //=======================================================
        willShowUCode();
        System.out.println(
                        "/**\n" +
                        " * 點類\n" +
                        " * <p>\n" +
                        " * 補充: 標準的javaBean\n" +
                        " * 1.)屬性私有化\n" +
                        " * 2.)屬性可以透過方法修改或查詢(Get&Set)\n" +
                        " * 3.)至少有一個無參構造方法\n" +
                        " */\n" +
                        "public class Point {\n" +
                        "    private int x;\n" +
                        "    private int y;\n" +
                        "\n" +
                        "    public Point() {\n" +
                        "    }\n" +
                        "\n" +
                        "    public Point(int x, int y) {\n" +
                        "        this.x = x;\n" +
                        "        this.y = y;\n" +
                        "    }\n" +
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
                        "\n" +
                        "    @Override\n" +
                        "    public boolean equals(Object o) {\n" +
                        "        if (this == o) return true;\n" +
                        "        if (o == null || getClass() != o.getClass()) return false;\n" +
                        "        Point point = (Point) o;\n" +
                        "        return x == point.x &&\n" +
                        "                y == point.y;\n" +
                        "    }\n" +
                        "\n" +
                        "    @Override\n" +
                        "    public int hashCode() {\n" +
                        "        return Objects.hash(x, y);\n" +
                        "    }\n" +
                        "\n" +
                        "\n" +
                        "}\n"
        );
        System.out.println(
                        "/**\n" +
                        " * 萬類之祖 :　Object是所有類的頂級父類(直接或間接繼承)\n" +
                        " * 或者說------萬類皆對象(為了多態)\n" +
                        " * <p>\n" +
                        " * ===>Object類中定義的方法可以在任何類中使用<===但是，基本類型不是類!!\n" +
                        " */\n" +
                        "public class ObjectDemo {\n" +
                        "    public static void seDay01(String[] args) {\n" +
                        "        /**\n" +
                        "         * 每個類最少都會有\"本身\"或者\"Object\"兩種類型的多態\n" +
                        "         */\n" +
                        "        Aoo a1 = new Aoo();\n" +
                        "        Object o1 = new Aoo();\n" +
                        "\n" +
                        "        Boo b2 = new Boo();\n" +
                        "        Object o2 = new Boo();\n" +
                        "        Aoo a2 = new Boo();\n" +
                        "\n" +
                        "        Coo c3 = new Coo();\n" +
                        "        Object o3 = new Coo();\n" +
                        "        Aoo a3 = new Coo();\n" +
                        "        Boo b3 = new Coo();\n" +
                        "        Loo l3 = new Coo();\n" +
                        "\n" +
                        "        /**\n" +
                        "         *\n" +
                        "         * Object.toString()\n" +
                        "         *\n" +
                        "         * 當我們輸出引用變量時，JAVA會默認調用Object.toString()方法\n" +
                        "         * 而該方法會返回對象的\"HashCode\"值(可以簡單理解為內存地址)\n" +
                        "         * 但這個值對我們開發軟件而言，其實並沒有太多意義\n" +
                        "         * 我們真正想輸出的是該變量的屬性值\n" +
                        "         * 因此我們常常需要重寫toString()來返回具體的屬性值\n" +
                        "         */\n" +
                        "        System.out.println(c3);//objcet.Coo@1b6d3586\n" +
                        "        System.out.println(a3);//objcet.Coo@4554617c\n" +
                        "        System.out.println(b3);//objcet.Coo@74a14482\n" +
                        "        System.out.println(l3);//objcet.Coo@1540e19d\n" +
                        "        System.out.println(o3);//objcet.Coo@677327b6\n" +
                        "\n" +
                        "        /**\n" +
                        "         * String類 & StringBuilder類，其實本身已經重寫過toString()方法\n" +
                        "         */\n" +
                        "        String string = \"Hello\";\n" +
                        "        System.out.println(\"string = \" + string);//直接輸出\n" +
                        "        StringBuilder builder = new StringBuilder(string);\n" +
                        "        System.out.println(\"builder = \" + builder);//直接輸出\n" +
                        "\n" +
                        "        /**\n" +
                        "         *\n" +
                        "         * Object.equals()\n" +
                        "         *\n" +
                        "         * 當我們調用Object.equals()方法時，內部還是在比較地址(內部使用的還是\"==\")，並沒有參考意義\n" +
                        "         * 因此若想比較對象的屬性值，我們認為Object.equals()並不能滿足需求\n" +
                        "         * 因此常常也會重寫equals()方法來比較屬性值\n" +
                        "         */\n" +
                        "        Point p1 = new Point();\n" +
                        "        Point p2 = new Point();\n" +
                        "        System.out.println(\"p1 == p2 ? \" + (p1 == p2));//false\n" +
                        "        System.out.println(\"p1.equals(p2) ? \" + p1.equals(p2));//重寫後比較的是屬性值true\n" +
                        "\n" +
                        "        /**\n" +
                        "         * String類其實本身已經重寫過equals()方法\n" +
                        "         * 但StringBuilder類沒有!\n" +
                        "         */\n" +
                        "        String string1 = new String(\"123456789\");\n" +
                        "        String string2 = new String(\"123456789\");\n" +
                        "        System.out.println(\"string1 == string2 ? \" + (string1 == string2));//false，已知兩者內存地址必不相同(new)\n" +
                        "        System.out.println(\"string1.equals(string2) ? \" + string1.equals(string2));//String類已經重寫equals()方法\n" +
                        "\n" +
                        "        StringBuilder builder1 = new StringBuilder(string);\n" +
                        "        StringBuilder builder2 = new StringBuilder(string);\n" +
                        "        System.out.println(\"builder1 == builder2 ? \" + (builder1 == builder2));////false，已知兩者內存地址必不相同(new)\n" +
                        "        System.out.println(\"builder1.equals(builder2) ? \" + builder1.equals(builder2));//StringBuilder類沒有重寫equals()方法\n" +
                        "\n" +
                        "\n" +
                        "\n" +
                        "    }\n" +
                        "\n" +
                        "}\n" +
                        "\n" +
                        "class Aoo {\n" +
                        "\n" +
                        "}\n" +
                        "\n" +
                        "class Boo extends Aoo {\n" +
                        "\n" +
                        "}\n" +
                        "\n" +
                        "class Coo extends Boo implements Loo {\n" +
                        "\n" +
                        "}\n" +
                        "\n" +
                        "interface Loo {\n" +
                        "\n" +
                        "}"
        );
        //=======================================================
        willShowURun();
        //背景代碼存放區開始----------------------------------------
        Aoo a1 = new Aoo();
        Object o1 = new Aoo();

        Boo b2 = new Boo();
        Object o2 = new Boo();
        Aoo a2 = new Boo();

        Coo c3 = new Coo();
        Object o3 = new Coo();
        Aoo a3 = new Coo();
        Boo b3 = new Coo();
        Loo l3 = new Coo();

        System.out.println("c3 = " + c3);//objcet.Coo@1b6d3586
        System.out.println("a3 = " + a3);//objcet.Coo@4554617c
        System.out.println("b3 = " + b3);//objcet.Coo@74a14482
        System.out.println("l3 = " + l3);//objcet.Coo@1540e19d
        System.out.println("o3 = " + o3);//objcet.Coo@677327b6

        String string = "Hello";
        System.out.println("string = " + string);
        StringBuilder builder = new StringBuilder(string);
        System.out.println("builder = " + builder);

        Point p1 = new Point();
        Point p2 = new Point();
        System.out.println("p1 == p2 ? " + (p1 == p2));
        System.out.println("p1.equals(p2) ? " + p1.equals(p2));

        String string1 = new String("123456789");
        String string2 = new String("123456789");
        System.out.println("string1 == string2 ? " + (string1 == string2));
        System.out.println("string1.equals(string2) ? " + string1.equals(string2));

        StringBuilder builder1 = new StringBuilder(string);
        StringBuilder builder2 = new StringBuilder(string);
        System.out.println("builder1 == builder2 ? " + (builder1 == builder2));
        System.out.println("builder1.equals(builder2) ? " + builder1.equals(builder2));
        //背景代碼存放區結束----------------------------------------
        backToMenu();
    }

    /**
     * 第三題演示
     */
    public static void question3() throws InterruptedException {
        waitForPreparing();
        //=======================================================
        willShowUCode();
        System.out.println(
                        "/**\n" +
                        " * Integer(int的包裝類) 適用所有包裝類\n" +
                        " */\n" +
                        "public class IntegerDemo {\n" +
                        "    public static void seDay01(String[] args) {\n" +
                        "        /**\n" +
                        "         * 基本類型 ---打包--> 包裝類型 : 包裝類名.valueOf\n" +
                        "         */\n" +
                        "        Integer i1 = new Integer(5);\n" +
                        "        Integer i2 = new Integer(5);\n" +
                        "        System.out.println(i1 == i2);//必定false\n" +
                        "        System.out.println(i1.equals(i2));//true，包裝類已重寫equals()方法\n" +
                        "\n" +
                        "        /**\n" +
                        "         * valueOf會複用一個字節(-128~127)範圍之內的數據，所以一般建議使用valueOf聲明包裝類\n" +
                        "         */\n" +
                        "        Integer i3 = Integer.valueOf(5);\n" +
                        "        Integer i4 = Integer.valueOf(5);\n" +
                        "        System.out.println(i3 == i4);//true，實現複用\n" +
                        "        System.out.println(i3.equals(i4));//true，包裝類已重寫equals()方法\n" +
                        "\n" +
                        "        Integer i5 = Integer.valueOf(128);\n" +
                        "        Integer i6 = Integer.valueOf(128);\n" +
                        "        System.out.println(i5 == i6);//false，超出valueOf可複用範圍，故無法實現複用\n" +
                        "        System.out.println(i5.equals(i6));//true，包裝類已重寫equals()方法\n" +
                        "\n" +
                        "        /**\n" +
                        "         * 包裝類型 ---拆包--> 基本類型 : 包裝類對象.基本類型+value\n" +
                        "         */\n" +
                        "        int j1 = i1.intValue();\n" +
                        "        int j2 = i2.intValue();\n" +
                        "        int j3 = i3.intValue();\n" +
                        "        int j4 = i4.intValue();\n" +
                        "        int j5 = i5.intValue();\n" +
                        "        int j6 = i6.intValue();\n" +
                        "\n" +
                        "        /**\n" +
                        "         * Java支援自動拆裝箱 : 使用上更直觀\n" +
                        "         */\n" +
                        "        int num = 10;\n" +
                        "\n" +
                        "        //自動打包------>底層邏輯: Integer k = Integer.valueOf(num);\n" +
                        "        Integer k = num;\n" +
                        "\n" +
                        "        //自動拆包------>底層邏輯: int l = k.intValue();\n" +
                        "        int l = k;\n" +
                        "\n" +
                        "        System.out.println(k);\n" +
                        "        System.out.println(l);\n" +
                        "\n" +
                        "        /**\n" +
                        "         * 包類類的常用操作演示\n" +
                        "         */\n" +
                        "\n" +
                        "        //1.)包裝類內涵最大值最小值方法\n" +
                        "        int intMax = Integer.MAX_VALUE;\n" +
                        "        int intMin = Integer.MIN_VALUE;\n" +
                        "        System.out.println(\"intRange = (\" + intMax + \",\" + intMin);\n" +
                        "\n" +
                        "        long longMax = Long.MAX_VALUE;\n" +
                        "        long longMin = Long.MIN_VALUE;\n" +
                        "        System.out.println(\"longRange = (\" + longMax + \",\" + longMin);\n" +
                        "\n" +
                        "        double doubleMax = Double.MAX_VALUE;\n" +
                        "        double doubleMin = Double.MIN_VALUE;\n" +
                        "        System.out.println(\"doubleRange = (\" + doubleMax + \",\" + doubleMin);\n" +
                        "\n" +
                        "        //2.)包裝類可以將字符串轉換為對應的基本類型------特別常用，需重點掌握\n" +
                        "        String num1 = \"39\";\n" +
                        "        int n1 = Integer.parseInt(num1);//String ------> int(不同於valueOf: Object ------> 包裝類型)\n" +
                        "        System.out.println(n1);\n" +
                        "\n" +
                        "        String num2 = \"3.1415926\";\n" +
                        "        double n2 = Double.parseDouble(num2);//String ------> double(不同於valueOf: Object ------> 包裝類型)\n" +
                        "        System.out.println(n2);\n" +
                        "\n" +
                        "\n" +
                        "    }\n" +
                        "}\n"
        );
        //=======================================================
        willShowURun();
        //背景代碼存放區開始----------------------------------------
        Integer i1 = new Integer(5);
        Integer i2 = new Integer(5);
        System.out.println(i1 == i2);
        System.out.println(i1.equals(i2));

        Integer i3 = Integer.valueOf(5);
        Integer i4 = Integer.valueOf(5);
        System.out.println(i3 == i4);
        System.out.println(i3.equals(i4));

        Integer i5 = Integer.valueOf(128);
        Integer i6 = Integer.valueOf(128);
        System.out.println(i5 == i6);
        System.out.println(i5.equals(i6));

        int j1 = i1.intValue();
        int j2 = i2.intValue();
        int j3 = i3.intValue();
        int j4 = i4.intValue();
        int j5 = i5.intValue();
        int j6 = i6.intValue();

        int num = 10;
        Integer k = num;
        int l = k;

        System.out.println(k);
        System.out.println(l);

        //1.)包裝類內涵最大值最小值方法
        int intMax = Integer.MAX_VALUE;
        int intMin = Integer.MIN_VALUE;
        System.out.println("intRange = (" + intMax + "," + intMin);

        long longMax = Long.MAX_VALUE;
        long longMin = Long.MIN_VALUE;
        System.out.println("longRange = (" + longMax + "," + longMin);

        double doubleMax = Double.MAX_VALUE;
        double doubleMin = Double.MIN_VALUE;
        System.out.println("doubleRange = (" + doubleMax + "," + doubleMin);

        //2.)包裝類可以將字符串轉換為對應的基本類型------特別常用，需重點掌握
        String num1 = "39";
        int n1 = Integer.parseInt(num1);//String ------> int(不同於valueOf: Object ------> 包裝類型)
        System.out.println(n1);

        String num2 = "3.1415926";
        double n2 = Double.parseDouble(num2);//String ------> double(不同於valueOf: Object ------> 包裝類型)
        System.out.println(n2);
        //背景代碼存放區結束----------------------------------------
        backToMenu();
    }

    /**
     * 第四題演示
     */
    public static void question4() throws InterruptedException {
        waitForPreparing();
        //=======================================================
        willShowUCode();

        //=======================================================
        willShowURun();
        //背景代碼存放區開始----------------------------------------
        //背景代碼存放區結束----------------------------------------
        backToMenu();
    }

    /**
     * 第五題演示
     */
    public static void question5() throws InterruptedException {
        waitForPreparing();
        //=======================================================
        willShowUCode();

        //=======================================================
        willShowURun();
        //背景代碼存放區開始----------------------------------------
        //背景代碼存放區結束----------------------------------------
        backToMenu();
    }

    /**
     * 第六題演示
     */
    public static void question6() throws InterruptedException {
        waitForPreparing();
        //=======================================================
        willShowUCode();

        //=======================================================
        willShowURun();
        //背景代碼存放區開始----------------------------------------
        //背景代碼存放區結束----------------------------------------
        backToMenu();
    }

    /**
     * 第七題演示
     */
    public static void question7() throws InterruptedException {
        waitForPreparing();
        //=======================================================
        willShowUCode();

        //=======================================================
        willShowURun();
        //背景代碼存放區開始----------------------------------------
        //背景代碼存放區結束----------------------------------------
        backToMenu();
    }

    /**
     * 第八題演示
     */
    public static void question8() throws InterruptedException {
        waitForPreparing();
        //=======================================================
        willShowUCode();

        //=======================================================
        willShowURun();
        //背景代碼存放區開始----------------------------------------
        //背景代碼存放區結束----------------------------------------
        backToMenu();
    }

    /**
     * 第九題演示
     */
    public static void question9() throws InterruptedException {
        waitForPreparing();
        //=======================================================
        willShowUCode();

        //=======================================================
        willShowURun();
        //背景代碼存放區開始----------------------------------------
        //背景代碼存放區結束----------------------------------------
        backToMenu();
    }

    /**
     * 第十題演示
     */
    public static void question10() throws InterruptedException {
        waitForPreparing();
        //=======================================================
        willShowUCode();

        //=======================================================
        willShowURun();
        //背景代碼存放區開始----------------------------------------
        //背景代碼存放區結束----------------------------------------
        backToMenu();
    }


    /**
     * 點類
     */
    private static class Point {
        private int x;
        private int y;

        public Point() {
        }

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x &&
                    y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    /**
     * 萬類之祖 :　Object是所有類的頂級父類(直接或間接繼承)
     */
    private class ObjectDemo {

    }

    static class Aoo {

    }

    static class Boo extends Aoo {

    }

    static class Coo extends Boo implements Loo {

    }

    interface Loo {

    }

}


