package day07;

import java.util.*;

/**
 * day07
 * 編碼練習的作業類
 */
public class HomeworkChecker {
    /**
     * 導入題目的方法(設計中...思考如何將方法分類擺好)
     */
//    private static String getQuestionName(int num,String name) {
//        String questionName = "";
//        System.out.println(num + "." + name);
//        return questionName;
//    }

//=============================================================
//===第五題方法區================================================
//=============================================================
    /**
     * 接收分數形成數組的方法
     */
    private static double[] getScoreList(int count) {
        double[] scoreList = new double[count];
        for (int i = 0; i < scoreList.length; i++) {
            System.out.println("請輸入第" + (i + 1) + "個成績...");
            scoreList[i] = new Scanner(System.in).nextInt();
        }
        return scoreList;
    }

    /**
     * 計算所給數組平均數的方法
     */
    private static double getScoreAvg(double[] scoreList) {
        //數組數據求平均
        double sum = getScoreSum(scoreList);//求數組總分
        double length = scoreList.length;//求個數
        double avg = sum / length;//平均 = 總分 / 個數

        //返回所求
        return avg;

    }

    /**
     * 去除所給數組中最大值跟最小值的方法
     */
    private static double[] cutBiggestAndSmall(double[] scoreList) {
        //使用 Arrays.sort() 完成自然排列(小到大)
        Arrays.sort(scoreList);

        //縮容去除末尾完成刪除最大值
        scoreList = Arrays.copyOf(scoreList, scoreList.length - 1);//縮容去除最末位(去除最大值)

        //將欲刪除對象以末尾元素賦值，再以縮容去除最末元素，即完成刪除最小值
        scoreList[0] = scoreList[scoreList.length - 1];//將此時的最末位賦值(覆蓋)給首位元素
        scoreList = Arrays.copyOf(scoreList, scoreList.length - 1);//再次縮容去除最末位(覆蓋首位元素去除最小值)

        return scoreList;
    }

    /**
     * 計算所給數組數據總和的方法
     */
    private static double getScoreSum(double[] scoreList) {
        double sum = 0;//接收數組總分
        for (double s : scoreList) {
            sum += s;//求和
        }
        return sum;
    }

//=============================================================
//===第四題方法區================================================
//=============================================================

    /**
     * 計算機票價格的方法
     */
    private static double calFinalPrice(double price, int month, int type) {
        double finalPrice = price;//接收價格
        /**
         * 先驗證數據有無錯誤，若錯誤一律返回-1
         */
        if (price < 0) {
            System.out.println("票價輸入錯誤");
            return -1;
        }
        if (month < 1 || month > 12) {
            System.out.println("月份輸入錯誤");
            return -1;
        }
        if (type < 1 || type > 3) {
            System.out.println("艙位輸入錯誤");
            return -1;
        }

        /**
         * 確認資料無誤後才會直接走進這邊的折扣分支
         * (程序走到這代表數據一定正常無誤)
         */
        switch (type) {
            case 1:
                if (month >= 5 && month <= 10) {//旺季
                    finalPrice *= 0.9;
                } else {//旺季以外但輸入正確的月份(淡季)
                    finalPrice *= 0.7;
                }
                break;

            case 2:
                if (month >= 5 && month <= 10) {//旺季
                    finalPrice *= 0.85;
                } else {//旺季以外但輸入正確的月份(淡季)
                    finalPrice *= 0.65;
                }
                break;

            case 3:
                if (month >= 5 && month <= 10) {//旺季
                    finalPrice *= 0.8;
                } else {//旺季以外但輸入正確的月份(淡季)
                    finalPrice *= 0.6;
                }
                break;

        }
        return finalPrice;
    }

//=============================================================
//===第二題方法區================================================
//=============================================================
    /**
     * 生成N位驗證碼
     */
    private static String createVerificationCode(int len) {
        String code = "";
        for (int i = 1; i <= len; i++) {
            int chance = new Random().nextInt(3) + 1;//1~3
            switch (chance) {
                case 1://生成數字
                    code += createNum();//隨機生成數字0~9的字符串
                    break;
                case 2://生成大寫
                    code += createBigEng();//隨機生成數字A~Z的字符串
                    break;
                case 3://生成小寫
                    code += createSmaEng();//隨機生成數字a~z的字符串
                    break;
            }
        }
        return code;
    }

    /**
     * 隨機生成數字0~9的字符
     */
    private static char createNum() {
        int index = new Random().nextInt(10) + 48;//48~57
        return (char) index;
    }

    /**
     * 隨機生成大寫字母A~Z的字符
     */
    private static char createBigEng() {
        int index = new Random().nextInt(26) + 65;//65~90
        return (char) index;
    }

