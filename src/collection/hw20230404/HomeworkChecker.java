package collection.hw20230404;

import java.util.*;

/**
 * weekendHomework 2023.04.04
 * HomeworkChecker.ver3.7
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
 * 20230405_XCX
 */
class HomeworkChecker extends HomeworkCheckerTools {
    /**
     * 加載題目資料庫中的數據:不用每次進到系統就加載一次，所以放系統外
     */
    static Question[] questionList = new QuestionDatabase().downloadQuestion();

    /**
     * 作業檢測系統入口
     */
    static void homeworkChecker() throws InterruptedException {

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
    Question(int questionNum, String questionName, String questionContent) {
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
    static void whatUChooseFromMenu(int checker, Question[] questionList) throws InterruptedException {
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
    static void showMenuTip(Question[] questionList) {
        System.out.println("======================================================================");
        System.out.println("Hint : 請輸入要檢查的題數(如第一題請輸入1，本次作業共" + questionList.length + "題，若想結束檢查請輸入99)");
        System.out.println("======================================================================");
    }

    /**
     * 遍歷所有題目的方法
     *
     * @param max 本次開放題數
     */
    static void showQuestionList(Question[] questionList, int max) {
        for (int i = 0; i < HomeworkChecker.questionList.length; i++) {//遍歷題目列表
            System.out.println(questionList[i].questionNum + "." + questionList[i].questionName);
            System.out.println(questionList[i].questionContent);
            System.out.println();
        }
    }

    /**
     * 執行question?的方法
     */
    static void goToQuestion(int num) throws InterruptedException {
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
    static void backToMenu() throws InterruptedException {
        System.out.println("本題展示完成，即將返回大題選單......");
        Thread.sleep(1000);
        HomeworkChecker.homeworkChecker();
    }

    /**
     * 告知用戶輸入不合法的方法
     */
    static void uRWrong() {
        try {
            throw new RuntimeException("輸入錯誤，請重新輸入");
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

    /**
     * 預告即將為您展示代碼運行結果的方法
     */
    static void willShowURun() {
        System.out.println("以下為您展示運行結果......");
    }

    /**
     * 預告即將為您展示代碼運行結果的方法
     */
    static void willShowUCode() {
        System.out.println("以下為您展示代碼......");
    }

    /**
     * 廣播說明客戶所選擇的業務
     */
    static void whatYouChoose(String doSomething) {
        System.out.println("您所選擇的是" + doSomething);
    }

    /**
     * 開始演示question的方法
     */
    static void waitForPreparing() throws InterruptedException {
        System.out.println("請稍候...正在為您生成本題的演示過程...");
        Thread.sleep(1000);
    }

    /**
     * 結束的方法
     */
    static void ending() throws InterruptedException {
        System.out.println("感謝您的耐心檢查，系統正在關閉......");
        Thread.sleep(1000);
        System.out.println("ByeBye......");
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
    Question[] downloadQuestion() {
        Question[] data = new Question[4];//<<---------------------------------手動修改
        data[0] = new Question(1, "List基本練習", "");
        data[1] = new Question(2, "List獲取子集", "");
        data[2] = new Question(3, "集合排序相關練習", "");
        data[3] = new Question(4, "利用Set去重", "");
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
    static void question1() throws InterruptedException {
        waitForPreparing();
        //=======================================================
        willShowUCode();
        System.out.println(
                "/**\n" +
                        " * List集合演示類\n" +
                        " * (本質上跟Collection一樣是接口)\n" +
                        " * (底層邏輯跟數組相似，更可以與數組互相轉換)\n" +
                        " * 1.可重複集合\n" +
                        " * 2.有序(有下標，類似數組)\n" +
                        " *\n" +
                        " * 常見實現類\n" +
                        " *\n" +
                        " * ArrayList  集合 :\n" +
                        " * 底層使用數組呈現，故查詢性能好(下標)，但增刪性能差(數組長度是不變的，增刪數組底層就是重新引用新對象)\n" +
                        " *\n" +
                        " * LinkedList 集合 :\n" +
                        " * 底層使用鍊表呈現，查詢性能不好，但首尾增刪性能佳(只能知道首尾的地址)\n" +
                        " */\n" +
                        "public class ListDemo {\n" +
                        "    public static void seDay01(String[] args) {\n" +
                        "        List<String> list = new ArrayList();//向上造型\n" +
                        "        list.add(\"one\");\n" +
                        "        list.add(\"two\");\n" +
                        "        list.add(\"three\");\n" +
                        "        list.add(\"four\");\n" +
                        "        list.add(\"five\");\n" +
                        "        list.add(\"one\");\n" +
                        "        System.out.println(list);//[one, two, three, four, five, one]\n" +
                        "\n" +
                        "        /**\n" +
                        "         * E get(int index) : 獲取指定下標所對應的元素\n" +
                        "         */\n" +
                        "        String e = list.get(2);\n" +
                        "        System.out.println(e);//three\n" +
                        "\n" +
                        "        //常規遍歷\n" +
                        "        for (int i = 0; i < list.size(); i++) {\n" +
                        "            System.out.print(list.get(i) + \" \");\n" +
                        "        }\n" +
                        "        System.out.println();\n" +
                        "\n" +
                        "        //增強型for循環\n" +
                        "        for (String s : list) {\n" +
                        "            System.out.print(s + \" \");\n" +
                        "        }\n" +
                        "        System.out.println();\n" +
                        "\n" +
                        "        //迭代器\n" +
                        "        Iterator<String> it = list.iterator();\n" +
                        "        while (it.hasNext()) {\n" +
                        "            System.out.print(it.next() + \" \");\n" +
                        "        }\n" +
                        "        System.out.println();\n" +
                        "\n" +
                        "        /**\n" +
                        "         * E set(int index,object obj) : 將list中下標為n的元素設置為obj，並將被取代的元素返回\n" +
                        "         */\n" +
                        "        String old = list.set(2, \"six\");//將list中下標為2的元素設置為six，同時將被替換的元素返回\n" +
                        "        System.out.println(old);//[one, two, six, four, five, one]\n" +
                        "        System.out.println(\"list:\" + list);\n" +
                        "\n" +
                        "        /**\n" +
                        "         * E remove(int index) : 刪除集合中指定下標的元素，並將其返回\n" +
                        "         */\n" +
                        "        String s1 = list.remove(2);\n" +
                        "        System.out.println(s1);//six\n" +
                        "        System.out.println(\"list:\" + list);//[one, two, four, five, one]\n" +
                        "\n" +
                        "        /**\n" +
                        "         * void add(int index,E e) : 將給定元素e添加到指定下標為index的位置，可以理解為插入操作\n" +
                        "         */\n" +
                        "        list.add(3,\"seven\");//在下標位置為3的位置上插入seven\n" +
                        "        System.out.println(\"list\" + list);//[one, two, four, seven, five, one]\n" +
                        "    }\n" +
                        "}\n"
        );

        //=======================================================
        willShowURun();
        //背景代碼存放區開始----------------------------------------

        List<String> list = new ArrayList();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        list.add("five");
        list.add("one");
        System.out.println(list);

        String e = list.get(2);
        System.out.println(e);

        //常規遍歷
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();

        //增強型for循環
        for (String s : list) {
            System.out.print(s + " ");
        }

        System.out.println();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();

        String old = list.set(2, "six");
        System.out.println(old);
        System.out.println("list:" + list);

        String s1 = list.remove(2);
        System.out.println(s1);
        System.out.println("list:" + list);

        list.add(3, "seven");
        System.out.println("list" + list);
        //背景代碼存放區結束----------------------------------------
        backToMenu();
    }

    /**
     * 第二題演示
     */
    static void question2() throws InterruptedException {
        waitForPreparing();
        //=======================================================
        willShowUCode();
        System.out.println(
                "/**\n" +
                        " * List sublist(int start,int end) : 獲取指定下標的子集(下標含頭不含尾)\n" +
                        " * 注意 : 源集合與子集合其實都是引用到相同的數據對象，因此兩者共同引用的數據被更改時，兩者皆會同步。\n" +
                        " */\n" +
                        "public class SubListDemo {\n" +
                        "    public static void seDay01(String[] args) {\n" +
                        "//        List<Integer> list = new LinkedList<>();//使用鍊表也不會影響後續代碼進行，兩者只是底層邏輯結構不同\n" +
                        "        List<Integer> list = new ArrayList<>();\n" +
                        "        for (int i = 0; i < 10; i++) {\n" +
                        "            list.add(i * 10);\n" +
                        "        }\n" +
                        "        System.out.println(\"list:\" + list);//[0, 10, 20, 30, 40, 50, 60, 70, 80, 90]\n" +
                        "\n" +
                        "        /**\n" +
                        "         * 獲取下標3到7的字集\n" +
                        "         */\n" +
                        "        List<Integer> subList = list.subList(3, 8);\n" +
                        "        System.out.println(subList);//[30, 40, 50, 60, 70]\n" +
                        "\n" +
                        "        /**\n" +
                        "         * 將子集每個元素都擴大為十倍 : 對子集的操作就是對源集合的元素操作\n" +
                        "         */\n" +
                        "        for (int i = 0; i < subList.size(); i++) {\n" +
                        "            subList.set(i, subList.get(i) * 10);\n" +
                        "        }\n" +
                        "        System.out.println(\"subList:\" + subList);\n" +
                        "        System.out.println(\"list:\" + list);\n" +
                        "\n" +
                        "        /**\n" +
                        "         * 將源集合下標為3的元素更改為1000 : 源數組數據改變後，子集亦將跟著改變\n" +
                        "         */\n" +
                        "        list.set(3, 1000);\n" +
                        "        System.out.println(\"list:\" + list);\n" +
                        "        System.out.println(\"subList:\" + subList);\n" +
                        "\n" +
                        "        /**\n" +
                        "         * 對源集增刪後，子集不能再進行操作(不支持操作異常)\n" +
                        "         * 對子集增刪後，源集跟著改\n" +
                        "         * (源集類似原件，子集類似複印件)\n" +
                        "         */\n" +
                        "        subList.remove(0);//子集修改\n" +
                        "        System.out.println(\"subList:\" + subList);\n" +
                        "        System.out.println(\"list:\" + list);\n" +
                        "\n" +
                        "        list.remove(0);//源集增刪\n" +
                        "        System.out.println(\"list:\" + list);\n" +
                        "        /**\n" +
                        "         * ConcurrentModificationException : 不支持操作異常\n" +
                        "         */\n" +
                        "        System.out.println(\"subList:\" + subList);\n" +
                        "\n" +
                        "    }\n" +
                        "}\n"
        );
        //=======================================================
        willShowURun();
        //背景代碼存放區開始----------------------------------------
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i * 10);
        }
        System.out.println("list:" + list);

        List<Integer> subList = list.subList(3, 8);
        System.out.println(subList);

        for (int i = 0; i < subList.size(); i++) {
            subList.set(i, subList.get(i) * 10);
        }
        System.out.println("subList:" + subList);
        System.out.println("list:" + list);

        list.set(3, 1000);
        System.out.println("list:" + list);
        System.out.println("subList:" + subList);

        subList.remove(0);//子集修改
        System.out.println("subList:" + subList);
        System.out.println("list:" + list);

//        list.remove(0);//源集增刪

        System.out.println("list:" + list);

        System.out.println("subList:" + subList);

        //背景代碼存放區結束----------------------------------------
        backToMenu();
    }

    /**
     * 第三題演示
     */
    static void question3() throws InterruptedException {
        waitForPreparing();
        //=======================================================
        willShowUCode();
        System.out.println("SortInteger------------------------------");
        System.out.println(
                "/**\n" +
                        " * 對Integer元素進行排序\n" +
                        " */\n" +
                        "public class SortInteger {\n" +
                        "    public static void seDay01(String[] args) {\n" +
                        "        List<Integer> list = new ArrayList<>();\n" +
                        "        for (int i = 0; i < 10; i++) {\n" +
                        "            list.add(new Random().nextInt(100));//0~99\n" +
                        "        }\n" +
                        "        System.out.println(\"list原始數據:\" + list);\n" +
                        "        Collections.sort(list);//自然排序(升冪排序)\n" +
                        "        System.out.println(\"list自然排序後數據:\" + list);\n" +
                        "        Collections.reverse(list);//反轉排序(降冪排序)\n" +
                        "        System.out.println(\"list反轉排序後數據:\" + list);\n" +
                        "    }\n" +
                        "}\n"
        );

        System.out.println("---------------SortString---------------");
        System.out.println(
                "\n" +
                        "/**\n" +
                        " * 對String元素排序\n" +
                        " */\n" +
                        "public class SortString {\n" +
                        "    public static void seDay01(String[] args) {\n" +
                        "        /**\n" +
                        "         * 對英文字符串的排序時，會依照首字母的ASCII碼來排\n" +
                        "         * 若首字母相同，則比較第二個字母的ASCII碼，依此類推...\n" +
                        "         * A~Z:65~90\n" +
                        "         * a~z:97~122\n" +
                        "         */\n" +
                        "        List<String> list1 = new ArrayList<>();\n" +
                        "        list1.add(\"jack\");\n" +
                        "        list1.add(\"rose\");\n" +
                        "        list1.add(\"tom\");\n" +
                        "        list1.add(\"jerry\");\n" +
                        "        list1.add(\"black\");\n" +
                        "        list1.add(\"Kobe\");\n" +
                        "\n" +
                        "        System.out.println(\"list1原始數據:\" + list1);//[jack, rose, tom, jerry, black, Kobe]\n" +
                        "        Collections.sort(list1);\n" +
                        "        System.out.println(\"list1自然排序後:\" + list1);//[Kobe, black, jack, jerry, rose, tom]\n" +
                        "\n" +
                        "        /**\n" +
                        "         * 對中文字符串的排序時，依然是按照首字母的ASCII碼來排\n" +
                        "         * 若首字母相同，則比較第二個字母的ASCII碼，依此類推...\n" +
                        "         * 但ASCII碼對於業務並無太大意義，因此可以自定義排序方式\n" +
                        "         * 系統對於一個類是否可以排序，會以該類有沒有實現Comparable來確定\n" +
                        "         * Integer、String類中都有實現Comparable接口，因此可以直接排序\n" +
                        "         * 自定義類也必須實現Comparable才可以排序，否則直接編譯錯誤\n" +
                        "         */\n" +
                        "        List<String> list2 = new ArrayList<>();\n" +
                        "        list2.add(\"王克晶\");\n" +
                        "        list2.add(\"傳奇sdfsdf\");\n" +
                        "        list2.add(\"國斌老師\");\n" +
                        "        System.out.println(\"list2原始數據:\" + list2);\n" +
                        "        Collections.sort(list2);\n" +
                        "        System.out.println(\"list2自然排序後:\" + list2);\n" +
                        "\n" +
                        "        System.out.println(\"王:\" + (int)'王');//29579\n" +
                        "        System.out.println(\"傳:\" + (int)'傳');//20659\n" +
                        "        System.out.println(\"國:\" + (int)'國');//22283\n" +
                        "\n" +
                        "        /**\n" +
                        "         * 特別注意 : 一般我們不會直接在類名實現Comparable接口來定義排序規則\n" +
                        "         * 因為這種作法對程序有侵入性，非常不利於後期代碼的維護\n" +
                        "         *\n" +
                        "         * \"當我們調用某個API功能時，其要求我們為其修改額外代碼的的現象就稱為侵入性\"\n" +
                        "         * 如:後續刪除sort()語句時，原有比較方法後續未必適用，甚至造成同事調用方法時的困擾\n" +
                        "         * 我們通常會傾向做一次排序時定義一次規則，讓各自規則影響各自排序，才不會交互影響\n" +
                        "         *\n" +
                        "         * 解決辦法 : 匿名內部類\n" +
                        "         * 使用重載的Collections.sort(List list,Comparator o)\n" +
                        "         */\n" +
                        "        Collections.sort(list2, new Comparator<String>() {\n" +
                        "            @Override\n" +
                        "            /**\n" +
                        "             * compare()方法用於定義o1與o2比較大小的規則，他的返回值表達大小關係\n" +
                        "             * o1 - o2 升序，前面減後面為升序\n" +
                        "             * o2 - o1 降序，後面減前面為降序\n" +
                        "             */\n" +
                        "            public int compare(String o1, String o2) {\n" +
                        "                return o1.length() - o2.length();//升序(依照長度)\n" +
                        "            }\n" +
                        "        });\n" +
                        "        System.out.println(\"list2排序後數據:\" + list2);//[\"王克晶\",\"國斌老師\",\"傳奇sdfsdf\"]\n" +
                        "    }\n" +
                        "}\n"
        );
        System.out.println("---------------------------SortPoint");
        System.out.println(
                "/**\n" +
                        " * 對Point進行排序\n" +
                        " */\n" +
                        "public class SortPoint {\n" +
                        "    public static void seDay01(String[] args) {\n" +
                        "        List<Point> list = new ArrayList<>();\n" +
                        "        list.add(new Point(1, 2));\n" +
                        "        list.add(new Point(3, 4));\n" +
                        "        list.add(new Point(5, 6));\n" +
                        "        list.add(new Point(7, 8));\n" +
                        "        list.add(new Point(9, 0));\n" +
                        "\n" +
                        "        System.out.println(\"list原始數據:\" + list);//[(1,2), (3,4), (5,6), (7,8), (9,0)]\n" +
                        "//        Collections.sort(list);//編譯錯誤，Point未實現Comparable接口，系統認為不具可比性\n" +
                        "        Collections.sort(list, new Comparator<Point>() {\n" +
                        "            @Override\n" +
                        "            public int compare(Point o1, Point o2) {\n" +
                        "                return o1.getX() - o2.getX();//依照X升序排列\n" +
                        "            }\n" +
                        "        });\n" +
                        "        System.out.println(\"list自定義排序後:\" + list);//[(1,2), (3,4), (5,6), (7,8), (9,0)]\n" +
                        "\n" +
                        "        Collections.sort(list, new Comparator<Point>() {//依照Point與圓心距離升序排序\n" +
                        "            @Override\n" +
                        "            public int compare(Point o1, Point o2) {\n" +
                        "                int d1 = o1.getX() * o1.getX() + o1.getY() * o1.getY();\n" +
                        "                int d2 = o2.getX() * o2.getX() + o2.getY() * o2.getY();\n" +
                        "                return d1 - d2;\n" +
                        "            }\n" +
                        "        });\n" +
                        "        System.out.println(\"list依照與圓心距離升序排列後:\" + list);//[(1,2), (3,4), (5,6), (9,0), (7,8)]\n" +
                        "\n" +
                        "        /**\n" +
                        "         * JDK1.8時，List集和自身也提供了sort方法進行排序，該方法只需傳入比較器即可\n" +
                        "         */\n" +
                        "        list.sort(new Comparator<Point>() {//比較器依然可使用匿名內部類\n" +
                        "            @Override\n" +
                        "            public int compare(Point o1, Point o2) {\n" +
                        "                return o1.getX() - o2.getX();//依照X升序排列\n" +
                        "            }\n" +
                        "        });\n" +
                        "        System.out.println(\"list調用自身比較器的升序後:\" + list);\n" +
                        "\n" +
                        "        /**\n" +
                        "         * Lambda表達式\n" +
                        "         *\n" +
                        "         * 語法:\n" +
                        "         * (參數列表)->{\n" +
                        "         *  方法體\n" +
                        "         * }\n" +
                        "         */\n" +
                        "        list.sort((o1,o2)->o2.getX() - o1.getX());\n" +
                        "        System.out.println(\"list調用自身比較器的降序後(Lambda):\" + list);\n" +
                        "    }\n" +
                        "}\n"
        );

        //=======================================================
        willShowURun();
        //背景代碼存放區開始----------------------------------------
        /**
         * Integer
         */
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new Random().nextInt(100));//0~99
        }
        System.out.println("list原始數據:" + list);
        Collections.sort(list);//自然排序(升冪排序)
        System.out.println("list自然排序後數據:" + list);
        Collections.reverse(list);//反轉排序(降冪排序)
        System.out.println("list反轉排序後數據:" + list);

        /**
         * String
         */
        List<String> list1 = new ArrayList<>();
        list1.add("jack");
        list1.add("rose");
        list1.add("tom");
        list1.add("jerry");
        list1.add("black");
        list1.add("Kobe");

        System.out.println("list1原始數據:" + list1);//[jack, rose, tom, jerry, black, Kobe]
        Collections.sort(list1);
        System.out.println("list1自然排序後:" + list1);//[Kobe, black, jack, jerry, rose, tom]

        List<String> list2 = new ArrayList<>();
        list2.add("王克晶");
        list2.add("傳奇sdfsdf");
        list2.add("國斌老師");
        System.out.println("list2原始數據:" + list2);
        Collections.sort(list2);
        System.out.println("list2自然排序後:" + list2);

        System.out.println("王:" + (int) '王');//29579
        System.out.println("傳:" + (int) '傳');//20659
        System.out.println("國:" + (int) '國');//22283

        Collections.sort(list2, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();//升序(依照長度)
            }
        });
        System.out.println("list2排序後數據:" + list2);//["王克晶","國斌老師","傳奇sdfsdf"]

        /**
         * Point
         */
        List<Point> list7 = new ArrayList<>();
        list7.add(new Point(1, 2));
        list7.add(new Point(3, 4));
        list7.add(new Point(5, 6));
        list7.add(new Point(7, 8));
        list7.add(new Point(9, 0));

        System.out.println("list原始數據:" + list7);//[(1,2), (3,4), (5,6), (7,8), (9,0)]
        Collections.sort(list7, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return o1.getX() - o2.getX();//依照X升序排列
            }
        });
        System.out.println("list自定義排序後:" + list7);//[(1,2), (3,4), (5,6), (7,8), (9,0)]

        Collections.sort(list7, new Comparator<Point>() {//依照Point與圓心距離升序排序
            @Override
            public int compare(Point o1, Point o2) {
                int d1 = o1.getX() * o1.getX() + o1.getY() * o1.getY();
                int d2 = o2.getX() * o2.getX() + o2.getY() * o2.getY();
                return d1 - d2;
            }
        });
        System.out.println("list依照與圓心距離升序排列後:" + list7);//[(1,2), (3,4), (5,6), (9,0), (7,8)]

        list7.sort(new Comparator<Point>() {//比較器依然可使用匿名內部類
            @Override
            public int compare(Point o1, Point o2) {
                return o1.getX() - o2.getX();//依照X升序排列
            }
        });
        System.out.println("list調用自身比較器的升序後:" + list7);

        list7.sort((o1, o2) -> o2.getX() - o1.getX());
        System.out.println("list調用自身比較器的降序後(Lambda):" + list7);
        //背景代碼存放區結束----------------------------------------
        backToMenu();
    }

