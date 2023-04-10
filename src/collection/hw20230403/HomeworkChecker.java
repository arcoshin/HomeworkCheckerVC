package collection.hw20230403;

import java.util.*;

/**
 * weekendHomework 2023.04.03
 * Collection作業類/周末作業類
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
        Question[] data = new Question[7];//<<---------------------------------手動修改
        /*第一題*/data[0] = new Question(1, "Collection集合基本方法練習", "");
        /*第二題*/data[1] = new Question(2, "Collection集合間操作的練習", "");
        /*第三題*/data[2] = new Question(3, "迭代器遍歷集合", "");
        /*第四題*/data[3] = new Question(4, "增強型for循環", "");
        /*第五題*/data[4] = new Question(5, "泛型練習", "");
        /*第六題*/data[5] = new Question(6, "集合轉數組", "");
        /*第七題*/data[6] = new Question(7, "數組轉集合", "");
//        /*第八題*/data[7] = new Question(8, "", "");
//        /*第九題*/data[8] = new Question(9, "", "");
//        /*第十題*/data[9] = new Question(10, "", "");
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
                        " * Collection是所有集合的頂級接口，封裝了很多共有的方法\n" +
                        " * 常見兩種實現類\n" +
                        " * java.util.Set  : 線性表，可重複，有順序\n" +
                        " * java.util.List : 不可重複集合，大部分都是無序的\n" +
                        " */\n" +
                        "public class CollectionDemo {\n" +
                        "    public static void seDay01(String[] args) {\n" +
                        "        Collection c = new ArrayList();\n" +
                        "        c.add(\"one\");\n" +
                        "        c.add(\"two\");\n" +
                        "        c.add(\"three\");\n" +
                        "        c.add(\"four\");\n" +
                        "        c.add(\"five\");\n" +
                        "        System.out.println(c);//toString已經被重寫\n" +
                        "\n" +
                        "        /**\n" +
                        "         * int size() : 獲取集合長度或元素個素\n" +
                        "         * boolean isEmpty : 檢查所給集合是否為空(c.size = 0 ?)並返回\n" +
                        "         * clear() : 完全清空所給集合內部元素的方法\n" +
                        "         */\n" +
                        "        System.out.println(\"size : \" + c.size());\n" +
                        "        System.out.println(\"是否為空集 : \" + c.isEmpty());//false\n" +
                        "\n" +
                        "        c.clear();\n" +
                        "        System.out.println(\"數據已清空\");\n" +
                        "        System.out.println(\"size : \" + c.size());\n" +
                        "        System.out.println(\"是否為空集合 : \" + c.isEmpty());//true\n" +
                        "\n" +
                        "        /**\n" +
                        "         * 引用類型元素相關演示\n" +
                        "         */\n" +
                        "        Collection pointCollection = new ArrayList();\n" +
                        "        pointCollection.add(new Point(1, 2));\n" +
                        "        pointCollection.add(new Point(3, 4));\n" +
                        "        pointCollection.add(new Point(5, 6));\n" +
                        "        pointCollection.add(new Point(7, 8));\n" +
                        "        pointCollection.add(new Point(9, 0));\n" +
                        "        pointCollection.add(new Point(1, 2));\n" +
                        "        System.out.println(\"pointCollection = \" + pointCollection);\n" +
                        "\n" +
                        "        /**\n" +
                        "         * boolean contains(Object obj) : 判斷調用對象是否包含所給元素並返回\n" +
                        "         * 底層邏輯其實是以equals為基礎進行比較後返回boolean值\n" +
                        "         * 因此記得重寫，否則比較的是地址沒有實際意義\n" +
                        "         */\n" +
                        "        Point p1 = new Point(1, 2);\n" +
                        "        System.out.println(\"當前集合是包含p1(1,2)這個點?\" + pointCollection.contains(p1));\n" +
                        "\n" +
                        "        /**\n" +
                        "         * boolean remove (Object obj) : 刪除集合中的給定元素obj，刪除成功則返回true\n" +
                        "         * 一般不接收返回值\n" +
                        "         * 判定是否是給定元素obj，底層邏輯是以equals為基礎進行比較，比較結果為true時才會刪除\n" +
                        "         * 這個方法一次只會刪除\"一個\"符合所給條件的對象\n" +
                        "         */\n" +
                        "        System.out.println(\"源集合 : \" + pointCollection);\n" +
                        "        pointCollection.remove(p1);\n" +
                        "        System.out.println(\"調用一次remove(p1)後的結果 : \" + pointCollection);\n" +
                        "        pointCollection.remove(p1);\n" +
                        "        System.out.println(\"調用一次remove(p1)後的結果 : \" + pointCollection);\n" +
                        "\n" +
                        "        /**\n" +
                        "         * 集合中存的是對象的地址，因此當對象修改時，打印集合也可發現數值跟著修正\n" +
                        "         */\n" +
                        "        Collection cc = new ArrayList();\n" +
                        "        Point pp = new Point(10, 20);\n" +
                        "        cc.add(pp);//將pp的引用(地址)存到cc中\n" +
                        "        System.out.println(\"pp : \" + pp);//(1,2)\n" +
                        "        System.out.println(\"cc : \" + cc);//[(1,2)]\n" +
                        "\n" +
                        "        pp.setX(999);\n" +
                        "        System.out.println(\"pp : \" + pp);//(999,2)\n" +
                        "        System.out.println(\"cc : \" + cc);//[(999,2)]\n" +
                        "    }\n" +
                        "}\n"
        );
        //=======================================================
        willShowURun();
        //背景代碼存放區開始----------------------------------------
        Collection c = new ArrayList();
        c.add("one");
        c.add("two");
        c.add("three");
        c.add("four");
        c.add("five");
        System.out.println(c);//toString已經被重寫

        System.out.println("size : " + c.size());
        System.out.println("是否為空集 : " + c.isEmpty());//false
        c.clear();
        System.out.println("數據已清空");
        System.out.println("size : " + c.size());
        System.out.println("是否為空集合 : " + c.isEmpty());//true

        Collection pointCollection = new ArrayList();
        pointCollection.add(new Point(1, 2));
        pointCollection.add(new Point(3, 4));
        pointCollection.add(new Point(5, 6));
        pointCollection.add(new Point(7, 8));
        pointCollection.add(new Point(9, 0));
        pointCollection.add(new Point(1, 2));
        System.out.println("pointCollection = " + pointCollection);

        Point p1 = new Point(1, 2);
        System.out.println("當前集合是包含p1(1,2)這個點?" + pointCollection.contains(p1));

        System.out.println("源集合 : " + pointCollection);
        pointCollection.remove(p1);
        System.out.println("調用一次remove(p1)後的結果 : " + pointCollection);
        pointCollection.remove(p1);
        System.out.println("調用一次remove(p1)後的結果 : " + pointCollection);

        Collection cc = new ArrayList();
        Point pp = new Point(10, 20);
        cc.add(pp);//將pp的引用(地址)存到cc中
        System.out.println("pp : " + pp);//(1,2)
        System.out.println("cc : " + cc);//[(1,2)]

        pp.setX(999);
        System.out.println("pp : " + pp);//(999,2)
        System.out.println("cc : " + cc);//[(999,2)]
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
                        " * 集合之間的操作\n" +
                        " */\n" +
                        "public class CollectionOperDemo {\n" +
                        "    public static void seDay01(String[] args) {\n" +
                        "        Collection c1 = new ArrayList();\n" +
                        "        c1.add(\"java\");\n" +
                        "        c1.add(\"c++\");\n" +
                        "        c1.add(\".net\");\n" +
                        "        System.out.println(\"c1 : \" + c1);//[java, c++, .net]\n" +
                        "\n" +
                        "        Collection c2 = new ArrayList();\n" +
                        "        c2.add(\"android\");\n" +
                        "        c2.add(\"ios\");\n" +
                        "        c2.add(\"java\");\n" +
                        "        System.out.println(\"c2 : \" + c2);//[android, ios, java]\n" +
                        "\n" +
                        "\n" +
                        "        /**\n" +
                        "         * boolean addAll(Collection c)\n" +
                        "         * 將所給集合完全加入調用者集合的方法\n" +
                        "         * 返回值一般很少使用\n" +
                        "         */\n" +
                        "        c1.addAll(c2);//將c2完全加入c1中\n" +
                        "        System.out.println(\"c1 : \" + c1);//[java, c++, .net, android, ios, java]\n" +
                        "        System.out.println(\"c2 : \" + c2);//[android, ios, java]\n" +
                        "\n" +
                        "        /**\n" +
                        "         * boolean containsAll(Collection c)\n" +
                        "         * 判斷調用者集合是否完全包含給定集合並返回boolean值\n" +
                        "         */\n" +
                        "        Collection c3 = new ArrayList();\n" +
                        "        c3.add(\"c++\");\n" +
                        "        c3.add(\"android\");\n" +
                        "        c3.add(\"php\");\n" +
                        "        System.out.println(\"c3 : \" + c3);//[c++, android, php]\n" +
                        "        System.out.println(\"c1是否完全包含c3 : \" + c1.containsAll(c3));//false，須完全包含但順序無關\n" +
                        "        System.out.println(\"c1是否完全包含c2 : \" + c1.containsAll(c2));\n" +
                        "\n" +
                        "        /**\n" +
                        "         * retainAll(Collection c) : 取交集\n" +
                        "         * 僅保留調用者與所給定集合共有的元素(只會對調用者保留)\n" +
                        "         *\n" +
                        "         * removeAll(Collection c) : 刪交集\n" +
                        "         * 僅刪除調用者與所給定集合共有的元素(只會對調用者刪除)\n" +
                        "         * 換句話說其實就是將所有調用者中與給定集合中相同的元素部分刪除\n" +
                        "         */\n" +
                        "        c1.retainAll(c3);//僅保留c1中，與c3共有的部分\n" +
                        "        System.out.println(\"c1對c3取交集 : \" + c1);//[c++, android]\n" +
                        "        System.out.println(\"c3 : \" + c3);//[c++, android, php]\n" +
                        "\n" +
                        "        c1.removeAll(c3);//刪除c1中,與c3共有的部分\n" +
                        "        System.out.println(\"c1對c3刪交集 : \" + c1);//空集合\n" +
                        "        System.out.println(\"c3 : \" + c3);//[c++, android, php]\n" +
                        "    }\n" +
                        "}\n"
        );
        //=======================================================
        willShowURun();
        //背景代碼存放區開始----------------------------------------
        Collection c1 = new ArrayList();
        c1.add("java");
        c1.add("c++");
        c1.add(".net");
        System.out.println("c1 : " + c1);//[java, c++, .net]

        Collection c2 = new ArrayList();
        c2.add("android");
        c2.add("ios");
        c2.add("java");
        System.out.println("c2 : " + c2);//[android, ios, java]

        c1.addAll(c2);//將c2完全加入c1中
        System.out.println("c1 : " + c1);//[java, c++, .net, android, ios, java]
        System.out.println("c2 : " + c2);//[android, ios, java]

        Collection c3 = new ArrayList();
        c3.add("c++");
        c3.add("android");
        c3.add("php");
        System.out.println("c3 : " + c3);//[c++, android, php]
        System.out.println("c1是否完全包含c3 : " + c1.containsAll(c3));//false，須完全包含但順序無關
        System.out.println("c1是否完全包含c2 : " + c1.containsAll(c2));

        c1.retainAll(c3);//僅保留c1中，與c3共有的部分
        System.out.println("c1對c3取交集 : " + c1);//[c++, android]
        System.out.println("c3 : " + c3);//[c++, android, php]

        c1.removeAll(c3);//刪除c1中,與c3共有的部分
        System.out.println("c1對c3刪交集 : " + c1);//空集合
        System.out.println("c3 : " + c3);//[c++, android, php]

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
        System.out.println(
                        "/**\n" +
                        " * 迭代器類\n" +
                        " * Collection接口中提供了一個Iterator iterator()方法，所有集合都能使用\n" +
                        " * 該方法可以返回當前對象的迭代器(Iterator接口類型)\n" +
                        " * 迭代器就是用來遍歷集合的工具\n" +
                        " */\n" +
                        "public class IteratorDemo {\n" +
                        "    public static void seDay01(String[] args) {\n" +
                        "        Collection c = new ArrayList();\n" +
                        "        c.add(\"one\");\n" +
                        "        c.add(\"#\");\n" +
                        "        c.add(\"two\");\n" +
                        "        c.add(\"#\");\n" +
                        "        c.add(\"three\");\n" +
                        "        c.add(\"#\");\n" +
                        "        c.add(\"four\");\n" +
                        "        c.add(\"#\");\n" +
                        "        c.add(\"five\");\n" +
                        "        c.add(\"#\");\n" +
                        "\n" +
                        "        /**\n" +
                        "         * 迭代器常用操作: 問 取 刪\n" +
                        "         *\n" +
                        "         * 問:\n" +
                        "         * boolean it.hasNext()---是否有下一個元素\n" +
                        "         * 注意:hasNext()只會問，無論調用多少次hasNext()，迭代器的指針都不會動\n" +
                        "         * 注意:指針起始位置為\"首位元素\"前一個位置(所以第一次問就是問首位元素而非第二元素)\n" +
                        "         *\n" +
                        "         * 取:\n" +
                        "         * object next()---將迭代器指針指向後一位元素，並將其返回\n" +
                        "         * 只有當hasNext()為true時，代表集合中仍有下一個元素要輸出，才有移動指針的必要與可能\n" +
                        "         *\n" +
                        "         * 刪:(非必要操作)\n" +
                        "         * void remove()---迭代器提供的remove()方法\n" +
                        "         */\n" +
                        "        Iterator it = c.iterator();//獲取c集合的迭代器\n" +
                        "        while (it.hasNext()){//當還有下一個元素時...\n" +
                        "            String str = (String) it.next();\n" +
                        "            System.out.println(str);//將指針移至該元素\n" +
                        "\n" +
                        "            //若需要不打印某些元素(非必要操作)\n" +
                        "            if (\"#\".equals(str)) {//變量後擺可避免空指針異常(str為null時)\n" +
                        "\n" +
                        "                /**\n" +
                        "                 * 注意 : 迭代過程中禁止對集合進行任何Collection提供的增刪操作方法，否則異常\n" +
                        "                 * ConcurrentModificationException : 併發修改異常\n" +
                        "                 * 此時，若要滿足刪除需求，Iterator提供了實例方法remove()\n" +
                        "                 */\n" +
                        "//                c.remove(\"#\");\n" +
                        "                it.remove();//迭代器提供了remove方法協助移除\n" +
                        "            }\n" +
                        "        }//迭代完成後\n" +
                        "        System.out.println(\"c : \" + c);//驗證源集合刪除結果\n" +
                        "    }\n" +
                        "}\n"
        );
        //=======================================================
        willShowURun();
        //背景代碼存放區開始----------------------------------------

        Collection c = new ArrayList();
        c.add("one");
        c.add("#");
        c.add("two");
        c.add("#");
        c.add("three");
        c.add("#");
        c.add("four");
        c.add("#");
        c.add("five");
        c.add("#");

        Iterator it = c.iterator();
        while (it.hasNext()){
            String str = (String) it.next();
            System.out.println(str);

            if ("#".equals(str)) {

                it.remove();
            }
        }//迭代完成後
        System.out.println("c : " + c);
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
                        "        /**\n" +
                        "         * 當前已學習遍歷數組與集合的方法\n" +
                        "         */\n" +
                        "\n" +
                        "        //遍歷數組\n" +
                        "        String[] array = {\"one\", \"two\", \"three\", \"four\", \"five\"};\n" +
                        "        for (int i = 0; i < array.length; i++) {\n" +
                        "            System.out.print(array[i] + \" \");\n" +
                        "        }\n" +
                        "        System.out.println();//換行\n" +
                        "\n" +
                        "        //遍歷集合\n" +
                        "        Collection collection = new ArrayList();\n" +
                        "        collection.add(\"one\");\n" +
                        "        collection.add(\"two\");\n" +
                        "        collection.add(\"three\");\n" +
                        "        collection.add(\"four\");\n" +
                        "        collection.add(\"five\");\n" +
                        "\n" +
                        "        Iterator it = collection.iterator();\n" +
                        "        while (it.hasNext()) {\n" +
                        "            System.out.print(it.next() + \" \");\n" +
                        "        }\n" +
                        "        System.out.println();//換行\n" +
                        "\n" +
                        "        /**\n" +
                        "         * 使用增強型for循環遍歷數組與集合\n" +
                        "         * 語法:\n" +
                        "         *\n" +
                        "         * for(類型 變量名 : 遍歷對象) {\n" +
                        "         *    循環體\n" +
                        "         * }\n" +
                        "         *\n" +
                        "         */\n" +
                        "\n" +
                        "        //遍歷數組\n" +
                        "        for (String s : array) {\n" +
                        "            System.out.print(s + \" \");\n" +
                        "        }\n" +
                        "        System.out.println();//換行\n" +
                        "\n" +
                        "        //遍歷集合\n" +
                        "        for (Object s : collection) {\n" +
                        "            System.out.print((String) s + \" \");\n" +
                        "        }\n" +
                        "        System.out.println();//換行\n" +
                        "\n" +
                        "    }\n" +
                        "}"
        );
        //=======================================================
        willShowURun();
        //背景代碼存放區開始----------------------------------------
        String[] array = {"one", "two", "three", "four", "five"};
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();//換行

        Collection collection = new ArrayList();
        collection.add("one");
        collection.add("two");
        collection.add("three");
        collection.add("four");
        collection.add("five");

        //遍歷數組
        for (String s : array) {
            System.out.print(s + " ");
        }
        System.out.println();//換行

        //遍歷集合
        for (Object s : collection) {
            System.out.print((String) s + " ");
        }
        System.out.println();//換行
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
        System.out.println(
                "\n" +
                        "/**\n" +
                        " * 泛型(Generic)的演示類\n" +
                        " */\n" +
                        "public class GenericDemo {\n" +
                        "    public static void seDay01(String[] args) {\n" +
                        "        Collection<String> c = new ArrayList<>();\n" +
                        "        c.add(\"one\");\n" +
                        "        c.add(\"two\");\n" +
                        "        c.add(\"three\");\n" +
                        "        c.add(\"four\");\n" +
                        "        c.add(\"five\");\n" +
                        "//        c.add(123);//編譯錯誤，123違背了集合c所指向的泛型類型\n" +
                        "\n" +
                        "        /**\n" +
                        "         * 迭代器所使用的泛型應與其所遍歷的集合泛型一致\n" +
                        "         */\n" +
                        "        Iterator<String> it = c.iterator();\n" +
                        "        while (it.hasNext()) {\n" +
                        "            System.out.println(it.next());\n" +
                        "        }\n" +
                        "\n" +
                        "        for (String s : c) {\n" +
                        "            System.out.println(s);\n" +
                        "        }\n" +
                        "\n" +
                        "        /**\n" +
                        "         * 引用類型\n" +
                        "         */\n" +
                        "        Collection<Point> collection = new ArrayList<>();\n" +
                        "        collection.add(new Point(1,2));\n" +
                        "        collection.add(new Point(3,4));\n" +
                        "        collection.add(new Point(5,6));\n" +
                        "        collection.add(new Point(7,8));\n" +
                        "\n" +
                        "        Iterator<Point> iterator = collection.iterator();\n" +
                        "        while (iterator.hasNext()) {\n" +
                        "            System.out.println(iterator.next());\n" +
                        "        }\n" +
                        "\n" +
                        "        for (Point p : collection) {\n" +
                        "            System.out.println(p);\n" +
                        "        }\n" +
                        "    }\n" +
                        "}\n"
        );
        //=======================================================
        willShowURun();
        //背景代碼存放區開始----------------------------------------
        Collection<String> c = new ArrayList<>();
        c.add("one");
        c.add("two");
        c.add("three");
        c.add("four");
        c.add("five");

        Iterator<String> it = c.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        for (String s : c) {
            System.out.println(s);
        }


        Collection<Point> collection = new ArrayList<>();
        collection.add(new Point(1,2));
        collection.add(new Point(3,4));
        collection.add(new Point(5,6));
        collection.add(new Point(7,8));

        Iterator<Point> iterator = collection.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        for (Point p : collection) {
            System.out.println(p);
        }
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
        System.out.println(
                "\n" +
                        "/**\n" +
                        " * Collection ------> Array\n" +
                        " * 集合轉數組演示類\n" +
                        " */\n" +
                        "public class CollectionToArray {\n" +
                        "    public static void seDay01(String[] args) {\n" +
                        "        Collection<String> c = new ArrayList<>();\n" +
                        "        c.add(\"one\");\n" +
                        "        c.add(\"two\");\n" +
                        "        c.add(\"three\");\n" +
                        "        c.add(\"four\");\n" +
                        "        c.add(\"five\");\n" +
                        "        System.out.println(c);//[\"one\", \"two\", \"three\", \"four\", \"five\"]\n" +
                        "\n" +
                        "        /**\n" +
                        "         * Collection toArray(T[] ts)\n" +
                        "         * T  : 表示泛型，也就是生成目標數組的類型\n" +
                        "         * ts : 表示目標數組對象(通常new一個)\n" +
                        "         *\n" +
                        "         *\n" +
                        "         * 當 源集合容量 等於 目標數組容量 正常轉換\n" +
                        "         * 當 源集合容量 大於 目標數組容量 正常轉換，數組自動依照集合大小調整容量\n" +
                        "         * 當 源集合容量 小於 目標數組容量 正常轉換，數組於末尾補其齊默認值\n" +
                        "         */\n" +
                        "        String[] str = c.toArray(new String[c.size()]);\n" +
                        "        System.out.println(Arrays.toString(str));\n" +
                        "    }\n" +
                        "}\n"
        );
        //=======================================================
        willShowURun();
        //背景代碼存放區開始----------------------------------------
        Collection<String> c = new ArrayList<>();
        c.add("one");
        c.add("two");
        c.add("three");
        c.add("four");
        c.add("five");
        System.out.println(c);//["one", "two", "three", "four", "five"]

        String[] str = c.toArray(new String[c.size()]);
        System.out.println(Arrays.toString(str));

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
        System.out.println(
                "\n" +
                        "/**\n" +
                        " * Array ------> List(Set集合不支持數組轉換所以此處不宜寫Collection)\n" +
                        " * 數組轉集合演示類\n" +
                        " */\n" +
                        "public class ArrayToList {\n" +
                        "    public static void seDay01(String[] args) {\n" +
                        "        String[] array = new String[]{\"one\", \"two\", \"three\", \"four\", \"five\"};\n" +
                        "\n" +
                        "        /**\n" +
                        "         * 數組工具類Arrays中提供了asList方法可以將數組作為List集合返回\n" +
                        "         * 但是此時還有一個很大的缺陷 :\n" +
                        "         * 我們修改新生成的集合時，會造成引用到同一個對象地址的源數據也發生改變\n" +
                        "         * 解決方案:\n" +
                        "         * 1).\n" +
                        "         * 生成新的集合，於構造器ArrayList()中傳入list(new一個新的地址)\n" +
                        "         *\n" +
                        "         * 2).\n" +
                        "         * 創建一個新集合，使用addAll()，將整個集合加入" +
                        "         */\n" +
                        "        List<String> list = Arrays.asList(array);\n" +
                        "        list.set(0, \"1\");\n" +
                        "        System.out.println(\"list = \" + list);\n" +
                        "        System.out.println(\"array = \" + Arrays.toString(array));\n" +
                        "\n" +
                        "        /**\n" +
                        "         * 此時對集合增刪操作就是對數組增刪操作\n" +
                        "         * 然而數組長度是定死的，不支持自動擴容與縮容\n" +
                        "         * 因此運行時雖說編譯語法正確，但會出現運行中異常\n" +
                        "         * UnsupportedOperationException : 操作不支持異常\n" +
                        "         */\n" +
                        "//        list.add(\"abc\");//運行中異常\n" +
                        "\n" +
                        "        //1).new\n" +
                        "        List<String> list1 = new ArrayList<>(list);\n" +
                        "        list1.set(1, \"2\");\n" +
                        "        System.out.println(\"list1 = \" + list1);\n" +
                        "        System.out.println(\"array = \" + Arrays.toString(array));\n" +
                        "\n" +
                        "        //2).addAll()\n" +
                        "        ArrayList<String> list2 = new ArrayList<>();\n" +
                        "        list2.addAll(list);\n" +
                        "        list2.set(2, \"3\");\n" +
                        "        System.out.println(\"list2 = \" + list2);\n" +
                        "        System.out.println(\"array = \" + Arrays.toString(array));\n" +
                        "\n" +
                        "    }\n" +
                        "}\n"
        );
        //=======================================================
        willShowURun();
        //背景代碼存放區開始----------------------------------------

        String[] array = new String[]{"one", "two", "three", "four", "five"};

        List<String> list = Arrays.asList(array);
        list.set(0, "1");
        System.out.println("list = " + list);
        System.out.println("array = " + Arrays.toString(array));

        //1).new
        List<String> list1 = new ArrayList<>(list);
        list1.set(1, "2");
        System.out.println("list1 = " + list1);
        System.out.println("array = " + Arrays.toString(array));

        //2).addAll()
        ArrayList<String> list2 = new ArrayList<>();
        list2.addAll(list);
        list2.set(2, "3");
        System.out.println("list2 = " + list2);
        System.out.println("array = " + Arrays.toString(array));
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


