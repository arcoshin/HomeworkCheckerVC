package day06;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * day06
 * 方法練習的作業類
 */
public class HomeworkChecker {
    /**
     * 結束的方法
     */
    private static void end() {
        System.out.println("感謝您的耐心檢查");
        System.out.println("END");
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
     * 自動回到第N題的方法
     */
    private static void backToQuestion(int n) throws InterruptedException {
        System.out.println("即將返回第" + n + "題選單......");
        Thread.sleep(1000);
        switch (n) {
            case 1:
                question1();
                break;
            case 2:
                question2();
                break;
            case 3:
                question3();
                break;
            case 4:
                question4();
                break;
            case 5:
                question5();
                break;
            default:
                uRWrong();
        }
    }

    /**
     * 自動回到首頁的方法
     */
    private static void backToMenu() throws InterruptedException {
        System.out.println("本題展示完成，即將返回大題選單......");
        Thread.sleep(1000);
        homeworkChecker();
    }

    /**
     * 說明模擬業務完成的方法
     */
    private static void missionComplete() {
        System.out.println("業務執行完畢，請選擇下個業務");
    }

    /**
     * 廣播說明客戶所選擇的業務
     */
    private static void whatYouChoose(String doSomething) {
        System.out.println("您所選擇的是" + doSomething);
    }

    /**
     * 作業檢測系統入口
     */
    private static void homeworkChecker() throws InterruptedException {
        /**
         * 聲明scanner對象及初始化老師輸入的指令
         */
        Scanner scanner = new Scanner(System.in);
        int homeworkCheck;
        System.out.println("======================================================================");
        System.out.println("Hint : 請輸入要檢查的題數(如第一題請輸入1，本次作業共2題，若想結束檢查請輸入99)");
        System.out.println("======================================================================");
        System.out.println("1." +
                "MaxOfArray求數組元素最大值並放在最後一個元素的下一個位置\n" +
                "\t 要求：聲明整型數組並填充隨機數，找到最大值，將數組擴容並將最大值放末尾");
        System.out.println("2.方法的練習：" + "\n" +
                "\t *定義say() 無參無返回值方法，調用測試\n" +
                "\t *定義say() 有一個參無返回值方法，調用測試\n" +
                "\t *定義say() 有兩個參無返回值的方法，調用測試\n" +
                "\t *定義getNum() 無參有返回值方法，演示return的用法，調用測試\n" +
                "\t *定義plus() 兩個參有返回值方法，調用測試\n" +
                "\t *定義generateArray() 用於生成整型數組填充隨機數並返回數組，調用測試"
        );
        //System.out.println("3. ");
        //System.out.println("4. ");
        //System.out.println("5. ");//記得修改最大題數
        homeworkCheck = scanner.nextInt();

        /**
         * 作業查找分支系統
         */
        switch (homeworkCheck) {
            case 1:
                whatYouChoose("MaxOfArray求數組元素最大值並放在最後一個元素的下一個位置");
                question1();
                break;
            case 2:
                whatYouChoose("方法的練習");
                question2();
                break;
//            case 3:
//                whatYouChoose("數組小代碼練習");
//                question3();
//                break;
//            case 4:
//                whatYouChoose("MaxOfArray求數組元素最大值");
//                question4();
//                break;
//            case 5:
//                whatYouChoose("對數組進行升序排列");
//                question5();
//                break;
            case 99:
                return;
            default:
                uRWrong();
                homeworkChecker();
        }
    }

    /**
     * 數組生成器(容量,賦值範圍)
     */
    private static int[] createArrayFillWithRandom(int length, int max) {
        //聲明一個int數組，容量為10
        int[] array = new int[length];

        //隨機賦值1~99數字給每個元素
        for (int i = 0; i < array.length; i++) {
            array[i] = new Random().nextInt(max + 1);//bound不包含所輸入的值
        }
        return array;
    }

    /**
     * 第一題演示
     */
    private static void question1() throws InterruptedException {
        System.out.println("正在演示過程......");
        Thread.sleep(1000);
        System.out.println("==========================================================================");
        System.out.println(
                "//1.)調用一個方法生成一數組，該數組包含十個隨機產生1~99的數\n" +
                        "int[] arr = createArrayFillWithRandom(10, 99);"
        );
        System.out.println("==========================================================================");
        System.out.println("//2.)其中createArrayFillWithRandom()方法展示如下.....");
        System.out.println(
                        "  /**\n" +
                        "    * 數組生成器(容量,賦值範圍)\n" +
                        "    */\n" +
                        "    private static int[] createArrayFillWithRandom(int length, int max) {\n" +
                        "        //聲明一int數組，容量為10\n" +
                        "        int[] array = new int[length];\n" +
                        "\n" +
                        "        //隨機賦值1~99數字給每個元素\n" +
                        "        for (int i = 0; i < array.length; i++) {\n" +
                        "            array[i] = new Random().nextInt(max + 1);//bound不包含所輸入的值\n" +
                        "        }\n" +
                        "        return array;\n" +
                        "    }"
        );
        System.out.println("==========================================================================");
        System.out.print("//3.)調用方法後生成的數組:");
        //調用一個方法生成一數組，該數組包含十個隨機產生1~99的數
        int[] arr = createArrayFillWithRandom(10, 99);
        System.out.println();
        System.out.println(Arrays.toString(arr));//輸出數組檢驗
        System.out.println("==========================================================================");
        System.out.println("//4.)找出最大值:......");
        System.out.println(
                "        //求數組最大的邏輯:使用Arrays.sort()進行自然排列，其最後者則為最大值\n" +
                        "        Arrays.sort(arr);//進行排序\n" +
                        "        //此時的最末位元素必為最大值\n" +
                        "        int max = arr[arr.length-1];");
        //求數組最大的邏輯:使用Arrays.sort()進行自然排列，其最後者則為最大值
        Arrays.sort(arr);//進行排序
        int max = arr[arr.length - 1];//此時的最末為元素為最大值
        System.out.println("最大值 = " + max);
        System.out.println("==========================================================================");
        System.out.println("//5.)擴容與賦值");
        System.out.println(
                "        arr = Arrays.copyOf(arr,arr.length+1);//擴容(末尾補一個默認值)\n" +
                        "        arr[arr.length-1] = max;//將最大值的數賦值給最末位\n" +
                        "        System.out.println(Arrays.toString(arr));//輸出數組檢驗"
        );
        arr = Arrays.copyOf(arr, arr.length + 1);//擴容(末尾補一個默認值)
        arr[arr.length - 1] = max;//將最大值的數賦值給最末位
        System.out.println("得檢驗結果:" + Arrays.toString(arr));//輸出數組檢驗

        backToMenu();
    }

    //2-?背景聲明方法區開始===================================
    public static void say() {
        System.out.println("這個無參無返方法已執行");
    }

    public static void say(int a) {
        System.out.println("這個" + a + "參無返方法已執行");
    }

    public static void say(int a, int b) {
        System.out.println("這個" + (a + b) + "參無返方法已執行");
    }

    public static double getPi() {
        return 3.14;
    }

    public static int plus(int a, int b) {
        return a+b;
    }

    private static int[] generateArray(int length, int max) {
        //1.)聲明一個int數組，容量為10
        int[] array = new int[length];
        //2.)隨機賦值1~99數字給每個元素
        for (int i = 0; i < array.length; i++) {
            array[i] = new Random().nextInt(max + 1);//bound不包含所輸入的值
        }
        return array;//返回arr數組
    }
    //2-?背景聲明方法區結束===================================

    /**
     * 第二題演示
     */
    private static void question2() throws InterruptedException {
        System.out.println("即將為您展示第2題:方法的練習......");
        Thread.sleep(1000);
        System.out.println("==========================================================================");
        System.out.println("第2.1題:定義無參無返方法並調用測試-------------------------------say()");
        System.out.println(
                        "    public static void say() {\n" +
                        "        System.out.println(\"這個無參無返方法已執行\");\n" +
                        "    }"
        );
        System.out.println("    say();//調用");
        System.out.println("輸出結果:");
        say();
        System.out.println("==========================================================================");
        System.out.println("第2.2題:定義一參無返方法並調用測試-------------------------------say()");
        System.out.println(
                        "    public static void say(int a) {\n" +
                        "        System.out.println(\"這個\" + a + \"參無返方法已執行\");\n" +
                        "    }"
        );
        System.out.println("    say(1);//調用");
        System.out.println("輸出結果:");
        say(1);
        System.out.println("==========================================================================");
        System.out.println("第2.3題:定義雙參無返方法並調用測試-------------------------------say()");
        System.out.println(
                        "    public static void say(int a, int b) {\n" +
                        "        System.out.println(\"這個\" + (a + b) + \"參無返方法已執行\");\n" +
                        "    }"
        );
        System.out.println("    say(1,1);//調用");
        System.out.println("輸出結果:");
        say(1,1);
        System.out.println("==========================================================================");
        System.out.println("第2.4題:定義無參有返方法並調用測試----------------------------get???()");
        System.out.println(
                        "    public static double getPi() {\n" +
                        "        return 3.14;\n" +
                        "    }"
        );
        System.out.println("    double d = getPi();//調用");
        double d = getPi();
        System.out.println("    System.out.println(\"d = \" + d);");
        System.out.println("輸出結果:");
        System.out.println("d = " + d);
        System.out.println("==========================================================================");
        System.out.println("第2.5題:定義雙參有返方法並調用測試------------------------------plus()");
        System.out.println(
                        "    public static int plus(int a, int b) {\n" +
                        "        return a+b;\n" +
                        "    }"
        );
        System.out.println("    int sum = plus(49,51);//調用");
        int sum = plus(49,51);
        System.out.println("    System.out.println(\"sum = \" + sum);");
        System.out.println("輸出結果:");
        System.out.println("sum = " + sum);
        System.out.println("==========================================================================");
        System.out.println("第2.6題:定義一用於生成整型數組填充隨機數並返回數組的方法---generateArray()");
        System.out.println(
                        "    private static int[] generateArray(int length, int max) {\n" +
                        "        //1.)聲明一個int數組，容量為max\n" +
                        "        int[] array = new int[length];\n" +
                                "\n" +
                        "        //2.)隨機賦值0~max給每個元素\n" +
                        "        for (int i = 0; i < array.length; i++) {\n" +
                        "            array[i] = new Random().nextInt(max + 1);//bound不包含所輸入的值\n" +
                        "        }\n" +
                        "        return array;//返回arr數組\n" +
                        "    }"
        );
        System.out.println("    int[] arr = generateArray(10,10);//調用");
        int[] arr = generateArray(10,10);
        System.out.println("    System.out.println(\"arr: \" + Arrays.toString(arr));//輸出數組");
        System.out.println("輸出結果:");
        System.out.println("arr: " + Arrays.toString(arr));
        System.out.println("==========================================================================");
        System.out.println(".");
        System.out.println(".");
        System.out.println(".");
        System.out.println(".");
        System.out.println(".");
        backToMenu();
    }

    /**
     * 第三題演示
     */
    private static void question3() throws InterruptedException {

        backToMenu();
    }

    /**
     * 第四題演示
     */
    private static void question4() throws InterruptedException {

        backToMenu();
    }

    /**
     * 第五題演示
     */
    private static void question5() throws InterruptedException {

        backToMenu();
    }

    /**
     * 程序入口
     */
    public static void main(String[] args) {
        try {
            homeworkChecker();
            end();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
