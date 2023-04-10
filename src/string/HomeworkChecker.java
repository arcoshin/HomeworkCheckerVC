package string;

import java.util.Scanner;

/**
 * String、StringBuilder核心API練習作業類
 * HomeworkChecker.ver3.9
 * <p>
 * <p>
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
 * 20230331_XCX
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
                    whatYouChoose(questionList[i - 1].num + "." + questionList[i - 1].questionName);//數組中，下標(i-1)的內容 == 第i題的內容
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
        System.out.println("以下為您展示代碼運行結果......");
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
        Question[] data = new Question[10];//<<---------------------------------手動修改
        data[0] = new Question(1, "String基本練習", "使用相同字面量方式創建字符串對象，體會字符串常量池，" +
                "使用new的方式創建字符串對象s並賦值為hello，聲明字符串變量s1並賦值為字面量hello，使用==和equals()比較s與s1是否相同");
        data[1] = new Question(2, "String方法length()的練習", "聲明字符串型變量並賦值，獲取字符串的長度並輸出");
        data[2] = new Question(3, "String方法indexOf()&lastIndexOf()的練習", "" +
                "聲明字符串型變量並賦值，檢索當前字符串中給定字符串的位置並輸出，檢索給定字符串在當前字符串中最後一次出現的位置並輸出");
        data[3] = new Question(4, "String方法substring()的練習", "" +
                "聲明字符串型變量並賦值為一個網址，截取域中的名字並輸出，截取整個域名並輸出");
        data[4] = new Question(5, "String方法trim()的練習", "聲明字符串型變量並賦值，去除當前字符串兩邊的空白字符");
        data[5] = new Question(6, "String方法charAt()的練習", "聲明字符串型變量並賦值，返回當前字符串指定位置上的字符並輸出");
        data[6] = new Question(7, "String方法startsWith()&endsWith()的練習", "" +
                "聲明字符串型變量並賦值，判斷當前字符串是否是以給定的字符串開始的或結束的");
        data[7] = new Question(8, "String方法toUpperCase()&toLowerCase()的練習", "" +
                "聲明字符串型變量並賦值，將當前字符串中的英文部分轉為全大寫或全小寫");
        data[8] = new Question(9, "String靜態方法valueOf()的練習", "" +
                "聲明一個整型變量和一個浮點型變量，將其數據類型轉換為String並輸出");
        data[9] = new Question(10, "StringBuilder的練習", "append()追加、replace()替換、delete()刪除、insert()插入");
        return data;

    }

    /**
     * 第一題演示
     */
    public static void question1() throws InterruptedException {
        waitForPreparing();
        //=======================================================
        willShowUCode();
        System.out.println(
                "/**\n" +
                        " * String字符串類型演示類\n" +
                        " */\n" +
                        "public class StringDemo {\n" +
                        "    final static String sss5 = \"123\";\n" +
                        "    public static void seDay01(String[] args) {\n" +
                        "        /**\n" +
                        "         * 若使用直接量、字面量聲明String對象時，系統會自動去常量池比對\n" +
                        "         * 1).若無，則創建一個字符串對象，並於常量池中產生引用(常量池成可理解為地址列表)\n" +
                        "         * 2).若有，則直引用至該對象不再生成新對象，實現資源複用\n" +
                        "         *\n" +
                        "         * String的賦值，本質上就是在堆中創建新對象重新引用\n" +
                        "         * 而最後堆中未被引用的資源，將被JAVA自帶的GC清除(GC可理解為垃圾回收員)\n" +
                        "         *\n" +
                        "         * 備註:\n" +
                        "         * 基本類型中的\"==\"，比較的是對象中所存的值(直接量)\n" +
                        "         * 引用類型中的\"==\"，比較的是對象的內存地址\n" +
                        "         */\n" +
                        "        String s1 = \"ABC\";//堆中創建一個\"ABC\"字符串對象\n" +
                        "        String s2 = \"ABC\";//常量池中有相當資源，直接引用至對中該對象\n" +
                        "        String s3 = \"ABC\";//常量池中有相當資源，直接引用至對中該對象\n" +
                        "\n" +
                        "        System.out.println(s1 == s2);//實現資源複用........................................1\n" +
                        "        System.out.println(s1 == s3);//實現資源複用........................................2\n" +
                        "        System.out.println(s2 == s3);//實現資源複用........................................3\n" +
                        "\n" +
                        "        s1 = s1 + \"!\";\n" +
                        "        System.out.println(s1 == s2); //false，s1已重新引用至堆中新創的對象(\"ABC!\")........................................4\n" +
                        "\n" +
                        "        /**======\n" +
                        "         * 面試題\n" +
                        "         =======*/\n" +
                        "        /**\n" +
                        "         * \"\"\"在編譯期\"\"\"時，若發現是兩個字面量拼相連，會直接拼接好再傳入常量值中查詢\n" +
                        "         * 只有\"\"\"字面量\"\"\"相連才會有此情形，\"\"\"變量不會\"\"\"\n" +
                        "         * 此為系統規定，能真正有效節省資源\n" +
                        "         */\n" +
                        "\n" +
                        "        String sss1 = \"123abc\";\n" +
                        "        /**\n" +
                        "         * 直接量拼接String\n" +
                        "         */\n" +
                        "        String sss2 = \"123\" + \"abc\";\n" +
                        "        System.out.println(sss1 == sss2);//true........................................5\n" +
                        "\n" +
                        "        /**\n" +
                        "         * 變量拼接String\n" +
                        "         * 此時變量在編譯期不會實現預先拼接\n" +
                        "         * sss4的地址為sss3+\"abc\"在堆中所生成的新對象地址\n" +
                        "         * 所以sss1與sss4的地址必然不同\n" +
                        "         */\n" +
                        "        String sss3 = \"123\";\n" +
                        "        String sss4 = sss3 + \"abc\";\n" +
                        "        System.out.println(sss1 == sss4);//false........................................6\n" +
                        "\n" +
                        "        /**\n" +
                        "         * 常量拼接String\n" +
                        "         * 常量可以理解為在編譯期就會直接替換為字面量、直接量\n" +
                        "         * 因此傳入常量池的值依然是拼接後的值(\"123abc\")\n" +
                        "         * 故而可知實現複用，引用該對象地址\n" +
                        "         */\n" +
                        "//        final static String sss5 = \"123\";//已在類中聲明，此為提醒\n" +
                        "        String sss6 = sss5 + \"abc\";\n" +
                        "        System.out.println(sss1 == sss6);//true........................................7\n" +
                        "\n" +
                        "        /**\n" +
                        "         * 很常見的面試題:\n" +
                        "         * String s = new String(\"hello\");\n" +
                        "         * 請問如上語句，總共創建了幾個對象?\n" +
                        "         * 答 兩個\n" +
                        "         */\n" +
                        "\n" +
                        "        /**\n" +
                        "         * 解析:\n" +
                        "         * 此時堆中會產生:\n" +
                        "         * 第一個對象為 \"hello\" 的字面量String對象......r1\n" +
                        "         * 第二個對象為 \"new String()\" 對象............r2\n" +
                        "         * 而 s 會引用至 r2(s存的是r2的地址)\n" +
                        "         *\n" +
                        "         * 補充:\n" +
                        "         * 可以發現使用題目的方式聲明變量，new String的部分是灰色的---無意義代碼\n" +
                        "         */\n" +
                        "\n" +
                        "        String s = new String(\"hello\");\n" +
                        "\n" +
                        "       /**\n" +
                        "         * 延伸:\n" +
                        "         * 若此時再聲明String r3 = \"hello\";\n" +
                        "         * 則根據傳入常量池的值，直接引用r1\n" +
                        "         */\n" +
                        "        String r3 = \"hello\";\n" +
                        "\n" +
                        "        /**\n" +
                        "         * 比較:\n" +
                        "         * 1.)使用\"==\" : 比較基本類型變量的數值 或者 \"引用類型的對象地址\"\n" +
                        "         * 1.)使用\".equal\" : \"引用類型變量的內容\"\n" +
                        "         * 可發現即使字面量相同，但存的是不同地址，意即代表引用到不同的字符串對象\n" +
                        "         */\n" +
                        "        System.out.println(s == r3);//false，不同地址表示不同對象........................................8\n" +
                        "        System.out.println(s.equals(r3));//true，兩個String對象中所儲存的內容相通(字面量相同)........................................9\n" +
                        "    }\n" +
                        "\n" +
                        "}\n"
        );
        //=======================================================
        willShowURun();
        //背景代碼存放區開始
        String s1 = "ABC";//堆中創建一個"ABC"字符串對象
        String s2 = "ABC";//常量池中有相當資源，直接引用至對中該對象
        String s3 = "ABC";//常量池中有相當資源，直接引用至對中該對象

        System.out.print(s1 == s2);//實現資源複用
        System.out.println("........................................1");
        System.out.print(s1 == s3);//實現資源複用
        System.out.println("........................................2");
        System.out.print(s2 == s3);//實現資源複用
        System.out.println("........................................3");

        s1 = s1 + "!";
        System.out.print(s1 == s2); //false，s1已重新引用至堆中新創的對象("ABC!")
        System.out.println(".......................................4");


        String sss1 = "123abc";
        String sss2 = "123" + "abc";
        System.out.print(sss1 == sss2);//true
        System.out.println("........................................5");


        String sss3 = "123";
        String sss4 = sss3 + "abc";
        System.out.print(sss1 == sss4);//false
        System.out.println(".......................................6");


        String sss6 = sss5 + "abc";
        System.out.print(sss1 == sss6);//true
        System.out.println("........................................7");


        String s = new String("hello");
        String r3 = "hello";
        System.out.print(s == r3);//false
        System.out.println(".......................................8");
        System.out.print(s.equals(r3));//true
        System.out.println("........................................9");

        //背景代碼存放區結束
        backToMenu();
    }

    final static String sss5 = "123";


    /**
     * 第二題演示
     */
    public static void question2() throws InterruptedException {
        waitForPreparing();
        //=======================================================
        willShowUCode();
        System.out.println(
                "/**\n" +
                        " * int length();\n" +
                        " * 獲取數組長度的方法\n" +
                        " */\n" +
                        "public class LengthDemo {\n" +
                        "    public static void seDay01(String[] args) {\n" +
                        "        String str = \"JAVA !\";\n" +
                        "        int length = str.length();//獲取str數組的長度\n" +
                        "        System.out.println(length);//6，空格也算\n" +
                        "    }\n" +
                        "}"
        );
        //=======================================================
        willShowURun();
        //背景代碼存放區開始
        String str = "JAVA !";
        int length = str.length();
        System.out.println("length = " + length);
        //背景代碼存放區結束

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
                        " * indexOf(String str,int n):檢索在所給字符串對象中，下標為n開始，str第一次出現的位置(n默認為0，可省略不寫為重載方法)\n" +
                        " * lastIndexOf(String str)  :檢索在所給字符串對象中，str最後一次出現的位置(有同上的重載方法，幾乎不使用)\n" +
                        " */\n" +
                        "public class IndexOfAndLastIndexOf {\n" +
                        "    public static void seDay01(String[] args) {\n" +
                        "        //............0000000000111111 下\n" +
                        "        //............0123456789012345 標\n" +
                        "        String str = \"thinking in java\";\n" +
                        "\n" +
                        "        int index = str.indexOf(\"in\");//檢索in在str中第一次出現的位置\n" +
                        "        System.out.println(index);//2\n" +
                        "\n" +
                        "        index =  str.indexOf(\"in\", 3);//檢索從下標為3開始，in在str中第一次出現的位置\n" +
                        "        System.out.println(index);//5\n" +
                        "\n" +
                        "        index = str.indexOf(\"abc\");//若字符串不存在，則返回-1\n" +
                        "        System.out.println(index);//-1\n" +
                        "\n" +
                        "        index = str.lastIndexOf(\"in\");//檢索in在str中最後一次出現的位置\n" +
                        "        System.out.println(index);//9\n" +
                        "    }\n" +
                        "}\n"
        );
        //=======================================================
        willShowURun();
        //背景代碼存放區開始
        String str = "thinking in java";
        int index = str.indexOf("in");
        System.out.println(index);//2

        index = str.indexOf("in", 3);
        System.out.println(index);//5

        index = str.indexOf("abc");
        System.out.println(index);//-1

        index = str.lastIndexOf("in");
        System.out.println(index);//9
        //背景代碼存放區結束
        backToMenu();
    }

    /**
     * 第四題演示
     */
    public static void question4() throws InterruptedException {
        waitForPreparing();
        //=======================================================
        willShowUCode();
        System.out.println(
                "\n" +
                        "/**\n" +
                        " * String substring(int begin,int end):擷取字符串中下標begin到end位置的元素，以字符串返回(含頭不含尾)\n" +
                        " * 如substring(3,8):表示擷取字符串中下標3~7的元素，並以一個新的字符串形式返回\n" +
                        " */\n" +
                        "public class SubstringDemo {\n" +
                        "    public static void seDay01(String[] args) {\n" +
                        "        //            0123456789 下標\n" +
                        "        String str = \"0123456789\";\n" +
                        "\n" +
                        "        //擷取34567\n" +
                        "        int start = str.indexOf(\"3\");//擷取下標含頭不含尾所以不用修正\n" +
                        "        int end = str.lastIndexOf(\"7\") + 1;//擷取下標含頭不含尾所以+1\n" +
                        "        String sub = str.substring(start, end);//取下標3~7\n" +
                        "        System.out.println(sub);//34567\n" +
                        "\n" +
                        "        //擷取公司名(適用於雙後綴網址)\n" +
                        "        str = \"www.tedu.cn\";\n" +
                        "        start = str.indexOf(\".\") + 1;//從第一個\".\"之後開始，擷取下標含頭不含尾所以+1\n" +
                        "        end = str.indexOf(\".\", start);//從第一個\".\"之後，開始找第一次出現的\".\"作為擷取的末尾元素，擷取下標含頭不含尾所以不用修正。\n" +
                        "        System.out.println(str.substring(start, end));\n" +
                        "\n" +
                        "    }\n" +
                        "}"
        );
        //=======================================================
        willShowURun();
        //背景代碼存放區開始

        String str = "0123456789";

        int start = str.indexOf("3");
        int end = str.lastIndexOf("7") + 1;
        String sub = str.substring(start, end);
        System.out.println(sub);

        str = "www.tedu.cn";
        start = str.indexOf(".") + 1;
        end = str.indexOf(".", start);
        System.out.println(str.substring(start, end));

        //背景代碼存放區結束
        backToMenu();
    }

    /**
     * 第五題演示
     */
    public static void question5() throws InterruptedException {
        waitForPreparing();
        //=======================================================
        willShowUCode();
        System.out.println(
                "\n" +
                        "/**\n" +
                        " * String Trim()\n" +
                        " * 消除字符串頭尾空白字符的方法:包含兩邊的 空白符、迴車符、換行符\n" +
                        " *\n" +
                        " * 再次體會String對象為不變對象\n" +
                        " * 因此任何對於字符串的修改，本質上都是創建一個新的字符串對象重新引用\n" +
                        " */\n" +
                        "public class TrimDemo {\n" +
                        "    public static void seDay01(String[] args) {\n" +
                        "        /**\n" +
                        "         * 消除字符串頭尾空白字符\n" +
                        "         */\n" +
                        "        String tom = \"                  Tom    \";\n" +
                        "        String s1 = tom.trim();//接收修改後的新字符串對象\n" +
                        "        System.out.println(s1);//Tom\n" +
                        "\n" +
                        "        /**\n" +
                        "         * 消除字符串頭尾空白字符 : 包含空白符、迴車符、換行符\n" +
                        "         */\n" +
                        "        String jerry = \"\" +\n" +
                        "                \"\" +\n" +
                        "                \"\" +\n" +
                        "                \"\" +\n" +
                        "                \"Jerry\" +\n" +
                        "                \"\" +\n" +
                        "                \"\" +\n" +
                        "                \"\" +\n" +
                        "                \"\" +\n" +
                        "                \"\" +\n" +
                        "                \"\" +\n" +
                        "                \"\";\n" +
                        "        System.out.println(jerry.trim());//Jerry\n" +
                        "\n" +
                        "        /**\n" +
                        "         * 消除字符串頭尾空白字符 : 包含空白符、迴車符、換行符\n" +
                        "         * 但不會相除非空白字符之間的元素\n" +
                        "         */\n" +
                        "        String something = \"   . Something ,     \";\n" +
                        "        System.out.println(something.trim());//. Something ,\n" +
                        "    }\n" +
                        "}\n"
        );
        //=======================================================
        willShowURun();
        //背景代碼存放區開始
        String tom = "                  Tom    ";
        String s1 = tom.trim();
        System.out.println(s1);
        String jerry = "" +
                "" +
                "" +
                "" +
                "Jerry" +
                "" +
                "" +
                "" +
                "" +
                "" +
                "" +
                "";
        System.out.println(jerry.trim());
        String something = "   . Something ,     ";
        System.out.println(something.trim());
        //背景代碼存放區結束
        backToMenu();
    }

    /**
     * 第六題演示
     */
    public static void question6() throws InterruptedException {
        waitForPreparing();
        //=======================================================
        willShowUCode();
        System.out.println(
                "\n" +
                        "/**\n" +
                        " * char chatAt(int index)\n" +
                        " * 查詢在所給的字符串指定下標位置上的字符，並返回\n" +
                        " */\n" +
                        "public class CharAtDemo {\n" +
                        "    public static void seDay01(String[] args) {\n" +
                        "        //.............0000000000111111 下\n" +
                        "        //.............0123456789012345 標\n" +
                        "        String str = \"thinking in java\";\n" +
                        "        /**\n" +
                        "         * StringIndexOutOfBoundsException : 字符串下標越界異常\n" +
                        "         */\n" +
                        "        try {\n" +
                        "            System.out.println(str.charAt(16));//StringIndexOutOfBoundsException: String index out of range: 16\n" +
                        "        } catch (Exception e) {\n" +
                        "        }\n" +
                        "        /**\n" +
                        "         * 輸出下標位置15的元素(字符)\n" +
                        "         */\n" +
                        "        char b = str.charAt(15);\n" +
                        "        System.out.println(b);//a\n" +
                        "    }\n" +
                        "}\n"
        );
        //=======================================================
        willShowURun();
        //背景代碼存放區開始
        String str = "thinking in java";
        try {
            System.out.println(str.charAt(16));
        } catch (Exception e) {

        }
        char b = str.charAt(15);
        System.out.println(b);
        backToMenu();
    }

    /**
     * 第七題演示
     */
    public static void question7() throws InterruptedException {
        waitForPreparing();
        //=======================================================
        willShowUCode();
        System.out.println(
                "/**\n" +
                        " * Boolean startsWith(String s) : 判斷當前字符串是否以給定字符串s為開頭\n" +
                        " * Boolean   endsWith(String s) : 判斷當前字符串是否以給定字符串s為結尾\n" +
                        " */\n" +
                        "public class StartsWithAndEndsWith {\n" +
                        "    public static void seDay01(String[] args) {\n" +
                        "        String str = \"thinking in java\";\n" +
                        "\n" +
                        "        /**\n" +
                        "         * startsWith(String s) : 判斷當前字符串是否以給定字符串s為開頭\n" +
                        "         */\n" +
                        "        Boolean r1 = str.startsWith(\"think\");//判斷str是否以think開頭\n" +
                        "        System.out.println(r1);//true\n" +
                        "\n" +
                        "        /**\n" +
                        "         * endsWith(String s) : 判斷當前字符串是否以給定字符串s為結尾\n" +
                        "         */\n" +
                        "        Boolean r2 = str.endsWith(\".png\");//判斷str是否以.png結尾\n" +
                        "        System.out.println(r2);//false\n" +
                        "\n" +
                        "    }\n" +
                        "}"
        );
        //=======================================================
        willShowURun();
        //背景代碼存放區開始
        String str = "thinking in java";
        Boolean r1 = str.startsWith("think");
        System.out.println(r1);

        Boolean r2 = str.endsWith(".png");
        System.out.println(r2);
        //背景代碼存放區結束
        backToMenu();
    }

    /**
     * 第八題演示
     */
    public static void question8() throws InterruptedException {
        waitForPreparing();
        //=======================================================
        willShowUCode();
        System.out.println(
                "/**\n" +
                        " * String toUpperCase() : 將字符串中的字母全部改為大寫\n" +
                        " * String toLowerCase() : 將字符串中的字母全部改為小寫\n" +
                        " */\n" +
                        "public class ToUpperAndLowerCase {\n" +
                        "    public static void seDay01(String[] args) {\n" +
                        "        String text = \"I am practicing JAVA\";\n" +
                        "\n" +
                        "        /**\n" +
                        "         * 全大寫 : ToUpperCase\n" +
                        "         */\n" +
                        "        String upper = text.toUpperCase();\n" +
                        "        System.out.println(upper);//I AM PRACTICING JAVA\n" +
                        "\n" +
                        "        /**\n" +
                        "         * 全小寫 : ToLowerCase\n" +
                        "         */\n" +
                        "        String lower = text.toLowerCase();\n" +
                        "        System.out.println(lower);//i am practicing java\n" +
                        "    }\n" +
                        "}\n"
        );
        //=======================================================
        willShowURun();
        //背景代碼存放區開始
        String text = "I am practicing JAVA";
        String upper = text.toUpperCase();
        System.out.println(upper);

        String lower = text.toLowerCase();
        System.out.println(lower);
        //背景代碼存放區結束
        backToMenu();
    }

    /**
     * 第九題演示
     */
    public static void question9() throws InterruptedException {
        waitForPreparing();
        //=======================================================
        willShowUCode();
        System.out.println(
                "/**\n" +
                        " * String String.valueOf()\n" +
                        " * 將所給變量轉變為字符串類型的方法\n" +
                        " */\n" +
                        "public class ValueOfDemo {\n" +
                        "    public static void seDay01(String[] args) {\n" +
                        "        /**\n" +
                        "         * int轉String\n" +
                        "         */\n" +
                        "        System.out.println(\"int轉String=======================\");\n" +
                        "        int numInt = 123456789;\n" +
                        "        System.out.println(\"numInt        = \" + numInt);\n" +
                        "        System.out.println(\"numInt + 1    = \" + (numInt + 1));\n" +
                        "        String numString = String.valueOf(numInt);\n" +
                        "        System.out.println(\"numString + 1 = \" + numString + 1 + \"(拼接)\");\n" +
                        "\n" +
                        "        /**\n" +
                        "         * double轉String\n" +
                        "         */\n" +
                        "        System.out.println(\"double轉String====================\");\n" +
                        "        double piDouble = 3.14;\n" +
                        "        System.out.println(\"piDouble      = \" + piDouble);\n" +
                        "        System.out.println(\"piDouble + 1  = \" + (piDouble + 1));\n" +
                        "        String piString = String.valueOf(piDouble);\n" +
                        "        System.out.println(\"piString + 1  = \" + piString + 1 + \"(拼接)\");\n" +
                        "\n" +
                        "        /**\n" +
                        "         * String.valueOf()為將所給變量轉變為字符串類型的方法\n" +
                        "         * 而String與任何變量加法時，結果都會變為String類型(字符串拼接)，但效率低\n" +
                        "         */\n" +
                        "\n" +
                        "    }\n" +
                        "}\n"
        );
        //=======================================================
        willShowURun();
        //背景代碼存放區開始
        System.out.println("int轉String=======================");
        int numInt = 123456789;
        System.out.println("numInt        = " + numInt);
        System.out.println("numInt + 1    = " + (numInt + 1));
        String numString = String.valueOf(numInt);
        System.out.println("numString + 1 = " + numString + 1 + "(拼接)");

        System.out.println("double轉String====================");
        double piDouble = 3.14;
        System.out.println("piDouble      = " + piDouble);
        System.out.println("piDouble + 1  = " + (piDouble + 1));
        String piString = String.valueOf(piDouble);
        System.out.println("piString + 1  = " + piString + 1 + "(拼接)");
        //背景代碼存放區結束
        backToMenu();
    }

    /**
     * 第十題演示
     */
    public static void question10() throws InterruptedException {
        waitForPreparing();
        //=======================================================
        willShowUCode();
        System.out.println(
                "/**\n" +
                        " * StringBuilder類 : 適合頻繁編輯的String工具，改善頻繁增刪對象的過程\n" +
                        " */\n" +
                        "public class StringBuilderDemo {\n" +
                        "    public static void seDay01(String[] args) {\n" +
                        "        //StringBuilder創建方式\n" +
                        "        StringBuilder b1 = new StringBuilder();//目前為空字符串\n" +
                        "        StringBuilder b2 = new StringBuilder(\"abc\");//b2為\"abc\"字符串\n" +
                        "\n" +
                        "        //String 與 StringBuilder 互轉\n" +
                        "        String str1 = \"abc\";\n" +
                        "        StringBuilder b3 = new StringBuilder(str1);//b3為\"abc\"字符串\n" +
                        "        String str2 = b3.toString();//StringBuilder轉換為String的方法\n" +
                        "        System.out.println(str2);\n" +
                        "\n" +
                        "        String str = \"好好學習Java\";\n" +
                        "        //String -> StringBuilder : 利於頻繁修改\n" +
                        "        StringBuilder builder = new StringBuilder(str);\n" +
                        "\n" +
                        "        /**\n" +
                        "         * 優點 : builder為可變字符串，故不用重新賦值回builder\n" +
                        "         */\n" +
                        "\n" +
                        "        /**\n" +
                        "         * append()追加內容，從末尾開始\n" +
                        "         */\n" +
                        "        builder.append(\"，為了找份好工作!\");\n" +
                        "        System.out.println(builder);//好好學習Java，為了找份好工作!\n" +
                        "        //                            0.00.0.00000.01.11.1.11.1 下\n" +
                        "        //                            0.12.3.45678.90.12.3.45.6 標\n" +
                        "\n" +
                        "        /**\n" +
                        "         * replace(int start,int end,String str)替換指定位置的內容\n" +
                        "         */\n" +
                        "        builder.replace(9, 16, \"就是為了改變世界\");//下標一樣含頭不含尾(實際取代9~15)\n" +
                        "        System.out.println(builder);//好好學習Java，就是為了改變世界!\n" +
                        "        //                            0.00.0.00000.01.11.1.11.11 下\n" +
                        "        //                            0.12.3.45678.90.12.3.45.67 標\n" +
                        "\n" +
                        "        /**\n" +
                        "         * delete(int start,int end)刪除指定位置的內容\n" +
                        "         */\n" +
                        "        builder.delete(0,8);//下標一樣含頭不含尾(實際刪除0~7)\n" +
                        "        System.out.println(builder);//，就是為了改變世界!\n" +
                        "        //                             0.0 0.00.00.00.0 下\n" +
                        "        //                             0.1 2.34.56.78.9 標\n" +
                        "\n" +
                        "        /**\n" +
                        "         * insert(int start,String str)從指定位置插入內容\n" +
                        "         */\n" +
                        "        builder.insert(0,\"活著\");\n" +
                        "        System.out.println(builder);//活著，就是為了改變世界\n" +
                        "\n" +
                        "    }\n" +
                        "}\n"
        );
        //=======================================================
        willShowURun();
        //背景代碼存放區開始
        StringBuilder b1 = new StringBuilder();
        StringBuilder b2 = new StringBuilder("abc");

        String str1 = "abc";
        StringBuilder b3 = new StringBuilder(str1);
        String str2 = b3.toString();
        System.out.println(str2);

        String str = "好好學習Java";
        StringBuilder builder = new StringBuilder(str);

        builder.append("，為了找份好工作!");
        System.out.println(builder);//好好學習Java，為了找份好工作!

        builder.replace(9, 16, "就是為了改變世界");
        System.out.println(builder);

        builder.delete(0, 8);
        System.out.println(builder);

        builder.insert(0, "活著");
        System.out.println(builder);

        //背景代碼存放區結束
        backToMenu();
    }

}