    /**
     * 第四題演示
     */
    static void question4() throws InterruptedException {
        waitForPreparing();
        //=======================================================
        willShowUCode();
        System.out.println(
                "\n" +
                        "/**\n" +
                        " * Set集合 : 不可重複集合，大部分數據是無序的(無序並非隨機，只是沒有下標)\n" +
                        " */\n" +
                        "public class SetDemo {\n" +
                        "    public static void seDay01(String[] args) {\n" +
                        "        Set<String> set = new HashSet<>();\n" +
                        "        set.add(\"one\");\n" +
                        "        set.add(\"two\");\n" +
                        "        set.add(\"three\");\n" +
                        "        set.add(\"four\");\n" +
                        "        set.add(\"five\");\n" +
                        "        set.add(\"two\");//加入失敗，Set為不可重複集合，但此處不報錯\n" +
                        "        System.out.println(\"set:\" + set);\n" +
                        "\n" +
                        "        /**\n" +
                        "         * 小面試題 : 如何去重(將已重複元素去除)\n" +
                        "         */\n" +
                        "        List<String> list = new ArrayList<>();\n" +
                        "        list.add(\"one\");\n" +
                        "        list.add(\"two\");\n" +
                        "        list.add(\"three\");\n" +
                        "        list.add(\"four\");\n" +
                        "        list.add(\"five\");\n" +
                        "        list.add(\"two\");\n" +
                        "        System.out.println(\"list原始數據:\" + list);//[one, two, three, four, five, two]\n" +
                        "\n" +
                        "        //將數據傳入set中\n" +
                        "        //1.\n" +
                        "        Set listToSet1 = new HashSet(list);\n" +
                        "        System.out.println(\"listToSet1去重後:\" + listToSet1);//[four, one, two, three, five]\n" +
                        "        //2.\n" +
                        "        Set listToSet2 = new HashSet();\n" +
                        "        listToSet2.addAll(list);\n" +
                        "        System.out.println(\"listToSet2去重後:\" + listToSet2);//[four, one, two, three, five]\n" +
                        "\n" +
                        "    }\n" +
                        "}\n"
        );
        //=======================================================
        willShowURun();
        //背景代碼存放區開始----------------------------------------
        Set<String> set = new HashSet<>();
        set.add("one");
        set.add("two");
        set.add("three");
        set.add("four");
        set.add("five");
        set.add("two");//加入失敗，Set為不可重複集合，但此處不報錯
        System.out.println("set:" + set);

        /**
         * 小面試題 : 如何去重(將已重複元素去除)
         */
        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        list.add("five");
        list.add("two");
        System.out.println("list原始數據:" + list);//[one, two, three, four, five, two]

        //將數據傳入set中
        //1.
        Set listToSet1 = new HashSet(list);
        System.out.println("listToSet1去重後:" + listToSet1);//[four, one, two, three, five]
        //2.
        Set listToSet2 = new HashSet();
        listToSet2.addAll(list);
        System.out.println("listToSet2去重後:" + listToSet2);//[four, one, two, three, five]
        //背景代碼存放區結束----------------------------------------
        backToMenu();
    }

    /**
     * 第五題演示
     */
    static void question5() throws InterruptedException {
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
    static void question6() throws InterruptedException {
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
    static void question7() throws InterruptedException {
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
    static void question8() throws InterruptedException {
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
    static void question9() throws InterruptedException {
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
    static void question10() throws InterruptedException {
        waitForPreparing();
        //=======================================================
        willShowUCode();

        //=======================================================
        willShowURun();
        //背景代碼存放區開始----------------------------------------
        //背景代碼存放區結束----------------------------------------
        backToMenu();
    }

}


