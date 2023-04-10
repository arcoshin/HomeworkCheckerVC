package day00ForWeekendHomework.homework20230325;

import java.util.*;

/**
 * weekendHomework 2023.03.25
 * 周末作業作業類
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
public class HomeworkChecker extends HomeworkCheckerTools {
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

        whatUChooseFromMenu(checker, questionList);

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
     * 學術用作弊業務
     */
    protected static void cheat(int ans) {
        System.out.println("學術用作弊程式已開始...ans:" + ans);
    }

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
            for (int i = 1; i <= questionList.length; i++) {//題數指針遍歷
                if (checker == i) {
                    whatYouChoose(questionList[i - 1].questionName);//數組中，下標(i-1)的內容==第i題的內容
                    goToQuestion(i);//去到第i題，但該業務結束後會自動回到本系統入口
                    return;
                }
            }
        } else {//others->Enter again!
            uRWrong();//錯了，重來
            HomeworkChecker.homeworkChecker();
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
        for (int i = 0; i < questionList.length; i++) {//遍歷題目列表
            System.out.println(questionList[i].num + "." + questionList[i].questionName);
        }
    }

    /**
     * 執行question?的方法
     */
    protected static void goToQuestion(int i) throws InterruptedException {
        switch (i) {
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
    protected static void backToMenu(HomeworkChecker HC) throws InterruptedException {
        System.out.println("本題展示完成，即將返回大題選單......");
        Thread.sleep(1000);
        HC.homeworkChecker();
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
        Question[] data = new Question[10];//<<---------------------------------手動修改
        data[0] = new Question(1, "CommandBySwitch", "練習Switch");
        data[1] = new Question(2, "Guessing猜數字", "練習自造死循環while(true)");
        data[2] = new Question(3, "計算1~100數字和", "練習for循環");
        data[3] = new Question(4, "Addition隨機加法運算", "練習for循環");
        data[4] = new Question(5, "九九乘法表", "練習雙重for循環");
        data[5] = new Question(6, "MaxOfArray求最大值並放到數組最後一位", "練習數組、循環");
        data[6] = new Question(7, "生成N位數驗證碼", "練習數組、循環和方法");
        data[7] = new Question(8, "找出2~100中所有素數", "練習雙重for循環");
        data[8] = new Question(9, "機票打折系統", "練習分支與方法");
        data[9] = new Question(10, "去大去小求平均的計算方式", "練習數組、循環和方法");
        return data;
    }

    /**
     * 第一題演示
     */
    public static void question1() throws InterruptedException {
        HomeworkCheckerTools.waitForPreparing();
        //=======================================================
        System.out.println("=================================================================================");
        System.out.println("歡迎來到XCX網路銀行，請輸入您要辦理的業務: 1.存款業務 2.提款業務 3.轉帳業務 99.退出網銀");
        System.out.println("=================================================================================");
        int user = new Scanner(System.in).nextInt();//接收用戶提交的業務代碼

        switch (user) {
            case 1:
                System.out.println("您的模擬存款業務已完成，正在跳回選單");
                question1();
                break;
            case 2:
                System.out.println("您的模擬提款業務已完成，正在跳回選單");
                question1();
                break;
            case 3:
                System.out.println("您的模擬轉帳業務已完成，正在跳回選單");
                question1();
                break;
            case 99:
                return;
            default:
                uRWrong();
                question1();
        }

        //=======================================================
        backToMenu(new HomeworkChecker());
    }

    /**
     * 第二題演示
     */
    public static void question2() throws InterruptedException {
        HomeworkCheckerTools.waitForPreparing();
        //=======================================================

        System.out.println("=================================================================================");
        System.out.println("歡迎來到猜數字遊戲，請輸入你想猜的數字範圍");
        System.out.println("Tips:比如輸入100，數字範圍即為1到100()的數字喔!");
        System.out.println("=================================================================================");

        int max = new Scanner(System.in).nextInt();//接收玩家自定義的的遊戲範圍
        int answer = new Random().nextInt(max - 1 + 1) + 1;//生成隨機數min~max:(max-min+1)+min

        cheat(answer);//教學輔助

        while (true) {//不斷循環
            System.out.println("您設定的範圍為1~" + max + "之間的數，請開始猜吧");
            int user = new Scanner(System.in).nextInt();//接收玩家猜的數

            if (user == answer) {//如果猜對了
                System.out.println("恭喜，猜對了");
                backToMenu(new HomeworkChecker());
                return;//跳出方法
            } else if (user > answer) {
                System.out.println("猜得太大了!縮小點繼續再猜!!");
            } else {
                System.out.println("猜得太小了!加大點繼續再猜!!");
            }
        }
        //=======================================================

    }

    /**
     * 第三題演示
     */
    public static void question3() throws InterruptedException {
        HomeworkCheckerTools.waitForPreparing();
        //=======================================================
        System.out.println("正在計算1+2+3+......98+99+100的結果......");
        Thread.sleep(1000);
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            sum += i;
        }
        System.out.println("計算結果為:" + sum);
        //=======================================================
        backToMenu(new HomeworkChecker());
    }

    /**
     * 第四題演示
     */
    public static void question4() throws InterruptedException {
        HomeworkCheckerTools.waitForPreparing();
        //=======================================================
        System.out.println("=================================================================================");
        System.out.println("隨機加法練習器:");
        System.out.println("下面將隨機生成十題簡易加法，答對一題得十分，答錯不倒扣");
        System.out.println("=================================================================================");
        //=======================================================
        int score = 0;//分數
        for (int i = 0; i < 10; i++) {//循環十次
            int x = new Random().nextInt(99 - 1 + 1) + 1;////生成隨機數min~max:(max-min+1)+min
            int y = new Random().nextInt(99 - 1 + 1) + 1;////生成隨機數min~max:(max-min+1)+min
            System.out.println("第" + (i + 1) + "題:" + x + "+" + y + "=?");//輸出問題
            cheat(x + y);//教學輔助
            int user = new Scanner(System.in).nextInt();//接收答案
            if (user == x + y) {
                System.out.println("答對了!");
                score += 10;
            } else {
                System.out.println("很遺憾您答錯了!");
            }
            System.out.println("=================================================================================");
        }//循環結束
        System.out.println("恭喜，您已完成所有題目，測驗結束!!");
        System.out.println("你的測驗總分為:" + score + "分!!!");
        System.out.println("=================================================================================");
        backToMenu(new HomeworkChecker());
    }

    /**
     * 第五題演示
     */
    public static void question5() throws InterruptedException {
        HomeworkCheckerTools.waitForPreparing();
        //=======================================================
        System.out.println("正在生成九九乘法表......");
        Thread.sleep(3000);
        System.out.println("=================================================================================");
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                System.out.print(j + "x" + i + "=" + i * j + " \t");
            }
            System.out.println();
        }
        System.out.println("=================================================================================");

        //=======================================================
        backToMenu(new HomeworkChecker());
    }

    /**
     * 第六題演示
     */
    public static void question6() throws InterruptedException {
        HomeworkCheckerTools.waitForPreparing();
        //=======================================================
        System.out.println("正在十個元素的生隨機數組......");
        Thread.sleep(1000);
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Random().nextInt(100 - 1 + 1) + 1;//1~100
        }
        System.out.println("已生成數組:" + Arrays.toString(arr));
        System.out.println("假設首位元素\"" + arr[0] + "\"為最大值，用以遍歷數組其餘元素比較......");
        int max = arr[0];

        for (int i = 2; i < arr.length; i++) {
            if (max < arr[i]) {
                System.out.println("遍歷過程發現\"" + arr[i] + "\"比\"" + max + "\"還大，故以\"" + arr[i] + "\"為新的最大值繼續遍歷");
                max = arr[i];
            }
        }
        System.out.println("遍歷結束，此時可知最大值為:" + max);
        System.out.println("正在準備將數組擴容並將最大值放至最後一位");
        arr = Arrays.copyOf(arr, arr.length + 1);
        arr[arr.length - 1] = max;
        System.out.println("最終結果的數組:" + Arrays.toString(arr));
        //=======================================================
        backToMenu(new HomeworkChecker());
    }

    /**
     * 第七題演示
     */
    public static void question7() throws InterruptedException {
        HomeworkCheckerTools.waitForPreparing();
        //=======================================================
        System.out.println("請問您需要產生幾位數的驗證碼(N=?)...?");
        int length = new Scanner(System.in).nextInt();
        System.out.println("正在為您生成" + length + "位的驗證碼......");
        String code = "";//驗證碼
        for (int i = 0; i < length; i++) {//一次拼接一個隨機字符，循環次數即是驗證碼長度
            int chance = new Random().nextInt(3 - 1 + 1) + 1;//1~3
            switch (chance) {//隨機數字決定使用隨機方法，再拼接
                case 1:
                    code += createNumber();//隨機生成一個數字(0~9)的方法
                    break;
                case 2:
                    code += createUppercase();//隨機生成一個大寫英文字母的方法
                    break;
                case 3:
                    code += createLowercase();//隨機生成一個小寫英文字母的方法
                    break;
            }
        }//拼接完成後輸出
        System.out.println("您的驗證碼為:" + code);

        //=======================================================
        backToMenu(new HomeworkChecker());
    }

    /**
     * 第七題材料方法
     */
    private static char createNumber() {//隨機生成一個數字(0~9)的方法
        int index = new Random().nextInt(57 - 48 + 1) + 48;//0~9
        return (char) index;
    }

    private static char createUppercase() {//隨機生成一個大寫英文的方法
        int index = new Random().nextInt(90 - 65 + 1) + 65;//65~90
        return (char) index;
    }

    private static char createLowercase() {//隨機生成一個小寫英文的方法
        int index = new Random().nextInt(122 - 97 + 1) + 97;//97~122
        return (char) index;
    }


    /**
     * 第八題演示
     */
    public static void question8() throws InterruptedException {
        HomeworkCheckerTools.waitForPreparing();
        //=======================================================
        System.out.println("正在生成一個容器......");
        Collection<Integer> c = new ArrayList();

        System.out.println("正在檢驗2~100之間的素數......");
        for (int num = 2; num <= 100; num++) {//檢驗每個數的循環開始==================================
            //檢驗一個數是否為素數的過程的開始=======================================================
            boolean result = true;//假設所有數皆為素數
            for (int i = 2; i <= (num / 2); i++) {
                if (num % i == 0) {//可被小於自己的某個數整除，則必飛素數
                    result = false;//直接給予不輸出的標籤
                    break;//並且剩餘數字已沒有執行檢驗的必要
                }
            }
            if (result) {//通過循環而沒有被貼標籤者即為素數，裝入容器方便打印
                c.add(num);
            }
            //檢驗一個數是否為素數的過程的結束=======================================================
        }//檢驗每個數的循環結束=======================================================================

        System.out.println("檢驗完畢，正在輸出結果......");
        System.out.println("2~100之間的素數有" + c.size() + "個，包含:" + c);
        //=======================================================
        backToMenu(new HomeworkChecker());
    }

    /**
     * 第九題演示
     */
    public static void question9() throws InterruptedException {
        HomeworkCheckerTools.waitForPreparing();
        //=======================================================
        System.out.println("=================================================================================");
        System.out.println("系統啟動中......");
        Thread.sleep(1000);

        System.out.println("請輸入原始票價");
        double oldPrice = new Scanner(System.in).nextDouble();
        System.out.println("請輸入出行月份");
        int month = new Scanner(System.in).nextInt();
        System.out.println("請輸入座位艙等: 1.頭等艙 2.商務艙 3.經濟艙");
        int level = new Scanner(System.in).nextInt();

        System.out.println("資料建立完畢，正在為您驗證中......");
        Thread.sleep(1000);
        double finalPrice = 0;
        if (checkInformation(oldPrice, month, level)) {//通過驗證
            System.out.println("資料驗證完畢，正在為您生成專屬優惠......");
            Thread.sleep(1000);
            finalPrice = getAirPrice(oldPrice, month, level);
        }
        System.out.println("查詢所有優惠活動完成，您的票價最低為:" + finalPrice + "元起");
        System.out.println("=================================================================================");
        //=======================================================
        backToMenu(new HomeworkChecker());
    }

    /**
     * 第九題材料方法
     *
     * @param oldPrice 原始票價
     * @param month    出遊月份
     * @param level    座位艙等
     */
    public static boolean checkInformation(double oldPrice, int month, int level) {
        if (oldPrice <= 0) {
            System.out.println("票價輸入錯誤");
            return false;
        } else if (month < 1 || month > 12) {
            System.out.println("月份輸入錯誤");
            return false;
        } else if (level < 1 || level > 3) {
            System.out.println("艙等輸入錯誤");
            return false;
        } else {
            System.out.println("驗證成功");
            return true;
        }

    }

    public static double getAirPrice(double price, int month, int level) {
        switch (level) {
            case 1://頭等艙
                if (5 <= month && month <= 10) {//旺季
                    price *= 0.9;
                } else {//淡季
                    price *= 0.7;
                }
                break;
            case 2://商務艙
                if (5 <= month && month <= 10) {//旺季
                    price *= 0.85;
                } else {//淡季
                    price *= 0.65;
                }
                break;
            case 3://經濟艙
                if (5 <= month && month <= 10) {//旺季
                    price *= 0.8;
                } else {//淡季
                    price *= 0.6;
                }
                break;
        }
        return price;
    }

    /**
     * 第十題演示
     */
    public static void question10() throws InterruptedException {
        HomeworkCheckerTools.waitForPreparing();
        //=======================================================
        /**
         * 生成一個數組並包含十個元素
         */
        System.out.println("本題嘗試使用面向方法解題......");
        System.out.println("=================================================================================");
        System.out.println("正在調用\"生成一個整型數組並且包含隨機10個分數元素的方法\"......");
        int[] scores = createArrayWithTenElement();
        /**
         * MAX & MIN
         */
        System.out.println("=================================================================================");
        System.out.println("正在調用\"求出最大值的方法\"......");
        int max = getArrayMax(scores);
        System.out.println("=================================================================================");
        System.out.println("正在調用\"求出最小值的方法\"......");
        int min = getArrayMin(scores);
        /**
         * 去除極端值
         */
        System.out.println("=================================================================================");
        System.out.println("正在調用\"一個可以切除數組中極端值的方法\"......");
        int[] newScores = cutExtremeValue(scores, max, min);
        /**
         * 求平均
         */
        System.out.println("=================================================================================");
        System.out.println("正在調用\"一個可以計算數組中所有元素和的方法\"......");
        int sum = getArraySum(newScores);
        System.out.println("=================================================================================");
        System.out.println("正在調用\"一個可以計算數組長度的方法\"......");
        int length = getArrayLength(newScores);
        System.out.println("=================================================================================");
        System.out.println("正在調用\"一個可以計算數組中所有元素平均的方法\"......");
        double avg = getArrayAvg(newScores);
        System.out.println("=================================================================================");
        /**
         * 說明結果的方法
         */
        System.out.println("正在調用\"一個可以說明計算結果的方法\"......");
        System.out.println(resultReport(sum, length, avg));
        //=======================================================
        backToMenu(new HomeworkChecker());
    }

    /**
     * 第十題材料方法
     */
    private static int[] createArrayWithTenElement() {
        int[] scores = new int[10];
        for (int i = 0; i < scores.length; i++) {
            scores[i] = new Random().nextInt(100 - 75 + 1) + 75;//75~100
        }
        System.out.println("已生成隨機分數數組:" + Arrays.toString(scores));

        return scores;
    }

    private static int getArraySum(int[] array) {//求數組和的方法
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];

        }
        System.out.println("數組中所有元素總和為:" + sum);
        return sum;
    }

    private static int getArrayLength(int[] array) {//求數組長度的方法
        int length = array.length;//求數組對象個數
        System.out.println("數組長度為:" + length);
        return length;
    }

    private static double getArrayAvg(int[] array) {//求平均的方法
        double sum = getArraySum(array);//求數組和，自動轉換
        int len = getArrayLength(array);//求數組元素個數
        double avg = sum / len;//平均 = 總和 / 個數
        System.out.println("數組中所有元素值的平均為:" + avg);
        return avg;
    }

    private static int getArrayMax(int[] array) {//求數組最大值的方法
        System.out.println("假設首位元素\"" + array[0] + "\"為最大值，用以遍歷數組其餘元素比較......");
        int max = array[0];
        for (int i = 1; i < array.length; i++) {//i=1,不需與自己比
            if (max < array[i]) {
                System.out.println("遍歷過程發現\"" + array[i] + "\"比\"" + max + "\"還大，故以\"" + array[i] + "\"為新的最大值繼續遍歷");
                max = array[i];
            }
        }
        System.out.println("遍歷結束，此時可知最大值為:" + max);
        return max;
    }

    private static int getArrayMin(int[] array) {//求數組最大值的方法
        System.out.println("假設首位元素\"" + array[0] + "\"為最小值，用以遍歷數組其餘元素比較......");
        int min = array[0];
        for (int i = 1; i < array.length; i++) {//i=1,不需與自己比
            if (min > array[i]) {
                System.out.println("遍歷過程發現\"" + array[i] + "\"比\"" + min + "\"還小，故以\"" + array[i] + "\"為新的最小值繼續遍歷");
                min = array[i];
            }
        }
        System.out.println("遍歷結束，此時可知最小值為:" + min);
        return min;
    }

    private static int[] cutExtremeValue(int[] array, int max, int min) {//去除極值的方法
        System.out.println("原始數組:" + Arrays.toString(array) + "，長度為:" + array.length);
        for (int i = 0; i < array.length; i++) {
            if (array[i] == max || array[i] == min) {//去除極大值與極小值
                array[i] = array[array.length - 1];
                array = Arrays.copyOf(array, array.length - 1);
            }

        }
        System.out.println("去除極端值後:" + Arrays.toString(array) + "，長度為:" + array.length);
        return array;
    }

    private static String resultReport(int sum, int length, double avg) {
        String result = "此時數組中共有" + length + "組數據，總分為" + sum + "分，可得平均為" + avg + "分";
        return result;
    }

}