    /**
     * 隨機生成小寫字母a-z的字符
     */
    private static char createSmaEng() {
        int index = new Random().nextInt(26) + 97;//97~122
        return (char) index;
    }

//=============================================================
//===本系統方法區================================================
//=============================================================
    /**
     * 開場的方法
     */
    private static void welcome() throws InterruptedException {
        System.out.println("請稍後...正在為您演示...");
        Thread.sleep(1000);
    }

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
        System.out.println("Hint : 請輸入要檢查的題數(如第一題請輸入1，本次作業共5題，若想結束檢查請輸入99)");
        System.out.println("======================================================================");
        System.out.println("1. 猜數字");
        System.out.println("2. 生成N位驗證碼");
        System.out.println("3. 找到2~100之間的素數");
        System.out.println("4. 飛機票打折系統");
        System.out.println("5. 評分系統:去大去小的求平均方法");//記得修改最大題數
        homeworkCheck = scanner.nextInt();

        /**
         * 作業查找分支系統
         */
        switch (homeworkCheck) {
            case 1:
                whatYouChoose("猜數字");
                question1();
                break;
            case 2:
                whatYouChoose("生成N位驗證碼");
                question2();
                break;
            case 3:
                whatYouChoose("找到2~100之間的素數");
                question3();
                break;
            case 4:
                whatYouChoose("飛機票打折系統");
                question4();
                break;
            case 5:
                whatYouChoose("評分系統:去大去小的求平均方法");
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
        welcome();
        //=======================================================
        /**
         * 隨機賦值目標數
         */
        int num = new Random().nextInt(1000) + 1;//1~1000
        System.out.println("num = " + num);//作弊


        /**
         * 自造死循環
         */
        while (true) {
            /**
             * 賦值使用者作答
             */
            System.out.println("請猜吧~(1~1000)");
            int user = new Scanner(System.in).nextInt();//接收使用者作答

            if (user < num) {
                System.out.println("猜太小了!!加大點再猜猜吧!!");
            } else if (user > num) {
                System.out.println("猜太大了!!縮小點再猜猜吧!!");
            } else {
                System.out.println("恭喜你猜對了!!");
                break;//跳出循環
            }
        }
        //=======================================================
        backToMenu();
    }

    /**
     * 第二題演示
     */
    private static void question2() throws InterruptedException {
        welcome();
        //=======================================================
        System.out.println("請輸入要產生多少位數的驗證碼?(N=?)");
        int num = new Scanner(System.in).nextInt();
        String code = createVerificationCode(num);
        System.out.println(code);
        //=======================================================
        backToMenu();
    }

    /**
     * 第三題演示
     */
    private static void question3() throws InterruptedException {
        welcome();
        //=======================================================

        Collection c  = new ArrayList();
        for (int i = 2; i <= 100; i++) {//題目要求2-100
            //預設皆為素數
            boolean result = true;//假設為素數，每次測試新數字都須回歸true

            //測試，沒通過則標記為false
            for (int j = 2; j < i; j++) {//跟2~自己-1之間的數相除，但只需檢驗一半(乘法交換律，後半重複檢驗)
                if (i % j == 0) {
                    result = false;//能被任一數(非自己)整除則必非素數
                    break;
                }
            }
            //通過測試就歸納
            if (result) {//如果通過for代表無法被整除，屬於素數，納入數組
                c.add(i);
            }
        }
        System.out.println(c);//展示累積的數
        System.out.println("2~100之間共有" + c.size() + "個素數");
        //=======================================================
        backToMenu();
    }

    /**
     * 第四題演示
     */
    private static void question4() throws InterruptedException {
        welcome();
        //=======================================================
        Scanner scanner = new Scanner(System.in);

        System.out.println("請輸入原始價格");
        double price = scanner.nextDouble();
        System.out.println("請輸入月份");
        int month = scanner.nextInt();
        System.out.println("請選擇艙位: 1.頭等艙 2.商務艙 3.經濟艙");
        int type = scanner.nextInt();

        double finalPrice = calFinalPrice(price, month, type);

        if (finalPrice != -1) {//返回-1都是有錯誤的
            System.out.println("機票的最終價格為:" + finalPrice);
        }
        //=======================================================
        backToMenu();
    }

    /**
     * 第五題演示
     */
    private static void question5() throws InterruptedException {
        welcome();
        //=======================================================
        double[] scoreList = getScoreList(10);//接收N個數的數組
        double[] scores = cutBiggestAndSmall(scoreList);//去除最大與最小值
        System.out.println("切除後的元素列表" + Arrays.toString(scores));//輸出去除結果，打樁語句
        double scoreAvg = getScoreAvg(scores);//求所給數組的元素平均(去除後的數組)
        double scoreSum = getScoreSum(scores);//求所給數組中數據總和(去除後的數組)
        System.out.println("依照要求去除後的數組總分分數為:" + scoreSum);
        System.out.println("依照要求去除後的數組平均分數為:" + scoreAvg);
        //=======================================================
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
