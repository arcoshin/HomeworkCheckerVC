package day04;

import java.util.Scanner;

/**
 * day04
 * switch...case結構、循環結構的練習
 */
public class HomeworkChecker {
    /**
     * 結束的方法
     */
    private static void end () {
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
     * 自動回到第四題的方法
     */
    private static void backToQuestion4() throws InterruptedException {

        System.out.println("即將返回第四題選單......");
        Thread.sleep(1000);
        question4();
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
        int homeworkCheck = 0;
        System.out.println("======================================================================");
        System.out.println("Hint : 請輸入要檢查的題數(如第一題請輸入1，本次作業共4題，若想結束檢查請輸入99)");
        System.out.println("======================================================================");
        System.out.println("1. CommandBySwitch命令解析程序： 要求：接收用戶輸入的命令，依據命令做不同的操作");
        System.out.println("2. Guessing猜數字之while版： 要求：隨機生成一個數，由用戶來猜，猜不對則反覆猜，並給出大小提示，猜對的則結束，用while來實現。");
        System.out.println("3. Guessing猜數字之do...while版 要求：隨機生成一個數，由用戶來猜，猜不對則反复猜，並給出大小提示，猜對的則結束，用do...while來實現。");
        System.out.println("4. for循環：輸出5次\"行動是成功的階梯\"、輸出9的乘法表(1到9、1/3/5/7/9、9到1)、1到100的累加和");

        homeworkCheck = scanner.nextInt();

        /**
         * 作業查找分支系統
         */
        switch (homeworkCheck) {
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
        /**
         * 聲明scanner對象及初始化客戶輸入的指令
         */
        Scanner scanner = new Scanner(System.in);
        int command = 0;

        /**
         * 指令選單的分支結構(因為最少要執行一次所以只能do...while，否則無法實現輸入4自動跳出的功能---不進入循環)
         */
        do {
            System.out.println("請選擇功能:1.存款業務 2.提款業務 3.查詢餘額 4.退出卡片回上一層");//功能導覽
            command = scanner.nextInt();//將客戶給出的數據賦值給scanner對象
            switch (command) {
                case 1:
                    whatYouChoose("存款業務");//模擬實際執行業務
                    missionComplete();//OK
                    break;//避免串接執行
                case 2:
                    whatYouChoose("提款業務");//模擬實際執行業務
                    missionComplete();//OK
                    break;//避免串接執行
                case 3:
                    whatYouChoose("查詢餘額");//模擬實際執行業務
                    missionComplete();//OK
                    break;//避免串接執行
                case 4:
                    whatYouChoose("退出卡片");//模擬實際執行業務
                    System.out.println("已為您退出，請記得收好您的卡片");
                    backToMenu();
                    break;
                default:
                    uRWrong();
            }
        } while (command != 4);//連續測試
        System.out.println("感謝您的使用，歡迎下次光臨~");
        backToMenu();
    }

    /**
     * 第二題演示
     */
    private static void question2() throws InterruptedException {
        /**
         * 用戶要猜的目標數goal(0~1000):此處使用今天教的Math.random()
         */
        int goal = (int) (Math.random() * 1000 + 1);
        System.out.println("Answer : " + goal);//打樁語句

        /**
         * 聲明一個scanner對象並初始化玩家所猜的數字
         */
        Scanner scanner = new Scanner(System.in);
        System.out.println("請開始猜數字...");
        int user = scanner.nextInt();

        /**
         * 提示系統(限定使用while)
         */
        while (user != goal) {//如果猜錯走此分支(包含首次)
            if (user > goal) {
                System.out.println("你猜得太大了，縮小點再猜猜吧!!");
            } else {//已排除猜對及猜太大的可能，所以不用再次使用if
                System.out.println("你猜得太小了，加大點再猜猜吧!!");
            }
            user = scanner.nextInt();
        }//如果猜對則跳過循環(含首次)程序直接運行至此

        System.out.println("恭喜你猜對了!!遊戲結束!!");
        backToMenu();
    }

    /**
     * 第三題演示
     */
    private static void question3() throws InterruptedException {
        /**
         * 用戶要猜的目標數goal(0~1000):此處使用今天教的Math.random()
         */
        int goal = (int) (Math.random() * 1000 + 1);
        System.out.println("Answer : " + goal);//打樁語句

        /**
         * 聲明一個scanner對象並初始化玩家所猜的數字
         */
        Scanner scanner = new Scanner(System.in);
        System.out.println("請開始猜數字...");
        int user = scanner.nextInt();

        /**=========================================================
         * 注意此處只能使用if...else if結構，否則第一次時就猜中會走進else分支
         =========================================================*/
        do {//代入
            if (user > goal) {
                System.out.println("你猜得太大了，再猜一次吧!!");
            } else if (user < goal) {
                System.out.println("你猜得太小了，再猜一次吧!!");
            } else {//如果第一次就猜中就會走此分支，否則不會顯示猜對的恭喜提示程序就結束了
                break;
            }
            user = scanner.nextInt();
        } while (user != goal);
        System.out.println("恭喜你猜對了!!遊戲結束!!");
        backToMenu();
    }

    /**
     * 第四題演示
     */
    private static void question4() throws InterruptedException {
        /**
         * 聲明一個scanner對象並初始化老師所想看的小題
         */
        Scanner scanner = new Scanner(System.in);
        System.out.println("====================================================================");
        System.out.println("Hint : 請選擇小題，如想看第4-1題請輸入1即可，本題共分三小題，輸入99可以退回");
        System.out.println("====================================================================");
        System.out.println("第4-1題: 輸出5次\"行動是成功的階梯\"");
        System.out.println("第4-2題: 輸出9的乘法表(1到9、1/3/5/7/9、9到1)");
        System.out.println("第4-3題: 求1到100的數字和");
        int toWhichTitleOfQuestion4 = scanner.nextInt();

        switch (toWhichTitleOfQuestion4) {
            case 1:
                for (int i = 0; i < 5; i++) {
                    System.out.println("行動是成功的階梯，這是第" + (i + 1) + "次");
                }

                backToQuestion4();
                break;

            case 2:
                System.out.println("9的乘法表(1~9版):======================================================");
                for (int i = 1; i <= 9; i++) {
                    System.out.print(9 + "x" + i + "=" + 9 * i + "\t");
                }
                System.out.println();//換行排版
                System.out.println("9的乘法表(1/3/5/7/9):==================================================");
                for (int i = 1; i <= 9; i += 2) {
                    System.out.print(9 + "x" + i + "=" + 9 * i + "\t");
                }
                System.out.println();//換行排版
                System.out.println("9的乘法表(9~1版):======================================================");
                for (int i = 9; i > 0; i--) {
                    System.out.print(9 + "x" + i + "=" + 9 * i + "\t");
                }
                System.out.println();//換行排版

                backToQuestion4();
                break;

            case 3:
                int sum = 0;
                for (int i = 1; i <= 100; i++) {
                    sum += i;
                }
                System.out.println("sum = " + sum);

                backToQuestion4();
                break;

            case 99:
                backToMenu();
                break;

            default:
                uRWrong();
                backToQuestion4();
        }

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
