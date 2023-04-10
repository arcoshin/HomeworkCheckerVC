package day05;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * day05
 * 循環與數組的作業類
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
        System.out.println("Hint : 請輸入要檢查的題數(如第一題請輸入1，本次作業共5題，若想結束檢查請輸入99)");
        System.out.println("======================================================================");
        System.out.println("1. Addition隨機加法運算器: 要求：由系統隨機出10道加法題，而後由用戶來答題，答題後輸出\"答對了\"或\"答錯了\"，答對1題得10分，答錯1題不扣分，最後輸出總分數。");
        System.out.println("2. MultiTable九九乘法表： 要求：輸出九九乘法表");
        System.out.println("3. 數組小代碼練習：聲明、初始化、訪問、遍歷");
        System.out.println("4. MaxOfArray求數組元素最大值");
        System.out.println("5. 對數組進行升序排列，並輸出排序後的結果");
        homeworkCheck = scanner.nextInt();

        /**
         * 作業查找分支系統
         */
        switch (homeworkCheck) {
            case 1:
                whatYouChoose("Addition隨機加法運算器");
                question1();
                break;
            case 2:
                whatYouChoose("MultiTable九九乘法表");
                question2();
                break;
            case 3:
                whatYouChoose("數組小代碼練習");
                question3();
                break;
            case 4:
                whatYouChoose("MaxOfArray求數組元素最大值");
                question4();
                break;
            case 5:
                whatYouChoose("對數組進行升序排列");
                question5();
                break;
            case 99:
                return;
            default:
                uRWrong();
                homeworkChecker();
        }
    }

    /**
     * 第一題演示
     */
    private static void question1() throws InterruptedException {
        System.out.println("正在生成題目......");
        Thread.sleep(2000);

        //生成隨機數對象及計分對象
        Random random = new Random();
        int x;//隨機數
        int y;//隨機數
        int score = 0;//總分

        //生成scanner對象並將使用者輸入的答案初始化
        Scanner scanner = new Scanner(System.in);
        int userAnswer;

        System.out.println("=====測驗開始=====");

        //循環十次出題
        for (int i = 1; i <= 10; i++) {
            x = random.nextInt(100);//每次生成隨機數
            y = random.nextInt(100);//每次生成隨機數
            System.out.println("(" + (i) + ")" + x + "+" + y + "=?");//題目顯示

            userAnswer = scanner.nextInt();//獲得使用者的答案

            if (userAnswer == x + y) {//判題分支
                System.out.println("答對了");
                score += 10;
            } else {
                System.out.println("答錯了");
            }
        }

        //答題結果
        System.out.println("=====測驗結束=====");
        System.out.println("您的測驗總分為: " + score + "分");


        backToMenu();
    }

    /**
     * 第二題演示
     */
    private static void question2() throws InterruptedException {
        System.out.println("正在生成九九乘法表......");
        Thread.sleep(2000);
        for (int num = 1; num <= 9; num++) {
            for (int i = 1; i <= num; i++) {
                System.out.print(i + "x" + num + "=" + i * num + "\t");
                /**
                 * "\t"水平製表常用，可以彈性空格(總長固定佔八位)來實現切齊
                 */
            }
            System.out.println();//分行，排版用
        }
        backToMenu();
    }

    /**
     * 第三題演示
     */
    private static void question3() throws InterruptedException {
        System.out.println("正在產生數組練習代碼成果......");
        Thread.sleep(2000);
        //背景代碼存放區起始===============================

        //聲明
        String[] TaoyuanThreeBrothers = new String[3];
        //初始化
        TaoyuanThreeBrothers[0] = "劉備";
        TaoyuanThreeBrothers[1] = "關羽";
        TaoyuanThreeBrothers[2] = "張飛";
        System.out.println();//排版裝飾用

        //背景代碼存放區結束===============================

        //3-1開始
        Thread.sleep(1000);
        System.out.println("1.聲明數組============================================");
        System.out.println("我將展示我如何聲明一個字符串數組名為桃園三結義...");
        System.out.println();//排版裝飾用
        System.out.println(
                "String[] TaoyuanThreeBrothers = new String[3];"
        );
        System.out.println();//排版裝飾用

        //3-1結束
        //3-2開始
        Thread.sleep(1000);
        System.out.println("2.初始化內部數據=======================================");
        System.out.println("我將展示我如何分別初始化內部的所有數據為劉關張...");
        System.out.println();//排版裝飾用
        System.out.println("TaoyuanThreeBrothers[0] = \"劉備\";");
        System.out.println("TaoyuanThreeBrothers[1] = \"關羽\";");
        System.out.println("TaoyuanThreeBrothers[2] = \"張飛\";");
        System.out.println();//排版裝飾用

        //3-2結束
        //3-3開始
        Thread.sleep(1000);
        System.out.println("3.訪問內部數據========================================");
        System.out.println("我將展示我如何訪問內部的數據...");
        System.out.println();//排版裝飾用
        System.out.print("System.out.print(TaoyuanThreeBrothers[0]);//訪問第一個元素");
        System.out.println();//排版裝飾用
        System.out.println(TaoyuanThreeBrothers[0]);
        System.out.println();//排版裝飾用
        System.out.print("System.out.print(TaoyuanThreeBrothers[1]);//訪問第二個元素");
        System.out.println();//排版裝飾用
        System.out.println(TaoyuanThreeBrothers[1]);
        System.out.println();//排版裝飾用
        System.out.print("System.out.print(TaoyuanThreeBrothers[2]);//訪問第三個元素");
        System.out.println();//排版裝飾用
        System.out.println(TaoyuanThreeBrothers[2]);
        System.out.println();//排版裝飾用

        //3-3結束
        //3-4開始
        Thread.sleep(1000);
        System.out.println("4.遍歷數據===========================================");
        System.out.println("我將展示我如何遍歷這個數組...");
        System.out.println();//排版裝飾用
        System.out.println(
                "System.out.print(\"[\");\n" +
                        "        for (int i = 0; i < TaoyuanThreeBrothers.length; i++) {\n" +
                        "            if (i == (TaoyuanThreeBrothers.length - 1)) {\n" +
                        "                System.out.print(TaoyuanThreeBrothers[i]);\n" +
                        "            } else {\n" +
                        "                System.out.print(TaoyuanThreeBrothers[i] + \",\");\n" +
                        "            }\n" +
                        "        }\n" +
                        "        System.out.print(\"]\");"
        );
        System.out.println();//排版裝飾用
        System.out.print("[");
        for (int i = 0; i < TaoyuanThreeBrothers.length; i++) {
            if (i == (TaoyuanThreeBrothers.length - 1)) {
                System.out.print(TaoyuanThreeBrothers[i]);
            } else {
                System.out.print(TaoyuanThreeBrothers[i] + ",");
            }
        }
        System.out.print("]");
        System.out.println();//排版裝飾用
        //3-4結束
        System.out.println();//排版裝飾用

        backToMenu();
    }

    /**
     * 第四題演示
     */
    private static void question4() throws InterruptedException {
        System.out.println("正在展示MaxOfArray求數組最大值相關語法......");
        Thread.sleep(2000);
        //============================================================================
        System.out.println("//聲明一個int類型數組名為arr，並開闢10個空間");
        System.out.println();//排版裝飾用
        System.out.println("int[] arr = new int[10];");
        System.out.println();//排版裝飾用

        int[] arr = new int[10];
        //============================================================================
        System.out.println("//將數組中的默認數據初始化為十個範圍1~10的數，並輸出展示");
        System.out.println();//排版裝飾用
        System.out.println(
                "for (int i = 0; i < arr.length; i++) {\n" +
                        "            arr[i] = new Random().nextInt(10 - 1) + 1;\n" +
                        "            System.out.println(arr[i]);\n" +
                        "        }"
        );
        System.out.println();//排版裝飾用

        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Random().nextInt(10 - 1) + 1;
        }
        System.out.println(Arrays.toString(arr));
        System.out.println();//排版裝飾用
        //============================================================================
        System.out.println("求最大值邏輯:假設首位元素為最大，用for循環與其餘元素比較，若遭遇更大則重新賦值");
        System.out.println();//排版裝飾用
        System.out.println(
                "int max = arr[0];//假設第一個元素為最大值\n" +
                        "        for (int i = 1; i < arr.length; i++) {//i=1，因為不需要跟自己比較\n" +
                        "            if (arr[i] > max) {//如果元素對象比max還大則走此分支\n" +
                        "                max = arr[i];//將max修改為當前這個較大的元素\n" +
                        "            }\n" +
                        "        }\n" +
                        "        System.out.println(\"最大值為:\" + max);//取出最大值"
        );
        System.out.println();//排版裝飾用
        int max = arr[0];//假設第一個元素為最大值
        for (int i = 1; i < arr.length; i++) {//i=1，因為不需要跟自己比較
            if (arr[i] > max) {//如果元素對象比max還大則走此分支
                max = arr[i];//將max修改為當前這個較大的元素
            }
        }
        System.out.println("最大值為:" + max);//取出最大值
        System.out.println();//排版裝飾用
        backToMenu();


    }

    /**
     * 第五題演示
     */
    private static void question5() throws InterruptedException {
        System.out.println("==========================================================================");
        System.out.println("//1.聲明一數組ar，並賦值十個隨機數(1~99)後輸出展示");
        System.out.println("==========================================================================");

        System.out.println();//排版裝飾用
        int[] ar = new int[10];
        for (int i = 0; i < ar.length; i++) {
            ar[i] = new Random().nextInt(99 - 1) + 1;
        }
        System.out.println(Arrays.toString(ar));
        System.out.println();//排版裝飾用

        System.out.println("==========================================================================");
        System.out.println("//2.調用數組工具類Arrays中自帶的sort()方法，該方法可將數組依照自然排序排列(升序)");
        System.out.println("==========================================================================");

        System.out.println("語法為: Arrays.sort(ar);//注意，本方法只排序不會自動輸出");
        System.out.println("System.out.println(Arrays.toString(ar));//輸出數組內容");

        Arrays.sort(ar);
        System.out.println();//排版裝飾用
        System.out.println("排序後:" + Arrays.toString(ar));
        System.out.println();//排版裝飾用

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
